package com.logistica.proyecto.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DetalleCompra {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Integer idCompra;
@OneToOne
@JoinColumn(name = "idProducto")	
Producto producto;
int cantidad ;
public Integer getIdCompra() {
	return idCompra;
}
public void setIdCompra(Integer idCompra) {
	this.idCompra = idCompra;
}
public Producto getProducto() {
	return producto;
}
public void setProducto(Producto producto) {
	this.producto = producto;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public DetalleCompra(Integer idCompra, Producto producto, int cantidad) {
	super();
	this.idCompra = idCompra;
	this.producto = producto;
	this.cantidad = cantidad;
}
public DetalleCompra() {
	super();
}
public DetalleCompra(Producto producto) {
	super();
	this.producto = producto;
}
@Override
public String toString() {
	return "DetalleCompra [idCompra=" + idCompra + ", producto=" + producto + ", cantidad=" + cantidad + "]";
}
 
 



}
