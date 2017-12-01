$(document).ready(function() {
	
});

$("#cmbSucursal").change(function() {
	location.href=this.value;	
});

$("#btnCerrarSesion").click(function(){
	document.cookie="empleado=;expires=Thu, 01 Jan 1970 00:00:01 GMT;";
	location.href="/";
});






