package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TipoPago {
private String nombre;
private double monto;

public TipoPago() {
	super();
}
public TipoPago(String nombre, double monto) {
	super();
	this.nombre = nombre;
	this.monto = monto;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getMonto() {
	return monto;
}
public void setMonto(double monto) {
	this.monto = monto;
}


}
