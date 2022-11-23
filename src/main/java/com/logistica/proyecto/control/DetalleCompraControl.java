package com.logistica.proyecto.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.logistica.proyecto.entidad.DetalleCompra;
import com.logistica.proyecto.entidad.Producto;
import com.logistica.proyecto.interfaces.InterfacesSimple;
import com.logistica.proyecto.servicio.DetalleCompraServicioImp;

@Controller
@SessionAttributes({ "carrito" })
@RequestMapping("/DetalleCompra")
public class DetalleCompraControl {
	String carpeta = "DetalleCompra";
	@Autowired
	private InterfacesSimple<DetalleCompra> Service;

	@Autowired
	private InterfacesSimple<Producto> ServicioProducto;

	@Autowired
	DetalleCompraServicioImp servicioIMP;

	@Autowired
	DetalleCompraServicioImp DATOSComprar;

	@ModelAttribute("carrito")
	public List<Producto> getListado() {
		List<Producto> listaCarrito = new ArrayList<>();
		return listaCarrito;
	}

	@RequestMapping("/")
	public String inicio(@ModelAttribute("carrito") List<Producto> listaCarrito, Model model) {
		model.addAttribute("titulo", "Compra");
		model.addAttribute("RutaNuevo", "/" + carpeta + "/crear/"); // Crear
		model.addAttribute("lista", Service.obtenerLista());
		model.addAttribute("listaProducto", ServicioProducto.obtenerLista());

		return "/" + carpeta + "/listado";
	}

	@RequestMapping("/agregar")
	public String agregarCarrito(@ModelAttribute("carrito") List<DetalleCompra> listaCarrito,
			@RequestParam(name = "valor", required = false) int valor) {
        
		System.err.println("ID " + valor);
        int idProducto = valor;
		Producto p = ServicioProducto.BuscarPorIdEntidad(idProducto);
		 DATOSComprar.INSERTCompra();
		int id =DATOSComprar.select()+1;
		listaCarrito.add(new DetalleCompra(id, new Producto(p.getIdProducto(), p.getNombre(), p.getPrecioCosto()), 1));
		System.err.println("dd" + new DetalleCompra(id, new Producto(p.getIdProducto(), p.getNombre(), p.getPrecioCosto()), 1));

		System.err.println("asdas");
		for (DetalleCompra detalleCompra : listaCarrito) {
			System.err.println("List " + detalleCompra.getProducto().getNombre());
		}
		return "redirect:";
	}

	@RequestMapping("/grabar")
	public String guardar(Model model, @ModelAttribute("carrito") List<DetalleCompra> listaCarrito) {
		for (DetalleCompra item : listaCarrito) {
			System.err.println("add" + item);
		}
		servicioIMP.guardarTodo(listaCarrito);
		listaCarrito.removeAll(listaCarrito);
		return "redirect:";
	}

	@GetMapping("/eliminar")
	public String eliminar(@ModelAttribute("carrito") List<DetalleCompra> listaCarrito) {
		System.err.println("ELIMINANDO" + 0);

		listaCarrito.remove(0);

		return "redirect:";
	}

}
