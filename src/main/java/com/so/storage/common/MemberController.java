package com.so.storage.common;

//import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
//import com.google.gson.JsonArray;

import member.MemberServiceImpl;
import member.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberServiceImpl service;

	@ResponseBody
	@RequestMapping("/and_login")
	public void login(String id, String pw, HttpServletResponse res) throws Exception {

//		System.out.println(id + ", " + pw);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id); // 가져온 값 hashmap 에 담아줌
		map.put("pw", pw);
		
		MemberVO vo = service.member_login(map);

		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
		 
	}
	
	@ResponseBody
	@RequestMapping("/and_join")
	public void join(MemberVO vo) {
		//vo = new MemberVO(id, pw, name, email, tel);
		service.member_join(vo);
	}
}
