package com.loginSection.spring.controller;
import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.loginSection.spring.jsonFit;
import com.loginSection.spring.model.UploadBanner;
import com.loginSection.spring.model.User;
import com.loginSection.spring.model.UserDAO;
import com.loginSection.spring.model.UserDAOImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
public class loginCont {

	@RequestMapping("/signup")
	public String signup(){
		return "signup";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST/*,produces="application/json"*/)
	
	public @ResponseBody jsonFit signupAction(MultipartHttpServletRequest  request,Model model,@ModelAttribute("uploadBanner") UploadBanner banner){
		try{
		System.out.println(request.getFile("uploadBanner"));
		}catch(Exception e){e.printStackTrace();
		}
		//System.out.println(request.getParameter("nma"));
		//model.addAttribute("response","{msgType:error,msg:Invalid ID}");
		String str = basicValidations(request);
		System.out.println(str + "-----");
		if(str!=null)
			return  new jsonFit("error",str);
		if(!fileUploading(request.getFile("uploadBanner")))
			return new jsonFit("error","We are unable to upload banner image");
		User user = new User();
		user.setEmail(request.getParameter("FromEmailAddress"));
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserDAO userDAO = context.getBean(UserDAO.class);
		if(userDAO.verifyUser(user))
			return new jsonFit("error","Email Id is already registered");
		user.setFirstName(request.getParameter("FirstName"));
		user.setLastName(request.getParameter("LastName"));
		
		
		userDAO.saveUser(user);
		
		 return new jsonFit("success","Account created successfully");
		
		
	}
	
	private String basicValidations(MultipartHttpServletRequest request){
		
		if(request.getParameter("FirstName")==null || request.getParameter("FirstName").isEmpty() )
			return "Please enter first name";
		if(request.getParameter("LastName")==null || request.getParameter("LastName").isEmpty() )
			return "Please enter last name";
		if(request.getParameter("FromEmailAddress")==null || request.getParameter("FromEmailAddress").isEmpty() )
			return "Please enter Email";
		return null;
	}
	
	private boolean fileUploading(MultipartFile bannerFile){
		String Directory = "/tmp/";
		
		if(bannerFile==null) return false;
		MultipartFile file = bannerFile;
		
		try{
			file.transferTo(new File(Directory+file.getOriginalFilename()));
		}catch(Exception e){e.printStackTrace(); return false;}
		return true;
	}
}

