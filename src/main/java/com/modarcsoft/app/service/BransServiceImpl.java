package com.modarcsoft.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.modarcsoft.app.entities.Branslar;
import com.modarcsoft.app.repository.BransRepository;

public class BransServiceImpl implements BransService{
	
	@Autowired
	private BransRepository bransRepository;

	@Override
	public Branslar ekleBrans(Branslar brans) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Branslar> tumBranslariGetir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Branslar guncelleBrans(Branslar brans, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void silBrans(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
