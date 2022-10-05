package com.logistica.proyecto.control;
 

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.logistica.proyecto.entidad.Imagen;
import com.logistica.proyecto.entidad.Producto;
import com.logistica.proyecto.interfaces.InterfacesSimple;
import com.logistica.proyecto.servicio.ImagenServicioImp;
 

 
 

@Controller
@RequestMapping("/Imagen")
public class ImagenControl {
	String carpeta = "Imagen";
	@Autowired
	private InterfacesSimple<Imagen> Service;
	@Autowired
	private InterfacesSimple<Producto> ServiceProducto;
	@Autowired
	private ImagenServicioImp IMP;
	
	
	@GetMapping("/ver/{idProducto}")
	public String crear(Model model, @PathVariable(value = "idProducto") Integer idProducto ) {
		 
            Producto producto=new Producto();
            int valor=idProducto;
            Imagen obj=new Imagen(producto); 
            model.addAttribute("titulo", carpeta);
		    System.out.println("--->"+idProducto );
			 
			 model.addAttribute("listaVer",IMP.ListarImagenes(valor)) ;
		 
			 model.addAttribute("listaProducto", ServiceProducto.BuscarPorIdEntidad(idProducto));
		  model.addAttribute("RutaListado", "/Producto/"); // Regresar
		 	model.addAttribute("RutaGrabar", "/" + carpeta + "/grabar"); // RutaGrabar
	      model.addAttribute("entidad", obj);// entidad

			return "/" + carpeta + "/formulario";
		

	}

	@RequestMapping("/grabar")
	public String guardar(Model model, Imagen obj,@RequestParam("file") MultipartFile foto) {
		

		if (!foto.isEmpty()) {
			String uniqueFileName = UUID.randomUUID().toString() + "_" + foto.getOriginalFilename();
			Path rootPath = Paths.get("uploads").resolve(uniqueFileName);
			Path rootAbsolutPath = rootPath.toAbsolutePath();
			try {
				Files.copy(foto.getInputStream(), rootAbsolutPath);
				obj.setRutaFoto(uniqueFileName);
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		
		Service.guardar(obj);
		return "redirect:/"+carpeta+"/ver/"+obj.getIdProducto().getIdProducto();
	}

}
