package Model;

public class Personel {

	private int id;
	private String kullaniciAdi;
	private String sifre;
	private String ad;
	private String soyad;
	private String unvan;
	private String tur;
	private double maas;
	private String maasTuru;
	private String departman;
	private String mevcutIs;
	private String cinsiyet;

	public Personel(int id, String kullaniciAdi, String sifre, String ad, String soyad, String unvan, String tur,
			double maas, String departman, String mevcutIs, String cinsiyet, String maasTuru) {
		super();
		this.id = id;
		this.kullaniciAdi = kullaniciAdi;
		this.sifre = sifre;
		this.ad = ad;
		this.soyad = soyad;
		this.unvan = unvan;
		this.tur = tur;
		this.maas = maas;
		this.departman = departman;
		this.mevcutIs = mevcutIs;
		this.cinsiyet = cinsiyet;
		this.maasTuru = maasTuru;
	}

	public Personel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getUnvan() {
		return unvan;
	}

	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	public double getMaas() {
		return maas;
	}

	public void setMaas(double maas) {
		this.maas = maas;
	}

	public String getDepartman() {
		return departman;
	}

	public void setDepartman(String departman) {
		this.departman = departman;
	}

	public String getMevcutIs() {
		return mevcutIs;
	}

	public void setMevcutIs(String mevcutIs) {
		this.mevcutIs = mevcutIs;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getMaasTuru() {
		return maasTuru;
	}

	public void setMaasTuru(String maasTuru) {
		this.maasTuru = maasTuru;
	}

}
