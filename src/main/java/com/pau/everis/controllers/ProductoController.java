package com.pau.everis.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pau.everis.models.Categoria;
import com.pau.everis.models.Producto;
import com.pau.everis.services.CategoriaService;
import com.pau.everis.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;

	@RequestMapping("/muestraFormulario")
	public String muestraFormulario(Model model) {
		System.out.println("nombreProd" + model.getAttribute("producto"));
		Producto producto=new Producto();
		model.addAttribute("producto", producto);
		//categoriaService.poblarCategorias();
		model.addAttribute("categorias", categoriaService.getAll());
		
		return "registroProductos.jsp";
	}
	
	@RequestMapping("/procesaFormulario")
	public String procesaFormulario(@ModelAttribute("producto") Producto producto,
									Model model){
		Producto prd = new Producto();//nombre, apellido, prdname, password);
		prd.setNombre(producto.getNombre());
		prd.setDescripcion(producto.getDescripcion());
		//obtener la categoria seleccionada para producto y asignarla al atributo del objeto a guardar
		prd.setCategoria(producto.getCategoria());
		
		prd.setPrecio(producto.getPrecio());
		System.out.println("nombre desde el procesaFormulario: " + producto.getNombre());
	
		if((producto.getNombre().isEmpty() || producto.getDescripcion().isEmpty() )
		||(  producto.getPrecio().isNaN())) { //producto.getCategorias().isEmpty() ||
			System.out.println("Uno o más datos nulos: " + producto.getNombre());
			String mensaje = "Debe completar todos los campos";
			model.addAttribute("mensaje", mensaje);
		}
		else {
			productoService.addProducto(producto);
			String mensaje = "Usuario registrado correctamente";
			model.addAttribute("mensaje", mensaje);
		}
		return "redirect:/";//"NewFile.jsp"
	}

//	@RequestMapping("/editar/{id}")
//	public String editar(@PathVariable("id") Long id, Model model) {
//		Producto prod= productoService.getById(id);
//		
//		List<Categoria> listaCategorias =  categoriaService.getAll();
//		
//		model.addAttribute("producto", prod);
//		model.addAttribute("listaCategorias", listaCategorias);
//		return "editproducto.jsp";
//	}
//	
//	@RequestMapping("/update")
//	public String update(@ModelAttribute("producto")Producto prod ) {
//		productoService.addProducto(prod);
//		return "redirect:/producto";
//	}
}
