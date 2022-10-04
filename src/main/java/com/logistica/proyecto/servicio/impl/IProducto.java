package com.logistica.proyecto.servicio.impl;

 

 
import org.springframework.data.repository.CrudRepository;

import com.logistica.proyecto.entidad.Producto;
 
 
public interface IProducto extends CrudRepository<Producto, Integer> {
	 
 
}
