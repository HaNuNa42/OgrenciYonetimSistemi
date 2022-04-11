package com.modarcsoft.app.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Branslar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bransId;
	
	@Column
	private String brans;

	@OneToMany(mappedBy = "branslar") //birden çoka ilişki 
	private List<Dersler> dersler = new ArrayList<Dersler>();
	
	@OneToMany(mappedBy = "brans") 
	private List<Kullanicilar> kullanicilar = new ArrayList<Kullanicilar>();
}
