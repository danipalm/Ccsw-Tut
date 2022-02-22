package com.capgemini.ccsw.tutorial.prestamos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.tutorial.prestamos.model.Prestamo;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamoDto;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamoSearchDto;
import com.capgemini.ccsw.tutorial.config.mapper.BeanMapper;
/**
* @author ccsw
*/
@RequestMapping(value = "/prestamos")
@RestController
@CrossOrigin(origins = "*")
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;

    @Autowired
    BeanMapper beanMapper;
    
    /**
     * Método para recuperar un listado paginado de {@link com.capgemini.ccsw.tutorial.prestamos.model.Prestamo}
     * @param dto
     * @return
     */
     @RequestMapping(path = "", method = RequestMethod.POST)
     public Page<PrestamoDto> findPage(@RequestBody PrestamoSearchDto dto) {

    	return this.beanMapper.mapPage(this.prestamoService.findPage(dto), PrestamoDto.class);
    	 
     }
     

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<PrestamoDto> find(@RequestParam(value = "idGame", required = false) Long idGame,
            @RequestParam(value = "idCliente", required = false) Long idCliente) {

        List<Prestamo> prestamos = prestamoService.find(idGame, idCliente);

        return beanMapper.mapList(prestamos, PrestamoDto.class);
    }

    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody PrestamoDto dto) {

    	prestamoService.save(id, dto);
    }

}
