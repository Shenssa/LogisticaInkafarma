package com.logistica.proyecto.interfaces;

import java.util.List;

public interface InterfacesSimple<T> {
public List<T> obtenerLista();
public void guardar(T obj);
public void eliminar(Integer id);
public T BuscarPorIdEntidad(Integer id);
public boolean existe(Integer id);
}
