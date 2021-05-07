package com.boot.jpa.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jpa.model.dao.JpaDao;
import com.boot.jpa.model.dto.JpaDto;

@Controller
@RequestMapping("/member")
public class JpaController {

	@Autowired
	private JpaDao dao;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		
		model.addAttribute("list", dao.findAll());
		
		return "jpalist";
	}
	
	@GetMapping("/insertform")
	public String insertForm() {
		return "jpainsert";
	}
	
	@GetMapping("/insertRes")
	public String insertRes(JpaDto dto) {
		// dto.setMyDate(new Date());
		dao.save(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("detail")
	public String detail(Model model, int myno) {
		
		model.addAttribute("dto", dao.findByMyno(myno));
		
		return "jpadetail";
	}
	
	@GetMapping("/updateForm")
	public String updateFrom(Model model, int myno) {
		
		model.addAttribute("dto", dao.findByMyno(myno));
		
		return "jpaupdate";
	}
	
	@GetMapping("/updateres")
	public String updateRes(JpaDto dto) {
		
		dao.saveAndFlush(dto);
		
		return "redirect:detail?myno=" +dto.getMyno();
	}
	
	@GetMapping("/delete")
	public String delete(int myno) {
		
		dao.deleteByMyno(myno);
		
		return "redirect:list";
	}
}
