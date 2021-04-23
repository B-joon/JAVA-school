package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.biz.HelloBiz;

//TODO: 05.BIz(@Service) 호출
@Controller
public class Hellocontroller {
	
	@Autowired
	private HelloBiz biz;

	//TODO: 04. HandlerMapping을 통해, hello.do로 넘어온 요청이 Controller의 해당 method를 찾아옴
	@RequestMapping("/hello.do")
	public String getHello(Model model) {
		
		//TODO : 09.return 받은 값을 model 객체에 담아서 전달(ModelAndView)
		model.addAttribute("message",biz.getHello());
		
		//TODO : 10. view
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("bye.do")
	public ModelAndView getBye(String name) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message","bye,"+name);
		
		
		
		return mav;
	}
	
	
	
}





/*
 * 
 * @RequestMapping 
 * -url을 class 또는 method와 mapping 시켜주는 역할이다.
 * 
 * @RequestParam
 * -key = value 형태로 넘어오는 파라미터를 mapping된 method의 파라미터로 지정 
 * index.html에서 쿼리스트링 값인 name=spring 이라고 줬으니까 컨트롤러에서 name이 파라미터로 들어가면 @requestParam이 없어도 자동으로 그 값이 들어간다....뭔말이냐 이게
 * 
 * @ModelAttribute 
 * -form tag를 통해 넘어온 model을 mapping된 method의 파라미터로 지정 
 * 
 * @sessionAttributeS
 * -session에서 model의 정보를 유지하고 싶을 경우 사용 
 * 
 * 
 */
