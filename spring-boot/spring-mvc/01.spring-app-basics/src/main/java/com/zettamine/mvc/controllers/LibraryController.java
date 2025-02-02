package com.zettamine.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zettamine.mvc.dao.LibraryDao;
import com.zettamine.mvc.entities.Book;

@Controller
@RequestMapping("/book")
public class LibraryController {
	@Autowired
	private LibraryDao repo;
	
	@GetMapping("/allbooks")
	public String getAllBooks(Model model) {
		
		model.addAttribute("books", repo.getAll());
		return "allbooks";
	}
	
	@GetMapping("/book/delete/{id}")
	public String deleteBook(Model model,@PathVariable(name = "id") Integer id) {
		System.out.println("#######################################################");
		model.addAttribute("books", repo.deleteBook(id));
		return "allbooks";
	}

}
