package mx.unila.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.unila.edu.bos.AdmisionBOS;
import mx.unila.edu.model.RelUsuarioRol;
import mx.unila.edu.model.TblContacto;
import mx.unila.edu.model.TblDireccion;
import mx.unila.edu.model.TblFormacionAcademica;
import mx.unila.edu.model.TblSolicitud;
import mx.unila.edu.model.TblUsuario;
import mx.unila.edu.repositories.CatEstadoRepository;
import mx.unila.edu.repositories.CatEstadoSolicitudRepository;
import mx.unila.edu.repositories.CatGradoEstudiosRepository;
import mx.unila.edu.repositories.CatModalidadRepository;
import mx.unila.edu.repositories.CatOfertaAcademicaRepository;
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
	@Autowired CatModalidadRepository catModalidadRepository;
	@Autowired CatOfertaAcademicaRepository ofertaAcademicaRepository;
	@Autowired CatEstadoSolicitudRepository estadoSolicitudRepository;
	
	@RequestMapping("/")
	public String fomulario(Model model) {
		model = this.llenarDatosFormulario(model);		
		return "solicitud";
	}																																												
	
	@RequestMapping("/solicitud")
	public String solicitud(Model model, TblUsuario user, TblDireccion direction, TblContacto contacto, Long idOfertaAcademica, String nivelesString) {
		user = this.asignarValores(user, direction, contacto, nivelesString, idOfertaAcademica);		
		model.addAttribute("user", user);
		System.out.println(user.toString());
		return "precarga";
	}
	
	@RequestMapping("/distribuir")
	public String distribuir(Model model, TblUsuario user, TblDireccion direction, TblContacto contacto, TblFormacionAcademica[] academica, int bandera) {
		String direccionar = "";
		//user = this.asignarValores(user, direction, contacto, academica);
		if(bandera == 0) 
			direccionar = this.editar(model, user, direction, contacto, academica);
		else
			direccionar = this.almacenar(model, user, direction, contacto, academica);
		return direccionar;
	}	
		
	public String editar(Model model, TblUsuario user, TblDireccion direction, TblContacto contacto, TblFormacionAcademica[] academica) {
		
		model = this.llenarDatosFormulario(model);
		model.addAttribute("user", user);
		return "editar-solicitud";
	}	
	
	public String almacenar(Model model, TblUsuario user, TblDireccion direction, TblContacto contacto, TblFormacionAcademica[] academica) {		
		user.generarUsuario();
		usuarioRepository.save(user);		
		model.addAttribute("user", user);
		this.generarRol(user, 3L);
		return "confirmacion";
	}

	public TblUsuario asignarValores(TblUsuario user, TblDireccion direction, TblContacto contacto, String nivelesString, Long idOfertaAcademica) {
		TblSolicitud solicitud = new TblSolicitud();
		AdmisionBOS admisionBos = new AdmisionBOS();
		solicitud.setCatOfertaAcademica(ofertaAcademicaRepository.getOne(idOfertaAcademica));
		solicitud.setCatEstadoSolicitud(estadoSolicitudRepository.getOne(1L));
		direction.setCatEstado(estadoRepository.getOne(direction.getCatEstado().getId()));
		direction.setCatPais(paisRepository.getOne(direction.getCatPais().getId()));		
		user.setTblDireccion(direction);
		user.setTblContacto(contacto);
		user.setTblFormacionAcademicas(admisionBos.obtenerFormaciones(nivelesString));
		solicitud.setUsuario(user);
		return user;
	}
	
	public Model llenarDatosFormulario(Model model) {
		model.addAttribute("estados", estadoRepository.findAll());
		model.addAttribute("paises", paisRepository.findAll());
		model.addAttribute("gradosAcademicos", gradoRepository.findAll());
		model.addAttribute("ofertas", ofertaAcademicaRepository.findByAllActivo(1L));		
		return model;
	}
	
	private void generarRol(TblUsuario user, Long idRol) {
		RelUsuarioRol rol = new RelUsuarioRol(rolRepository.getOne(idRol), user, true);
		usuarioRolRepository.save(rol);
	}
}