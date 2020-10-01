package com.example.algamoney_api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoney_api.model.Categoria;
import com.example.algamoney_api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	public void  criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		
		Categoria categoriaSalva = categoriaRepository.save(categoria);
				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idCategoria}")
				.buildAndExpand(categoriaSalva.getIdCategoria()).toUri();
		
		  
		response.setHeader("Location", uri.toASCIIString());
			
	}
	
		
	
	
	
	@GetMapping("/{idCategoria}") 
	public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long idCategoria) {

		Optional<Categoria> objCategoria = categoriaRepository.findById(idCategoria);
		
		if (objCategoria.isPresent()) {
			
			return  ResponseEntity.ok(objCategoria.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	
	}

}
