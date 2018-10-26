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
import com.jdental.domain.Item;
import com.jdental.domain.User;
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
		@RequestMapping("/success")
		public String success() {
			return "/success";

		}

		@RequestMapping(value = "/signup", method = RequestMethod.GET)
		public String signup(Model model) {
			User user = new User();
	
			model.addAttribute("user", user);
	
			return "signup";
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
