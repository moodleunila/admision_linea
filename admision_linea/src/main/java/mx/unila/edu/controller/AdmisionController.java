package mx.unila.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.unila.edu.CatEstadoRepository;
import mx.unila.edu.CatGradoEstudiosRepository;
import mx.unila.edu.CatPaisRepository;
import mx.unila.edu.TblUsuarioRepository;
import mx.unila.edu.model.TblContacto;
import mx.unila.edu.model.TblDireccion;
import mx.unila.edu.model.TblFormacionAcademica;
import mx.unila.edu.model.TblUsuario;

@Controller
public class AdmisionController {
	
	@Autowired TblUsuarioRepository usuarioRepository;
	@Autowired CatEstadoRepository estadoRepository;
	@Autowired CatGradoEstudiosRepository gradoRepository;
	@Autowired CatPaisRepository paisRepository;
	
	@RequestMapping("/solicitud")
	public String solicitud(Model model, TblUsuario user, TblDireccion direction, TblContacto contacto, TblFormacionAcademica academica) {
		user = this.asignarValores(user, direction, contacto, academica);		
		model.addAttribute("user", user);
		return "precarga";
	}
	
	@RequestMapping("/editar")
	public String editar(Model model, TblUsuario user, TblDireccion direction, TblContacto contacto, TblFormacionAcademica academica) {
		user = this.asignarValores(user, direction, contacto, academica);
		model = this.llenarDatosFormulario(model);
		model.addAttribute("user", user);
		return "editar-solicitud";
	}
	
	@RequestMapping("/almacenar")
	public String almacenar(Model model, TblUsuario user, TblDireccion direction, TblContacto contacto, TblFormacionAcademica academica) {
		user = this.asignarValores(user, direction, contacto, academica);		
		usuarioRepository.save(user);
		model.addAttribute("user", user);		
		return "confirmacion";
	}
	
	@RequestMapping("/")
	public String fomulario(Model model) {
		model = this.llenarDatosFormulario(model);		
		return "solicitud";
	}
	
	public TblUsuario asignarValores(TblUsuario user, TblDireccion direction, TblContacto contacto, TblFormacionAcademica academica) {
		direction.setCatEstado(estadoRepository.getOne(direction.getCatEstado().getId()));
		direction.setCatPais(paisRepository.getOne(direction.getCatPais().getId()));
		academica.setCatGradoEstudios(gradoRepository.getOne(academica.getCatGradoEstudios().getId()));
		user.setTblDireccion(direction);
		user.setTblContacto(contacto);
		user.setTblFormacionAcademica(academica);
		return user;
	}
	
	public Model llenarDatosFormulario(Model model) {
		model.addAttribute("estados", estadoRepository.findAll());
		model.addAttribute("paises", paisRepository.findAll());
		model.addAttribute("gradosAcademicos", gradoRepository.findAll());
		return model;
	}
}
