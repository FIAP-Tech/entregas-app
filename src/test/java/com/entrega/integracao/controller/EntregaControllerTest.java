package com.entrega.integracao.controller;

import com.entrega.controller.EntregaController;
import com.entrega.service.EntregaServiceImpl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class EntregaControllerTest {

        @Autowired
        private EntregaController entregaController;

        @Autowired
        private EntregaServiceImpl entregaService;

        @Nested
        class ObterEntregasTest {
            @Nested
            class Success {
                @Test
                public void deveRetornarListaDeEntregasDoServicoRealComSucesso() {

                }
                @Test
                public void deveBuscarEntregaComIdEspecificoDoServicoRealComSucesso() {
                    // ... Implementação do teste ...
                }
            }
            @Nested
            class Failure {

                @Test
                public void devePropagarExcecaoDoServicoAoObterEntregas() {

                }
                @Test
                public void deveRetornarNotFoundParaIdInexistente() {

                }

            }
        }
        @Nested
        class CriarEntregasTest {
            @Test
            public void deveCriarNovaEntregaNoServicoRealComSucesso() {
                // ... Implementação do teste ...
            }

        }
        @Nested
        class AtualizarEntregasTest {
            @Test
            public void deveAtualizarEntregaExistenteNoServicoRealComSucesso() {
                // ... Implementação do teste ...
            }
        }

        @Nested
        class ExcluirEntregasTest {
            @Test
            public void deveExcluirEntregaComIdEspecificoDoServicoRealComSucesso() {
                // ... Implementação do teste ...
            }
        }

    }
