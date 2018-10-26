package mx.unila.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.unila.edu.CatEstadoRepository;
import mx.unila.edu.CatGradoEstudiosRepository;
import mx.unila.edu.CatPaisRepository;
import mx.unila.edu.TblUsuarioRepository;
import mx.unila.edu.model.CatEstado;
import mx.unila.edu.model.TblDireccion;
import mx.unila.edu.model.TblUsuario;

@Controller
public class AdmisionController {
	
	@Autowired TblUsuarioRepository usuarioRepository;
	@Autowired CatEstadoRepository estadoRepository;
	@Autowired CatGradoEstudiosRepository gradoRepository;
	@Autowired CatPaisRepository paisRepository;
	
	
	
	@RequestMapping("/solicitud")
	public String solicitud(Model model, TblUsuario user, TblDireccion direction) {
		//user.setDireccion(direction);
		model.addAttribute("user", user);
		return "precarga";
	}
	
	@RequestMapping("/")
	public String fomulario(Model model) {
		model.addAttribute("estados", estadoRepository.findAll());
		
		for(CatEstado estado : estadoRepository.findAll()) {
			System.out.println("estado: " + estado.toString());
		}
		return "solicitud";
	}
}
