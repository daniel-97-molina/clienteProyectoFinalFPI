$(document).ready(function() {
	$("#cmbSucursal").val('3');
});

$("#cmbSucursal").change(function() {
location.href=this.value;	
});