# Sistem Penyewaan Sepeda (PBO – MVC + JDBC/DAO)
# **Muhammad Aqia Yudha Yulian Putra**

## **1. Deskripsi singkat program**

Aplikasi Sistem Manajemen Penyewaan Sepeda adalah program berbasis konsol (CLI) yang dikembangkan menggunakan bahasa pemograman Java dengan menerapkan arsitektur MVC (Model-View-Controller) dan prinsip Pemrograman Berorientasi Objek (PBO). Tujuan utama dari program ini adalah untuk mendigitalisasi dan menyederhanakan proses operasional bisnis penyewaan sepeda—mulai dari manajemen data inventaris sepeda (seperti Sepeda Gunung dan Sepeda Listrik), pengelolaan data pelanggan, hingga pemrosesan transaksi sewa secara akurat, lengkap dengan sistem validasi input, durasi hari, dan kalkulasi diskon otomatis.

# Sistem Manajemen Penyewaan Sepeda (PBO - MVC)

## Deskripsi Singkat Program
Aplikasi **Sistem Manajemen Penyewaan Sepeda** adalah program berbasis konsol (CLI) yang dikembangkan menggunakan bahasa pemograman Java dengan menerapkan arsitektur **MVC (Model-View-Controller)** dan prinsip **Pemrograman Berorientasi Objek (PBO)**. Tujuan utama dari program ini adalah untuk mendigitalisasi dan menyederhanakan proses operasional bisnis penyewaan sepeda—mulai dari manajemen data inventaris sepeda (seperti Sepeda Gunung dan Sepeda Listrik), pengelolaan data pelanggan, hingga pemrosesan transaksi sewa secara akurat, lengkap dengan sistem validasi input, durasi hari, dan kalkulasi diskon otomatis.


## Penerapan Inheritance & Nilai Tambah Polymorphism
* **Inheritance (Pewarisan)**: Kelas utama `Sepeda` bertindak sebagai *parent class* yang merangkum atribut umum (seperti `idSepeda`, `merk`, dan `hargaSewaPerHari`). Atribut dan fungsi ini diturunkan ke *child class* yaitu `SepedaGunung` dan `SepedaListrik` guna menghindari duplikasi kode dan menjaga struktur program tetap rapi.
* **Polymorphism & Interface**: Program mengimplementasikan *interface* `Sewaable` yang memaksa kelas turunan untuk melakukan *method overriding* pada fungsi perhitungan biaya sewa dan detail informasi. Hal ini memungkinkan objek dari kelas berbeda (`SepedaGunung` dan `SepedaListrik`) merespons pemanggilan method yang sama (`hitungBiayaSewa()` dan `getDetail()`) dengan perilaku spesifik sesuai jenis sepedanya masing-masing.


## Fitur Utama
1. Tampilkan Daftar Sepeda
2. Tambah Sepeda Baru (Sepeda Gunung / Sepeda Listrik)
3. Ubah Data Sepeda
4. Hapus Sepeda
5. Buat Transaksi Sewa (Lengkap dengan kalkulasi durasi dan metode *overloading* diskon)

## Cara Menjalankan Program
1. Buka proyek melalui Apache NetBeans.
2. Lakukan *Clean and Build* pada proyek `Minpro-3-PBO-Sistem-Penyewaan-Sepeda`.
3. Jalankan file utama (`Main.java`) yang berada pada paket *main*.

## **2. Penjelasan Alur Program**
Ketika program dijalankan, sistem akan menampilkan Menu Utama yang terdiri dari pilihan pengelolaan data sepeda serta menu untuk keluar.

Pengguna dapat memilih menu dengan memasukkan angka sesuai dengan pilihan yang tersedia:

### **Tampilkan Sepeda (Read):**

Sistem menampilkan seluruh data sepeda yang telah tersimpan di dalam sistem (ID, merk, jenis, dan harga sewa per hari).

### **Tambah Sepeda (Create):**

Pengguna memasukkan ID sepeda, merk, jenis, dan harga sewa per hari. Data kemudian disimpan ke dalam ArrayList.

### **Ubah Data Sepeda (Update):**

Pengguna memasukkan ID sepeda yang ingin diubah, kemudian memasukkan data baru berupa merk, jenis, dan harga sewa.

