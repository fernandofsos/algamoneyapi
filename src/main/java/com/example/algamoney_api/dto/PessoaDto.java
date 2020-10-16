package com.example.algamoney_api.dto;

import javax.persistence.Embedded;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

public class PessoaDto {
		
	@Getter @Setter
	private Long idPessoa;
		
	@Getter @Setter
	@NotEmpty
	@NotNull	
	@Size(min = 3, max = 40)
	private String nome;
	
	@Getter @Setter
	@NotNull
	private Boolean flgAtivo ;

	@Embedded
	@Getter @Setter
	private EnderecoDto enderecoDto ;
	

}
