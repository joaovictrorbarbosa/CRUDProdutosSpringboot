package com.produtoapi.repository;

import com.produtoapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	//Busca por nome
	List<Produto> findByNome(String nome);
	
	List<Produto> findByNomeContaining(String nome);
	
	List<Produto> findByNomeAndStatus(String nome, String status);
	
	List<Produto> findByNomeStartingWith(String prefix);
	
	List<Produto> findByNomeEndingWith(String suffix);
	
	//Buscas pro Preço
	List<Produto> findByPreco(Double preco);
	
	List<Produto> findByPrecoGreaterThan(Double preco);
	
	List<Produto> findByPrecoLessThan(Double preco);

	//Usando @Query para obter total de preços
	@Query("SELECT SUM(p.preco) FROM Produto p")
	Double findTotalPreco();
	
	//BUSCA POR QUANTIDADE DETALHADA
	List<Produto> findByQuantidade(Integer quantidade);
	
	List<Produto> findByQuantidadeGreaterThan(Integer quantidade);
	
	List<Produto> findByQuantidadeLessThan(Integer quantidade);
	
	//Buscas Por preço e Status
	List<Produto> findByStatus(String status);
	
	List<Produto> findByStatusIsNull();
	
	List<Produto> findByPrecoAndStatus(Double preco, String status);
}
