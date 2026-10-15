package model;

public class SepedaListrik extends Sepeda {
    private int kapasitasBaterai; // Dalam mAh

    public SepedaListrik(String idSepeda, String merk, double hargaSewaPerHari, int kapasitasBaterai) {
        super(idSepeda, merk, hargaSewaPerHari);
        this.kapasitasBaterai = kapasitasBaterai;
    }

    public int getKapasitasBaterai() { return kapasitasBaterai; }
    public void setKapasitasBaterai(int kapasitasBaterai) { this.kapasitasBaterai = kapasitasBaterai; }

    @Override
    public String getKategori() {
        return "Sepeda Listrik";
    }

    @Override
    public String getDetail() {
        return super.getDetail() + " | Jenis: " + getKategori() + " | Baterai: " + kapasitasBaterai + " mAh";
    }
    @Override
    public double hitungBiayaSewa(int lamaSewa) {
      return super.hitungBiayaSewa(lamaSewa) + (5000 * lamaSewa); // biaya pengisian baterai
  }
}