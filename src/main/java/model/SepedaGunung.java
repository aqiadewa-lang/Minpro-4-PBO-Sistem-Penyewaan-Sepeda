package model;

public class SepedaGunung extends Sepeda {
    private int jumlahGear;
    private String suspensi;

    // Constructor 1 (overloading): dengan jumlah gear
    public SepedaGunung(String idSepeda, String merk, double hargaSewaPerHari, int jumlahGear) {
        super(idSepeda, merk, hargaSewaPerHari);
        this.jumlahGear = jumlahGear;
        this.suspensi = "-";
    }

    // Constructor 2 (overloading): dengan tipe suspensi
    public SepedaGunung(String idSepeda, String merk, double hargaSewaPerHari, String suspensi) {
        super(idSepeda, merk, hargaSewaPerHari);
        this.suspensi = suspensi;
        this.jumlahGear = 0;
    }

    public int getJumlahGear() { return jumlahGear; }
    public void setJumlahGear(int jumlahGear) { this.jumlahGear = jumlahGear; }
    public String getSuspensi() { return suspensi; }
    public void setSuspensi(String suspensi) { this.suspensi = suspensi; }

    @Override
    public String getKategori() {
        return "Sepeda Gunung";
    }

    @Override
    public String getDetail() {
        return super.getDetail() + " | Jenis: " + getKategori() + " | Suspensi: " + suspensi;
    }
}   