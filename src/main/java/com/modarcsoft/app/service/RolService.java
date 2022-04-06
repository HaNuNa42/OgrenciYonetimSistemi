package com.modarcsoft.app.service;

import java.util.List;
import com.modarcsoft.app.entities.Roller;

public interface RolService {
	
	Roller ekleRol(Roller rol);

	List<Roller> tumRolleriGetir();

	Roller guncelleRol(Roller rol, int id);

	void silRol(int id);

}