### **Hapus Sepeda (Delete):**

Pengguna memasukkan ID sepeda yang ingin dihapus, kemudian sistem menghapus data tersebut dari ArrayList.

### **Keluar:**

Program menampilkan pesan bahwa program telah selesai dan sistem berhenti bekerja.

# **3. Dokumentasi Program**
<img width="300" height="168" alt="image" src="https://github.com/user-attachments/assets/a3a4d683-5868-4ba9-bb0b-59e7cb980caf" />

### **Berikut tampilan Menu Utama yang menyediakan fitur untuk mengelola data sepeda, seperti melihat (Read), menambah (Create), mengubah (Update), dan menghapus (Delete) data sepeda.**

# **4. Implementasi Program**
## **4.1 Implementasi Tambah & Lihat Sepeda (Create & Read)**
<img width="497" height="753" alt="image" src="https://github.com/user-attachments/assets/4efbe5b1-3b27-4504-a49a-3d604e7857c8" />

### **Menu ini digunakan untuk menambahkan data sepeda baru dan menampilkan daftar sepeda yang tersimpan.**
 
## **4.2 Implementasi Ubah Data Sepeda (Update)**
<img width="532" height="753" alt="image" src="https://github.com/user-attachments/assets/5c74b36d-b552-4346-ba11-6bd124c3151b" />

### **Menu ini digunakan untuk mengubah informasi data sepeda berdasarkan ID sepeda, Merk sepeda, dan Jenis sepeda.**

## **4.3 Implementasi Hapus Data Sepeda (Delete)**
<img width="485" height="670" alt="image" src="https://github.com/user-attachments/assets/75ebeb06-421d-4e69-b4ba-f73dd3a34a1d" />

### **Menu ini digunakan untuk menghapus data sepeda dari sistem berdasarkan ID sepeda, Merk sepeda, dan Jenis sepeda.**

# **5. Penerapan Konsep Minpro 3**
 
## **5.1 Abstraction (Abstract Class & Abstract Method)**
 
Abstraction adalah konsep menyembunyikan detail implementasi dan hanya menampilkan kerangka umum dari suatu objek. Pada program ini, abstraction diterapkan pada class `Sepeda`.
 
Class `Sepeda` dideklarasikan sebagai **abstract class** karena "sepeda" hanyalah konsep umum, sedangkan objek yang nyata adalah jenisnya, yaitu `SepedaGunung` dan `SepedaListrik`. Karena bersifat abstract, class `Sepeda` **tidak dapat diinstansiasi** secara langsung (`new Sepeda()` akan menyebabkan error) dan hanya berfungsi sebagai kerangka bagi class turunannya.
 
```java
public abstract class Sepeda implements Sewaable {
    ...
    // Abstract method: tidak punya isi, wajib di-override oleh subclass
    public abstract String getKategori();
}
```
 
Di dalam `Sepeda` terdapat **abstract method** `getKategori()`. Method ini hanya berisi deklarasi tanpa isi (body), sehingga setiap subclass **wajib** mendefinisikan sendiri kategorinya. `SepedaGunung` mengembalikan "Sepeda Gunung" dan `SepedaListrik` mengembalikan "Sepeda Listrik". Selain itu, atribut umum (`idSepeda`, `merk`, `hargaSewaPerHari`) cukup ditulis sekali di `Sepeda` lalu diwariskan ke kedua subclass.
 
**Screenshot 1 – Deklarasi abstract class dan abstract method (`Sepeda.java`)**
 
<img width="570" height="92" alt="image" src="https://github.com/user-attachments/assets/24f5eb3d-9a5a-4f6f-881c-37806a0c778f" />

<img width="605" height="46" alt="image" src="https://github.com/user-attachments/assets/7ee90d4f-64b4-4db8-9acf-99a57c317e4e" />

**Screenshot 2 – Implementasi abstract method `getKategori()` pada subclass (`SepedaGunung.java`)**
 
<img width="402" height="92" alt="image" src="https://github.com/user-attachments/assets/46c37d90-2a93-409c-b0c8-27a72671eba2" />
 
---
 
## **5.2 Polymorphism**
 
Polymorphism berarti satu nama method dapat memiliki perilaku berbeda. Program ini menerapkan dua bentuk polymorphism, yaitu **overriding** dan **overloading**.
 
