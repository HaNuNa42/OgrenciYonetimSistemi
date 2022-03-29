package com.modarcsoft.app.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Kullanicilar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name= "adi")
	private String adi;
	
	@Column(name= "soyadi")
	private String soyadi;
	
	@Column
	private String sifre;
	
	@Column(name="sifretekrar")
	private String sifretekrar;
	
	@Column
	private int rol;
	
	@Column
	private String avatar; //profil resmi
	
	@Column
	private String telefon;
	
	@Column
	private String adres;
	
	@Column
	private String mail;
	
	@Column(name= "olusturulmatarihi")
	private Date olusturulmaTarihi;
	
	@Column(name = "degistirmetarihi")
	private Date degistirmeTarihi;
	
	@ManyToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL) //çoktan bire ilişki
	@JoinColumn(name= "rol", nullable=false)
	private Roller roller;

	

	public Kullanicilar() {
		super();
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getSifretekrar() {
		return sifretekrar;
	}

	public void setSifretekrar(String sifretekrar) {
		this.sifretekrar = sifretekrar;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getOlusturulmaTarihi() {
		return olusturulmaTarihi;
	}

	public void setOlusturulmaTarihi(Date olusturulmaTarihi) {
		this.olusturulmaTarihi = olusturulmaTarihi;
	}

	public Date getDegistirmeTarihi() {
		return degistirmeTarihi;
	}

	public void setDegistirmeTarihi(Date degistirmeTarihi) {
		this.degistirmeTarihi = degistirmeTarihi;
	}
	
	
	
}
