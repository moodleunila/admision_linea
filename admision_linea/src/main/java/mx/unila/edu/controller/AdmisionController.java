package mx.unila.edu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.unila.edu.TblUsuarioRepository;
import mx.unila.edu.model.TblUsuario;

@Controller
public class AdmisionController {
	
	@Autowired
	private TblUsuarioRepository tblUsuarioRepository;
	
	TblUsuario usuario = new TblUsuario();
	
	@RequestMapping("/solicitud")
	public String greeting(Model model, @RequestParam String nombre, @RequestParam String APaterno, @RequestParam String AMaterno, 
			@RequestParam String email, @RequestParam String curp, @RequestParam String rfc, @RequestParam String genero, 
			@RequestParam String telefonoLocal, @RequestParam String telefonoCelular, @RequestParam String universidadOrigen, 
			@RequestParam String tituloLicenciatura, @RequestParam Long catEstado, @RequestParam Long catGradoEstudios) {
		
		tblUsuarioRepository.save(usuario);
			
		model.addAttribute("usuario", usuario);

		return "ejemplo";
	}
}
