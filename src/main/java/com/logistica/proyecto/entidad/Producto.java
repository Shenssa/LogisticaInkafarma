package com.logistica.proyecto.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
@Entity
@Table
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProducto")
	int idProducto;
	@OneToOne
	@JoinColumn(name = "idCategoria")
	Categoria idCategoria;
	
	@OneToOne
	@JoinColumn(name = "idMarca")
	Marca idMarca;
	String nombre;
	String descripcion;
	Double precioCosto;
	Double precioVenta;
	int stock;
	int stockMinimo;
	String estado;
	
	
	
	public Producto() {
		super();
	}


	public Producto(int idProducto) {
		super();
		this.idProducto = idProducto;
	}

 

 


	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public Categoria getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}


	public Marca getIdMarca() {
		return idMarca;
	}


	public void setIdMarca(Marca idMarca) {
		this.idMarca = idMarca;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getPrecioCosto() {
		return precioCosto;
	}


	public void setPrecioCosto(Double precioCosto) {
		this.precioCosto = precioCosto;
	}


	public Double getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getStockMinimo() {
		return stockMinimo;
	}


	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	 


	public Producto(int idProducto, Categoria idCategoria, Marca idMarca, String nombre, String descripcion,
			Double precioCosto, Double precioVenta, int stock, int stockMinimo, String estado) {
		super();
		this.idProducto = idProducto;
		this.idCategoria = idCategoria;
		this.idMarca = idMarca;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioCosto = precioCosto;
		this.precioVenta = precioVenta;
		this.stock = stock;
		this.stockMinimo = stockMinimo;
		this.estado = estado;
	}


	@PrePersist
	@PreUpdate
	void inicio() {
		estado="ACTIVO";
		precioVenta=0.0;
		stock=0;
	}

 

	 
	
	
	
}
