package org.dam2.examenjpa.modelo;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Data

@Entity
public class Venta {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int idVenta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	private int cantidad;
	
	private LocalDate fechaCompra;
}
