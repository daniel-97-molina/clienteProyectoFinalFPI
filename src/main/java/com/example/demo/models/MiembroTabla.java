package com.example.demo.models;

import java.sql.Date;

public class MiembroTabla extends Miembro {

	private String estado;
	private Date ultimoPago;

	public MiembroTabla() {
		super();
	}
	public MiembroTabla(String estado,Date ultimoPago,int id, String nombre, boolean masculino, boolean activo, int sucursal_id, Date fechaingreso) {
		super(id,nombre,masculino,activo,sucursal_id,fechaingreso);
		this.estado = estado;
		this.ultimoPago=ultimoPago;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getUltimoPago() {
		return ultimoPago;
	}
	public void setUltimoPago(Date ultimoPago) {
		this.ultimoPago = ultimoPago;
	}
	
	
}
