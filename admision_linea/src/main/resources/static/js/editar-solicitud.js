$(document).ready(function() {
	
	
	/*
	 * 
	 * Registrar un nuevo novel educativo
	 * */	
	$("#registrar-nivel-ed").on("click", function(){
		var aniadir = true;
		var grado = $("#catGradoEstudios option:selected").val();
		if($("#institucion").val() == null || $("#institucion").val() == ""){
			$( "#institucion").addClass( "is-invalid" );
			aniadir = false;
		}
		
		if($("#documento").val() == null || $("#documento").val() == ""){
			$( "#documento").addClass( "is-invalid" );
			aniadir = false;
		}		
		
		if(grado*1 > 3){	    	
	    	if($("#tituloLicenciatura").val() == "" || $("#tituloLicenciatura").val() == null){
	    		$( "#tituloLicenciatura").addClass( "is-invalid" );
	    		aniadir = false;
	    	}
	    }
		
		if(aniadir){
			var registro = "<tr class='registro'>" + "<td class='institucion'>" + $("#institucion").val() + "</td>" + "<td class='documento'>" + $("#documento").val() + "</td>" + "<td class='grado'>" + $('select[name="catGradoEstudios.id"] option:selected').text() + "</td>" +"<td class='nombre'>";
			if($("#tituloLicenciatura").val() == "")
				registro += "Sin dato";
			else			
				registro += $("#tituloLicenciatura").val();						
			registro += "</td><td class='idGrado oculto'>"+ $('select[name="catGradoEstudios.id"] option:selected').val() + "</td><td><button type='button' class='btn btn-outline-danger' onclick='return eliminarTr(this);'>Eliminar</button></td></tr>";
			$("#formaciones").append(registro);			
			
			
			$("#tabla-datos-academicos").show("slow");
			$(".form-nuevo").hide("slow");
			if(grado*1 > 3){	
				$("#titulo-licenciatura").hide("slow");
			}
			$("#agregar-nivel").show("slow");
			
			$("#institucion").val("");
			$("#documento").val("");
			$("#catGradoEstudios").val('1');
			$("#tituloLicenciatura").val("");
		}
	});	
});

function eliminarTr(elemento){	
	$(elemento).parent().parent().remove();	
}

function validarDatos(){
	var cadena = "";
	$("#formaciones .registro").each(function(index){
		var institucion = $(this).find(".institucion").html();
		var documento = $(this).find(".documento").html();
		var idGrado = $(this).find(".idGrado").html();
		var nombre = $(this).find(".nombre").html();
		if(nombre != "")
			cadena += institucion + ">" + documento + ">" + idGrado + ">" + nombre + "¬";
		else
			cadena += institucion + ">" + documento + ">" + idGrado + ">Sin dato¬";		
	});	
	$("#niveles-educativos").val(cadena);
	return validar();
}

