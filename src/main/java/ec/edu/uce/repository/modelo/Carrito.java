package ec.edu.uce.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {
	
	@Id
	@Column(name = "carr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carr")
	@SequenceGenerator(name = "seq_carr", sequenceName = "seq_carr", allocationSize = 1)
	private Integer id;
	
	@Column(name = "carr_nombre")
	private String nombre;
	
	@Column(name = "carr_precio")
	private BigDecimal precio;

	@Column(name = "carr_descripcion")
	private String descripcion;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}	
	
}