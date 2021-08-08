package com.so.storage.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import manager.ManagerServiceImpl;

@Controller
public class QnAController {

	@Autowired private ManagerServiceImpl service;
	
	@RequestMapping("/list.QnA")
	public String QnA(HttpSession session, Model model){
		session.setAttribute("category", "QnA");
		model.addAttribute("faq", service.faq_list());
		return "qna/QnA";
	}
}
