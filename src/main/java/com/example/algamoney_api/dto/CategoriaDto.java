package com.example.algamoney_api.dto;

import javax.validation.constraints.NotNull;

import com.example.algamoney_api.model.Categoria;

import lombok.Getter;
import lombok.Setter;

public class CategoriaDto {
		
	@Getter @Setter
	private Long idCategoria;
	
	@Getter @Setter
	@NotNull
	private String nome;
	
	public Categoria transformaParaObjeto() {
		return new Categoria(idCategoria,nome); 
	}
	

}
