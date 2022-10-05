package com.logistica.proyecto.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Proveedor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "idProveedor")
Integer idProveedor ;
String ruc;
String Empresa;
String telefono;

 
public Proveedor() {
	super();
}
public Proveedor(Integer idProveedor, String ruc, String empresa, String telefono) {
	super();
	this.idProveedor = idProveedor;
	this.ruc = ruc;
	Empresa = empresa;
	this.telefono = telefono;
}
public Integer getIdProveedor() {
	return idProveedor;
}
public void setIdProveedor(Integer idProveedor) {
	this.idProveedor = idProveedor;
}
public String getRuc() {
	return ruc;
}
public void setRuc(String ruc) {
	this.ruc = ruc;
}
public String getEmpresa() {
	return Empresa;
}
public void setEmpresa(String empresa) {
	Empresa = empresa;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}



}
