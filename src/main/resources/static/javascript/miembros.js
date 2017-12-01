$(document).ready(function() {
	
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

