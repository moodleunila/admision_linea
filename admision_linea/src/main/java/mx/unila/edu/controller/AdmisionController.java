package mx.unila.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.unila.edu.model.RelUsuarioRol;
import mx.unila.edu.model.TblContacto;
import mx.unila.edu.model.TblDireccion;
import mx.unila.edu.model.TblFormacionAcademica;
import mx.unila.edu.model.TblUsuario;
import mx.unila.edu.repositories.CatEstadoRepository;
import mx.unila.edu.repositories.CatGradoEstudiosRepository;
import mx.unila.edu.repositories.CatPaisRepository;
import mx.unila.edu.repositories.CatRolRepository;
import mx.unila.edu.repositories.RelUsuarioRolRepository;
import mx.unila.edu.repositories.TblUsuarioRepository;

@Controller
public class AdmisionController {
	
	@Autowired TblUsuarioRepository usuarioRepository;
	@Autowired CatEstadoRepository estadoRepository;
	@Autowired CatGradoEstudiosRepository gradoRepository;
	@Autowired CatPaisRepository paisRepository;
	@Autowired RelUsuarioRolRepository usuarioRolRepository;
	@Autowired CatRolRepository rolRepository;
	
	@RequestMapping("/solicitud")
	public String solicitud(Model model, TblUsuario user, TblDireccion direction, TblContacto contacto, TblFormacionAcademica academica) {
		user = this.asignarValores(user, direction, contacto, academica);		
		model.addAttribute("user", user);
		return "precarga";
	}
	
	@RequestMapping("/distribuir")
	public String distribuir(Model model, TblUsuario user, TblDireccion direction, TblContacto contacto, TblFormacionAcademica academica, int bandera) {
		String direccionar = "";
		if(bandera == 0) 
			direccionar = this.editar(model, user, direction, contacto, academica);
		else
			direccionar = this.almacenar(model, user, direction, contacto, academica);
		return direccionar;
	}
	
	
	public String editar(Model model, TblUsuario user, TblDireccion direction, TblContacto contacto, TblFormacionAcademica academica) {
		user = this.asignarValores(user, direction, contacto, academica);
		model = this.llenarDatosFormulario(model);
		model.addAttribute("user", user);
		return "editar-solicitud";
	}	
	
	public String almacenar(Model model, TblUsuario user, TblDireccion direction, TblContacto contacto, TblFormacionAcademica academica) {
		user = this.asignarValores(user, direction, contacto, academica);
		user.generarUsuario();
		usuarioRepository.save(user);		
		model.addAttribute("user", user);
		this.generarRol(user, 3L);
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
	
	private void generarRol(TblUsuario user, Long idRol) {
		RelUsuarioRol rol = new RelUsuarioRol(rolRepository.getOne(idRol), user, true);
		usuarioRolRepository.save(rol);
	}
}
