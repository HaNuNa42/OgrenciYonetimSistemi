package com.modarcsoft.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OgrenciController {
	
	@GetMapping({"ogrenciler"})
	public String ogrenciler() {
		return "ogrenciler";
	}

}

