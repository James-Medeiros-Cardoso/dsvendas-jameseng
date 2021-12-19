package com.jameseng.jevendas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //mapeamento objeto relacional da Jpa
@Table(name="tb_sellers") //tb_sellers = será o nome da tabela no banco de dados, igual no script do SQL
public class Seller {
	
	@Id //vai indicar para o BD qual é o atributo da chave primária
	@GeneratedValue(strategy=GenerationType.IDENTITY) //o banco vai gerar novo id conforme necessário
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="seller") //um para muitos | "seller"=tem que ser igual a entidade declarada na outra classe
	private List<Sale> sales=new ArrayList<>(); //um vendedor pode ter várias vendas.
	
	public Seller() {
	}

	public Seller(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sale> getSales() {
		return sales;
	}
}
