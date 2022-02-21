package com.capgemini.ccsw.tutorial.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial.client.model.Client;
import com.capgemini.ccsw.tutorial.client.model.ClientDto;

/**
* @author ccsw
*
*/
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    /**
    * {@inheritDoc}
    */
    @Override
    public Client get(Long id) {

        return this.clientRepository.findById(id).orElse(null);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public List<Client> findAll() {

        return (List<Client>) this.clientRepository.findAll();
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void save(Long id, ClientDto dto) {

    	Client cliente = null;
    	boolean existe = false;
        if (id == null)
            cliente = new Client();
        else
            cliente = this.get(id);

        cliente.setName(dto.getName());
        
        for( Client aux : findAll())
        {
        	if (aux.getName().equals(cliente.getName()))
        	{
        		System.out.print("El nombre ya existe, no lo creamos\n");
        		existe = true;
        		break;
        	}
        }
        
        if(!existe)
        	this.clientRepository.save(cliente);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void delete(Long id) {

        this.clientRepository.deleteById(id);

    }
}
