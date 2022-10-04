package com.logistica.proyecto.servicio.impl;

 

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.logistica.proyecto.entidad.Categoria;
 
 
public interface ICategoria extends CrudRepository<Categoria, Integer>,JpaRepository<Categoria, Integer> {  
	@Query(value = "SELECT COUNT(id_categoria) FROM producto  where id_categoria=?;", nativeQuery = true)
	 int contarID(int idCategoria);
	 
	
}
