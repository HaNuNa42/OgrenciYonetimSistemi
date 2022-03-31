package com.modarcsoft.app.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Dersler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dersId;
	
	@Column(name="dersadi")
	private String dersAdi;
	
	@Column(name= "bransid")
	private int bransId;
	
	@ManyToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL) //çoktan bire ilişki
	@JoinColumn(name= "bransid", insertable=false, updatable=false) //nullable=false GELECEK
	private Branslar branslar;


}
