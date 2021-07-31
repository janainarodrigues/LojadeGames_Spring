package org.generation.Lojagames.repository;

import java.util.List;
import org.generation.Lojagames.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // informando para repository que a CategoriaRepository é um repositório
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findAllByNomeContainingIgnoreCase (String nome);
}
	
// dentro do SQL seria select* tb_categoria where like "%descricao%"
