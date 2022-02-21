package com.capgemini.ccsw.tutorial.client;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.devonfw.module.beanmapping.common.api.BeanMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.ccsw.tutorial.client.model.ClientDto;

/*
* @author ccsw
*/
@RequestMapping(value = "/clientes")
@RestController
@CrossOrigin(origins = "*")
public class ClientController {

	@Autowired
	  private ClientService clientService;
	
	@Autowired
	BeanMapper beanMapper;
  /*
  * Método para recuperar todos los clientes
  * @return
  */
  @RequestMapping(path = "", method = RequestMethod.GET)
  public List<ClientDto> findAll() {

      return this.beanMapper.mapList(this.clientService.findAll(), ClientDto.class);
  }

  /*
  * Método para crear o actualizar un Cliente
  * @param id
  * @param dto
  * @return
  */
  @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
  public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody ClientDto dto) {
	  this.clientService.save(id, dto);
      
  }

  /*
  * Método para borrar un Cliente
  * @param id
  */
  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable("id") Long id) {
	  clientService.delete(id);
      
  }
}
