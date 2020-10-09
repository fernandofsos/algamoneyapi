package com.example.algamoney_api.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Table(name = "t_pessoa")
@SequenceGenerator(name = "S_PESSOA", sequenceName = "S_PESSOA", allocationSize = 1)
public class Pessoa {
	
	@Id
	@Getter @Setter
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PESSOA")
	@Column(name = "id_pessoa")
	private Long idPessoa;
		
	@Getter @Setter
	@NotEmpty
	@NotNull
	@Size(min = 3, max = 40)
	@Column(name = "nome")
	private String nome;
	
	@Getter @Setter
	@NotNull
	@Column(name = "flg_ativo")
	private Boolean flgAtivo ;
	
	@Embedded
	@Getter @Setter
	private Endereco endereco;
	
	
	
}
