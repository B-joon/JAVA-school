package com.boot.leaf.controlller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.leaf.dto.LeafDto;

@Controller
public class LeafController {

	@GetMapping("/hello")
	public String Hello(Model model) {
		model.addAttribute("name", "Thymeleaf");
		return "hello";
	}
	
	@GetMapping("/util")
	public String utility() {
		return "utility";
	}
	
	@GetMapping("/expr")
	public String expression(Model model) {
		
		model.addAttribute("name", "Thyemleaf");
		
		LeafDto dto = new LeafDto("Java", 1);
		model.addAttribute("dto", dto);
		
		List<LeafDto> list = new ArrayList<LeafDto>();
		list.add(new LeafDto("DataBase", 2));
		list.add(new LeafDto("UI", 3));
		list.add(new LeafDto("WEB", 4));
		
		model.addAttribute("list", list);
		
		return "expression";
	}
	
	@GetMapping("/params")
	public String parameters(Model model, HttpSession session) {
		session.setAttribute("pw", "kh");
		return "params";
	}
	
	@GetMapping("/static")
	public String statics() {
		return "static";
	}
}
