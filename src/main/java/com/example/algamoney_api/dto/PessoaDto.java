package com.example.algamoney_api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.algamoney_api.model.Pessoa;

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
	
		
	public static Pessoa mapToPessoa(PessoaDto pessoaDto) {
		
		Pessoa objPessoa = new Pessoa();
		
		objPessoa.setIdPessoa(pessoaDto.getIdPessoa());
		objPessoa.setNome(pessoaDto.getNome());
		objPessoa.setFlgAtivo(pessoaDto.getFlgAtivo());
			
		
		return objPessoa; 
	}
	

}
