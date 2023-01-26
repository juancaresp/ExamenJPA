package org.dam2.examenjpa.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Entity
public class Proveedor {

	@Id
	@NonNull
	@EqualsAndHashCode.Include
	@Column(length = 10)
	private String nif;
	
	@Column(length = 30)
	private String nombre;
	
	@Column(length = 40)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Direccion direccion;
}
