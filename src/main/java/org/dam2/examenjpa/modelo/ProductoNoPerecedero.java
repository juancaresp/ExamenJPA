package org.dam2.examenjpa.modelo;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

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
public class ProductoNoPerecedero extends Producto {
	
	//@Enumerated
	private Formato formato;
	private boolean frio;
}
