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
import com.jdental.domain.Item;
import com.jdental.domain.User;
import com.jdental.domain.security.UserRole;
import com.jdental.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleDao roleDao;

    @GetMapping(value = "/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        if(userService.checkUserExists(user.getUsername(), user.getEmail())) {

            JOptionPane.showMessageDialog(null, " username exist already", "TITLE", JOptionPane.WARNING_MESSAGE);
        }
        
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
        return userService.createUser(user, userRoles);
    }


    // @RequestMapping(value = "/userMain", method = RequestMethod.GET)
    // public String profile(Principal principal, Model model) {
    //     User user = userService.findByUsername(principal.getName());

    //     model.addAttribute("user", user);

    //     return "userMain";
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

