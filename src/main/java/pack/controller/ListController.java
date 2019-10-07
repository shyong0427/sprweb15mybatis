package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.SangpumDto;
import pack.model.SangpumInter;

@Controller
public class ListController {
	@Autowired
	@Qualifier("sangpumImpl")
	private SangpumInter sangpumInter;
	
	@RequestMapping("list")
	public ModelAndView listProcess() {
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)sangpumInter.list();
		
		ModelAndView modelAndView = new ModelAndView("list");
		modelAndView.addObject("datas", list);
		
		return modelAndView;
	}
}