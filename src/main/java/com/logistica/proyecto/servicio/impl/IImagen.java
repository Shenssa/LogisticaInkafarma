package com.logistica.proyecto.servicio.impl;

 

 
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.logistica.proyecto.entidad.Imagen;
import com.logistica.proyecto.entidad.Producto;
 
 @Transactional
public interface IImagen extends CrudRepository<Imagen, Integer> {
	@Query(value = "SELECT * FROM Imagen WHERE id_producto=?", nativeQuery = true)
	List<Imagen> findByImagens(Producto id);  
	 
}
