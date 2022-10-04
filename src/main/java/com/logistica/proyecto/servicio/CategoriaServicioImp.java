package com.logistica.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.proyecto.entidad.Categoria;
import com.logistica.proyecto.interfaces.InterfacesSimple;
import com.logistica.proyecto.servicio.impl.ICategoria;

@Service
public class CategoriaServicioImp implements InterfacesSimple<Categoria> {
	@Autowired
	private ICategoria DAO;

	@Override
	public List<Categoria> obtenerLista() {
		return (List<Categoria>) DAO.findAll();

	}

	@Override
	public void guardar(Categoria obj) {
		DAO.save(obj);

	}

	@Override
	public void eliminar(Integer id) {
		DAO.deleteById(id);

	}

	 

	@Override
	public Categoria BuscarPorIdEntidad(Integer id) {
		 return DAO.findById((Integer) id).orElse(null);
		 
	}

	@Override
	public boolean existe(Integer id) {
	return DAO.existsById(id);
	}

	 
	public int total() {
		return (int) DAO.count();
	}

	public int contarById(int id) {
		return  DAO.contarID(id);
	} 
	 
	 

}
