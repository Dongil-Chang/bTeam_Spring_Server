package com.so.storage.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//이용안내 화면 요청
@Controller
public class CommonController {	
	@RequestMapping("/guide.gu")
	public String list(HttpSession session, Model model) {
		session.setAttribute("category", "gu");
		return "guide/guide";
	}

}
