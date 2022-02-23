package com.capgemini.ccsw.tutorial.prestamos;

import java.sql.Date;
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
	public List<Prestamo> find(Long idGame, Long idCliente, Date fecha) {
    	return this.prestamoRepository.find(idGame, idCliente, fecha);
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
	 
	 List<Prestamo> listaPrestamosActuales =  find(prestamo.getGame().getId(), null, null);
	 
	 for (Prestamo aux : listaPrestamosActuales)
	 {
		 
		 if (prestamo.getDate_p().after (aux.getDate_p()) || prestamo.getDate_p().before (aux.getDate_d())
				 || prestamo.getDate_d().before (aux.getDate_d()) )
		 {
				 
			 comprobacionesOK = false;
		 }
		 	
	 }
	 
	 if (comprobacionesOK)
		 this.prestamoRepository.save(prestamo);
	
	}


	@Override
	public Page<Prestamo> findPage(PrestamoSearchDto dto) {
		 return this.prestamoRepository.findAll(dto.getPageable());
	}
	
	
    public void delete(Long id) {

        this.prestamoRepository.deleteById(id);

    }

}
