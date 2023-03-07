package ec.edu.uce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import ec.edu.uce.repository.modelo.Carrito;
import ec.edu.uce.service.ICarritoService;

@RestController
@CrossOrigin()
@RequestMapping(path = "/carritos")
public class CarritoControllerRestFull {

	@Autowired
	ICarritoService carritoService;
	
	@GetMapping()
	public List<Carrito> obtenerProductos(){
		return this.carritoService.buscarTodos();
	}
	
	//crud producto
	
	@PostMapping()
	public void ingresarProducto(@RequestBody Carrito car) {
		this.carritoService.create(car);
	}
	
	@DeleteMapping(path = "/{id}")
	public void borrarProducto(@PathVariable("id") Integer id) {
		this.carritoService.delete(id);
	}
}
