package com.jdental.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jdental.domain.Cart;
import com.jdental.domain.CartItem;

public interface CartItemDao extends CrudRepository<CartItem, Long> {
    List<CartItem> findByCart(Cart cart);
}
