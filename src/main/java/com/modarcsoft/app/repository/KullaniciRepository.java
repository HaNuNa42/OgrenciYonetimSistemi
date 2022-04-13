package com.modarcsoft.app.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.modarcsoft.app.entities.Kullanicilar;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanicilar, Integer>{

	@Query("SELECT k FROM Kullanicilar k WHERE k.kullaniciadi =?1 and k.sifre =?2")
	Kullanicilar kullaniciadiSifre(String kullaniciadi, String sifre);

	@Query("SELECT k FROM Kullanicilar k Where kullaniciadi =?1")
	ArrayList<Kullanicilar> getResultsKullaniciadi(Kullanicilar id, String kullaniciadi);

}
