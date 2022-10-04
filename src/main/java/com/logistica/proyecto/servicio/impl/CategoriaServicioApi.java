package com.logistica.proyecto.servicio.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.logistica.proyecto.entidad.Categoria;

public interface CategoriaServicioApi {
Page<Categoria> getAll (Pageable pageable);
}
