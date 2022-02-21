package com.capgemini.ccsw.tutorial.prestamos;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.ccsw.tutorial.prestamos.model.Prestamo;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamoDto;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamoSearchDto;

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
     * Método para recuperar un listado paginado de {@link com.capgemini.ccsw.tutorial.prestamos.model.Prestamo}
     * @param dto
     * @return
     */
     Page<Prestamo> findPage(PrestamoSearchDto dto);

    /**
    * Guarda un prestamo
    * @param id
    * @param dto
    */
    void save(Long id, PrestamoDto dto);

}
