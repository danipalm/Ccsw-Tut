package com.capgemini.ccsw.tutorial.prestamos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.ccsw.tutorial.prestamos.model.Prestamo;

public interface PrestamoRepository extends CrudRepository<Prestamo, Long> {

    @Query("select p from Prestamo p where (:game is null or p.game.id = :game) and (:client is null or p.client.id = :client)"
    		+ "and :fecha is null or :fecha between p.date_p and p.date_d")
    List<Prestamo> find(@Param("game") Long game, @Param("client") Long cliente, @Param("fecha") Date fecha);

    /**
     * Método para recuperar un listado paginado de {@link com.capgemini.ccsw.tutorial.prestamo.model.Prestamo}
     * @param page
     * @return
     */
	Page<Prestamo> findAll(Pageable pageable);
    
}
