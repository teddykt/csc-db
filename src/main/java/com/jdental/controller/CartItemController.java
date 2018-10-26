package com.jdental.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jdental.dao.RoleDao;
import com.jdental.domain.Cart;
import com.jdental.domain.CartItem;
import com.jdental.domain.Item;
import com.jdental.domain.User;
import com.jdental.service.CartItemService;
import com.jdental.service.CartService;
import com.jdental.service.ItemService;
import com.jdental.service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/cartItem")
public class CartItemController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;


    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem cartItem){
        return cartItemService.addToCart(cartItem);
    }

    @PostMapping("/get")
    public List<CartItem> addToCart(@RequestBody Cart cart){
        return cartItemService.findByCart(cart);
    }

    @PostMapping("/delete")
    public void removeCartItem(@RequestBody CartItem cartItem){
        cartItemService.deleteById(cartItem.getId());
    }



}

