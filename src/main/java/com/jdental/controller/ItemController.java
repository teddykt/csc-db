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
import com.jdental.domain.Item;
import com.jdental.domain.User;
import com.jdental.service.CartService;
import com.jdental.service.ItemService;
import com.jdental.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Item> findItemList(){
        return itemService.findItemList();
    }


    @PostMapping(value = "/add")
    public Item add(@RequestBody Item item){
        if(itemService.checkItemExists(item.getName())) {

            JOptionPane.showMessageDialog(null, " Item exist already", "TITLE", JOptionPane.WARNING_MESSAGE);
        }
        return itemService.addItem(item);
    }

    @GetMapping(value = "/{itemName}")
    public Item findByName(@PathVariable String itemName) {
        return itemService.findByName(itemName);
    }



    // @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    // public Cart addToCart(@RequestBody Cart cart){
    //     // if(userService.checkItemExists(item.getName())) {

    //     //     JOptionPane.showMessageDialog(null, " Item exist already", "TITLE", JOptionPane.WARNING_MESSAGE);
    //     // }
    //     return cartService.addToCart(cart);
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

