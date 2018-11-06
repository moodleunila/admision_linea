package mx.unila.edu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.unila.edu.CatEstadoRepository;
import mx.unila.edu.CatGradoEstudiosRepository;
import mx.unila.edu.CatPaisRepository;
import mx.unila.edu.CatRolRepository;
import mx.unila.edu.model.CatEstado;
import mx.unila.edu.model.CatGradoEstudios;
import mx.unila.edu.model.CatPais;
import mx.unila.edu.model.CatRol;

@Controller
public class CatalogosController {
	
	@Autowired CatEstadoRepository estadoRepository;
	@Autowired CatGradoEstudiosRepository gradoRepository;
	@Autowired CatPaisRepository paisRepository;
	@Autowired CatRolRepository rolRepository;
	
	@PostConstruct
	public void init() {
		this.llenarFormularioEstados();
		this.llenarFormularioGradoEstudios();
		this.llenarFormularioPais();
		this.llenarCatalogoRoles();
	}
	
	private void llenarFormularioEstados() {
		List<CatEstado> estados = new ArrayList<CatEstado>(0);
		estados.add(new CatEstado(1L, "Ciudad de México", new Date()));
		estados.add(new CatEstado(2L, "Aguas Calientes", new Date()));
		estados.add(new CatEstado(3L, "Baja California Norte", new Date()));
		estados.add(new CatEstado(4L, "Baja California Sur", new Date()));
		estados.add(new CatEstado(5L, "Campeche", new Date()));
		estados.add(new CatEstado(6L, "Chiapas", new Date()));
		estados.add(new CatEstado(7L, "Chihuahua", new Date()));
		estados.add(new CatEstado(8L, "Coahuila", new Date()));
		estados.add(new CatEstado(9L, "Colima", new Date()));		
		estados.add(new CatEstado(10L, "Durango", new Date()));
		estados.add(new CatEstado(11L, "Guanajuato", new Date()));
		estados.add(new CatEstado(12L, "Guerrero", new Date()));
		estados.add(new CatEstado(13L, "Hidalgo", new Date()));
		estados.add(new CatEstado(14L, "Jalisco", new Date()));
		estados.add(new CatEstado(15L, "Estado de México", new Date()));
		estados.add(new CatEstado(16L, "Michoacán", new Date()));
		estados.add(new CatEstado(17L, "Morelos", new Date()));
		estados.add(new CatEstado(18L, "Nayarit", new Date()));
		estados.add(new CatEstado(19L, "Nuevo León", new Date()));
		estados.add(new CatEstado(20L, "Oaxaca", new Date()));
		estados.add(new CatEstado(21L, "Puebla", new Date()));
		estados.add(new CatEstado(22L, "Querétaro", new Date()));
		estados.add(new CatEstado(23L, "Quintana Roo", new Date()));
		estados.add(new CatEstado(24L, "San Luis Potosí", new Date()));
		estados.add(new CatEstado(25L, "Sinaloa", new Date()));
		estados.add(new CatEstado(26L, "Sonora", new Date()));
		estados.add(new CatEstado(27L, "Tabasco", new Date()));
		estados.add(new CatEstado(28L, "Tamaulipas", new Date()));
		estados.add(new CatEstado(29L, "Tlaxcala", new Date()));
		estados.add(new CatEstado(30L, "Veracruz", new Date()));
		estados.add(new CatEstado(31L, "Yucatán", new Date()));
		estados.add(new CatEstado(32L, "Zacatecas", new Date()));
		estadoRepository.save(estados);
	}
	
