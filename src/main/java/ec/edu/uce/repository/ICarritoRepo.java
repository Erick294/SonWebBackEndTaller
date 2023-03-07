package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.repository.modelo.Carrito;

public interface ICarritoRepo {

	public void create(Carrito car);
	public Carrito read(Integer id); 
	public void update(Carrito car); 
	public void delete(Integer id);	
	public List<Carrito> buscarTodos();
	
}
