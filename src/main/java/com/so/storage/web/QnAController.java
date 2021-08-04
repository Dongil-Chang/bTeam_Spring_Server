package com.so.storage.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QnAController {

	@RequestMapping("/list.QnA")
	public String QnA(HttpSession session){
		session.setAttribute("category", "QnA");
		return "qna/QnA";
	}
}
