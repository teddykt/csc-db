package com.jdental.domain;

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

@Entity
@Table(name = "cartItem")
public class CartItem {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int qty;
    private BigDecimal subTotal;

    @ManyToOne(cascade = CascadeType.ALL)
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cart cart;

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
    public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
    }
    public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
}