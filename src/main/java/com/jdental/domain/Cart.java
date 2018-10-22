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
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal grandTotal;

    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy="cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItem;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }
    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public List<CartItem> getCartItem() {
        return cartItem;
    }
    public void setCartItem(List<CartItem> cartItem) {
        this.cartItem = cartItem;
    }
}


