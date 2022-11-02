package com.logistica.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.proyecto.entidad.Rol;
import com.logistica.proyecto.interfaces.InterfacesSimple;
import com.logistica.proyecto.servicio.impl.IRol;

@Service
public class RolServicioImp implements InterfacesSimple<Rol> {
	@Autowired
	private IRol DAO;

	@Override
	public List<Rol> obtenerLista() {
		return (List<Rol>) DAO.findAll();

	}

	@Override
	public void guardar(Rol obj) {
		DAO.save(obj);

	}

	@Override
	public void eliminar(Integer id) {
		DAO.deleteById(id);

	}

	 

	@Override
	public Rol BuscarPorIdEntidad(Integer id) {
		 return DAO.findById((Integer) id).orElse(null);
		 
	}

	@Override
	public boolean existe(Integer id) {
	return DAO.existsById(id);
	}

 

}