### **a. Overriding**
 
Overriding adalah ketika subclass menulis ulang method milik parent class dengan nama dan parameter yang sama, ditandai dengan anotasi `@Override`. Penerapannya:
 
| Method | Class | Perilaku |
|---|---|---|
| `getKategori()` | `SepedaGunung` | Mengembalikan "Sepeda Gunung" |
| `getKategori()` | `SepedaListrik` | Mengembalikan "Sepeda Listrik" |
| `hitungBiayaSewa(int)` | `SepedaGunung` | Diskon 10% jika sewa 7 hari atau lebih |
| `hitungBiayaSewa(int)` | `SepedaListrik` | Ditambah biaya pengisian baterai Rp 5.000 per hari |
| `getDetail()` | `SepedaGunung` | Menambahkan informasi suspensi |
| `getDetail()` | `SepedaListrik` | Menambahkan informasi kapasitas baterai |
 
Bukti polymorphism terlihat pada method `tampilkanSepeda()` di `MenuView`. List bertipe `Sepeda` berisi objek `SepedaGunung` dan `SepedaListrik`. Ketika `s.getDetail()` dipanggil, Java secara otomatis menjalankan versi method sesuai jenis objek sebenarnya, sehingga output tiap sepeda berbeda walaupun kode pemanggilannya sama. Hal yang sama terjadi pada `hitungBiayaSewa()` ketika transaksi dibuat.
 
**Screenshot 3 – Method `hitungBiayaSewa()` di `Sepeda` dan hasil override di subclass**
 
<img width="552" height="78" alt="image" src="https://github.com/user-attachments/assets/8cc619cf-15f0-45f3-bc4e-63451c1f1973" />

**Screenshot 4 – Override `getDetail()` pada `SepedaGunung`**
 
<img width="1005" height="113" alt="image" src="https://github.com/user-attachments/assets/cd42d795-0bbd-46b5-98b2-129ba7de79be" />

**Screenshot 5 – Pemanggilan polymorphic `s.getDetail()` pada `MenuView.tampilkanSepeda()`**
 
<img width="703" height="226" alt="image" src="https://github.com/user-attachments/assets/799a3b4c-55c9-4528-b48b-5b8398d3acff" />
 
**Screenshot 6 – Output menu 1 (Tampilkan Daftar Sepeda): detail berbeda untuk tiap jenis sepeda**
 
<img width="856" height="402" alt="image" src="https://github.com/user-attachments/assets/a80ade3a-1dc6-4e9f-965b-5b685153eede" />
 
### **b. Overloading**
 
Overloading adalah beberapa method dengan nama yang sama tetapi parameter berbeda dalam satu class. Penerapannya ada dua:
 
1. **Method `hitungTotalBiaya()` pada `TransaksiSewa`**
   - `hitungTotalBiaya()` tanpa parameter, menghitung biaya sewa normal.
   - `hitungTotalBiaya(double diskonRupiah)` dengan satu parameter, menghitung biaya setelah dikurangi diskon.
2. **Constructor pada `SepedaGunung`**
   - `SepedaGunung(String, String, double, int jumlahGear)` untuk sepeda gunung dengan data jumlah gear.
   - `SepedaGunung(String, String, double, String suspensi)` untuk sepeda gunung dengan data tipe suspensi (dipakai pada menu Tambah Sepeda).
Java membedakan method mana yang dipanggil berdasarkan jumlah dan tipe parameter yang diberikan.
 
**Screenshot 7 – Dua method `hitungTotalBiaya` pada `TransaksiSewa.java`**
 
<img width="612" height="73" alt="image" src="https://github.com/user-attachments/assets/541aaad3-c4e5-4da6-977e-78d7277fdb76" />

<img width="647" height="91" alt="image" src="https://github.com/user-attachments/assets/78c7d5b9-4edf-4296-bd91-ea2e1438df01" />
 
**Screenshot 8 – Dua constructor pada `SepedaGunung.java`**
 
<img width="491" height="67" alt="image" src="https://github.com/user-attachments/assets/a54d5fad-9ad4-41a7-ae89-79be14e1fde2" />

**Screenshot 9 – Output menu 5 (Buat Transaksi) untuk Sepeda Listrik: biaya normal dan biaya diskon**
 
