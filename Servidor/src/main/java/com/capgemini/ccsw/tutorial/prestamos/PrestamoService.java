package com.capgemini.ccsw.tutorial.prestamos;

import java.util.List;

import com.capgemini.ccsw.tutorial.prestamos.model.Prestamo;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamoDto;

/**
* 
*/
public interface PrestamoService {

    /**
    * Recupera los prestamos filtrando opcionalmente por juego y/o cliente y/o fecha
    * @param idGame
    * @param idCliente
    * @return
    */
    List<Prestamo> find(Long idGame, Long idCliente);

    /**
    * Guarda un prestamo
    * @param id
    * @param dto
    */
    void save(Long id, PrestamoDto dto);

}
