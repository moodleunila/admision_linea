$(document).ready(function() {
	
	$("#catGradoEstudios").on("change", function(){
		var grado = $("#catGradoEstudios option:selected").val();
		switch (grado*1){
			case 4:
			case 5:
			case 6:
				$("#universidad-origen").show("slow");
				$("#titulo-licenciatura").show("slow");
				break;
			default:
				$("#universidad-origen").hide("slow");
				$("#titulo-licenciatura").hide("slow");
		}
	});
	
	
});

function validar(){
	
	var enviar = true;
	var grado = $("#catGradoEstudios option:selected").val();
	
	if($("#nombre").val() == "" || $("#nombre").val() == null){
		$( "#nombre").addClass( "is-invalid" );
		enviar = false;
	}
	else{
		$( "#nombre").removeClass( "is-invalid" );
		$( "#nombre").addClass( "is-valid" );
	}
	
	if($("#APaterno").val() == "" || $("#APaterno").val() == null){
		$( "#APaterno").addClass( "is-invalid" );
		enviar = false;
	}
	else{
		$( "#APaterno").removeClass( "is-invalid" );
		$( "#APaterno").addClass( "is-valid" );
	}
	
	if($("#AMaterno").val() == "" || $("#AMaterno").val() == null){
		$( "#AMaterno").addClass( "is-invalid" );
		enviar = false;
	}
	else{
		$( "#AMaterno").removeClass( "is-invalid" );
		$( "#AMaterno").addClass( "is-valid" );
	}
	
	var caract = new RegExp(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/);
    if (caract.test($("#email").val()) == false || $("#email").val() == "" || $("#email").val() == null){
        enviar = false;
        $("#email").addClass("is-invalid" );
    }
    else{
		$( "#email").removeClass( "is-invalid" );
		$( "#email").addClass( "is-valid" );
	}
    
    if($("#curp").val() == "" || $("#curp").val() == null){
		$( "#curp").addClass( "is-invalid" );
		enviar = false;
	}
    else{
		$( "#curp").removeClass( "is-invalid" );
		$( "#curp").addClass( "is-valid" );
	}
    
    if($("#rfc").val() == "" || $("#rfc").val() == null){
		$( "#rfc").addClass( "is-invalid" );
		enviar = false;
	}
    else{
		$( "#rfc").removeClass( "is-invalid" );
		$( "#rfc").addClass( "is-valid" );
	}
    
    if($("#telefonoLocal").val() == "" || $("#telefonoLocal").val() == null){
		$( "#telefonoLocal").addClass( "is-invalid" );
		enviar = false;
	}
    else{
		$( "#telefonoLocal").removeClass( "is-invalid" );
		$( "#telefonoLocal").addClass( "is-valid" );
	}
    
    if($("#calle").val() == "" || $("#calle").val() == null){
    	$( "#calle").addClass( "is-invalid" );
		enviar = false;
    }
    else{
    	$( "#calle").removeClass( "is-invalid" );
		$( "#calle").addClass( "is-valid" );
    }
    
    if($("#colonia").val() == "" || $("#colonia").val() == null){
    	$( "#colonia").addClass( "is-invalid" );
		enviar = false;
    }
    else{
    	$( "#colonia").removeClass( "is-invalid" );
		$( "#colonia").addClass( "is-valid" );
    }
    
    if($("#codigoPostal").val() == "" || $("#codigoPostal").val() == null){
    	$( "#codigoPostal").addClass( "is-invalid" );
		enviar = false;
    }
    else{
    	$( "#codigoPostal").removeClass( "is-invalid" );
		$( "#codigoPostal").addClass( "is-valid" );
    }
    
    if(grado*1 > 3){
    	if($("#universidadOrigen").val() == "" || $("#universidadOrigen").val() == null){
    		$( "#universidadOrigen").addClass( "is-invalid" );
    		enviar = false;
    	}
    	else{
    		$( "#universidadOrigen").removeClass( "is-invalid" );
    		$( "#universidadOrigen").addClass( "is-valid" );
    	}
    	
    	if($("#tituloLicenciatura").val() == "" || $("#tituloLicenciatura").val() == null){
    		$( "#tituloLicenciatura").addClass( "is-invalid" );
    		enviar = false;
    	}
    	else{
    		$( "#tituloLicenciatura").removeClass( "is-invalid" );
    		$( "#tituloLicenciatura").addClass( "is-valid" );
    	}
    }
    
	if(enviar)
		$("#solicitud").submit();
	else
		$(".error").show("slow");
}

