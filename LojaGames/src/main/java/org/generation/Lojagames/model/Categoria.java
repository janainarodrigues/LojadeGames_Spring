package org.generation.Lojagames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Anotações
@Entity    // Informando que é uma entidade
@Table (name= "tb_categoria")    // Como se fosse Create table para categoria
public class Categoria {
	
	@Id // Como se fosse Primary Key -- informando que private long id é meu ID
	@GeneratedValue (strategy = GenerationType.IDENTITY)  // igual o  auto_increment
	private long id;  //id bigint
	
	@NotBlank // notnull, não pode ficar vazio, nem com espaços
	@Size (min =2, max=50) // tamanho permitido min e max permitido
	private String tipo; // tipo varchar
	
	@NotBlank 
	@Size (min =2, max=250) 
	private String descricao;
	
	@OneToMany (mappedBy = "categoria", cascade = CascadeType.REMOVE )
	@JsonIgnoreProperties ("categoria")
	private List<Produto> produtos;
	
	
	//get seters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	} 
	
}
