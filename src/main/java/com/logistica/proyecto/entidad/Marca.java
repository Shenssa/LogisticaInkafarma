package com.logistica.proyecto.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMarca")
	int idMarca;
	String nombre;
	
	
	
	public Marca() {
		super();
	}



	public Marca(int idMarca, String nombre) {
		super();
		this.idMarca = idMarca;
		this.nombre = nombre;
	}



	public int getIdMarca() {
		return idMarca;
	}



	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
 
	
	

}
