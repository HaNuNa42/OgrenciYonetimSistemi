package com.modarcsoft.app.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Kullanicilar implements Serializable{
	
	private static final long serialVersionUID = 5724727529841302098L; //silme bunu
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name="kullaniciadi")
	private String kullaniciadi;
	
	@Column(name="adi")
	private String adi;
	
	@Column(name= "soyadi")
	private String soyadi;
	
	@Column
	private String sifre;
	
	@Transient
	@Column(name="sifretekrar")
	private String sifretekrar;
	
	@Column
	private int rol;
	
	@Column
	private int brans;
	
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
	@JoinColumn(name= "rol", insertable=false, updatable=false)
	private Roller roller;
	
	@ManyToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name= "brans", insertable=false, updatable=false ) 
	private Branslar branslar;

	
	public Kullanicilar() {
		super();
	}
	 
	public Kullanicilar(int id, String kullaniciadi, String adi, String soyadi, String sifre, String sifretekrar,
			int rol, int brans, String avatar, String telefon, String adres, String mail, Date olusturulmaTarihi,
			Date degistirmeTarihi, Roller roller, Branslar branslar) {
		super();
		this.id = id;
		this.kullaniciadi = kullaniciadi;
		this.adi = adi;
		this.soyadi = soyadi;
		this.sifre = sifre;
		this.sifretekrar = sifretekrar;
		this.rol = rol;
		this.brans = brans;
		this.avatar = avatar;
		this.telefon = telefon;
		this.adres = adres;
		this.mail = mail;
		this.olusturulmaTarihi = olusturulmaTarihi;
		this.degistirmeTarihi = degistirmeTarihi;
		this.roller = roller;
		this.branslar = branslar;
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

	public String getKullaniciadi() {
		return kullaniciadi;
	}

	public void setKullaniciadi(String kullaniciadi) {
		this.kullaniciadi = kullaniciadi;
	}

	public Roller getRoller() {
		return roller;
	}

	public void setRoller(Roller roller) {
		this.roller = roller;
	}

	public int getBrans() {
		return brans;
	}

	public void setBrans(int brans) {
		this.brans = brans;
	}

	public Branslar getBranslar() {
		return branslar;
	}

	public void setBranslar(Branslar branslar) {
		this.branslar = branslar;
	}
	
	
	
}
