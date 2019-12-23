package com.indigital.retotech.cliente.dto;

import io.swagger.annotations.ApiModelProperty;

public class ClienteDto {

	private String id;
	
	@ApiModelProperty(required = true)
	private String nombre;
	
	@ApiModelProperty(required = true)
	private String apellido;
	
	private Integer edad;
	
	@ApiModelProperty(notes = "Formato requerido: dd/MM/yyyy", required = true)
	private String fechaNacimiento;
	
	private String fechaProbableMuerte;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaProbableMuerte() {
		return fechaProbableMuerte;
	}

	public void setFechaProbableMuerte(String fechaProbableMuerte) {
		this.fechaProbableMuerte = fechaProbableMuerte;
	}

	@Override
	public String toString() {
		return "ClienteDto [id=" + id + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", edad=" + edad
				+ ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaProbableMuerte=" + fechaProbableMuerte + "]";
	}
	
}
