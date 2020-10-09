package com.example.algamoney_api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney_api.dto.PessoaDto;
import com.example.algamoney_api.exceptionhandler.XMenorQUeYException;
import com.example.algamoney_api.model.Pessoa;
import com.example.algamoney_api.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	@GetMapping
	public List<Pessoa> listar(){
		
		return pessoaRepository.findAll();
	}
	
	@PostMapping                      
	private ResponseEntity<Pessoa> criar(@Valid @RequestBody PessoaDto pessoaDto, HttpServletResponse response) throws Exception {
		
		Integer x = 0;
		Integer y = 10;
	    
		if (x < y)
			throw new XMenorQUeYException();
		
		Pessoa pessoaSalva = pessoaRepository.save(PessoaDto.mapToPessoa(pessoaDto));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
		
	}
	
	@DeleteMapping("{idPessoa}")
	private void remover(@PathVariable Long idPessoa) {
		
		pessoaRepository.deleteById(idPessoa);
		
	}
	
	

}
