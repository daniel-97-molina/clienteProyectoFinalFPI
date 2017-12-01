package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Sucursal {
public int id;	
public String ubicacion;

public Sucursal() {
	super();
}
public Sucursal(int id, String ubicacion) {
	super();
	this.id = id;
	this.ubicacion = ubicacion;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUbicacion() {
	return ubicacion;
}
public void setUbicacion(String ubicacion) {
	this.ubicacion = ubicacion;
}


}
