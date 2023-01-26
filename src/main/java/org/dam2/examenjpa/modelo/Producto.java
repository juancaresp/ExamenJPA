package org.dam2.examenjpa.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Producto {

	@Id
	@EqualsAndHashCode.Include
	@Column(length = 10,nullable = false)
	private String nrefer;
	
	@Column(length = 30)
	private String nombre;
	
	private int stock;
	
	private float pvp;
	
	private float pvd;
	
	private int pedidos;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Proveedor proveedor;
	
}
