package com.example.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.form.RegistrationForm;
import com.example.model.User;
import com.example.service.UserService;

@Controller
@RequestMapping("auth")
public class AuthController {

	private static final Logger LOGGER = Logger.getLogger(AuthController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String login(@RequestParam("emailId") String emailId, @RequestParam("password") String password,
			ModelMap modelMap, HttpSession session) {
		LOGGER.info("Entering Login " + emailId + "-" + password);
		LOGGER.debug(new Object[] { emailId, password });

		User user = userService.findByEmailAndPassword(emailId, password);
		LOGGER.info("User:" + user);
		if (user != null) {
			session.setAttribute("LOGGED_IN_USER", user);
			LOGGER.info("Login Success");
			return "redirect:../books";
		} else {
			modelMap.addAttribute("ERROR_MESSAGE", "Invalid Email Id/Password");
			LOGGER.error("Login Failure");
			return "home";
		}
	}

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	@GetMapping("/register")
	public String showRegsiter() {
		return "user/register";
	}
	/*
	 * @RequestMapping(value = "/register", method= RequestMethod.GET) public
	 * String register() { System.out.println("controller called"); return
	 * "user/register";
	 * 
	 * }
	 * 
	 * @RequestMapping(value="/add",method=RequestMethod.POST) public String
	 * addUser( @RequestParam("name") String name,
	 * 
	 * @RequestParam("password") String password,
	 * 
	 * @RequestParam("emailID") String emailID) {
	 * 
	 * User user = new User(name, password, emailID); userService.save(user);
	 * return "auth/login"; }
	 */

	@PostMapping("/register")
	public String register(@ModelAttribute @Valid RegistrationForm user, BindingResult result, ModelMap modelMap,
			HttpSession session) throws Exception {
		try {

			System.out.println("Registraion Form :" + user);

			if (result.hasErrors()) {
				modelMap.addAttribute("errors", result.getAllErrors());
				modelMap.addAttribute("regFormData", user);
				return "user/register";
			} else {
				userService.register(user);

				return "redirect:../";
			}

		} catch (Exception e) {
			e.printStackTrace();
			modelMap.addAttribute("regFormData", user);
			modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
			return "user/register";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
