package com.mvc.upgrade.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MYMemberBiz;
import com.mvc.upgrade.model.dto.MYMemberDto;

@Controller
public class MYMemberController {
	
	private Logger logger = LoggerFactory.getLogger(MYMemberController.class);
	
	@Autowired
	private MYMemberBiz biz;
	
	@RequestMapping("loginform.do")
	public String loginForm() {
		logger.info("[controller] LoginForm.do");
		return "mymemberlogin";
	}
	
	/**
	 *@RequestBody : request로 넘어오는 데이터를 java Object (객체로 )변환  
	 *@ResponseBody :  java Object (객체) 를 response 객체에 데이터로 binding
	 * ---------------- > response body의 경우는 view resolver가 작동하지 않는다 . 객체만 응답해준다. 
	 * 
	 */
	@RequestMapping(value="ajaxlogin.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MYMemberDto dto){
		logger.info("[controller] ajaxlogin.do");
		MYMemberDto res = biz.login(dto);
		boolean check = false;
		
		if(res != null) {
			session.setAttribute("login", res);
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		
		map.put("check", check);
		
		
		return map;
	}
	
	@RequestMapping("signUpForm.do")
	public String signUpForm() {
		return "signUpForm";
	}
	@RequestMapping(value="signup.do", method=RequestMethod.POST)
	public String signUp (MYMemberDto dto) {
		int res = biz.signUp(dto);
		if(res > 0) {
			return "redirect:loginform.do";
		}
		return "redirect:signUpForm.do";
	}
}
