package com.modarcsoft.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.modarcsoft.app.entities.Dersler;
import com.modarcsoft.app.repository.DersRepository;

public class DersServiceImpl implements DersService{
	
	@Autowired
	private DersRepository dersRepository;

	@Override
	public Dersler ekleDers(Dersler ders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dersler> tumDersleriGetir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dersler guncelleDers(Dersler ders, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void silDers(int id) {
		// TODO Auto-generated method stub
		
	}

}
