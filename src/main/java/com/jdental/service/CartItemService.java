package com.jdental.service;

import java.util.List;

import com.jdental.domain.Cart;
import com.jdental.domain.CartItem;
import com.jdental.domain.Item;

public interface CartItemService {

    List<CartItem> findByCart(Cart cart);
    CartItem updateCartItem(CartItem cartItem);
}
