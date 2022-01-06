package com.example.bancotqi.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_loan")
public class Loan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double value;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant firstPlot;
	
	private Integer installments;
	
	@OneToMany(mappedBy = "id.loan")
	private Set<OrderLoan> items = new HashSet<>();	
	

	public Loan() {
		super();
	}
	

	public Loan(Long id, Double value, Instant firstPlot, Integer installments) {
		super();
		this.id = id;
		this.value = value;
		this.firstPlot = firstPlot;
		this.installments = installments;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Instant getFirstPlot() {
		return firstPlot;
	}

	public void setFirstPlot(Instant firstPlot) {
		this.firstPlot = firstPlot;
	}	
	
	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	
	public Double getValorParcela() {
		
		return value / installments;
	}

	@JsonIgnore
	public Set<Order> getOrders(){
		Set<Order> set = new HashSet<>();
		
		for(OrderLoan x: items) {
			set.add(x.getOrder());
		}
		return set;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
