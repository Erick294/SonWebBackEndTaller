package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.ICarritoRepo;
import ec.edu.uce.repository.modelo.Carrito;

@Service
public class CarritoServiceImpl implements ICarritoService {

	@Autowired
	private ICarritoRepo carritoRepo;

	@Override
	public void create(Carrito car) {
		// TODO Auto-generated method stub
		this.carritoRepo.create(car);
	}

	@Override
	public Carrito read(Integer id) {
		// TODO Auto-generated method stub
		return this.carritoRepo.read(id);
	}

	@Override
	public void update(Carrito car) {
		// TODO Auto-generated method stub
		this.carritoRepo.update(car);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.carritoRepo.delete(id);
	}

	@Override
	public List<Carrito> buscarTodos() {
		// TODO Auto-generated method stub
		return this.carritoRepo.buscarTodos();
	}



}

