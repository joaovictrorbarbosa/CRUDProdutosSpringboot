package com.produtoapi.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders; 
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.produtoapi.model.Produto;

import java.util.Arrays;
import java.util.List;

public class CRUDJavaClient {
	private static final String BASE_URL = "http://localhost:8080/produtos";
	private RestTemplate restTemplate;
	
	public CRUDJavaClient() {
		this.restTemplate = new RestTemplate();
	}
	
	//Método para listar todos produtos
	public void listarTodos() {
		ResponseEntity<Produto[]> response = restTemplate.getForEntity(BASE_URL, Produto[].class);
		List<Produto> produtos = Arrays.asList(response.getBody());
		produtos.forEach(produto -> {
			System.out.println("ID: " + produto.getId());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("Quantidade: " + produto.getQuantidade());
			System.out.println("Status: " + produto.getStatus());
			System.out.println("--------------------------------");
		});		
	}
	
	//Método para salvar novo produto
	public Produto salvar(Produto produto) {
		HttpEntity<Produto> request = new HttpEntity<>(produto);
		return restTemplate.postForObject(BASE_URL, request, Produto.class);
	}
	
	//Método para deletar produto por id
	public void deletar(long id) {
		restTemplate.delete(BASE_URL + "/" + id);
	}
	
	//Método para atualizar produto
	public Produto atualizar(long id, Produto produto) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Produto> request = new HttpEntity<>(produto, headers);
		ResponseEntity<Produto> response = restTemplate.exchange(BASE_URL + "/" + id, HttpMethod.PUT, request, Produto.class);
		return response.getBody();
	}
	
	//Método para buscar produto pelo id
	public Produto findById(long id) {
		ResponseEntity<Produto> response = restTemplate.getForEntity(BASE_URL + "/" + id, Produto.class);
		return response.getBody();
	}
	
	public static void main(String[] args) {
		CRUDJavaClient client = new CRUDJavaClient();
		
		// ====== criar novo produto ======
		/*
		  Produto novoProduto = new Produto();
		  novoProduto.setNome("Skate");
		  novoProduto.setPreco(520);
		  novoProduto.setQuantidade(100);
		  novoProduto.setStatus("Disponivel");
		  
		  System.out.println("Criar um novo produto");
		  client.salvar(novoProduto);
		  client.listarTodos(); // Lista todos produtos
		*/
		
		// ======= Atualizar produto =========
		/*
		  Produto atualizarProduto = client.findById(252);
		  atualizarProduto.setNome("Skate Iniciante");
		  atualizarProduto.setPreco(250); 
		  
		  System.out.println("Atualizar o produto");
		  client.atualizar(atualizarProduto.getId(),atualizarProduto);
		 
		  //Listar tudo novamente
		  client.listarTodos();
		 */
		
		// ======Deletar Produtos ======
		
		  System.out.println("Deletar o produto");
		  client.deletar(252);
		  
		   //Listar tudo de novo
		  client.listarTodos();
	
		
	}
}













