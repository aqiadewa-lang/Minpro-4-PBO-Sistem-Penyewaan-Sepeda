/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import config.DatabaseConnection;
import model.Sepeda;
import model.SepedaGunung;
import model.SepedaListrik;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author AQIAYUDHA
 */
 
public class SepedaDAO {

    // 1. Ambil semua data sepeda dari database (Read)
    public ArrayList<Sepeda> getAllSepeda() {
        ArrayList<Sepeda> daftarSepeda = new ArrayList<>();
        String query = "SELECT * FROM sepeda";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id_sepeda");
                String merk = rs.getString("merk");
                double harga = rs.getDouble("harga_sewa_per_hari");
                String jenis = rs.getString("jenis");

                if ("GUNUNG".equalsIgnoreCase(jenis)) {
                    int gear = rs.getInt("jumlah_gear");
                    String suspensi = rs.getString("suspensi");
                    SepedaGunung sg = new SepedaGunung(id, merk, harga, gear);
                    sg.setSuspensi(suspensi);
                    daftarSepeda.add(sg);
                } else if ("LISTRIK".equalsIgnoreCase(jenis)) {
                    int baterai = rs.getInt("kapasitas_baterai");
                    SepedaListrik sl = new SepedaListrik(id, merk, harga, baterai);
                    daftarSepeda.add(sl);
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data sepeda: " + e.getMessage());
        }
        return daftarSepeda;
    }

    // 2. Tambah data sepeda baru menggunakan PreparedStatement (Create)
    public boolean insertSepeda(Sepeda sepeda) {
        String query = "INSERT INTO sepeda (id_sepeda, merk, harga_sewa_per_hari, jenis, jumlah_gear, suspensi, kapasitas_baterai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, sepeda.getIdSepeda());
            pstmt.setString(2, sepeda.getMerk());
            pstmt.setDouble(3, sepeda.getHargaSewaPerHari());
            
            if (sepeda instanceof SepedaGunung) {
                SepedaGunung sg = (SepedaGunung) sepeda;
                pstmt.setString(4, "GUNUNG");
                pstmt.setInt(5, sg.getJumlahGear());
                pstmt.setString(6, sg.getSuspensi());
                pstmt.setNull(7, Types.INTEGER);
            } else if (sepeda instanceof SepedaListrik) {
                SepedaListrik sl = (SepedaListrik) sepeda;
                pstmt.setString(4, "LISTRIK");
                pstmt.setNull(5, Types.INTEGER);
                pstmt.setNull(6, Types.VARCHAR);
                pstmt.setInt(7, sl.getKapasitasBaterai());
            }
            
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Gagal menambah sepeda: " + e.getMessage());
            return false;
        }
    }

    // 3. Cek duplikasi ID Sepeda di database
    public boolean isIdExist(String id) {
        String query = "SELECT id_sepeda FROM sepeda WHERE id_sepeda = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println("Gagal cek ID: " + e.getMessage());
            return false;
        }
    }

    // 4. Update data sepeda (Update)
    public boolean updateSepeda(String id, String merkBaru, double hargaBaru) {
        String query = "UPDATE sepeda SET merk = ?, harga_sewa_per_hari = ? WHERE id_sepeda = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, merkBaru);
            pstmt.setDouble(2, hargaBaru);
            pstmt.setString(3, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Gagal update sepeda: " + e.getMessage());
            return false;
        }
    }

    // 5. Hapus data sepeda (Delete)
    public boolean deleteSepeda(String id) {
        String query = "DELETE FROM sepeda WHERE id_sepeda = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Gagal menghapus sepeda: " + e.getMessage());
            return false;
        }
    }
}