package com.modarcsoft.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KullaniciController {
	
	@GetMapping({"kullanicilar"})
	public String kullanicilar() {
		return "kullanicilar";
	}

}

