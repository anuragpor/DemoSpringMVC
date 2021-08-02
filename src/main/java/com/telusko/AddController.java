package com.telusko;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.service.AddService;


@RestController
public class AddController 
{
	
	Logger logger = LoggerFactory.getLogger(AddController.class);
	@RequestMapping("/add") // import package using ctrl+space or using ctrl+shift+o
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response)
	{
//		System.out.println("Im here");
		int i = Integer.parseInt(request.getParameter("t1"));
		int j = Integer.parseInt(request.getParameter("t2"));
		
		AddService as = new AddService();
		int k = as.add(i, j);
		logger.error("error happened");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp"); //here we set the view which and the request will now go to that view.
		mv.addObject("result", k);
		return mv;
	}
}
