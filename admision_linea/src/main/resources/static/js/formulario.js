$(document).ready(function() {
	
	/*
	 * 
	 * Habilitación del campo grado de estudios
	 * */
	$("#catGradoEstudios").on("change", function(){
		var grado = $("#catGradoEstudios option:selected").val();
		switch (grado*1){
			case 4:
			case 5:
			case 6:				
				$("#titulo-licenciatura").show("slow");
				break;
			default:				
				$("#titulo-licenciatura").hide("slow");
		}
	});
		
	/*
	 * 
	 * Habilitación de la ciudad internacional en caso de seleccionar otro país
	 * */
	$("#catPais").on("change", function(){		
		if($("#catPais option:selected").val()*1 > 1){
			$("#listado-estados").hide("slow");
			$("#ciudad-internacional").show("slow");
		}
		else{
			$("#listado-estados").show("slow");
			$("#ciudad-internacional").hide("slow");
		}
	});
		
	/*
	 * 
	 * Oculta 
	 * */	
	if($("#catPais option:selected").val() * 1 > 1){
		$("#listado-estados").hide();
		$("#ciudad-internacional").show();
	}
	
	if($("#catGradoEstudios option:selected").val() * 1 > 3)		
		$("#titulo-licenciatura").show();	
	
	/*
	 * 
	 * Agregar un nuevo nivel educativo
	 * */
	$("#agregar-nivel").on("click", function(){
		$(this).hide("slow");
		$(".form-nuevo").show("slow");
	});
	
	/*
	 * 
	 * Registrar un nuevo novel educativo
	 * */	
	$("#registrar-nivel").on("click", function(){
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
			var consecutivo = $("#cuerpo-tabla > tr").length + 1; 
			var registro = "<tr>" +	"<th scope='row'>" + consecutivo +"</th>" + "<td>" + $("#institucion").val() + "</td>" + "<td>" + $("#documento").val() + "</td>" + "<td>" + $('select[name="catGradoEstudios.id"] option:selected').text() + "</td>" +"<td>" + $("#tituloLicenciatura").val() + "</td>" + "</tr>";
			$("#cuerpo-tabla").append(registro);
			
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

function validar(){
	
	var enviar = true;	
	var paisSeleccionado = $("#catPais option:selected").val();
	
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
    
    if($("#fechaNacimiento").val() == "" || $("#fechaNacimiento").val() == null){
		$( "#fechaNacimiento").addClass( "is-invalid" );
		enviar = false;
	}
    else{
		$( "#fechaNacimiento").removeClass( "is-invalid" );
		$( "#fechaNacimiento").addClass( "is-valid" );
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
    
    if(paisSeleccionado*1 > 1){    	
    	if($("#ciudad").val() == "" || $("#ciudad").val() == null){    		
    		$("#ciudad").addClass("is-invalid");
    		enviar = false;
    	}
    	else{
    		$( "#ciudad").removeClass( "is-invalid" );
    		$( "#ciudad").addClass( "is-valid" );
    	}
    		
    }
    
	if(enviar)
		$("#solicitud").submit();
	else
		$(".error").show("slow");
}

