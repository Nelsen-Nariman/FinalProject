package Model;

public class Menu {
	//ctrl + shift + s 
	private String kode, nama, harga, stok;
	

	public Menu(String nama, String harga, String stok) {
		super();
//		this.kode = kode;
		this.nama = nama;
		this.harga = harga;
		this.stok = stok;
	}

	public String getKode() {
		return kode;
	}

	public String getNama() {
		return nama;
	}

	public String getHarga() {
		return harga;
	}

	public String getStok() {
		return stok;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	

}
