package com.jdental.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.jdbc.Blob;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Double price;
    @Column
    private String detail;
    @Column
    private int quantity;
    @Column
    private String type;
    @Column
    private String category;
	@Column
	private Blob img1;
	@Column
	private Blob img2;

    @OneToMany( mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItem;

    public List<CartItem> getCartItem() {
        return cartItem;
    }
    public void setCartItem(List<CartItem> cartItem) {
        this.cartItem = cartItem;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
    }
    public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
    }
    public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
    }
}
