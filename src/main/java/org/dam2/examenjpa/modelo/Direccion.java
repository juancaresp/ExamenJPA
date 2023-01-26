package org.dam2.examenjpa.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Entity
public class Direccion {

	@Id
	@EqualsAndHashCode.Include
	private int id;
	
	@Column(length = 30)
	private String calle;
	
	@Column(length = 10)
	private String portal;
	
	@Column(length = 30)
	private String localidad;
	
	@Column(length = 5)
	private String codPostal;
}
