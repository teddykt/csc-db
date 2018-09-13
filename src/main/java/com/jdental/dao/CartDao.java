package com.jdental.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jdental.domain.Cart;
import com.jdental.domain.Item;
import com.jdental.domain.User;

public interface CartDao extends CrudRepository<Cart, Long> {
    Cart findById(Cart cart);
    List<Cart> findAll();
    void delete(Cart cart);
	Cart findByUser(User user);
}
