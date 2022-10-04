package com.logistica.proyecto.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table
public class Imagen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idImagen")
    int idImagen;
	@ManyToOne
	@JoinColumn(name = "idProducto")
	Producto idProducto;
	String rutaFoto;
	 
	
	public Imagen() {
		super();
	}
	public Imagen(Producto idProducto) {
		super();
		this.idProducto = idProducto;
		 
	}
	public Imagen(int idImagen, Producto idProducto, String rutaFoto) {
		super();
		this.idImagen = idImagen;
		this.idProducto = idProducto;
		this.rutaFoto = rutaFoto;
	}
	public int getIdImagen() {
		return idImagen;
	}
	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}
	public Producto getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}
	public String getRutaFoto() {
		return rutaFoto;
	}
	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}
	@Override
	public String toString() {
		return "Imagen [idImagen=" + idImagen + ", idProducto=" + idProducto + ", rutaFoto=" + rutaFoto + "]";
	}

	
	 
	
	
	
	
	
	
}
