package mx.unila.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import mx.unila.edu.model.CatOfertaAcademica;
import mx.unila.edu.repositories.CatOfertaAcademicaRepository;

@RestController
public class AjaxController {
	
	@Autowired CatOfertaAcademicaRepository ofertaAcademicaRepository;
	
	@RequestMapping(value="/modalidad/{id}", method = RequestMethod.GET)
	public @ResponseBody List<CatOfertaAcademica> obtenerOfertasAcademicasPorModalidad(@PathVariable Long idModalidad){		
		return ofertaAcademicaRepository.findByAllActivo(idModalidad);
	}
	
	@JsonView(CatOfertaAcademica.Basico.class)
	@RequestMapping(value="/unamodalidad/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<CatOfertaAcademica> getCatOfertaAcademica(@PathVariable Long id){		
		CatOfertaAcademica oferta = ofertaAcademicaRepository.getOne(id);
		return new ResponseEntity<>(oferta, HttpStatus.OK);
	}
}