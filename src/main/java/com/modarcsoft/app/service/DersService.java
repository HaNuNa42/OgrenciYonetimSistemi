package com.modarcsoft.app.service;

import java.util.List;
import com.modarcsoft.app.entities.Dersler;

public interface DersService {
	
	Dersler ekleDers(Dersler ders);
	
	
	List<Dersler> tumDersleriGetir();
	

	Dersler guncelleDers(Dersler ders, int id);
	
	
	void silDers(int id);

}
