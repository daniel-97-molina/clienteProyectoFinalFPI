package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Empleado {
	private String codigo;
	private String nombre;
	private int sucursal_id;
	private String contrasena;
	
	public Empleado() {
		super();
	}
	public Empleado(String codigo, String nombre,int sucursal_id,String contrasena) {
		super();
		this.codigo=codigo;
		this.nombre=nombre;
		this.sucursal_id=sucursal_id;
		this.contrasena=contrasena;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSucursal_id() {
		return sucursal_id;
	}
	public void setSucursal_id(int sucursal_id) {
		this.sucursal_id = sucursal_id;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", nombre=" + nombre + ", idSucursal="+sucursal_id+", contraseña="+contrasena+"]";
	}
}
