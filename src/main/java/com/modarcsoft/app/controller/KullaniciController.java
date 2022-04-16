package com.modarcsoft.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.modarcsoft.app.entities.Kullanicilar;
import com.modarcsoft.app.service.KullaniciService;

@Controller
public class KullaniciController {

//	@Autowired
	private KullaniciService kullaniciService;

	@GetMapping({ "kullanicilar" })
	public String kullanicilar() {
		return "kullanicilar";
	}

	

	@RequestMapping(value = "/eklekullanici", method = RequestMethod.POST)
	public ResponseEntity<String> AddUser(@Valid @RequestBody Kullanicilar kullanici, HttpServletRequest request) {
		try {
			kullaniciService.ekleKullanici(kullanici);
		} catch (Exception e) {
			System.out.println(e);
		}

		return new ResponseEntity<>(("Kullanıcı başarıyla güncelleştirildi."), HttpStatus.CREATED);

	}

	@RequestMapping(value = "/getAllUser", method = RequestMethod.POST)
	public ArrayList<Kullanicilar> getAllUser( Kullanicilar kullanici, HttpServletRequest request) {
		
			kullaniciService.tumKullanicilariGetir(kullanici);
			System.out.println("hata     :  "+request);
			
			return null;
		
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<Kullanicilar> getUser(@PathVariable(value = "id") int id) {

		try {
			Kullanicilar us = kullaniciService.getFindById((int) id);

			return new ResponseEntity<>(us, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/guncellekullanici", method = RequestMethod.POST)
	public ResponseEntity<String> UpdateUser(@RequestBody Kullanicilar user, @PathVariable("id") int id,
			HttpServletRequest request) {

		try {

			kullaniciService.guncelleKullanici(user, id);

		} catch (Exception e) {
			System.out.println("hata : " + e.toString());

		}
		return new ResponseEntity<>(("Kullanıcı başarıyla güncelleştirildi."), HttpStatus.CREATED);

	}

	@RequestMapping(value = "/silkullanici", method = RequestMethod.POST)
	public ResponseEntity<String> DeleteUser(@PathVariable("id") int id, HttpServletRequest request) {
		try {
			kullaniciService.silKullanici(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<>(("Kullanıcı başarıyla güncelleştirildi."), HttpStatus.CREATED);
	}
}
