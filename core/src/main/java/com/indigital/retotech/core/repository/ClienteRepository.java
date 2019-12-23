package com.indigital.retotech.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.indigital.retotech.core.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
