package com.modarcsoft.app.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.modarcsoft.app.entities.Kullanicilar;
import com.modarcsoft.app.service.KullaniciService;

@Controller
public class LoginController {
	
	

	@Autowired
	private KullaniciService kullaniciService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {

		return "login";
	}

	@RequestMapping(value = "/loginControl", method = RequestMethod.POST)
	public String controlUser(Kullanicilar kullanici, HttpServletRequest request) {

		Kullanicilar kullanicilar = kullaniciService.kullaniciadiSifre(kullanici);
		try {
			if (kullanicilar != null) {
				System.out.printf("oturum açıldı", kullanici.getKullaniciadi().toString());

				request.getSession().setAttribute("kullanici", kullanicilar);
				request.getSession().setAttribute("id", kullanicilar.getId());

				return "redirect:/index";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "redirect:/login";
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		request.getSession().setAttribute("kullanici", null);

		return "redirect:/login";
	}
   
}
