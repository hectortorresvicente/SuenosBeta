package com.htv.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cielo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idc;
	@Column(name = "cielo")
	private String cielo;
	
	public Cielo(int idc, String cielo) {
		super();
		this.idc = idc;
		this.cielo = cielo;
	}

	public int getIdc() {
		return idc;
	}

	public void setIdc(int idc) {
		this.idc = idc;
	}

	public String getCielo() {
		return cielo;
	}

	public void setCielo(String cielo) {
		this.cielo = cielo;
	}

}
