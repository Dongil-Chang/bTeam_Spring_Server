package com.so.storage.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import contactus.ContactUsServiceImpl;
import contactus.ContactUsVO;
import member.MemberVO;

@Controller
public class ContactUsController {

	@Autowired private ContactUsServiceImpl service;
	
	// 1:1 문의 수정 처리 요청
	@RequestMapping("/cu_update.qa")
	public String cu_update(ContactUsVO vo, Model model) {
		service.cu_update(vo);
		return "redirect:cu_detail.qa";
	}
	
	// 1:1 문의 수정 화면 요청
	@RequestMapping("/cu_modify.qa")
	public String cu_modify(int board_num, Model model) {
		// 해당 글의 정보를 DB에서 조회하여 수정화면에 출력		
		model.addAttribute("vo", service.cu_detail(board_num));
		return "contact_us/cu_modify";
	}
	
	// 1:1 문의 상세 화면 요청
	@RequestMapping("/cu_detail.qa")
	public String cu_detail(int id, Model model) {
			
		// 해당 1:1 문의 글을 DB에서 조회하여 상세화면에 출력
		model.addAttribute("vo", service.cu_detail(id));
		return "contact_us/cu_detail";
	}
	
	// 1:1 문의 신규 내용 저장 요청
	@RequestMapping("/cu_insert.qa")
	public String cu_insert(ContactUsVO vo, HttpSession session) {
		MemberVO member = loginStatus(session); // 로그인된 회원정보를 가져옴
		if ( member == null ) return "redirect:cu_list.qa"; // 로그인 정보가 없으면 목록 화면으로 이동
		
		vo.setBoard_writer(member.getId());
		service.cu_insert(vo);
		return "redirect:cu_list.qa";
	}
	
	private MemberVO loginStatus(HttpSession session) {
		return (MemberVO) session.getAttribute("loginInfo");
	}
	
	// 1:1 문의 신규 내용 입력 화면 요청
	@RequestMapping("/cu_new.qa")
	public String cu_new() {
		return "contact_us/cu_new";
	}
	
	// 1:1 문의 목록 화면 요청
	@RequestMapping("/cu_list.qa")
	public String cu_list(HttpSession session, Model model) {
		session.setAttribute("category", "qa");
		model.addAttribute("list", service.cu_list());
		return "contact_us/cu_list";
	}
}
