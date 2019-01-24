$(document).ready(function() {	
	
	if($("#value-ciudad-internacional").val() != ""){
		$("#estado-republica-mexicana").hide();
		$("#ciudadInternacional").show();		
	}
	
	
	if($("#value-universidad-origen").val() != null || $("#value-universidad-origen").val() != ""){
		$("#universidad-origen").show();		
	}
	
	if($("#value-titulo-licenciatura").val() != null || $("#value-titulo-licenciatura").val() != ""){	
		$("#titulo-licenciatura").show();
	}
});

function editar(){	
	$("#bandera").attr("value","0");
	asignarFormaciones();
	$("#form-precarga").submit();
}

function almacenar(){
	$("#bandera").attr("value","1");
	asignarFormaciones();
	$("#spinner").show();
	$("#form-precarga").submit();
}                        

function asignarFormaciones(){
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
	$("#nivelesString").val(cadena);
}

