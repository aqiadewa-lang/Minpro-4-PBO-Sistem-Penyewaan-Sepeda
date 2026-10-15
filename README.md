# **Muhammad Aqia Yudha Yulian Putra**
# **SISTEM PENYEWAAN SEPEDA**

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

