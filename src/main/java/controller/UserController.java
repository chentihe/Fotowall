package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.bean.User;
import service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path= {"/user.controller"})
	public String handlerMethod(User user, BindingResult bindingResult, String useraction, Model model, HttpSession session) {
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		// 檢查客戶端輸入的格式
		if(bindingResult!=null && bindingResult.hasFieldErrors()) {
			if(bindingResult.hasFieldErrors("email")) {
				errors.put("email", "Please check the email format");
			}
			if(bindingResult.hasFieldErrors("password")) {
				errors.put("password", "Please enter correct password!");
			}
		}
		
		if(user.getEmail()==null || user.getEmail().length()==0) {
			errors.put("email", "Email is required!");
		}
		if(user.getPassword()==null || user.getPassword().length()==0) {
			errors.put("password", "Password is required!");
		}
		if(user.getUserName()==null || user.getUserName().length()==0) {
			errors.put("username", "Username is required!");
		}
		
		if ("Register".equals(useraction) && user!=null) {
			user = userService.register(user);
			if (user!=null) {
				user = userService.login(user.getEmail(), user.getPassword());
				session.setAttribute(Constant.USER_SESSION, user);
				return "redirect:/";
			} else {
				errors.put("email", "Email Address is been Registered!");
				return "index.jsp";
			}
		} else if ("Login".equals(useraction) && user!=null) {
			user = userService.login(user.getEmail(), user.getPassword());
			session.setAttribute(Constant.USER_SESSION, user);
			return "redirect:/";
		} else if ("Logout".equals(useraction)) {
			session.removeAttribute(Constant.USER_SESSION);
			return "redirect:/";
		} else {
			errors.put("password", "Login failed, please try again!");
			return "/index";
		}
	}
}
