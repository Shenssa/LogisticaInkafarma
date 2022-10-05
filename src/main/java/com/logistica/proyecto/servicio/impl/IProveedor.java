package com.logistica.proyecto.servicio.impl;

 

 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import com.logistica.proyecto.entidad.Proveedor;
 
 
public interface IProveedor extends CrudRepository<Proveedor, Integer> {
	   
 
	@Query(value = "Select * FROM proveedor WHERE empresa =:empresa", nativeQuery = true)
	List<Proveedor> buscarEmpresa(@PathVariable String empresa); 
	
	  
}
