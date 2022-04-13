package com.modarcsoft.app.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.modarcsoft.app.entities.Kullanicilar;
import com.modarcsoft.app.service.KullaniciService;

@Controller
public class KullaniciController {

	@Autowired
	private KullaniciService kullaniciService;
	

	@GetMapping({ "kullanicilar" })
	public String kullanicilar() {
		return "kullanicilar";
	}

	public boolean Kontrol(Kullanicilar kullanici, String kullaniciadi) {
		
			System.out.println("burası çalıştı 1");
		kullanici.setKullaniciadi(kullaniciadi);
			System.out.println("burası çalıştı 2");
		ArrayList<Kullanicilar> list = kullaniciService.getResults(kullanici, kullaniciadi);
			System.out.println("burası çalıştı 3");
		if (list.size() > 0) {
			return false; // Daha önce kullanıcı adı eklenmiş.
		} else {
			return true; // İlk kullanıcı.
		}
	}

	
	@RequestMapping(value = "/eklekullanici", method = RequestMethod.POST)
	public ResponseEntity<String> AddUser(@RequestBody Kullanicilar kullanici, HttpServletRequest request) {
		System.out.println("burası çalıştı 4");
		if (Kontrol(kullanici, kullanici.getKullaniciadi())) {
			System.out.println("burası çalıştı 5");
			Long ui = (Long) request.getSession().getAttribute("id");

			kullanici.setOlusturulmaTarihi(new Date());

			Kullanicilar result = kullaniciService.ekleKullanici(kullanici);
			if (result != null) {

				return new ResponseEntity<>(("Kullanıcı başarıyla oluşturuldu."), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(("İşlem esnasında hata oluştu."), HttpStatus.FORBIDDEN);

			}
		} else {
			return new ResponseEntity<>(
					("Girmiş olduğunuz Kullanıcı adı daha önce kullanılmıştır. Lütfen farklı Kullanıcı adı adresi giriniz !"),
					HttpStatus.BAD_REQUEST);
		}
	}
}
