package org.generation.Lojagames.controller;

import java.util.List;
import org.generation.Lojagames.model.Produto;
import org.generation.Lojagames.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

@RestController //será informando que CaterogiaController é o nosso controle 
@RequestMapping("/produto")
@CrossOrigin("*") // juntar back e front quando hospedados em sites diferentes
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository; 
	
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll (){  // metedo que busca tudo por categoria 
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //  vai usar a rota principal 
	public ResponseEntity<Produto> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}") 
	public ResponseEntity<List<Produto>> GetByCategoria (@PathVariable String nome){ 
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome)); 
	}
	
	@PostMapping
	public ResponseEntity<Produto> Post (@RequestBody Produto nome){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nome));
	}
	
	@PutMapping
	public ResponseEntity<Produto> Put (@RequestBody Produto nome){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nome));
	}
	
	@DeleteMapping("/{id}")
	public void deleteId (@PathVariable long id) {
		repository.deleteById(id);
		}
	
}
