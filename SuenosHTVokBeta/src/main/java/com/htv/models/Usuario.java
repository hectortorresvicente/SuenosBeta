package com.htv.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idu;
	@Column(name = "correo")
	private String correo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "contraseña")
	private String contraseña;

//	@OneToMany(mappedBy = "sueno",  cascade = CascadeType.ALL ) //fetch = FetchType.EAGER
//	@JoinTable(name = "sueno", joinColumns = { @JoinColumn(name = "idu") }, inverseJoinColumns = {
//			@JoinColumn(name = "ids") })
//	private Set<Sueno> ListSueno;
//
//
//	public Usuario(int idu, String correo, String nombre, String contraseña, Set<Sueno> listSueno) {
//		super();
//		this.idu = idu;
//		this.correo = correo;
//		this.nombre = nombre;
//		this.contraseña = contraseña;
//		ListSueno = listSueno;
//	}

	public Usuario(int idu, String correo, String nombre, String contraseña) {
		super();
		this.idu = idu;
		this.correo = correo;
		this.nombre = nombre;
		this.contraseña = contraseña;
	}

	public Usuario() {

	}



//	public Set<Sueno> getListSueno() {
//		return ListSueno;
//	}
//
//	public void setListSueno(Set<Sueno> listSueno) {
//		ListSueno = listSueno;
//	}

	public Usuario(String nombre, String contraseña) {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String correo2, String nombre2, String contraseña2) {
		// TODO Auto-generated constructor stub
	}

	public int getIdu() {
		return idu;
	}

	public void setIdu(int idu) {
		this.idu = idu;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String mail) {
		this.correo = mail;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

//	public Sueno getSueno() {
//		return sueno;
//	}
//
//	public void setSueno(Sueno sueno) {
//		this.sueno = sueno;
//	}

}
