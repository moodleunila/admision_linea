package mx.unila.edu.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.unila.edu.TblUsuarioRepository;
import mx.unila.edu.model.CatEstado;
import mx.unila.edu.model.CatGradoEstudios;
import mx.unila.edu.model.CatPais;
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

		usuario.setNombre(nombre);
		usuario.setAPaterno(APaterno);
		usuario.setAMaterno(AMaterno);
		usuario.setEmail(email);
		usuario.setCurp(curp);
		usuario.setRfc(rfc);
		usuario.setGenero(genero);
		usuario.setFechaNacimiento(new Date());
		usuario.setTelefonoLocal(telefonoLocal);
		usuario.setTelefonoCelular(telefonoCelular);
		usuario.setUniversidadOrigen(universidadOrigen);
		usuario.setTituloLicenciatura(tituloLicenciatura);
		usuario.setCatEstado(new CatEstado(catEstado));
		usuario.setCatPais(new CatPais(1L));
		usuario.setCatGradoEstudios(new CatGradoEstudios(catGradoEstudios));
		
		tblUsuarioRepository.save(usuario);
			
		model.addAttribute("usuario", usuario);

		return "ejemplo";
	}
}
