package com.logistica.proyecto.control;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.logistica.proyecto.entidad.Categoria;
import com.logistica.proyecto.entidad.Marca;
import com.logistica.proyecto.entidad.Producto;
import com.logistica.proyecto.interfaces.InterfacesSimple;
import com.logistica.proyecto.servicio.ProductoServicioImp;
import com.logistica.proyecto.servicio.ProveedorServicioImp;
 

@Controller
@RequestMapping("/Producto")
public class ProductoControl {
	String carpeta = "Producto";
	@Autowired
	private InterfacesSimple<Producto> Service;
	@Autowired
	private InterfacesSimple<Categoria> ServiceCategoria;
	
	@Autowired
	private InterfacesSimple<Marca> ServiceMarca;
	@Autowired
	private ProductoServicioImp servicioIMP;
	
	@RequestMapping({"/buscar/"})
	public String inicioB(Model model,@RequestParam(name="tipo") int tipo,@RequestParam(name="valor",required = false) Double valor) {
	  
	  
	   
	  switch(tipo) {
	  case 1: //Menor o igual
		  model.addAttribute("mensaje","Producto con precio >= ");
		  model.addAttribute("lista1",valor);
		  model.addAttribute("lista",servicioIMP.BuscarPorPrecioMayor(valor)); 
		  model.addAttribute("cantidad",servicioIMP.CantidadFiltroPrecioMayor(valor));
		  break;
		  
	  case 2: //Mayor igual
		  model.addAttribute("mensaje","Producto con precio <= ");
		  model.addAttribute("lista1",valor);
		  model.addAttribute("lista",servicioIMP.BuscarPorPrecioMenor(valor)); 
		  model.addAttribute("cantidad",servicioIMP.CantidadFiltroPrecioMenor(valor));
		  break;
		  
	  case 3: 
		  model.addAttribute("mensaje","Producto con stock  <= al stockMinimo ");
		  model.addAttribute("lista1","");
		  model.addAttribute("lista",servicioIMP.BuscarPorStockMinimo()); 
		  model.addAttribute("cantidad",servicioIMP.CantidadBuscarPorStockMinimo());
		  break;
	  }
	   
	   
	 
	  return "/" + carpeta + "/buscar";
	}
	
	
	
	@RequestMapping("/")
	public String inicio(Model model) {
		model.addAttribute("titulo", carpeta);
		model.addAttribute("RutaNuevo", "/" + carpeta + "/crear/"); // Crear
		model.addAttribute("RutaEliminar", "/" + carpeta + "/eliminar/"); // Eliminar
		model.addAttribute("RutaEditar", "/" + carpeta + "/editar/"); // Editar
		model.addAttribute("RutaVer", "/"  + "Imagen/ver/"); // Editar
		model.addAttribute("lista", Service.obtenerLista());
		model.addAttribute("listaCategoria", ServiceCategoria.obtenerLista());//ListaCategoria
		model.addAttribute("listaMarca", ServiceMarca.obtenerLista());//ListaMarca
		return "/" + carpeta + "/listado";
	}

	@GetMapping("/crear/")
	public String crear(Model model) {
		// instanciar entidad Nuevo
		Producto obj = new Producto();
		model.addAttribute("titulo", "Registrar " + carpeta);// titulo
		model.addAttribute("RutaListado", "/" + carpeta + "/"); // RutaListado
		model.addAttribute("RutaGrabar", "/" + carpeta + "/grabar"); // RutaGrabar
		model.addAttribute("listaCategoria", ServiceCategoria.obtenerLista());//ListaCategoria
		model.addAttribute("listaMarca", ServiceMarca.obtenerLista());//ListaMarca
		model.addAttribute("entidad", obj);// entidad
		return "/" + carpeta + "/formulario";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Integer id, Model model) {
		Producto obj = null;
		if (Service.existe(id) == true) {
			obj = Service.BuscarPorIdEntidad(id);
			model.addAttribute("titulo", "Modificar " + carpeta);
			model.addAttribute("RutaListado", "/" + carpeta + "/"); // RutaListado
			model.addAttribute("RutaGrabar", "/" + carpeta + "/grabar"); // RutaGrabar
			model.addAttribute("listaCategoria", ServiceCategoria.obtenerLista());//ListaCategoria
			model.addAttribute("listaMarca", ServiceMarca.obtenerLista());//ListaMarca
			model.addAttribute("entidad", obj);// modificar

			return "/" + carpeta + "/formulario";
		} else {
			return "/" + carpeta + "/error";
		}

	}

	@RequestMapping("/grabar")
	public String guardar(Model model, Producto obj) {
		Service.guardar(obj);
		return "redirect:";
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer id) {
		Service.eliminar(id);
		return "redirect:../";
	}

}
