package com.jbk.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbk.springdemo.customerservice.CustomerService;
import com.jbk.springdemo.entity.Admin;
import com.jbk.springdemo.entity.Customer;
import com.jbk.springdemo.entity.User;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	
	
	@GetMapping("/login") 
     public String loginPage(Model model) {
		Customer thecustomer=new Customer();
		
		model.addAttribute("customer", thecustomer);
		return "login-page";
	}
	
	
	@GetMapping("/forgotPassword")
	public String forgotPage() {
		return "forgotpage";
	}
	
	
	@PostMapping("/userPage")
	public String ProcessUserpage(@Valid@ModelAttribute("customer")User user,BindingResult result,Model model) {
		Customer userexist=customerservice.checkuser(user);
		if(result.hasErrors()) {
			return "login-page";
		}else if(userexist!=null) { 
								if(userexist.getGender().equals("male")) {
									model.addAttribute("message","Welcome Mr.");
									model.addAttribute("firstname",userexist);
									return "User-WelcomePage";
								}else {
									model.addAttribute("message","Welcome Mrs.");
									model.addAttribute("firstname",userexist);
									return "User-WelcomePage";
									}
		}					
		else {
			return "login-page";
		}
}
	
	
	
	@GetMapping("/Admin")
	public String AdminLoginpage(Model model) {
			Admin theadmin=new Admin();
		model.addAttribute("admin", theadmin);
		return "AdminLogin";
	}
	
	
	
	
	@GetMapping("/AdminPage")
	public String listCustomers(@Valid@ModelAttribute("admin")Admin admin,BindingResult result,Model model) {
		boolean AdminExist=customerservice.checkAdmin(admin.getUserName(),admin.getPassword());
		if(result.hasErrors()) {
			return "AdminLogin";
		}else if(AdminExist) {
			List<Customer> thecustomers=customerservice.getCustomer();
			model.addAttribute("customers", thecustomers);
			return "list-Users";
		}else {
			return "AdminLogin";
		}
		
	}
	
	
	@GetMapping("/showformadd")
	public String customerform(Model model) {
			Customer thecustomer=new Customer();
		   model.addAttribute("customer",thecustomer);
		   return "UserRegisteration";
		}
	
	
	@PostMapping("/saveCustomer")
       public String saveCustomer(@Valid@ModelAttribute("customer")Customer thecustomer,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "UserRegisteration";
		}else {
	customerservice.savecustomer(thecustomer);
	Customer thecus=new Customer();
	model.addAttribute("msg","Registered Successfully");
	model.addAttribute("customer", thecus);
	return "login-page";
		
		
	
		}
	}

	@PostMapping("/updateCustomer")
    public String updateCustomer(@Valid@ModelAttribute("customer")Customer thecustomer,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "updatePage";
		}else {
	customerservice.savecustomer(thecustomer);
	List<Customer> thecustomers=customerservice.getCustomer();
	model.addAttribute("customers", thecustomers);
		return "list-Users";
				
		}
	}
	
	
	@GetMapping("/showformforupdate")
	public String showFormUpdate(@RequestParam("customerID")int theid,Model model) {
		Customer thecustomer=customerservice.getCustomers(theid);
		model.addAttribute("customer",thecustomer);
		return "updatePage";
	}
	
	
	
	@GetMapping("/delete")
	public String deletecustomer(@RequestParam("customerID")int theid,Model model) {
		customerservice.delete(theid);
		List<Customer> thecustomers=customerservice.getCustomer();
		model.addAttribute("customers", thecustomers);
		return "list-Users";
	}
}


