package ec.edu.uce.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.Carrito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CarritoRepoImpl implements ICarritoRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Carrito car) {
		// TODO Auto-generated method stub
		this.entityManager.persist(car);
	}

	@Override
	public Carrito read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Carrito.class, id);
	}

	@Override
	public void update(Carrito car) {
		// TODO Auto-generated method stub
		this.entityManager.merge(car);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.read(id));
	}
	
	@Override
	public List<Carrito> buscarTodos() {
		TypedQuery<Carrito> myQuery=this.entityManager.createQuery("Select c from Carrito c", Carrito.class);
		return myQuery.getResultList();
	}

	
}