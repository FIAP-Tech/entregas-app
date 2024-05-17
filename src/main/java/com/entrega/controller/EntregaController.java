package com.entrega.controller;

import com.entrega.exception.EntregaInternalServerErrorException;
import com.entrega.model.Entrega;
import com.entrega.service.EntregaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/entrega")
public class EntregaController {

    private final EntregaServiceImpl entregaService;

    @Autowired
    public EntregaController(EntregaServiceImpl entregaService) {
        this.entregaService = entregaService;
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de entregas encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Entrega.class))),
        @ApiResponse(responseCode = "204", description = "Nenhuma entrega encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })

    @GetMapping("/obter/tudo")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Entrega> getEntregas() {
        return entregaService.getEntregas();
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrega encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Entrega.class))),
            @ApiResponse(responseCode = "404", description = "Entrega não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })

    @GetMapping("/obter/porId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Entrega>> getEntregaById(@PathVariable Long id) {
        try {
            Optional<Entrega> entrega = entregaService.getEntregaById(id);
            return ResponseEntity.ok(entrega);
        } catch (Exception e) {
            throw new EntregaInternalServerErrorException();
        }
    }

    @Operation(summary = "Cria uma nova entrega", responses = {
            @ApiResponse(responseCode = "201", description = "Entrega criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação ou regra de negócio"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEntrega(@RequestBody Entrega entrega) {
        entregaService.criarEntrega(entrega);
    }

    @Operation(summary = "Atualiza uma entrega existente", responses = {
            @ApiResponse(responseCode = "200", description = "Entrega atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Entrega não encontrada"),
            @ApiResponse(responseCode = "400", description = "Dados da entrega inválidos")
    })
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarEntrega(@PathVariable Long id, @RequestBody Entrega entrega) {
        entregaService.atualizarEntrega(id, entrega);
    }

    @Operation(summary = "Exclui uma entrega", responses = {
            @ApiResponse(responseCode = "204", description = "Entrega excluída com sucesso"),
            @ApiResponse(responseCode = "404", description = "Entrega não encontrada")
    })
    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirEntrega(@PathVariable Long id) {
        entregaService.excluirEntrega(id);
    }

}
