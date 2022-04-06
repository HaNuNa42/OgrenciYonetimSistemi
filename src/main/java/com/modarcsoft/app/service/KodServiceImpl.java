package com.modarcsoft.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.modarcsoft.app.entities.Kodlar;
import com.modarcsoft.app.repository.KodRepository;

public class KodServiceImpl implements KodService{
	
	@Autowired
	private KodRepository kodRepository;

	@Override
	public Kodlar ekleKod(Kodlar kod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kodlar> tumKodlariGetir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kodlar guncelleKod(Kodlar kod, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void silKod(int id) {
		// TODO Auto-generated method stub
		
	}

}
