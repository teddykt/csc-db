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
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private CartService cartService;
    
    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/{username}")
    public Cart getCart(@PathVariable String username) {
        Cart cart = cartService.findCartByUsername(username);
        return  cart;
    }

    ///////last try

    // @GetMapping
    // public List<Cart> getCart(){
    //     return cartService.getCart();
    // }


    // @DeleteMapping(value = "/delete")
    // public void removeCart(Cart cart){
    //     cartService.removeCart(cart);
    // }



    // @RequestMapping(value = "/userMain", method = RequestMethod.POST)
    // public String profilePost(@ModelAttribute("user") User newUser, Model model) {
    //     User user = userService.findByUsername(newUser.getUsername());
    //     user.setUsername(newUser.getUsername());
    //     user.setFirstName(newUser.getFirstName());
    //     user.setLastName(newUser.getLastName());
    //     user.setEmail(newUser.getEmail());
    //     user.setPhone(newUser.getPhone());

    //     model.addAttribute("user", user);

    //     userService.saveUser(user);

    //     return "userMain";
    // }


}

