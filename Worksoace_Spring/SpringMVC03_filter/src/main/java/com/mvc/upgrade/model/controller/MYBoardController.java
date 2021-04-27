package com.mvc.upgrade.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.upgrade.model.biz.MYBoardBiz;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Controller
public class MYBoardController {

	@Autowired
	private MYBoardBiz biz;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "myboardlist";
	}
	
	@RequestMapping(value = "/selectone.do", method = RequestMethod.GET)
	public String selectOne(Model model, @RequestParam("myno") int myno) {
				
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "selectone";
	}
	
	@RequestMapping("/writerform.do")
	public String insertFrom() {
				
		return "insert";
	}
	
	@RequestMapping(value = "/writeres.do", method = RequestMethod.POST)
	public String insertRes(MYBoardDto dto) {
		
		if (biz.insert(dto) > 0) {
			return "redirect:list.do";
		}
				
		return "redirect:writeform.do";
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "update";
	}
	
	@RequestMapping(value = "/updateres.do", method = RequestMethod.POST)
	public String updateRes(MYBoardDto dto) {
		
		if (biz.update(dto) > 0) {
			return "redirect:selectone.do?myno=" + dto.getMyno();
		}
		
		return "redirect:updateform.do";
	}
	
	@RequestMapping("/delete.do")
	public String delete(Model model, @RequestParam("myno") int myno) {
		
		if (biz.delete(myno) > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:selectone.do";
	}
	
}
