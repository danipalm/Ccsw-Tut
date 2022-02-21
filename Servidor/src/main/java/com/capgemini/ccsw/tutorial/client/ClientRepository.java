package com.capgemini.ccsw.tutorial.client;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.tutorial.client.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{
	
}
