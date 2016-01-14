package com.journaldev.spring.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.spring.mongodb.dao.PersonDAO;
import com.journaldev.spring.mongodb.model.Person;

@Controller
public class HomeController {

	@Autowired
	private PersonDAO personDAO;
	
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		List<Person> listUsers = personDAO.getList();
		ModelAndView model = new ModelAndView("UserList");
		model.addObject("userList", listUsers);
		return model;
	}
	
//    @RequestMapping(value = "/new", method = RequestMethod.GET)
//    public ModelAndView newUser() {
//        ModelAndView model = new ModelAndView("UserForm");
//        model.addObject("user", new User());
//        return model;      
//    }	
//    
//    @RequestMapping(value = "/edit", method = RequestMethod.GET)
//    public ModelAndView editUser(HttpServletRequest request) {
//        int userId = Integer.parseInt(request.getParameter("id"));
//        User user = userDAO.get(userId);
//        ModelAndView model = new ModelAndView("UserForm");
//        model.addObject("user", user);
//        return model;      
//    }    
//    
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public ModelAndView deleteUser(HttpServletRequest request) {
//        int userId = Integer.parseInt(request.getParameter("id"));
//        userDAO.delete(userId);
//        return new ModelAndView("redirect:/");     
//    }
//    
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ModelAndView saveUser(@ModelAttribute User user) {
//        userDAO.saveOrUpdate(user);
//        return new ModelAndView("redirect:/");
//    }  
//    
//    @RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
//    public ModelAndView downloadPdf() {
//		List<Person> listUsers = personDAO.getList();
//		ModelAndView model = new ModelAndView("pdfView");
//		model.addObject("listUsers", listUsers);
//		return model;		
//    }
//    
}
