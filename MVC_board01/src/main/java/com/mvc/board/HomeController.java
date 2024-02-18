package com.mvc.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.board.Biz.BoardBiz;
import com.mvc.board.Dto.BoardDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardBiz biz;
	
	
	/**
	 * 여기는 이해가 아직 미흡하다.
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("MAIN PAGE", locale);
		
		model.addAttribute("list", biz.selectList());
		
		return "home";
		
	}
	
	@RequestMapping("/one.do")
	public String one(Model model, int bd_no) {
		logger.info("SELECT ONE");
		
		model.addAttribute("dto", biz.selectOne(bd_no));
		
		return "selectone";
		
	}
	
	@RequestMapping("/update.do")
	public String update(Model model, int bd_no) {
		logger.info("UPDATE PAGE");
		
		model.addAttribute("dto", biz.selectOne(bd_no));
		
		return "update";
		
	}
	
	@RequestMapping("/bdupdate.do")
	public String updateBoard(BoardDto dto) {
		logger.info("UPDATE");
		
		int res = biz.update(dto);
		if(res>0) {
			return "redirect:one.do?bd_no="+dto.getBd_no();
		} else {
			return "redirect:update.do?bd_no="+dto.getBd_no();
		}
	}
	
	@RequestMapping("/insert.do")
	public String insert() {
		logger.info("INSERT PAGE");
		return "insert";
	}
	
	@RequestMapping("/bdinsert.do")
	public String insertBoard(BoardDto dto) {
		logger.info("INSERT");
		
		int res = biz.insert(dto);
		
		if(res>0) {
			return "redirect:list.do";
		} else {
			return "redirect:insert.do";
		}
	}
	
	@RequestMapping("/delete.do")
	public String delete(int bd_no) {
		logger.info("DELETE");
		
		int res = biz.delete(bd_no);
	
		if(res>0) {
			return "redirect:list.do";
		} else {
			return "redirect:one.do?bd_no="+bd_no;
		}
	}
}
