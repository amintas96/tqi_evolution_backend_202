package com.example.bancotqi.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.bancotqi.entities.PK.OrderLoanPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order_loan")
public class OrderLoan implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private OrderLoanPK id = new OrderLoanPK();
	private Integer quantity;
	private Double price;

	public OrderLoan() {
		super();
	}

	public OrderLoan(Order order, Loan loan, Integer quantity, Double price) {
		super();

		id.setOrder(order);
		id.setLoan(loan);
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore
	public Order getOrder() {

		return id.getOrder();
	}

	public void SetOrder(Order order) {
		id.setOrder(order);
	}

	public Loan getLoan() {
		return id.getLoan();
	}

	public void setLoan(Loan loan) {
		id.setLoan(loan);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		OrderLoan other = (OrderLoan) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
