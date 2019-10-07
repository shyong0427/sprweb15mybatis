package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.DataDao;
import pack.model.SangpumDto;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;
	
	@RequestMapping("list")
	public ModelAndView listProcess() {
		ArrayList<SangpumDto> list = dataDao.getDataAll();
		
		return new ModelAndView("list", "datas", list);
	}
}