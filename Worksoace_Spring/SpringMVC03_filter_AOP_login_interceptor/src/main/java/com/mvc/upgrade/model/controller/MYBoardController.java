package com.mvc.upgrade.model.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.MYBoardBiz;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Controller
public class MYBoardController {
	
	private Logger logger = LoggerFactory.getLogger(MYBoardController.class);

	@Autowired
	private MYBoardBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		logger.info("[controller] list.do");
		
		model.addAttribute("list", biz.selectList());
		
		return "myboardlist";
	}
	
	@RequestMapping("/detail.do")
	public String selectOne(Model model, int myno) {
		logger.info("[controller] detail.do");
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myboardselect";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		logger.info("[controller] insertform.do");
		return "myboardinsert";
	}
	@RequestMapping("/insertres.do")
	public String insertRes(MYBoardDto dto) {
		logger.info("[controller] insertres.do");
		
		if (biz.insert(dto) > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:insertform.do";
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		logger.info("[controller] updateform.do");
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myboardupdate";
	}
	@RequestMapping("/updateres.do")
	public String updateRes(MYBoardDto dto) {
		
		if (biz.update(dto) > 0) {
			return "redirect:detail.do?myno=" + dto.getMyno();
		}
		
		return "redirect:updateform.do";
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		
		if (biz.delete(myno) > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:detail.do?myno=" + myno;
	}
	
}













