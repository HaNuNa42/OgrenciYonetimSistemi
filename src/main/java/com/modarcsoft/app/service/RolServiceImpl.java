package com.modarcsoft.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.modarcsoft.app.entities.Roller;
import com.modarcsoft.app.repository.RolRepository;

public class RolServiceImpl implements RolService{
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public Roller ekleRol(Roller rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roller> tumRolleriGetir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roller guncelleRol(Roller rol, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void silRol(int id) {
		// TODO Auto-generated method stub
		
	}

}
