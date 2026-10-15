package model;

import model.SewaAble;

public abstract class Sepeda implements SewaAble {
    private String idSepeda;
    private String merk;
    private double hargaSewaPerHari;

    public Sepeda(String idSepeda, String merk, double hargaSewaPerHari) {
        this.idSepeda = idSepeda;
        this.merk = merk;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public String getIdSepeda() { return idSepeda; }
    public void setIdSepeda(String idSepeda) { this.idSepeda = idSepeda; }

    public String getMerk() { return merk; }
    public void setMerk(String merk) { this.merk = merk; }

    public double getHargaSewaPerHari() { return hargaSewaPerHari; }
    public void setHargaSewaPerHari(double hargaSewaPerHari) { this.hargaSewaPerHari = hargaSewaPerHari; }

    // Abstract method yang wajib di-override subclass
    public abstract String getKategori();

    // Implementasi interface Sewaable
    public double hitungBiayaSewa(int lamaSewa) {
        return hargaSewaPerHari * lamaSewa;
    }

    public String getDetail() {
        return "ID: " + idSepeda + " | Merk: " + merk + " | Harga/Hari: " + hargaSewaPerHari;
    }
}