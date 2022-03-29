package com.modarcsoft.app.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Kodlar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kodId;
	
	@Column(name="kodadi")
	private String kodAdi;
	
	@Column
	private String aciklama;
	

}
