package com.logistica.proyecto.servicio.impl;

 

 
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import com.logistica.proyecto.entidad.Imagen;
 
 @Transactional
public interface IImagen extends CrudRepository<Imagen, Integer> {
	@Query(value = "SELECT * FROM Imagen WHERE id_producto=?", nativeQuery = true)
	List<Imagen> findByImagens(@PathVariable int id);  
	 
}
