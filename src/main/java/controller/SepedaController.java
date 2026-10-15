package controller;

import DAO.SepedaDAO;
import java.sql.*;
import java.util.ArrayList;
import model.*;

public class SepedaController {
    private SepedaDAO sepedaDAO;

    public SepedaController() {
        this.sepedaDAO = new SepedaDAO();
    }

    public Sepeda cariSepeda(String id) {
        for (Sepeda s : getDaftarSepeda()) {
            if (s.getIdSepeda().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
    
    // --- BAGIAN SEPEDA (CRUD via DAO) ---
    public ArrayList<Sepeda> getDaftarSepeda() {
        return sepedaDAO.getAllSepeda();
    }

    public void tambahSepeda(Sepeda sepeda) {
        sepedaDAO.insertSepeda(sepeda);
    }

    public boolean isIdExist(String id) {
        return sepedaDAO.isIdExist(id);
    }

    public boolean hapusSepeda(String id) {
        return sepedaDAO.deleteSepeda(id);
    }

    // --- BAGIAN TRANSAKSI & PELANGGAN ---
    
    // 1. Mengambil pelanggan pertama dari database (untuk simulasi transaksi)
    public Pelanggan getPelangganPertama() {
        Pelanggan pelanggan = null;
        String query = "SELECT * FROM pelanggan LIMIT 1";
        
        try (Connection conn = config.DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            
            if (rs.next()) {
                String idP = rs.getString("id_pelanggan");
                String nama = rs.getString("nama");
                String telp = rs.getString("no_telepon");
                pelanggan = new Pelanggan(idP, nama, telp);
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil pelanggan: " + e.getMessage());
        }
        return pelanggan;
    }

    // 2. Mengambil daftar transaksi dari database
    public ArrayList<TransaksiSewa> getDaftarTransaksi() {
        ArrayList<TransaksiSewa> daftarTrx = new ArrayList<>();
        String query = "SELECT t.*, p.nama, p.no_telepon, s.merk, s.harga_sewa_per_hari, s.jenis, s.jumlah_gear, s.suspensi, s.kapasitas_baterai " +
                       "FROM transaksi_sewa t " +
                       "JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan " +
                       "JOIN sepeda s ON t.id_sepeda = s.id_sepeda";
        
        try (Connection conn = config.DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                String idTrx = rs.getString("id_transaksi");
                int lamaSewa = rs.getInt("lama_sewa_hari");
                
                Pelanggan p = new Pelanggan(rs.getString("id_pelanggan"), rs.getString("nama"), rs.getString("no_telepon"));
                
                String jenis = rs.getString("jenis");
                Sepeda s = null;
                if ("GUNUNG".equalsIgnoreCase(jenis)) {
                    SepedaGunung sg = new SepedaGunung(rs.getString("id_sepeda"), rs.getString("merk"), rs.getDouble("harga_sewa_per_hari"), rs.getInt("jumlah_gear"));
                    sg.setSuspensi(rs.getString("suspensi"));
                    s = sg;
                } else if ("LISTRIK".equalsIgnoreCase(jenis)) {
                    SepedaListrik sl = new SepedaListrik(rs.getString("id_sepeda"), rs.getString("merk"), rs.getDouble("harga_sewa_per_hari"), rs.getInt("kapasitas_baterai"));
                    s = sl;
                }
                
                TransaksiSewa trx = new TransaksiSewa(idTrx, p, s, lamaSewa);
                daftarTrx.add(trx);
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil daftar transaksi: " + e.getMessage());
        }
        return daftarTrx;
    }

    // 3. Menambah transaksi baru ke database menggunakan Prepared Statement
    public void tambahTransaksi(TransaksiSewa trx) {
        String query = "INSERT INTO transaksi_sewa (id_transaksi, id_pelanggan, id_sepeda, lama_sewa_hari, diskon, total_biaya, tanggal_sewa) VALUES (?, ?, ?, ?, ?, ?, CURDATE())";
        
        try (Connection conn = config.DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, trx.getIdTransaksi());
            pstmt.setString(2, trx.getPelanggan().getIdPelanggan());
            pstmt.setString(3, trx.getSepeda().getIdSepeda());
            pstmt.setInt(4, trx.getLamaSewahari());
            pstmt.setDouble(5, 0.0);
            pstmt.setDouble(6, trx.hitungTotalBiaya());
            
            pstmt.executeUpdate();
            System.out.println("Transaksi berhasil disimpan ke database!");
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan transaksi: " + e.getMessage());
        }
    }
}