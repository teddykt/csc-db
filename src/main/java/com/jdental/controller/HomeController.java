package com.jdental.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jdental.dao.RoleDao;
import com.jdental.domain.Appointment;
import com.jdental.domain.Item;
import com.jdental.domain.User;
import com.jdental.domain.security.UserRole;
import com.jdental.service.UserService;

@Controller
public class HomeController {
	
		@Autowired
		private UserService userService;
		
		@Autowired
		private RoleDao roleDao;

		@RequestMapping("/")
		public String home() {
			return "redirect:/index";
		}
		
		@RequestMapping("/index")
		public String index() {
			return "index";
		}		
						
		
		@RequestMapping("/booking")
		public String booking() {
			return "st/booking";

		}	

		@RequestMapping("/login")
		public String login() {
			return "login";

		}
		@RequestMapping("/appointment")
		public String appointment() {
			return "appointment";

		}

		@RequestMapping(value = "/signup", method = RequestMethod.GET)
		public String signup(Model model) {
			User user = new User();
	
			model.addAttribute("user", user);
	
			return "signup";
		}
		
		@RequestMapping(value = "/signup", method = RequestMethod.POST)
		public String signupPost(@ModelAttribute("user") User user, Model model) {
			if(userService.checkUserExists(user.getUsername(), user.getEmail())) {
				
				model.addAttribute("usernameExists", true);
				return "index";
			}
			else {
				Set<UserRole> userRoles = new HashSet<>();
				userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
				
				userService.createUser(user, userRoles);
				
				return "redirect:/";
			}
		}

		// @RequestMapping("/userMain") 
		// 	public String userMain(Principal principal, Model model) {
		// 		User user = userService.findByUsername(principal.getName());
		// 		List<Cart> cart = user.getCart();
				
		// 		model.addAttribute("cart", cart);
		//         model.addAttribute("user", user);

				
		// 		return "userMain";
				
		// }	
		
}
