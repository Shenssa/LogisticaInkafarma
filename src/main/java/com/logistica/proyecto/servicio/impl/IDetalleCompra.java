package com.logistica.proyecto.servicio.impl;

 

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.logistica.proyecto.entidad.DetalleCompra;
 
 
public interface IDetalleCompra extends CrudRepository<DetalleCompra, Integer>,JpaRepository<DetalleCompra, Integer> {  
	 
	 
	
}
