package mx.unila.edu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.unila.edu.model.TblDireccion;
import mx.unila.edu.model.TblUsuario;

@Controller
public class AdmisionController {
	
	@RequestMapping("/solicitud")
	public String greeting(Model model, TblUsuario user, TblDireccion direction) {
		user.setDireccion(direction);
		model.addAttribute("usuario", user);
		System.out.println("usuario" + user.toString());
		return "ejemplo";
	}
}
