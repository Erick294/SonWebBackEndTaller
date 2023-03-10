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

import ec.edu.uce.repository.modelo.Producto;
import ec.edu.uce.repository.modelo.Rol;
import ec.edu.uce.repository.modelo.Usuario;
import ec.edu.uce.service.IProductoService;
import ec.edu.uce.service.IUsuarioService;

@RestController
@CrossOrigin()
@RequestMapping(path = "/clientes")
public class ClienteControllerRestFull {

	@Autowired
	IProductoService productoService;
	
	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping(path = "/productos/{productos}")
	public List<Producto> obtenerProductosCategoria(@PathVariable("categoria") String categoria){
		return this.productoService.buscarProductoCategoria(categoria);
	}
	
	@GetMapping(path = "/productos")
	public List<Producto> obtenerProductos(){
		return this.productoService.buscarTodos();
	}
	
	@GetMapping(path = "productos/porId/{id}")
	public Producto obtenerProductoId(@PathVariable("id") Integer id) {
		return this.productoService.buscarId(id);
	}
	@GetMapping(path = "productos/porCodigo/{codigo}")
	public Producto obtenerProductoCodigo(@PathVariable("codigo") Integer codigo) {
		return this.productoService.buscarCodigo(codigo) ;
	}
	@GetMapping(path = "productos/porNombre/{nombre}")
	public Producto obtenerProductoNombre(@PathVariable("nombre") String nombre) {
		return this.productoService.buscarNombre(nombre);
	}
	
	//crud producto
	
	@PostMapping(path = "/productos")
	public void ingresarProducto(@RequestBody Producto producto) {
		this.productoService.create(producto);
	}
	@PutMapping(path = "/productos/{id}")
	public void actualizarProducto(@PathVariable("id") Integer id, @RequestBody Producto producto) {
		producto.setId(id);
		this.productoService.update(producto);
	}
	
	@DeleteMapping(path = "/productos/{id}")
	public void borrarProducto(@PathVariable("id") Integer id) {
		this.productoService.delete(id);
	}
	
	
	
	//crud cliente
	
	@PostMapping
	public void registrarCliente(@RequestBody Usuario usuario) {
		List<Rol> roles=new ArrayList<>();
		Rol cliente=new Rol();
		roles.add(cliente);
		cliente.setNombre("cliente");
		cliente.setUsuario(usuario);
		cliente.setDescripcion("ClienteSonWeb");
		usuario.setRoles(roles);
		this.usuarioService.create(usuario);
	}
	
}
