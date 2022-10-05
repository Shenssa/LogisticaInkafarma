package com.logistica.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.proyecto.entidad.Producto;
import com.logistica.proyecto.entidad.Proveedor;
import com.logistica.proyecto.interfaces.InterfacesSimple;
import com.logistica.proyecto.servicio.impl.IProducto;

@Service
public class ProductoServicioImp implements InterfacesSimple<Producto> {
	@Autowired
	private IProducto DAO;

	@Override
	public List<Producto> obtenerLista() {
		return (List<Producto>) DAO.findAll();

	}

	@Override
	public void guardar(Producto obj) {
		DAO.save(obj);

	}

	@Override
	public void eliminar(Integer id) {
		DAO.deleteById(id);

	}

	 

	@Override
	public Producto BuscarPorIdEntidad(Integer id) {
		 return DAO.findById((Integer) id).orElse(null);
		 
	}

	@Override
	public boolean existe(Integer id) {
	return DAO.existsById(id);
	}

	 
	 
	 public List<Producto> BuscarPorPrecioMayor(Double  valor) {
			 return  DAO.buscarPorPrecioMayor(valor);
			 
		}
	 public int CantidadFiltroPrecioMayor(Double  valor) {
		 return  DAO.contarPorFiltroMayor(valor);
		 
	}
	 
	 public List<Producto> BuscarPorPrecioMenor(Double  valor) {
		 return  DAO.buscarPorPrecioMenor(valor);
		 
	}
     public int CantidadFiltroPrecioMenor(Double  valor) {
	 return  DAO.contarPorFiltroMenor(valor);
	 
}
	 
     

	 public List<Producto> BuscarPorStockMinimo() {
			 return  DAO.buscarPorStockMinimo();
			 
		}
	 public int CantidadBuscarPorStockMinimo() {
		 return  DAO.contarPorProductoMinimo();
		 
	}
}
