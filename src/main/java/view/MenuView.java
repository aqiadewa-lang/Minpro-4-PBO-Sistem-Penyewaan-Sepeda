package view;

import controller.SepedaController;
import model.*;
import java.util.Scanner;

public class MenuView {
    private SepedaController controller;
    private Scanner scanner;

    public MenuView() {
        this.controller = new SepedaController();
        this.scanner = new Scanner(System.in);
    }

    public void tampilkanMenuUtama() {
        int pilihan = 0;
        while (pilihan != 6) { // Tambah 1 menu untuk Transaksi
            System.out.println("\n=== SISTEM PENYEWAAN SEPEDA (MVC) ===");
            System.out.println("1. Tampilkan Daftar Sepeda");
            System.out.println("2. Tambah Sepeda Baru");
            System.out.println("3. Ubah Data Sepeda");
            System.out.println("4. Hapus Sepeda");
            System.out.println("5. Buat Transaksi Sewa (Gunakan Pelanggan & Transaksi)");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Input harus berupa angka 1-6!");
                continue;
            }

            switch (pilihan) {
                case 1: tampilkanSepeda(); break;
                case 2: tambahSepeda(); break;
                case 3: ubahSepeda(); break;
                case 4: hapusSepeda(); break;
                case 5: buatTransaksi(); break;
                case 6: System.out.println("Terima kasih, program selesai."); break;
                default: System.out.println("Pilihan menu tidak valid!");
            }
        }
    }

    private void tampilkanSepeda() {
        System.out.println("\n--- DAFTAR SEPEDA ---");
        if (controller.getDaftarSepeda().isEmpty()) {
            System.out.println("Belum ada data sepeda.");
        } else {
            for (Sepeda s : controller.getDaftarSepeda()) {
                System.out.println(s.getDetail());
            }
        }
    }

    private void tambahSepeda() {
        System.out.println("\n--- TAMBAH SEPEDA BARU ---");
        System.out.print("ID Sepeda: ");
        String idBaru = scanner.nextLine();

        // Fix Bug: Pengecekan ID duplikat
        if (controller.isIdExist(idBaru)) {
            System.out.println("GAGAL: ID Sepeda '" + idBaru + "' sudah ada di sistem!");
            return;
        }

        System.out.print("Merk Sepeda: ");
        String merkBaru = scanner.nextLine();

        double hargaBaru = 0;
        while (true) {
            try {
                System.out.print("Harga Sewa/Hari: Rp ");
                hargaBaru = Double.parseDouble(scanner.nextLine());
                if (hargaBaru <= 0) {
                    System.out.println("Harga harus lebih dari 0!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Input harga harus berupa angka!");
            }
        }

        int jenisPilihan = 0;
        while (jenisPilihan != 1 && jenisPilihan != 2) {
            try {
                System.out.println("Pilih Jenis Sepeda:");
                System.out.println("1. Sepeda Gunung");
                System.out.println("2. Sepeda Listrik");
                System.out.print("Pilihan (1/2): ");
                jenisPilihan = Integer.parseInt(scanner.nextLine());

                if (jenisPilihan == 1) {
                    System.out.print("Tipe Suspensi (misal: Full/Hardtail): ");
                    String suspensi = scanner.nextLine();
                    controller.tambahSepeda(new SepedaGunung(idBaru, merkBaru, hargaBaru, suspensi));
                    System.out.println("Data Sepeda Gunung berhasil ditambahkan!");
                } else if (jenisPilihan == 2) {
                    // Fix Bug: Input baterai error, data gagal ditambahkan diperbaiki dengan looping
                    int baterai = 0;
                    boolean bateraiValid = false;
                    while (!bateraiValid) {
                        try {
                            System.out.print("Kapasitas Baterai (mAh): ");
                            baterai = Integer.parseInt(scanner.nextLine());
                            bateraiValid = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Input Baterai harus berupa angka! Ulangi.");
                        }
                    }
                    controller.tambahSepeda(new SepedaListrik(idBaru, merkBaru, hargaBaru, baterai));
                    System.out.println("Data Sepeda Listrik berhasil ditambahkan!");
                } else {
                    System.out.println("Pilihan tidak valid, pilih 1 atau 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Input harus berupa angka!");
            }
        }
    }

    private void ubahSepeda() {
        System.out.println("\n--- UBAH SEPEDA ---");
        System.out.print("Masukkan ID Sepeda yang ingin diubah: ");
        String idEdit = scanner.nextLine();

        Sepeda s = controller.cariSepeda(idEdit);
        if (s != null) {
            System.out.print("Merk Baru: ");
            s.setMerk(scanner.nextLine());
            while (true) {
                try {
                    System.out.print("Harga Baru: Rp ");
                    s.setHargaSewaPerHari(Double.parseDouble(scanner.nextLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Input harga harus berupa angka!");
                }
            }
            System.out.println("Data sepeda berhasil diperbarui.");
        } else {
            System.out.println("ID Sepeda tidak ditemukan.");
        }
    }

    private void hapusSepeda() {
        System.out.println("\n--- HAPUS SEPEDA ---");
        System.out.print("Masukkan ID Sepeda yang ingin dihapus: ");
        String idHapus = scanner.nextLine();

        if (controller.hapusSepeda(idHapus)) {
            System.out.println("Data sepeda berhasil dihapus.");
        } else {
            System.out.println("ID Sepeda tidak ditemukan.");
        }
    }
    
    // Fitur baru agar class Pelanggan & TransaksiSewa digunakan
    private void buatTransaksi() {
        System.out.println("\n--- BUAT TRANSAKSI SEWA ---");
        System.out.print("Masukkan ID Sepeda yang ingin disewa: ");
        String idSewa = scanner.nextLine();
        
        Sepeda s = controller.cariSepeda(idSewa);
        if (s != null) {
            System.out.print("Lama Sewa (Hari): ");
            int lama;
            try {
                lama = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Lama sewa harus angka.");
                return;
            }
            
            // Buat ID transaksi sederhana
            String idTrans = "TRX-" + (controller.getDaftarTransaksi().size() + 1);
            Pelanggan pelanggan = controller.getPelangganPertama(); // Ambil dummy
            
            TransaksiSewa trx = new TransaksiSewa(idTrans, pelanggan, s, lama);
            controller.tambahTransaksi(trx);
            
            System.out.println("Transaksi Berhasil Dibuat!");
            System.out.println("ID Transaksi: " + trx.getIdTransaksi());
            System.out.println("Penyewa     : " + trx.getPelanggan().getNama());
            System.out.println("Sepeda      : " + trx.getSepeda().getMerk());
            
            // Penggunaan Overloading (simulasi diskon 5000)
            System.out.println("Total Biaya Normal: Rp " + trx.hitungTotalBiaya());
            System.out.println("Total Biaya (Diskon 5000): Rp " + trx.hitungTotalBiaya(5000));
        } else {
            System.out.println("ID Sepeda tidak ditemukan.");
        }
    }
}