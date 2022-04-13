package com.modarcsoft.app.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.modarcsoft.app.entities.Kullanicilar;
import com.modarcsoft.app.repository.KullaniciRepository;

@Service
public class KullaniciServiceImpl implements KullaniciService {
	
//	private EntityManager entityManager;

	
	private KullaniciRepository kullaniciRepository;

	@Override
	public Kullanicilar ekleKullanici(Kullanicilar kullanici) {

		return kullaniciRepository.save(kullanici);
	}

	@Override
	public List<Kullanicilar> tumKullanicilariGetir() {

		return (List<Kullanicilar>) kullaniciRepository.findAll();
	}

	@Override
	public Kullanicilar guncelleKullanici(Kullanicilar kullanici, int id) {

		// kullanıcı vt de aranıyor
		Kullanicilar kullaniciVT = kullaniciRepository.findById(id).get();

		// düzenleme yapılıp yapılmadığının sorgusu dönüyor
		if (Objects.nonNull(kullanici.getAdres()) && !"".equalsIgnoreCase(kullanici.getAdres())) {
			kullaniciVT.setAdres(kullanici.getAdres());
		}

		if (Objects.nonNull(kullanici.getMail()) && !"".equalsIgnoreCase(kullanici.getMail())) {
			kullaniciVT.setMail(kullanici.getMail());
		}

		if (Objects.nonNull(kullanici.getTelefon()) && !"".equalsIgnoreCase(kullanici.getTelefon())) {
			kullaniciVT.setTelefon(kullanici.getTelefon());
		}

		return kullaniciRepository.save(kullaniciVT);
	}

	@Override
	public void silKullanici(int id) {
		kullaniciRepository.deleteById(id);
	}

	@Override
	public Kullanicilar kullaniciadiSifre(Kullanicilar kullanici) {
	
		try {
			System.out.println("doğrulama tamam");
			return kullaniciRepository.kullaniciadiSifre(kullanici.getKullaniciadi(), kullanici.getSifre());
		}catch (Exception e) {
			System.out.println("hata :: kullanıcı adı ve şifre hatalı : " + e);
		}
		return kullanici;
		
	}

	@Override
	public ArrayList<Kullanicilar> getResults(Kullanicilar id, String kullaniciadi) {
		System.out.println("burası çalıştı impl 1");
		
		if (id != null) {  
			 System.out.println("burası çalıştı impl 2");
			if (id.getKullaniciadi() != null && id.getKullaniciadi() != "") {
				System.out.println("burası çalıştı impl 3");
				((Query) kullaniciRepository).setParameter("kullaniciadi", id.getKullaniciadi());
				System.out.println("burası çalıştı impl 4");
			}
		}
		System.out.println("burası çalıştı impl 5");
		return kullaniciRepository.getResultsKullaniciadi(id, kullaniciadi);
		
	}
	
	
	
}
