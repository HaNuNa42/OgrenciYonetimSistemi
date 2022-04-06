package com.modarcsoft.app.service;

import java.util.List;
import com.modarcsoft.app.entities.Branslar;


public interface BransService {
	
	
		Branslar ekleBrans(Branslar brans);
		
	
		List<Branslar> tumBranslariGetir();
		
	
		Branslar guncelleBrans(Branslar brans, int id);
		
		
		void silBrans(int id);
		

}
