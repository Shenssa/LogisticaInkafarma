 package com.logistica.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.proyecto.entidad.Marca;
import com.logistica.proyecto.interfaces.InterfacesSimple;
import com.logistica.proyecto.servicio.impl.IMarca;

@Service
public class MarcaServicioImp implements InterfacesSimple<Marca> {
	@Autowired
	private IMarca DAO;

	@Override
	public List<Marca> obtenerLista() {
		return (List<Marca>) DAO.findAll();

	}

	@Override
	public void guardar(Marca obj) {
		DAO.save(obj);

	}

	@Override
	public void eliminar(Integer id) {
		DAO.deleteById(id);

	}

	 

	@Override
	public Marca BuscarPorIdEntidad(Integer id) {
		 return DAO.findById((Integer) id).orElse(null);
		 
	}

	@Override
	public boolean existe(Integer id) {
	return DAO.existsById(id);
	}

	 
	public int total() {
		return (int) DAO.count();
	}

 
	 
	 

}
