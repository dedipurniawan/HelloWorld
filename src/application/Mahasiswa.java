package application;

public class Mahasiswa {

    private String name;
    private int nim;
    private String fakultas;
    private String jurusan;
    private String alamat;
    private String kota;
    private int kode_pos;
    private String hobby;   
       
    public Mahasiswa() {
        this.name = "";
        this.nim = 1;
        this.fakultas = "";
        this.jurusan = "";
        this.alamat = "";
        this.kota = "";
        this.kode_pos = 1;
        this.hobby = "";
    }   

    public Mahasiswa(String name, int nim, String fakultas, String jurusan, String alamat, String kota,
			int kode_pos, String hobby) {
		this.name = name;
		this.nim = nim;
		this.fakultas = fakultas;
		this.jurusan = jurusan;
		this.alamat = alamat;
		this.kota = kota;
		this.kode_pos = kode_pos;
		this.hobby = hobby;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNim() {
        return nim;
    }

    public void setNIM(int nim) {
        this.nim = nim;
    }
    
    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
    
    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
    
    public double getKode_Pos() {
        return kode_pos;
    }

    public void setKode_Pos(int kode_pos) {
        this.kode_pos = kode_pos;
    }
    
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    
}
