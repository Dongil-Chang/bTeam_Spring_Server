package com.so.storage.web;



import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import member.MemberServiceImpl;
import member.MemberVO;
import notice.NoticePage;
import notice.NoticeServiceImpl;
import notice.NoticeVO;

@Controller
public class NoticeController {
	
	@Autowired private NoticeServiceImpl service;
	@Autowired private CommonService common;
	@Autowired private MemberServiceImpl member;
	@Autowired private NoticePage page;
	
	// 공지사항 상세화면 요청
		@RequestMapping("/detail.no")
		public String detail(int board_num, Model model) {
			// 상세화면 요청 전 조회수 증가
			service.notice_read(board_num);
			
			// 선택한 공지사항 정보를 DB에서 조회해 와 상세화면에 출력
			model.addAttribute("vo", service.notice_detail(board_num));
			model.addAttribute("crlf", "\r\n");
			model.addAttribute("page", page);
			return "notice/detail";
		}
	
	// 신규 공지사항 저장처리 요청
		@RequestMapping("/insert.no")
		public String insert(NoticeVO vo, MultipartFile file, HttpSession session) {
//			MemberVO member = (MemberVO)session.getAttribute("loginInfo");
//			vo.setWriter(member.getId());
			
			// 로그인 된 사용자의 id를 가져와 글쓴이(writer) 에 담기 위한 처리
			vo.setBoard_writer( ((MemberVO) session.getAttribute("loginInfo")).getId());
			
			
			if (! file.isEmpty() ) {	// 파일이 있는 경우
				// 파일 첨부 처리 부분
				vo.setFilename(file.getOriginalFilename());
				vo.setFilepath( common.fileUpload("notice",	file, session));		
			}
			
			// 화면에서 입력한 정보를 DB에 저장한 후 화면으로 연결		
			service.notice_insert(vo);
			return "redirect:list.no";	// 리턴 시 공지사항 목록 화면으로 이동 처리
		}
	
	// 신규 공지사항 입력화면 요청
		@RequestMapping("/new.no")
		public String notice() {
			return "notice/new";
		}
	
	
	// 공지사항 글목록 화면 요청
	@RequestMapping("/list.no")
	public String list(HttpSession session, Model model, 
					String search, String keyword,
				@RequestParam(defaultValue = "1") int curPage) {
		
		// 공지글 처리중 임의로 로그인해 두기 - 나중에 삭제할 것
		/*
		 * HashMap<String, String> map = new HashMap<String, String>(); map.put("id",
		 * "hanul"); map.put("pw", "hanul"); session.setAttribute("loginInfo",
		 * member.member_login(map));
		 */
		
		session.setAttribute("category", "no");
		
	//  DB에서 공지글 목록을 조회해와 목록화면에 출력		
	//	model.addAttribute("list", service.notice_list());
		
		// 페이지 처리된 글 목록조회
		page.setCurPage(curPage);	// 페이지의 현재 페이지는 curPage 이며

		// 게시글 검색을 위한 처리
		page.setSearch(search);
		page.setKeyword(keyword);
		
		model.addAttribute("page", service.notice_list(page));
		return "notice/list";
	}
	
	
}
