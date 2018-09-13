package com.jdental.service;

import java.util.List;

import com.jdental.domain.Cart;
import com.jdental.domain.CartItem;
import com.jdental.domain.Item;
import com.jdental.domain.User;

public interface CartService {

    // void removeCart(Cart cart);

    // Cart getCart();

    // Cart updateCart(Cart cart);

	Cart findByUser(User user);
	Cart findCartByUsername(String username);
}
