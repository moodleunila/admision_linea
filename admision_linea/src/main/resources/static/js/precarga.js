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
	$("#form-precarga").attr("action","/editar");
	$("#form-precarga").submit();
}

function almacenar(){
	$("#form-precarga").attr("action","/almacenar");
	$("#form-precarga").submit();
}

