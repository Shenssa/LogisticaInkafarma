package com.logistica.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.proyecto.entidad.Proveedor;
import com.logistica.proyecto.interfaces.InterfacesSimple;
import com.logistica.proyecto.servicio.impl.IProveedor;

@Service
public class ProveedorServicioImp implements InterfacesSimple<Proveedor> {
	@Autowired
	private IProveedor DAO;

	@Override
	public List<Proveedor> obtenerLista() {
		return (List<Proveedor>) DAO.findAll();

	}

	@Override
	public void guardar(Proveedor obj) {
		DAO.save(obj);

	}

	@Override
	public void eliminar(Integer id) {
		DAO.deleteById(id);

	}

	 

	@Override
	public Proveedor BuscarPorIdEntidad(Integer id) {
		 return DAO.findById((Integer) id).orElse(null);
		 
	}

	@Override
	public boolean existe(Integer id) {
	return DAO.existsById(id);
	}

	 

	 
	 
	 

}
