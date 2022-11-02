package com.logistica.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.proyecto.entidad.DetalleCompra;
import com.logistica.proyecto.interfaces.InterfacesSimple;
import com.logistica.proyecto.servicio.impl.IDetalleCompra;

@Service
public class DetalleCompraServicioImp implements InterfacesSimple<DetalleCompra> {
	@Autowired
	private IDetalleCompra DAO;

	@Override
	public List<DetalleCompra> obtenerLista() {
		return (List<DetalleCompra>) DAO.findAll();

	}

	@Override
	public void guardar(DetalleCompra obj) {
		DAO.save(obj);

	}

	@Override
	public void eliminar(Integer id) {
		DAO.deleteById(id);

	}

	 

	@Override
	public DetalleCompra BuscarPorIdEntidad(Integer id) {
		 return DAO.findById((Integer) id).orElse(null);
		 
	}

	@Override
	public boolean existe(Integer id) {
	return DAO.existsById(id);
	}

	  
	 

}
