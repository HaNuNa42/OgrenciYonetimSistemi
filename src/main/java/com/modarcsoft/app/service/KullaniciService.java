package com.modarcsoft.app.service;

import java.util.ArrayList;
import java.util.List;


import com.modarcsoft.app.entities.Kullanicilar;


public interface KullaniciService {
	
	//ekle
	Kullanicilar ekleKullanici(Kullanicilar kullanici);
	
	//listele
	List<Kullanicilar> tumKullanicilariGetir(Kullanicilar kullanici);
	
	//güncelle
	Kullanicilar guncelleKullanici(Kullanicilar kullanici, int id);
	
	//sil
	void silKullanici(int id);
	
	//kullanici kontrol
	Kullanicilar kullaniciadiSifre(Kullanicilar kullanici);

	ArrayList<Kullanicilar> getResults(Kullanicilar kullanici, String kullaniciadi);

	//id ye göre kullanici getir
	Kullanicilar getFindById(int id);



	

}
