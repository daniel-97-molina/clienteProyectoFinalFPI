package com.example.demo.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Miembro {
private int id;
private String nombre;
private boolean masculino;
private boolean activo;
private int sucursal_id;
private Date fechaingreso;

public Miembro() {
	super();
}
public Miembro(int id, String nombre, boolean masculino, boolean activo, int sucursal_id, Date fechaingreso) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.masculino = masculino;
	this.activo = activo;
	this.sucursal_id = sucursal_id;
	this.fechaingreso = fechaingreso;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public boolean isMasculino() {
	return masculino;
}
public void setMasculino(boolean masculino) {
	this.masculino = masculino;
}
public boolean isActivo() {
	return activo;
}
public void setActivo(boolean activo) {
	this.activo = activo;
}
public int getSucursal_id() {
	return sucursal_id;
}
public void setSucursal_id(int sucursal_id) {
	this.sucursal_id = sucursal_id;
}
public Date getFechaingreso() {
	return fechaingreso;
}
public void setFechaingreso(Date fechaingreso) {
	this.fechaingreso = fechaingreso;
}

}
