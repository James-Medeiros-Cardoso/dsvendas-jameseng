package com.jameseng.jevendas.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //mapeamento objeto relacional da Jpa
@Table(name="tb_sales") //tb_sales = será o nome da tabela no banco de dados, igual no script do SQL
public class Sale {
	
	@Id //vai indicar para o BD qual é o atributo da chave primária
	@GeneratedValue(strategy=GenerationType.IDENTITY) //o banco vai gerar novo id conforme necessário
	private Long id;
	private Integer visited;
	private Integer deals;
	private Double amount; //quantia das vendas
	private LocalDate date;
	
	@ManyToOne //muitos para um
	@JoinColumn(name="seller_id") //chave estrangeira, igual como está no script SQL
	private Seller seller; //uma venda tem que ter um vendedor.
	
	public Sale() {
	}

	public Sale(Long id, Integer visited, Integer deals, Double amount, LocalDate date, Seller seller) {
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
}
