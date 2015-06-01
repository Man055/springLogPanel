package com.loginSection.spring.controller;
import javax.servlet.http.HttpServletRequest;

import com.loginSection.spring.jsonFit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class loginCont {

	@RequestMapping("/signup")
	public String signup(){
		return "signup";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST,produces="application/json")
	public @ResponseBody jsonFit signupAction(HttpServletRequest request,Model model){
		System.out.println(request.getParameter("FirstName").length());
		//System.out.println(request.getParameter("nma"));
		//model.addAttribute("response","{msgType:error,msg:Invalid ID}");
		String str = basicValidations(request);
		System.out.println(str + "-----");
		if(str!=null)
			return  new jsonFit("error",str);
		 return new jsonFit("error","Invalid ID");
		
		
	}
	
	private String basicValidations(HttpServletRequest request){
		
		if(request.getParameter("FirstName")==null || request.getParameter("FirstName").isEmpty() )
			return "Please enter first name";
		return null;
	}
}

