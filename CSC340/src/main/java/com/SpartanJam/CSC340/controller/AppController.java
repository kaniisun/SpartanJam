package com.SpartanJam.CSC340.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.SpartanJam.CSC340.model.User;
import com.SpartanJam.CSC340.service.UserService;

/**
*
* @author NehaChauhan
*/
@Controller
public class AppController {
	
	@Autowired
	UserService userService;
	
    @GetMapping(value = {"", "/", "/dashboard", "/home"})
    public String home(Model model) {
        System.out.println("home page");
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("currentUser", name);
        
        String nextPage = "";
        switch(userService.getUserRole(name)) {
        	case "ADMIN":
        		nextPage = "admin/admin";
        		break;
        	case "LISTENER":
        		nextPage = "listener/listener";
        		break;
        	case "ARTIST":
        		nextPage = "artist";
        		break;
        	case "FORUM":
        		nextPage = "forum/forum";
        		break;
        	default:
        		nextPage = "security/login";
        		break;
        }
        return nextPage;
    }

    @GetMapping("/login")
    public String login() {
    	System.out.println("login page");
        return "security/login";
    }

    @GetMapping("/403")
    public String _403() {
    	System.out.println("Exception error 403");
        return "security/403";
    }
    
    @GetMapping("/new-user")
    public String newUser(Model model) {
    	return "user/new-user";
    }
    
    @PostMapping("/create-new-user")
    public String createnewUser(User user, Model model) {
    	//If new user inserted in database successfully, reroute to login page.
    	if(userService.saveUser(user)) {
    		return "security/login";
    	}
    	
    	//If user exists, then show error message and ask to retry.
    	model.addAttribute("userName", user.getUserName());
    	model.addAttribute("userExists", true);
    	return "user/new-user";
    }
}
