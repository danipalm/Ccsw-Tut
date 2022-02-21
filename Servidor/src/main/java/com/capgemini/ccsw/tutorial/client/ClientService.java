package com.capgemini.ccsw.tutorial.client;
import java.util.List;

import com.capgemini.ccsw.tutorial.client.model.Client;
import com.capgemini.ccsw.tutorial.client.model.ClientDto;


public interface ClientService {

	/**
	    * Recupera un {@link com.capgemini.ccsw.tutorial.client.model.Client} a partir de su ID
	    * @param id
	    * @return
	    */
	    Client get(Long id);
	    
	/**
	  * Método para recuperar todos los Client
	  * @return
	  */
	  List<Client> findAll();

	  /**
	  * Método para crear o actualizar un Cliente
	  * @param dto Objeto client para crear o actualizar
	  * @return
	  */
	  void save(Long id, ClientDto  dto);

	  /**
	  * Método para borrar un Client
	  * @param id
	  */
	  void delete(Long id);
	
}
