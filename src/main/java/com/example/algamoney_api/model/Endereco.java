package com.example.algamoney_api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Embeddable
public class Endereco {
	
	@Getter @Setter
	@NotNull
	@NotEmpty
	@Column(name = "logradouro")
	private String logradouro;
	
	@Getter @Setter
	@NotNull
	@NotEmpty
	@Column(name = "numero")
	private Integer numero;
	
	@Getter @Setter
	@NotNull
	@NotEmpty
	@Column(name = "complemento")
	private String complemento;
	
	@Getter @Setter
	@NotNull
	@NotEmpty
	@Column(name = "bairro")
	private String bairro;
	
	@Getter @Setter
	@NotNull
	@NotEmpty
	@Column(name = "cep")
	private String cep;
	
	@Getter @Setter
	@NotNull
	@NotEmpty
	@Column(name = "cidade")
	private String cidade;
	
	@Getter @Setter
	@NotNull
	@NotEmpty
	@Column(name = "estado")
	private String estado;
			
	
}