<img width="553" height="513" alt="image" src="https://github.com/user-attachments/assets/b620edd2-a821-465f-9a7f-4fd34194f19c" />

---
 
## **5.3 Interface (Nilai Tambah)**
 
Interface adalah kontrak yang berisi daftar method yang wajib dimiliki oleh class yang mengimplementasikannya. Program ini memiliki interface `Sewaable`:
 
```java
public interface Sewaable {
    double hitungBiayaSewa(int lamaSewa);
    String getDetail();
}
```
 
Class `Sepeda` mengimplementasikan interface ini dengan kata kunci `implements Sewaable`, sehingga semua jenis sepeda dijamin memiliki kemampuan menghitung biaya sewa dan menampilkan detail. Interface ini juga dimanfaatkan oleh `TransaksiSewa` melalui pemanggilan `sepeda.hitungBiayaSewa(lamaSewahari)`.
 
**Screenshot 10 – Isi interface `Sewaable.java`**
 
<img width="1135" height="316" alt="image" src="https://github.com/user-attachments/assets/ceff7563-72e8-4ae0-93bd-3fda4a3d0f0c" />
 
**Screenshot 11 – Class `Sepeda` yang meng-`implements Sewaable` dan mengimplementasikan method-nya**
 
<img width="600" height="111" alt="image" src="https://github.com/user-attachments/assets/3beca1db-82bd-461c-a31a-ba1173fa4a8c" />

<img width="562" height="88" alt="image" src="https://github.com/user-attachments/assets/06f3d83b-cde2-4709-8b99-d59b5b663618" />
 
---
 
## **5.4 Struktur MVC (Model, View, Controller)**
 
Program ini menggunakan arsitektur MVC yang memisahkan tanggung jawab kode ke dalam tiga bagian:
 
| Package | Class | Peran |
|---|---|---|
| `model` | `Sepeda`, `SepedaGunung`, `SepedaListrik`, `Pelanggan`, `TransaksiSewa`, `Sewaable` | Menyimpan data dan logika bisnis, seperti perhitungan biaya sewa |
| `view` | `MenuView` | Mengatur tampilan menu serta input dan output dari pengguna |
| `controller` | `SepedaController` | Penghubung antara View dan Model. Menyimpan `ArrayList` data serta menyediakan method tambah, cari, hapus, dan cek ID |
| `main` | `Main` | Titik masuk program, membuat `MenuView` lalu menjalankan menu utama |
 
**Contoh alur (menu Tambah Sepeda):**
 
1. Pengguna memasukkan data di **View** (`MenuView.tambahSepeda()`).
2. View membuat objek **Model** (`new SepedaGunung(...)`) lalu mengirimkannya ke **Controller** (`controller.tambahSepeda(...)`).
3. Controller menyimpan objek tersebut ke dalam `ArrayList<Sepeda>`.
4. Saat menu Tampilkan dipilih, View meminta data dari Controller (`controller.getDaftarSepeda()`) lalu menampilkannya.
View tidak menyimpan data sendiri, dan Model tidak mengetahui apa pun tentang tampilan. Dengan pemisahan ini kode lebih rapi dan mudah dikembangkan.
 
**Screenshot 12 – Struktur package proyek di NetBeans (`controller`, `main`, `model`, `view`)**
 
<img width="393" height="292" alt="image" src="https://github.com/user-attachments/assets/ae693a83-434a-4125-9ab5-856e67dcfc2f" />
 
**Screenshot 13 – Class `SepedaController.java` (Controller)**
 
<img width="590" height="107" alt="image" src="https://github.com/user-attachments/assets/da76923a-97d9-49e8-9fdf-5276286c7a78" />

<img width="536" height="67" alt="image" src="https://github.com/user-attachments/assets/17943fee-aeaa-4242-8895-3d6ceaea5b7c" />

<img width="660" height="190" alt="image" src="https://github.com/user-attachments/assets/aab0f17f-f066-476d-a244-b2bf7d362a1b" />

<img width="590" height="210" alt="image" src="https://github.com/user-attachments/assets/5554f8ab-6f37-4605-9cff-4a08e4809c99" />

**Screenshot 14 – Class `MenuView.java` yang memanggil `controller` (View)**
 
