package com.capgemini.ccsw.tutorial.prestamos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial.client.ClientService;
import com.capgemini.ccsw.tutorial.game.GameService;
import com.capgemini.ccsw.tutorial.prestamos.model.Prestamo;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamoDto;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamoSearchDto;

/**
* @author ccsw
*/
@Service
@Transactional
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoRepository prestamoRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    GameService gameService;

    
    
    /**
     * {@inheritDoc}
     */
    @Override
	public List<Prestamo> find(Long idGame, Long idCategory) {
    	return this.prestamoRepository.find(idGame, idCategory);
	}
    
    

    /**
     * {@inheritDoc}
     */
	@Override
	public void save(Long id, PrestamoDto dto) {
	Prestamo prestamo = new Prestamo();
	
	boolean comprobacionesOK = true;
	 
	 BeanUtils.copyProperties(dto, prestamo, "id", "game", "client");
	 
	 prestamo.setClient(clientService.get(dto.getClient().getId()));
	 prestamo.setGame(gameService.get(dto.getGame().getId()));
	 
	 
	 
	 if (comprobacionesOK)
		 this.prestamoRepository.save(prestamo);
	
	}


	@Override
	public Page<Prestamo> findPage(PrestamoSearchDto dto) {
		 return this.prestamoRepository.findAll(dto.getPageable());
	}
	
	/*
    public void delete(Long id) {

        this.prestamoRepository.deleteById(id);

    } */

}