	private void llenarFormularioGradoEstudios() {
		List<CatGradoEstudios> gradoEstudios = new ArrayList<CatGradoEstudios>(0);
		gradoEstudios.add(new CatGradoEstudios("Primaria", true));
		gradoEstudios.add(new CatGradoEstudios("Secundaria", true));
		gradoEstudios.add(new CatGradoEstudios("Medio superior", true));
		gradoEstudios.add(new CatGradoEstudios("Licenciatura", true));
		gradoEstudios.add(new CatGradoEstudios("Maestría", true));
		gradoEstudios.add(new CatGradoEstudios("Doctorado", true));
		gradoRepository.save(gradoEstudios);
		
	}
	
	
	private void llenarCatalogoRoles() {
		List<CatRol> roles = new ArrayList<CatRol>(0);
		roles.add(new CatRol("Administrador", new Date(), true));
		roles.add(new CatRol("Promotor", new Date(), true));
		roles.add(new CatRol("Ejecutivo", new Date(), true));
		roles.add(new CatRol("Solicitante", new Date(), true));//Estatus inicial de proceso Solicitud y carga de archivos
		roles.add(new CatRol("Aspirante", new Date(), true));//Estatus secundario, una vez validados los documentos
		roles.add(new CatRol("alumno", new Date(), true));//Estatus tercero, una vez hecho el pago		
		rolRepository.save(roles);
	}
	
	
	
