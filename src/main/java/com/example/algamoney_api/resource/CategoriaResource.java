package com.example.algamoney_api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoney_api.dto.CategoriaDto;
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
	public ResponseEntity<CategoriaDto> criar(@Valid @RequestBody CategoriaDto categoriaDto, HttpServletResponse response) {
		
		Categoria categoriaSalva = categoriaRepository.save(categoriaDto.transformaParaObjeto());
				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idCategoria}")
				.buildAndExpand(categoriaSalva.getIdCategoria()).toUri();
				  
		//response.setHeader("Location", uri.toASCIIString());
		
		BeanUtils.copyProperties(categoriaSalva, categoriaDto); 
				
		return ResponseEntity.created(uri).body(categoriaDto);	
	}
		
	
	@GetMapping("/{idCategoria}") 
	public ResponseEntity<CategoriaDto> buscarPeloCodigo(@PathVariable Long idCategoria) {
		
		CategoriaDto categoriaDto = new CategoriaDto();
		Optional<Categoria> optcategoria = categoriaRepository.findById(idCategoria);
						
		if(optcategoria.isPresent()) {
			BeanUtils.copyProperties(optcategoria.get(), categoriaDto); 
			return ResponseEntity.ok(categoriaDto);
		}else {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(categoriaDto);
			return ResponseEntity.notFound().build();
		}

	}

}
