package com.capgemini.ccsw.tutorial.prestamos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial.author.AuthorService;
import com.capgemini.ccsw.tutorial.category.CategoryService;
import com.capgemini.ccsw.tutorial.client.ClientService;
import com.capgemini.ccsw.tutorial.game.GameService;
import com.capgemini.ccsw.tutorial.game.model.Game;
import com.capgemini.ccsw.tutorial.game.model.GameDto;
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
    ClientService authorService;

    @Autowired
    GameService gameService;

    
    
    /**
     * {@inheritDoc}
     */
    @Override
	public List<Prestamo> find(Long idGame, Long idCategory) {
    	return this.prestamoRepository.find(idGame, idCategory);
	}
    
    
    /*
   
        BeanUtils.copyProperties(dto, game, "id", "author", "category");

        game.setAuthor(authorService.get(dto.getAuthor().getId()));
        game.setCategory(categoryService.get(dto.getCategory().getId()));
    }*/

    /**
     * {@inheritDoc}
     */
	@Override
	public void save(Long id, PrestamoDto dto) {
		Prestamo prestamo = null;
		
		 if (id == null)
			 prestamo = new Prestamo();
	        else
	         prestamo = this.prestamoRepository.findById(id).orElse(null);
		 
		 this.prestamoRepository.save(prestamo);
		
	}


	@Override
	public Page<Prestamo> findPage(PrestamoSearchDto dto) {
		 return this.prestamoRepository.findAll(dto.getPageable());
	}

}
