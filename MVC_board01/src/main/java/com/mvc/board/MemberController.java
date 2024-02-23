package com.mvc.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.board.Biz.MemberBiz;
import com.mvc.board.Dto.MemberDto;

@Controller
public class MemberController {
	private Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberBiz biz;
	
	@RequestMapping("/login.do")
	public String login() {
		logger.info("LOGIN PAGE");
		
		return "login";
	}
	
	@RequestMapping(value="/userlogin.do", method=RequestMethod.POST)
	public String userlogin(MemberDto dto, HttpServletRequest request) {
		logger.info("LOGIN");
		
		HttpSession session = request.getSession();
		
		MemberDto res = biz.login(dto);
		
		if (res!=null) {
			
			//세션 저장
			session.setAttribute("res", res);
			return "redirect:list.do";
		}else {
			return "redirect:login.do";
		}
		
	}
}
