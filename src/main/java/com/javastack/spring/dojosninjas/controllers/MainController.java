package com.javastack.spring.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javastack.spring.dojosninjas.models.Dojo;
import com.javastack.spring.dojosninjas.models.Ninja;
import com.javastack.spring.dojosninjas.services.DojoService;
import com.javastack.spring.dojosninjas.services.NinjaService;

@Controller
public class MainController {
	
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public MainController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/new")
	public String create(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/create.jsp";
	}
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/create.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.showDojo(id);
		model.addAttribute("dojo",dojo);
//		model.addAttribute("ninjas", ninjaService.allNinjas());
		return "/dojos/show.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String create(@ModelAttribute("ninja") Ninja ninja,Model model) {
		model.addAttribute("allDojos", dojoService.allDojos());
		return "/ninjas/create.jsp";
	}
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allDojos", dojoService.allDojos());
			return "/ninjas/create.jsp";
		}
		else {
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
}
