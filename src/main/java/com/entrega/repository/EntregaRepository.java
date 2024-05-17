package com.entrega.repository;

import com.entrega.model.Entrega;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface EntregaRepository extends CrudRepository<Entrega, String> {
}
