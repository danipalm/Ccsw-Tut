package com.capgemini.ccsw.tutorial.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.tutorial.client.model.ClientDto;

@SpringBootTest
@Transactional
public class ClientTest {

  @Autowired
  private ClientController clientController;

  @Test
  public void findAllShouldReturnAllclientesInDB() {

      assertNotNull(clientController);

      long clientesSize = 3;

      List<ClientDto> clientes = clientController.findAll();

      assertNotNull(clientes);
      assertEquals(clientesSize, clientes.size());

  }
  
  @Test
  public void saveWithoutIdShouldCreateNewClient() {

      assertNotNull(clientController);

      String newClientName = "Nueva Categoria";
      long newClientId = 4;
      long newclientesSize = newClientId;

      ClientDto dto = new ClientDto();
      dto.setName(newClientName);

      clientController.save(null, dto);

      List<ClientDto> clientes = clientController.findAll();
      assertNotNull(clientes);
      assertEquals(newclientesSize, clientes.size());

      ClientDto ClientSearch = clientes.stream().filter(item -> item.getId().equals(newClientId)).findFirst().orElse(null);
      assertNotNull(ClientSearch);
      assertEquals(newClientName, ClientSearch.getName());

  }
  
  @Test
  public void modifyWithExistsIdShouldModifyClient() {

      assertNotNull(clientController);

      String newClientName = "Nueva Categoria";
      long ClientId = 3;
      long clientesSize = 3;

      ClientDto dto = new ClientDto();
      dto.setName(newClientName);

      clientController.save(ClientId, dto);

      List<ClientDto> clientes = clientController.findAll();
      assertNotNull(clientes);
      assertEquals(clientesSize, clientes.size());

      ClientDto ClientSearch = clientes.stream().filter(item -> item.getId().equals(ClientId)).findFirst().orElse(null);
      assertNotNull(ClientSearch);
      assertEquals(newClientName, ClientSearch.getName());

  }
  
  @Test
  public void modifyWithNotExistsIdShouldThrowException() {

      assertNotNull(clientController);

      String newClientName = "Nueva Categoria";
      long ClientId = 4;

      ClientDto dto = new ClientDto();
      dto.setName(newClientName);

      assertThrows(NullPointerException.class, () -> clientController.save(ClientId, dto));
  }

  @Test
  public void deleteWithExistsIdShouldDeleteClient() {

      assertNotNull(clientController);

      long newclientesSize = 2;
      long deleteClientId = 2;

      clientController.delete(deleteClientId);

      List<ClientDto> clientes = clientController.findAll();

      assertNotNull(clientes);
      assertEquals(newclientesSize, clientes.size());

  }

  @Test
  public void deleteWithNotExistsIdShouldThrowException() {

      assertNotNull(clientController);

      long deleteClientId = 4;

      assertThrows(Exception.class, () -> clientController.delete(deleteClientId));

  }


  
  

}
