package com.modarcsoft.app.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Roller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rolId;
	
	@Column
	private String rol;
	
	@OneToMany(mappedBy = "kullanicilar") //birden çoka ilişki 
	private List<Kullanicilar> kullanicilar = new ArrayList<Kullanicilar>();
}
