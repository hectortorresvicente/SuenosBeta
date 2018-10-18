package com.htv.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Geolocalizacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idg;
	@Column(name = "ciudad")
	private String ciudad;
	@Column(name = "pais")
	private String pais;
	@Column(name = "latitud")
	private Double latitud;
	@Column(name = "longitud")
	private Double longitud;
	
	
	public Geolocalizacion(int idg, String ciudad, String pais, Double latitud, Double longitud) {
		super();
		this.idg = idg;
		this.ciudad = ciudad;
		this.pais = pais;
		this.latitud = latitud;
		this.longitud = longitud;
	}


	public int getIdg() {
		return idg;
	}


	public void setIdg(int idg) {
		this.idg = idg;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public Double getLatitud() {
		return latitud;
	}


	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}


	public Double getLongitud() {
		return longitud;
	}


	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	
	
	
}