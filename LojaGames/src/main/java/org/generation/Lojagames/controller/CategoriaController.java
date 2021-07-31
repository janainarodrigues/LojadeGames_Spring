package org.generation.Lojagames.controller;

import java.util.List;

import org.generation.Lojagames.model.Categoria;
import org.generation.Lojagames.repository.CategoriaRepository;
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
@RequestMapping("/categoria")
@CrossOrigin("*") // juntar back e front quando hospedados em sites diferentes
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository; 
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll (){  // metedo que busca tudo por categoria 
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //  vai usar a rota principal 
	public ResponseEntity<Categoria> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
		public ResponseEntity<List<Categoria>> GetByCategoria (@PathVariable String descricao){
		return   ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));	
	}
	
	@PostMapping
	public ResponseEntity<Categoria> Post (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> Put (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void deleteId (@PathVariable long id) {
		repository.deleteById(id);
		}
	
}
