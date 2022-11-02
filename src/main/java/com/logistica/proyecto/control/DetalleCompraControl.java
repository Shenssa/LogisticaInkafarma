package com.logistica.proyecto.control;
 
 

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.logistica.proyecto.entidad.DetalleCompra;
import com.logistica.proyecto.entidad.Producto;
import com.logistica.proyecto.interfaces.InterfacesSimple;
 

@Controller
@SessionAttributes({ "carrito" })
@RequestMapping("/DetalleCompra")
public class DetalleCompraControl {
	String carpeta = "DetalleCompra";
	@Autowired
	private InterfacesSimple<DetalleCompra> Service;

	@Autowired
	private InterfacesSimple<Producto> ServicioProducto;
	 

	@ModelAttribute("carrito")
	public List<Producto> getListado() {
		List<Producto> listaCarrito = new ArrayList<>();
		return listaCarrito;
	}
	
	
	@RequestMapping("/")
	public String inicio(@ModelAttribute("carrito") List<Producto> listaCarrito,Model model) {
		model.addAttribute("titulo", "Compra");
		model.addAttribute("RutaNuevo", "/" + carpeta + "/crear/"); // Crear
		model.addAttribute("lista", Service.obtenerLista());
		model.addAttribute("listaProducto", ServicioProducto.obtenerLista()); 
 
        return "/" + carpeta + "/listado";
	}
 
	
	@RequestMapping("/agregar")
	public String agregarCarrito(@ModelAttribute("carrito") List<Integer> listaCarrito) {
		listaCarrito.add(1);
		System.err.println("List "+ listaCarrito);
		return "redirect:";
	}
	
	@RequestMapping("/grabar")
	public String guardar(Model model,List<Integer> listaCarrito) {
		for (Integer item : listaCarrito) {
			System.err.println("add"+item);
		}
		 
		//Service.guardar(obj);
		return "redirect:";
	}


}
