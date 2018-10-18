package com.htv.models;

import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sueno")
public class Sueno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ids;

	@Column(name = "titulo")
	private String titulo;
	@Column(name = "sueno")
	private String sueno;
	@Column(name = "comentario")
	private String comentario;
	@Column(name = "idu")
	private int idu;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "idu" )
//	private Usuario usuario;
//
//	public Sueno(int ids, String titulo, String sueno, String comentario, Usuario usuario) {
//		super();
//		this.ids = ids;
//		this.titulo = titulo;
//		this.sueno = sueno;
//		this.comentario = comentario;
//		this.usuario = usuario;
//	}

	public Sueno(int ids, String titulo, String sueno, String comentario, int idu) {
		super();
		this.ids = ids;
		this.titulo = titulo;
		this.sueno = sueno;
		this.comentario = comentario;
		this.idu = idu;
	}

	public Sueno(int ids, String titulo, String sueno, String comentario) {
		super();
		this.ids = ids;
		this.titulo = titulo;
		this.sueno = sueno;
		this.comentario = comentario;
	}

	public Sueno(Sueno sueñoModificado) {

	}

	public Sueno() {

	}

//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

	public int getIdu() {
		return idu;
	}

	public void setIdu(int idu) {
		this.idu = idu;
	}

	public Sueno(String string) {
		// TODO Auto-generated constructor stub
	}

	public int getIds() {
		return ids;
	}

	public void setIds(int ids) {
		this.ids = ids;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSueno() {
		return sueno;
	}

	public void setSueno(String sueno) {
		this.sueno = sueno;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void getTitulo(String titulo) {
		this.titulo = titulo;

	}

	public void getSueno(String sueno) {
		this.sueno = sueno;

	}

	public void getComentario(String comentario) {
		this.comentario = comentario;

	}
}
