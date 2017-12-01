var idMiembroSeleccionado; 
var urlBase = "https://gym-danm97.c9users.io/";

$(document).ready(function() {
	var rows = $("#tblMiembros > tbody > tr");
	rows.each(function(index,value){
		
	});
	rows.click(function(){
		$("#btnAgregarPago").addClass("d-none");
		$("#btnInactivar").addClass("d-none");
		rows.removeClass('bg-primary');
		$(this).addClass('bg-primary');
		idMiembroSeleccionado = $(this).children()[0].getAttribute("id");
		
		$("#btnInactivar").removeClass("d-none");
		
		if($(this).children()[2].innerHTML == "No"){
		 $("#btnInactivar").html("Activar");
		}else{
			$("#btnInactivar").html("Inactivar");
		}
		if($(this).children()[4].innerHTML=="Atrasado"){
			$("#btnAgregarPago").removeClass("d-none");
		}
	});
	});

$("#cmbSucursal").change(function() {
	location.href=this.value;	
});

$("#btnCerrarSesion").click(function(){
	document.cookie="empleado=;expires=Thu, 01 Jan 1970 00:00:01 GMT;";
	location.href="/";
});
function x() {
	var fecha=new Date();
	alert(fecha.toISOString());
}
$(".agregarMiembro").submit(function() {
	var idSucursal=location.href.split("/")[3];
	var fecha=new Date();
	var fechaConFormato=fecha.toISOString().split("T")[0];
	$.ajax({
		  type: "POST",
		  url: "https://gym-danm97.c9users.io/sucursals/"+idSucursal+"/miembros",
		  data: {'nombre':this.nombre.value,'masculino':this.radio.value=="masc"?true:false,'activo':true,
				  'fechaingreso':fechaConFormato},
		  success: function(r){
			  
				  realizarPago(idSucursal,fechaConFormato,r.id);
		 },
		  dataType: "json"
		});
});

$("#btnAgregarPago").click(function(){
	
	$.ajax({
		  type: "POST",
		  url: urlBase+"sucursals/"+location.href.split("/")[3]+"/miembros/"+idMiembroSeleccionado+"/pagos",
		  data: {
		        fecha: new Date().toISOString().split("T")[0],
		        empleado_id: document.cookie.split("empleado=")[1],
		        tipopago_id: 1
		},
		  success: function(r){
			  console.log("response: "+r);
			  //NOTIFICACION
			  not();
			  location.reload();
		  },
		  dataType: "json"
		});
});


$("#btnInactivar").click(function(){
	
	var b = false;
	//console.log($.trim($(this).html()) == "Activar");
	if(($.trim($(this).html()) === "Activar")){
		b = true;
		
	}
	console.log(b);
	
	$.get( urlBase+"sucursals/"+location.href.split("/")[3]+"/miembros/"+idMiembroSeleccionado, function( data ) {
		$.ajax({
			  type: "PUT",
			  url: urlBase+"sucursals/"+location.href.split("/")[3]+"/miembros/"+idMiembroSeleccionado,
			  data: {
				  	nombre: data.nombre,
			        masculino: data.masculino,
			        activo: b,
			        sucursal_id: data.sucursal_id,
			        fechaingreso: data.fechaingreso,
			},
			  success: function(r){
				  console.log("response: "+r);
				  //NOTIFICACION
				  not();
				  location.reload();
			  },
			  dataType: "json"
			});
	});
	
});


function not(){
	PNotify.prototype.options.styling = "bootstrap3";
	  var notice = new PNotify({
	   title: 'Éxito',
	   text: 'La operación fue registrada exitosamente',
	   type: 'success'
	 });
	 notice.get().click(function() {
	     notice.remove();
	 });
	  
}

function realizarPago(idSucursal,fecha,id){
$.ajax({
	  type: "POST",
	  url: "https://gym-danm97.c9users.io/sucursals/"+idSucursal+"/miembros/"+id+"/pagos",
	  data: {
	        fecha: fecha,
	        empleado_id: document.cookie.split("empleado=")[1],
	        tipopago_id: 1
	},
	  success: function(r){
		  location.reload();
	  },
	  dataType: "json"
	});
}
if(document.cookie.length>0){
	setInterval(function() {
		if(document.cookie.length==0){
			location.href="/";
		}
	},1000);
}

