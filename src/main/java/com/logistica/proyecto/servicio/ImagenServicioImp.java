package com.logistica.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.proyecto.entidad.Imagen;
import com.logistica.proyecto.interfaces.InterfacesSimple;
import com.logistica.proyecto.servicio.impl.IImagen;

@Service
public class ImagenServicioImp implements InterfacesSimple<Imagen> {
	@Autowired
	private IImagen DAO;

	@Override
	public List<Imagen> obtenerLista() {
		return (List<Imagen>) DAO.findAll();

	}

	@Override
	public void guardar(Imagen obj) {
		DAO.save(obj);

	}

	@Override
	public void eliminar(Integer id) {
		DAO.deleteById(id);

	}

	@Override
	public Imagen BuscarPorIdEntidad(Integer id) {
		return DAO.findById((Integer) id).orElse(null);

	}

	@Override
	public boolean existe(Integer id) {
		return DAO.existsById(id);
	}

	public List<Imagen> ListarImagenes(int id) {
		return (List<Imagen>) DAO.findByImagens(id);

	}

}
