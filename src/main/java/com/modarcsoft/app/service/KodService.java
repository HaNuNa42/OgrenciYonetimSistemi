package com.modarcsoft.app.service;

import java.util.List;
import com.modarcsoft.app.entities.Kodlar;

public interface KodService {

	Kodlar ekleKod(Kodlar kod);

	List<Kodlar> tumKodlariGetir();

	Kodlar guncelleKod(Kodlar kod, int id);

	void silKod(int id);

}
