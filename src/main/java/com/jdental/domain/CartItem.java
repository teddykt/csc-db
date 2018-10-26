package com.jdental.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.access.prepost.PreAuthorize;

@Entity
@Table(name = "cartItem")
@PreAuthorize("hasRole('USER')")
public class CartItem implements Serializable{
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;	
	private int qty;
    private BigDecimal subTotal;

	@ManyToOne
	@JoinColumn(name ="item_id")
	private Item item;

    @ManyToOne
	@JoinColumn(name ="cart_id")
	private Cart cart;


    public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

    public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
    }

	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal total) {
		this.subTotal = total;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
    }


}