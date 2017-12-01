package com.example.demo.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Pago {
private Date fecha;
private int miembro_id;
private int empleado_id;
private int tipopago_id;

public Pago() {
	super();
}
public Pago(Date fecha, int miembro_id, int empleado_id, int tipopago_id) {
	super();
	this.fecha = fecha;
	this.miembro_id = miembro_id;
	this.empleado_id = empleado_id;
	this.tipopago_id = tipopago_id;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public int getMiembro_id() {
	return miembro_id;
}
public void setMiembro_id(int miembro_id) {
	this.miembro_id = miembro_id;
}
public int getEmpleado_id() {
	return empleado_id;
}
public void setEmpleado_id(int empleado_id) {
	this.empleado_id = empleado_id;
}
public int getTipopago_id() {
	return tipopago_id;
}
public void setTipopago_id(int tipopago_id) {
	this.tipopago_id = tipopago_id;
}


}
