package org.generation.Lojagames.repository;

import java.util.List;

import org.generation.Lojagames.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // informando para repository que a CategoriaRepository é um repositório
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Categoria> findAllByDescricaoContainingIgnoreCase (String descricao);
}
	
// dentro do SQL seria select* tb_categoria where like "%descricao%"
