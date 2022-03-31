package com.modarcsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modarcsoft.app.entities.Kullanicilar;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanicilar, Integer>{

	Kullanicilar kullaniciadiVeSifreKontrol(String kullanciadi, String sifre);

}
