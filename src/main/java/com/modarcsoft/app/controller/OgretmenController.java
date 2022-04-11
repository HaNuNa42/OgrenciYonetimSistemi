package com.modarcsoft.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OgretmenController {
	
	@GetMapping({"ogretmenler"})
	public String ogretmenler() {
		return "ogretmenler";
	}

}

