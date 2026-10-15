package model;

public class TransaksiSewa {
    private String idTransaksi;
    private Pelanggan pelanggan;
    private Sepeda sepeda;
    private int lamaSewahari;

    public TransaksiSewa(String idTransaksi, Pelanggan pelanggan, Sepeda sepeda, int lamaSewahari) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.sepeda = sepeda;
        this.lamaSewahari = lamaSewahari;
    }

    public double hitungTotalBiaya() {
        return sepeda.hitungBiayaSewa(lamaSewahari);
    }

    // Overloading method untuk diskon
    public double hitungTotalBiaya(double diskonRupiah) {
        return hitungTotalBiaya() - diskonRupiah;
    }

    public String getIdTransaksi() { return idTransaksi; }
    public Pelanggan getPelanggan() { return pelanggan; }
    public Sepeda getSepeda() { return sepeda; }
    public int getLamaSewahari() { return lamaSewahari; }
}