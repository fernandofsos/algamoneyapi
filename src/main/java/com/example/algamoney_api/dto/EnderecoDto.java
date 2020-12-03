package com.example.algamoney_api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class EnderecoDto {
	
	@Getter @Setter
	@NotNull
	private String cep ;
		
	@Getter @Setter
	@NotNull
	private String bairro ;
		
	@Getter @Setter
	@NotNull
	private String complemento;
		
	@Getter @Setter
	@NotNull
	private Integer numero;
		
	@Getter @Setter
	@NotNull
	@NotEmpty
	private String logradouro;
	
	@Getter @Setter
	@NotNull
	@NotEmpty
	private String cidade;
		
	@Getter @Setter
	@NotNull
	@NotEmpty
	private String estado;

}