<img width="471" height="71" alt="image" src="https://github.com/user-attachments/assets/298e8cf4-c8be-485a-8dc5-720d7d3f0567" />

<img width="667" height="112" alt="image" src="https://github.com/user-attachments/assets/f9160fff-4107-4f15-9c1e-94ec194a7438" />
 
**Screenshot 15 – Class `Main.java` (titik masuk program)**
 
<img width="655" height="228" alt="image" src="https://github.com/user-attachments/assets/18092b3b-7258-4908-b98d-6afeb03048b3" />


## **6. Penerapan JDBC (Prepared Statement) dan DAO**

Pada bagian ini program dihubungkan ke database MySQL memakai **JDBC** dengan **`PreparedStatement`** dan pola **DAO**.

### 6.1 Database
- Server database: **MySQL pada Laragon**, dikelola dengan HeidiSQL.
- Nama database: `sistem_penyewaan_sepeda`.
- File SQL: `database/sistem_penyewaan_sepeda.sql` berisi `CREATE TABLE` dan `INSERT` data awal.

| Tabel | Kolom yang dipakai program |
|---|---|
| `sepeda` | `id_sepeda`, `merk`, `harga_sewa_per_hari`, `jenis` (GUNUNG / LISTRIK), `jumlah_gear`, `suspensi`, `kapasitas_baterai` |
| `pelanggan` | `id_pelanggan`, `nama`, `no_telepon` |
| `transaksi_sewa` | `id_transaksi`, `id_pelanggan`, `id_sepeda`, `lama_sewa_hari`, `diskon`, `total_biaya`, dan kolom tanggal sewa |
 
Tabel `sepeda` memakai satu tabel untuk dua jenis sepeda. Kolom `jenis` menjadi pembeda, dan kolom yang tidak relevan diisi `NULL` (misalnya `kapasitas_baterai` untuk sepeda gunung).

<img width="403" height="235" alt="image" src="https://github.com/user-attachments/assets/f1fb0ade-e78f-4ec6-b25e-233f9176ce1d" />

<img width="1088" height="602" alt="image" src="https://github.com/user-attachments/assets/5c7f2440-cac3-4f31-91d4-183c101f390e" />

### 6.2 Data awal dari file `.sql` (bukan dari kode)
Data awal diisi lewat perintah `INSERT INTO` di file `.sql`, lalu di-import ke database. Tidak ada data dummy di dalam kode Java (tidak ada `add(new Sepeda(...))` pada controller). Akibatnya, saat menu **Tampilkan Sepeda** dipilih, data langsung tampil tanpa input dari awal.

<img width="991" height="502" alt="image" src="https://github.com/user-attachments/assets/9725bde2-c1e8-4645-a79f-8629fd2457b7" />

### 6.3 Koneksi database (`config/DatabaseConnection.java`)
 
```java
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sistem_penyewaan_sepeda";
    private static final String USER = "root";
    private static final String PASSWORD = "";
 
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Koneksi database gagal: " + e.getMessage());
        }
        return conn;
    }
}
```
 
- `URL` berisi alamat server (`localhost:3306`) dan nama database.
- `DriverManager.getConnection()` membuka koneksi memakai driver `mysql-connector-j` (ditambahkan sebagai dependency di `pom.xml`).
- Class ini dipakai bersama oleh DAO dan controller, sehingga pengaturan koneksi hanya ditulis di satu tempat.

<img width="997" height="375" alt="image" src="https://github.com/user-attachments/assets/e1468de1-ffc6-41b5-821d-973b80274132" />

<img width="1265" height="482" alt="image" src="https://github.com/user-attachments/assets/6379cc38-d9d9-4607-bd18-63c51438f5c8" />

### 6.4 Pola DAO (`DAO/SepedaDAO.java`)
 
DAO (*Data Access Object*) memisahkan kode akses database dari logika program. Seluruh perintah SQL untuk tabel `sepeda` dikumpulkan di class `SepedaDAO`, sehingga `View` tidak menyentuh database. `SepedaController` memanggil method DAO.
 
