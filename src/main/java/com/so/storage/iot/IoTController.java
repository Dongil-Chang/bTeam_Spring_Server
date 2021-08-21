package com.so.storage.iot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import iot.IoTServiceImpl;
import iot.IoTVO;

@Controller
public class IoTController {
	
	@Autowired private IoTServiceImpl service;
	
	@RequestMapping("/arduSetIoT")
	public String insert_temhum_iot(IoTVO vo, HttpServletRequest req, Model model) {
		// System.out.println("온도 : " + req.getParameter("temp"));
		// System.out.println("습도 : " + req.getParameter("hum"));
//		model.addAttribute("vo", req.getParameter("temp"));
//		model.addAttribute("vo", req.getParameter("hum"));

		service.IoT_insert_TemHum(vo);

		return "iot/arduSetIoT";
	}
	
	@RequestMapping("/checkIoT")
	public String IoT_list_TemHum(IoTVO vo, HttpServletRequest req, Model model) {
		model.addAttribute("vo",service.IoT_list());
		return "iot/temHumVal";
	}
}
