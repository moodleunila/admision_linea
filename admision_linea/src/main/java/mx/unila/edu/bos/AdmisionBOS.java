package mx.unila.edu.bos;
import java.util.HashSet;
import java.util.Set;

import mx.unila.edu.model.CatGradoEstudios;
import mx.unila.edu.model.TblFormacionAcademica;

public class AdmisionBOS {
	
	public Set<TblFormacionAcademica> obtenerFormaciones(String formaciones){
		Set<TblFormacionAcademica> listaFormaciones = new HashSet<TblFormacionAcademica>(0);
		String[] registros = formaciones.split("#");
		System.out.println("Registros:" + registros.length);
		for(String registro : registros) {
			String[] campos = registro.split(">");
			TblFormacionAcademica formacion = new TblFormacionAcademica();							
			formacion.setInstitucion(campos[0]);
			formacion.setDocumentoObtenido(campos[1]);
			formacion.setCatGradoEstudios(new CatGradoEstudios(Long.parseLong(campos[2])));
			formacion.setNombre(campos[3]);
			listaFormaciones.add(formacion);
		}
		return listaFormaciones;
	}
}