| Method DAO | Operasi | SQL |
|---|---|---|
| `getAllSepeda()` | Read | `SELECT * FROM sepeda` |
| `insertSepeda(Sepeda)` | Create | `INSERT INTO sepeda (id_sepeda, merk, harga_sewa_per_hari, jenis, jumlah_gear, suspensi, kapasitas_baterai) VALUES (?, ?, ?, ?, ?, ?, ?)` |
| `isIdExist(String)` | Cek ID ganda | `SELECT id_sepeda FROM sepeda WHERE id_sepeda = ?` |
| `updateSepeda(id, merkBaru, hargaBaru)` | Update | `UPDATE sepeda SET merk = ?, harga_sewa_per_hari = ? WHERE id_sepeda = ?` |
| `deleteSepeda(String)` | Delete | `DELETE FROM sepeda WHERE id_sepeda = ?` |
 
### 6.5 Prepared Statement
Semua query memakai `PreparedStatement`. Nilai dimasukkan lewat tanda tanya (`?`) dan diisi dengan `setString()`, `setDouble()`, `setInt()`, atau `setNull()`, bukan digabung langsung ke string SQL. Cara ini aman dari **SQL Injection**.

Contoh pada `updateSepeda()`:
 
```java
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
```
 
Hal penting pada kode DAO:
- **try-with-resources**: `Connection`, `PreparedStatement`, dan `ResultSet` ditutup otomatis.
- **`executeQuery()`** untuk `SELECT`, **`executeUpdate()`** untuk `INSERT`/`UPDATE`/`DELETE`.
- **`catch (SQLException e)`** menampilkan pesan error dan mengembalikan `false`, sehingga program tidak berhenti saat database bermasalah.
- Pada `getAllSepeda()`, kolom `jenis` dibaca lalu dibuat objek `SepedaGunung` atau `SepedaListrik` (polymorphism).
- Pada `insertSepeda()`, kolom yang tidak dipakai jenis tertentu diisi `setNull(...)`.

<img width="792" height="640" alt="image" src="https://github.com/user-attachments/assets/0dffc342-e769-464e-af96-181bf4cd7b16" />

<img width="1358" height="640" alt="image" src="https://github.com/user-attachments/assets/9da42d18-cb00-4457-af97-5191181a3af1" />

<img width="907" height="580" alt="image" src="https://github.com/user-attachments/assets/ca6eddba-79b7-451e-a05d-74d07272c305" />

<img width="703" height="268" alt="image" src="https://github.com/user-attachments/assets/ec20bdd5-66c7-4281-adaf-2b4291435b6e" />

### 6.6 Controller sebagai penghubung (`controller/SepedaController.java`)
`SepedaController` memiliki atribut `SepedaDAO sepedaDAO` dan meneruskan permintaan dari `View` ke DAO:
 
| Method Controller | Memanggil |
|---|---|
| `getDaftarSepeda()` | `sepedaDAO.getAllSepeda()` |
| `tambahSepeda(sepeda)` | `sepedaDAO.insertSepeda(sepeda)` |
| `isIdExist(id)` | `sepedaDAO.isIdExist(id)` |
| `hapusSepeda(id)` | `sepedaDAO.deleteSepeda(id)` |
 
Controller juga memiliki method untuk data pelanggan dan transaksi, yaitu `getPelangganPertama()` (`SELECT * FROM pelanggan LIMIT 1`), `getDaftarTransaksi()` (`JOIN` tiga tabel), dan `tambahTransaksi()` (`INSERT INTO transaksi_sewa`). Ketiganya juga memakai `PreparedStatement` dan `DatabaseConnection`.

<img width="631" height="512" alt="image" src="https://github.com/user-attachments/assets/7d2ed92d-aea3-4ac8-9dd1-38fc2a1ba27e" />
<img width="557" height="362" alt="image" src="https://github.com/user-attachments/assets/e752859f-9243-4e4e-8e0e-594141334e38" />

<img width="1397" height="475" alt="image" src="https://github.com/user-attachments/assets/9e4396fa-34aa-4ac1-99ad-f24463e51591" />

