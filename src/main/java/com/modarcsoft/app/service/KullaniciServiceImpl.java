package com.modarcsoft.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import com.modarcsoft.app.entities.Kullanicilar;
import com.modarcsoft.app.repository.KullaniciRepository;

@Service
public class KullaniciServiceImpl implements KullaniciService {

	@Autowired
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

		return kullaniciRepository.kullaniciadiSifre(kullanici.getKullaniciadi(), kullanici.getSifre());

	}

	
}
