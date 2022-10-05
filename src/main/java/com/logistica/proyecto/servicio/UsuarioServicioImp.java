package com.logistica.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.proyecto.entidad.Proveedor;
import com.logistica.proyecto.entidad.Usuario;
import com.logistica.proyecto.interfaces.InterfacesSimple;
import com.logistica.proyecto.servicio.impl.IUsuario;

@Service
public class UsuarioServicioImp implements InterfacesSimple<Usuario> {
	@Autowired
	private IUsuario DAO;

	@Override
	public List<Usuario> obtenerLista() {
		return (List<Usuario>) DAO.findAll();

	}

	@Override
	public void guardar(Usuario obj) {
		DAO.save(obj);

	}

	@Override
	public void eliminar(Integer id) {
		DAO.deleteById(id);

	}

	 

	@Override
	public Usuario BuscarPorIdEntidad(Integer id) {
		 return DAO.findById((Integer) id).orElse(null);
		 
	}

	@Override
	public boolean existe(Integer id) {
	return DAO.existsById(id);
	}

 

}