### 6.7 Contoh alur lengkap — Tambah Sepeda
1. Pengguna memasukkan data di **View** (`MenuView`).
2. View memanggil `controller.isIdExist(id)`, lalu controller memanggil `sepedaDAO.isIdExist(id)` → `SELECT id_sepeda FROM sepeda WHERE id_sepeda = ?`.
3. Jika ID belum dipakai, View membuat objek **Model** (`new SepedaGunung(...)` / `new SepedaListrik(...)`) dan mengirimkannya ke `controller.tambahSepeda(...)`.
4. Controller memanggil `sepedaDAO.insertSepeda(...)`, DAO menjalankan `INSERT` dengan `PreparedStatement`.
5. Data tersimpan di MySQL dan muncul saat menu **Tampilkan Sepeda** dipilih.

## **7. Cara Menjalankan Program**
 
**Kebutuhan:** Apache NetBeans, JDK 26 (sesuai `pom.xml`), Laragon (MySQL).
 
1. Jalankan **Laragon**, klik **Start All**.
2. Buka **HeidiSQL** dari Laragon, lalu **File → Run SQL file…** dan pilih `database/sistem_penyewaan_sepeda.sql`. Setelah itu database `sistem_penyewaan_sepeda` beserta tabel dan data awal akan terbentuk.
3. Buka project di Apache NetBeans, klik kanan project → **Clean and Build** (dependency `mysql-connector-j` terunduh otomatis).
4. Jika perlu, sesuaikan `URL`, `USER`, `PASSWORD` di `config/DatabaseConnection.java` (default: `root`, password kosong).
5. Jalankan `main/main.java` (**Run File**).
---
 
## **8. Hasil Running Program (Dokumentasi)**

### 8.1 Menu Utama

<img width="511" height="183" alt="image" src="https://github.com/user-attachments/assets/55474794-86c5-45cf-bed2-fe47557b076a" />

> Cara: jalankan program, screenshot tampilan menu utama di jendela Output NetBeans.

### 8.2 Tampilkan Sepeda (Read) — data awal dari database

<img width="1000" height="492" alt="image" src="https://github.com/user-attachments/assets/85907e92-0051-4c19-a993-f8978a4e8291" />

> Cara: jalankan program, **langsung pilih menu 1** tanpa menambah apa pun.

### 8.3 Tambah Sepeda (Create)

<img width="985" height="752" alt="image" src="https://github.com/user-attachments/assets/b8189524-f7c5-43da-acbc-6546a7bd2652" />

> Cara: pilih menu 2, isi data (misalnya ID baru `SPD-05`), lalu pilih menu 1 untuk melihat data baru tampil.

<img width="1080" height="267" alt="image" src="https://github.com/user-attachments/assets/52d26c39-b747-47ca-88e9-94457f785c0b" />

> Cara: di HeidiSQL, tabel `sepeda` → tab **Data** → tekan **F5** (refresh).

### 8.4 Ubah Data Sepeda (Update)

<img width="1027" height="661" alt="image" src="https://github.com/user-attachments/assets/a4df3206-7ab1-4fd9-ac52-505a20797995" />

> Cara: pilih menu 3, masukkan ID sepeda, isi merk dan harga baru, lalu pilih menu 1.

<img width="1057" height="270" alt="image" src="https://github.com/user-attachments/assets/2fe63767-4542-4fcc-a906-213bf31ef27f" />

> Cara: HeidiSQL → tabel `sepeda` → **F5**.

### 9.5 Hapus Sepeda (Delete)

<img width="1020" height="772" alt="image" src="https://github.com/user-attachments/assets/67ada7dc-163c-4dc7-b4f6-70f18d7b421d" />

> Cara: pilih menu 4, hapus sepeda yang tadi ditambah (`SPD-05`), lalu pilih menu 1.
 
<img width="1052" height="255" alt="image" src="https://github.com/user-attachments/assets/4e0fe335-9c16-4047-a136-0eef22631881" />

> Cara: HeidiSQL → tabel `sepeda` → **F5**.

### 9.6 Transaksi Sewa

<img width="692" height="610" alt="image" src="https://github.com/user-attachments/assets/9faa3dfd-7eb5-47f0-8138-22cd2a0e029a" />


> Cara: pilih menu 5, pilih sepeda listrik, isi lama sewa dan diskon. Screenshot hasil biaya normal dan biaya diskon.

 
<img width="926" height="236" alt="image" src="https://github.com/user-attachments/assets/dac67e5d-75d0-479b-b96e-fc194d320a56" />


> Cara: HeidiSQL → tabel `transaksi_sewa` → tab **Data** → **F5**.














