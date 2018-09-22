package mx.unila.edu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.unila.edu.model.TblDireccion;
import mx.unila.edu.model.TblUsuario;

@Controller
public class AdmisionController {
	
	TblUsuario usuario = new TblUsuario();
	TblDireccion direccion = new TblDireccion();
	
	@RequestMapping(value= "/solicitud", method = RequestMethod.POST)
	public String greeting(Model model, TblUsuario user, TblDireccion direction) {
		
		System.out.println("user: " + user.toString());
		
		
			
		model.addAttribute("usuario", usuario);

		return "ejemplo";
	}
}
