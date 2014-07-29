package com.hcca.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.hcca.model.Usuario;

@Entity
public class Persona {
	@Id @GeneratedValue @Column(name = "idpersona")
	private Integer idPersona;
	
	@Column(name = "nombre", length = 90, nullable = true)
	private String nombre;
	@Column(name = "apellidopaterno", length = 90, nullable = true)
	private String apellidoPaterno;
	@Column(name = "apellidomaterno", length = 90, nullable = true)
	private String apellidoMaterno;
	@Column(name = "telefono", length = 90, nullable = true)
	private String telefono;
	@Column(name = "dni", length = 8, nullable = true)
	private Integer dni;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idusuario", nullable = false)
	private Usuario usuario;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
}
