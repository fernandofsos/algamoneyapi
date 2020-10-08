package com.example.algamoney_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@EqualsAndHashCode
@Entity
@Table(name = "t_categoria")
@SequenceGenerator(name = "S_CATEGORIA", sequenceName = "S_CATEGORIA", allocationSize = 1)
public class Categoria {

	@Id
	@Getter @Setter
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CATEGORIA")
	@Column(name = "id_categoria")
	private Long idCategoria;

	 
	@Getter @Setter
	@NotEmpty
	@NotNull
	@Size(min = 3, max = 40)
	private String nome;
	
}
