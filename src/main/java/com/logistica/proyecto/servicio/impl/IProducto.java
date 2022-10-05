package com.logistica.proyecto.servicio.impl;

 

 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import com.logistica.proyecto.entidad.Producto;
 
 
public interface IProducto extends CrudRepository<Producto, Integer> {
	 

	@Query(value = "Select * FROM producto WHERE precio_costo >=:precio_costo order by precio_costo", nativeQuery = true)
	List<Producto> buscarPorPrecioMayor(@PathVariable Double precio_costo); 
	

	@Query(value = "Select COUNT(*) FROM producto WHERE precio_costo >=:precio_costo", nativeQuery = true)
	 int contarPorFiltroMayor(@PathVariable Double precio_costo); 
	
	
	
	@Query(value = "Select * FROM producto WHERE precio_costo <=:precio_costo order by precio_costo", nativeQuery = true)
	List<Producto> buscarPorPrecioMenor(@PathVariable Double precio_costo); 
	

	@Query(value = "Select COUNT(*) FROM producto WHERE precio_costo <=:precio_costo", nativeQuery = true)
	 int contarPorFiltroMenor(@PathVariable Double precio_costo); 
	

	@Query(value = "Select * from producto where stock_minimo>=stock ", nativeQuery = true)
	List<Producto> buscarPorStockMinimo(); 
	
	
	@Query(value = "Select COUNT(*) FROM producto where stock_minimo>=stock", nativeQuery = true)
	 int contarPorProductoMinimo(); 
	 
}