	private void llenarFormularioPais() {
		List<CatPais> paises = new ArrayList<CatPais>(0);
		paises.add(new CatPais("México", new Date()));
		paises.add(new CatPais("Albania", new Date()));
		paises.add(new CatPais("Alemania", new Date()));
		paises.add(new CatPais("Andorra", new Date()));
		paises.add(new CatPais("Angola", new Date()));
		paises.add(new CatPais("Antigua y Barbuda", new Date()));
		paises.add(new CatPais("Arabia Saudita", new Date()));
		paises.add(new CatPais("Argelia", new Date()));
		paises.add(new CatPais("Argentina", new Date()));
		paises.add(new CatPais("Armenia", new Date()));
		paises.add(new CatPais("Australia", new Date()));
		paises.add(new CatPais("Austria", new Date()));
		paises.add(new CatPais("Azerbaiyán", new Date()));
		paises.add(new CatPais("Bahamas", new Date()));
		paises.add(new CatPais("Bangladés", new Date()));
		paises.add(new CatPais("Barbados", new Date()));
		paises.add(new CatPais("Baréin", new Date()));
		paises.add(new CatPais("Bélgica", new Date()));
		paises.add(new CatPais("Belice", new Date()));
		paises.add(new CatPais("Benín", new Date()));
		paises.add(new CatPais("Bielorrusia", new Date()));
		paises.add(new CatPais("Birmania", new Date()));
		paises.add(new CatPais("Bolivia", new Date()));
		paises.add(new CatPais("Bosnia y Herzegovina", new Date()));
		paises.add(new CatPais("Botsuana", new Date()));
		paises.add(new CatPais("Brasil", new Date()));
		paises.add(new CatPais("Brunéi", new Date()));
		paises.add(new CatPais("Bulgaria", new Date()));
		paises.add(new CatPais("Burkina Faso", new Date()));
		paises.add(new CatPais("Burundi", new Date()));
		paises.add(new CatPais("Bután", new Date()));
		paises.add(new CatPais("Cabo Verde", new Date()));
		paises.add(new CatPais("Camboya", new Date()));
		paises.add(new CatPais("Camerún", new Date()));
		paises.add(new CatPais("Canadá", new Date()));
		paises.add(new CatPais("Catar", new Date()));
		paises.add(new CatPais("Chad", new Date()));
		paises.add(new CatPais("Chile", new Date()));
		paises.add(new CatPais("China", new Date()));
		paises.add(new CatPais("Chipre", new Date()));
		paises.add(new CatPais("Ciudad del Vaticano", new Date()));
		paises.add(new CatPais("Colombia", new Date()));
		paises.add(new CatPais("Comoras", new Date()));
		paises.add(new CatPais("Corea del Norte", new Date()));
		paises.add(new CatPais("Corea del Sur", new Date()));
		paises.add(new CatPais("Costa de Marfil", new Date()));
		paises.add(new CatPais("Costa Rica", new Date()));
		paises.add(new CatPais("Croacia", new Date()));
		paises.add(new CatPais("Cuba", new Date()));
		paises.add(new CatPais("Dinamarca", new Date()));
		paises.add(new CatPais("Dominica", new Date()));
		paises.add(new CatPais("Ecuador", new Date()));
		paises.add(new CatPais("Egipto", new Date()));
		paises.add(new CatPais("El Salvador", new Date()));
		paises.add(new CatPais("Emiratos Árabes Unidos", new Date()));
		paises.add(new CatPais("Eritrea", new Date()));
		paises.add(new CatPais("Eslovaquia", new Date()));
		paises.add(new CatPais("Eslovenia", new Date()));
		paises.add(new CatPais("España", new Date()));
		paises.add(new CatPais("Estados Unidos", new Date()));
		paises.add(new CatPais("Estonia", new Date()));
		paises.add(new CatPais("Etiopía", new Date()));
		paises.add(new CatPais("Filipinas", new Date()));
		paises.add(new CatPais("Finlandia", new Date()));
		paises.add(new CatPais("Fiyi", new Date()));
		paises.add(new CatPais("Francia", new Date()));
		paises.add(new CatPais("Gabón", new Date()));
		paises.add(new CatPais("Gambia", new Date()));
		paises.add(new CatPais("Georgia", new Date()));
		paises.add(new CatPais("Ghana", new Date()));
		paises.add(new CatPais("Granada", new Date()));
		paises.add(new CatPais("Grecia", new Date()));
		paises.add(new CatPais("Guatemala", new Date()));
		paises.add(new CatPais("Guyana", new Date()));
		paises.add(new CatPais("Guinea", new Date()));
		paises.add(new CatPais("Guinea ecuatorial", new Date()));
		paises.add(new CatPais("Guinea-Bisáu", new Date()));
		paises.add(new CatPais("Haití", new Date()));
		paises.add(new CatPais("Honduras", new Date()));
		paises.add(new CatPais("Hungría", new Date()));
		paises.add(new CatPais("India", new Date()));
		paises.add(new CatPais("Indonesia", new Date()));
		paises.add(new CatPais("Irak", new Date()));
		paises.add(new CatPais("Irán", new Date()));
		paises.add(new CatPais("Irlanda", new Date()));
		paises.add(new CatPais("Islandia", new Date()));
		paises.add(new CatPais("Islas Marshall", new Date()));
		paises.add(new CatPais("Islas Salomón", new Date()));
		paises.add(new CatPais("Israel", new Date()));
		paises.add(new CatPais("Italia", new Date()));
		paises.add(new CatPais("Jamaica", new Date()));
		paises.add(new CatPais("Japón", new Date()));
		paises.add(new CatPais("Jordania", new Date()));
		paises.add(new CatPais("Kazajistán", new Date()));
		paises.add(new CatPais("Kenia", new Date()));
		paises.add(new CatPais("Kirguistán", new Date()));
		paises.add(new CatPais("Kiribati", new Date()));
		paises.add(new CatPais("Kuwait", new Date()));
		paises.add(new CatPais("Laos", new Date()));
		paises.add(new CatPais("Lesoto", new Date()));
		paises.add(new CatPais("Letonia", new Date()));
		paises.add(new CatPais("Líbano", new Date()));
		paises.add(new CatPais("Liberia", new Date()));
		paises.add(new CatPais("Libia", new Date()));
		paises.add(new CatPais("Liechtenstein", new Date()));
		paises.add(new CatPais("Lituania", new Date()));
		paises.add(new CatPais("Luxemburgo", new Date()));
		paises.add(new CatPais("Madagascar", new Date()));
		paises.add(new CatPais("Malasia", new Date()));
		paises.add(new CatPais("Malaui", new Date()));
		paises.add(new CatPais("Maldivas", new Date()));
		paises.add(new CatPais("Malí", new Date()));
		paises.add(new CatPais("Malta", new Date()));
		paises.add(new CatPais("Marruecos", new Date()));
		paises.add(new CatPais("Mauricio", new Date()));
		paises.add(new CatPais("Mauritania", new Date()));
		paises.add(new CatPais("Afganistán", new Date()));
		paises.add(new CatPais("Micronesia", new Date()));
		paises.add(new CatPais("Moldavia", new Date()));
		paises.add(new CatPais("Mónaco", new Date()));
		paises.add(new CatPais("Mongolia", new Date()));
		paises.add(new CatPais("Montenegro", new Date()));
		paises.add(new CatPais("Mozambique", new Date()));
		paises.add(new CatPais("Namibia", new Date()));
		paises.add(new CatPais("Nauru", new Date()));
		paises.add(new CatPais("Nepal", new Date()));
		paises.add(new CatPais("Nicaragua", new Date()));
		paises.add(new CatPais("Níger", new Date()));
		paises.add(new CatPais("Nigeria", new Date()));
		paises.add(new CatPais("Noruega", new Date()));
		paises.add(new CatPais("Nueva Zelanda", new Date()));
		paises.add(new CatPais("Omán", new Date()));
		paises.add(new CatPais("Países Bajos", new Date()));
		paises.add(new CatPais("Pakistán", new Date()));
		paises.add(new CatPais("Palaos", new Date()));
		paises.add(new CatPais("Panamá", new Date()));
		paises.add(new CatPais("Papúa Nueva Guinea", new Date()));
		paises.add(new CatPais("Paraguay", new Date()));
		paises.add(new CatPais("Perú", new Date()));
		paises.add(new CatPais("Polonia", new Date()));
		paises.add(new CatPais("Portugal", new Date()));
		paises.add(new CatPais("Reino Unido", new Date()));
		paises.add(new CatPais("República Centroafricana", new Date()));
		paises.add(new CatPais("República Checa", new Date()));
		paises.add(new CatPais("República de Macedonia", new Date()));
		paises.add(new CatPais("República del Congo", new Date()));
		paises.add(new CatPais("República Democrática del Congo", new Date()));
		paises.add(new CatPais("República Dominicana", new Date()));
		paises.add(new CatPais("República Sudafricana", new Date()));
		paises.add(new CatPais("Ruanda", new Date()));
		paises.add(new CatPais("Rumanía", new Date()));
		paises.add(new CatPais("Rusia", new Date()));
		paises.add(new CatPais("Samoa", new Date()));
		paises.add(new CatPais("San Cristóbal y Nieves", new Date()));
		paises.add(new CatPais("San Marino", new Date()));
		paises.add(new CatPais("San Vicente y las Granadinas", new Date()));
		paises.add(new CatPais("Santa Lucía", new Date()));
		paises.add(new CatPais("Santo Tomé y Príncipe", new Date()));
		paises.add(new CatPais("Senegal", new Date()));
		paises.add(new CatPais("Serbia", new Date()));
		paises.add(new CatPais("Seychelles", new Date()));
		paises.add(new CatPais("Sierra Leona", new Date()));
		paises.add(new CatPais("Singapur", new Date()));
		paises.add(new CatPais("Siria", new Date()));
		paises.add(new CatPais("Somalia", new Date()));
		paises.add(new CatPais("Sri Lanka", new Date()));
		paises.add(new CatPais("Suazilandia", new Date()));
		paises.add(new CatPais("Sudán", new Date()));
		paises.add(new CatPais("Sudán del Sur", new Date()));
		paises.add(new CatPais("Suecia", new Date()));
		paises.add(new CatPais("Suiza", new Date()));
		paises.add(new CatPais("Surinam", new Date()));
		paises.add(new CatPais("Tailandia", new Date()));
		paises.add(new CatPais("Tanzania", new Date()));
		paises.add(new CatPais("Tayikistán", new Date()));
		paises.add(new CatPais("Timor Oriental", new Date()));
		paises.add(new CatPais("Togo", new Date()));
		paises.add(new CatPais("Tonga", new Date()));
		paises.add(new CatPais("Trinidad y Tobago", new Date()));
		paises.add(new CatPais("Túnez", new Date()));
		paises.add(new CatPais("Turkmenistán", new Date()));
		paises.add(new CatPais("Turquía", new Date()));
		paises.add(new CatPais("Tuvalu", new Date()));
		paises.add(new CatPais("Ucrania", new Date()));
		paises.add(new CatPais("Uganda", new Date()));
		paises.add(new CatPais("Uruguay", new Date()));
		paises.add(new CatPais("Uzbekistán", new Date()));
		paises.add(new CatPais("Vanuatu", new Date()));
		paises.add(new CatPais("Venezuela", new Date()));
		paises.add(new CatPais("Vietnam", new Date()));
		paises.add(new CatPais("Yemen", new Date()));
		paises.add(new CatPais("Yibuti", new Date()));
		paises.add(new CatPais("Zambia", new Date()));
		paises.add(new CatPais("Zimbabue", new Date()));
		paisRepository.save(paises);
	}

}
