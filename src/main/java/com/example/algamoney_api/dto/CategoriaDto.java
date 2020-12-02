package com.example.algamoney_api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.algamoney_api.model.Categoria;

import lombok.Getter;
import lombok.Setter;

public class CategoriaDto {
		
	@Getter @Setter
	private Long idCategoria;
	
	@Getter @Setter
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String nome;
	
	public Categoria transformaParaObjeto() {
		return new Categoria(idCategoria,nome); 
	}
	

}
