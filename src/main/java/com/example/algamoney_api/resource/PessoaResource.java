package com.example.algamoney_api.resource;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoney_api.dto.EnderecoDto;
import com.example.algamoney_api.dto.PessoaDto;
import com.example.algamoney_api.exceptionhandler.XMenorQUeYException;
import com.example.algamoney_api.model.Endereco;
import com.example.algamoney_api.model.Pessoa;
import com.example.algamoney_api.repository.PessoaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository pessoaRepository;
		
	@GetMapping
	public List<Pessoa> listar(){
		
		return pessoaRepository.findAll();
		
	}
	@GetMapping("/teste/{idPessoa}")
	public ResponseEntity<PessoaDto> buscaPessoa(@Valid @PathVariable Long idPessoa){
		 
		PessoaDto pessoaDto = new PessoaDto();
		pessoaDto.setEnderecoDto(new EnderecoDto()); 
		
		Optional<Pessoa> objPessoa = pessoaRepository.findById(idPessoa);
				
		BeanUtils.copyProperties(objPessoa.get(), pessoaDto) ;
		BeanUtils.copyProperties(objPessoa.get().getEndereco(), pessoaDto.getEnderecoDto()) ;

		return  ResponseEntity.ok(pessoaDto);
	}
	
	
	
	@GetMapping("/teste")
	//public ResponseEntity<PessoaDto> buscaPessoa(@Valid @RequestParam String idCodigoPessoa, @RequestParam String nome){
	public ResponseEntity<PessoaDto> buscaPessoa(@Valid @RequestParam Map<String, String> p){	
	    //System.out.println( idCodigoPessoa + " - " + nome);
	    
	     String key = p.get("idCodigoPessoa");
	     String value = p.get("nome");
	     String flgAtivo = p.get("flgAtivo");
	     
	     System.out.println( key + " - " + value + "-" + flgAtivo);
        //	    for (Map.Entry<String, String> entry : param.entrySet()) {
		//	        String key = entry.getKey();
		//	        String value = entry.getValue();
		//	        System.out.println(String.format("key: %s | value: %s", key, value));
		//	    }
		//		
		return null;
	}
		
	
	@PostMapping                      
	private ResponseEntity<PessoaDto> criar(@Valid @RequestBody PessoaDto pessoaDto, HttpServletResponse response) throws Exception {
		
		//Integer x = 0;
		//Integer y = 10;
	    //if (x < y)
		//	throw new XMenorQUeYException();
				
		Pessoa pessoa = new Pessoa();
		pessoa.setEndereco(new Endereco());
	
		BeanUtils.copyProperties(pessoaDto, pessoa) ;
		BeanUtils.copyProperties(pessoaDto.getEnderecoDto(), pessoa.getEndereco()) ;
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getEndereco().getBairro());

		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		
		BeanUtils.copyProperties(pessoaSalva, pessoaDto) ;
		BeanUtils.copyProperties(pessoaSalva.getEndereco(), pessoaDto.getEnderecoDto()) ;
		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idPessoa}")
				.buildAndExpand(pessoaDto.getIdPessoa()).toUri();
				
		return  ResponseEntity.created(uri).body(pessoaDto);
				// ResponseEntity.ok().body(pessoaDto);
			   // ResponseEntity.status(HttpStatus.CREATED).body(pessoaDto);
		       //  ResponseEntity.created(location) 
	}
	
	@DeleteMapping("{idPessoa}")
	private void remover(@PathVariable Long idPessoa) {

		pessoaRepository.deleteById(idPessoa);
	}
	
	@PutMapping("/{idPessoa}")
	public ResponseEntity<Pessoa> ayualizar(@PathVariable Long idPessoa, @Valid @RequestBody PessoaDto pessoaDto ){
		
		Pessoa p = new Pessoa();
		
		Optional<Pessoa> objPessoa = pessoaRepository.findById(idPessoa);
		
		p = objPessoa.get();
		
		BeanUtils.copyProperties(pessoaDto , p, "idPessoa");
		
		System.out.println(p);
		
		 pessoaRepository.save(p);
						
		return  ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	
	

}
