# Taxi Booking Management System

## Deskripsi
Aplikasi "Taxi Booking Management System" adalah program berbasis GUI (Graphical User Interface) yang dibuat menggunakan Java Swing. Aplikasi ini memungkinkan pengguna untuk:

- Menambahkan pemesanan taksi baru.
- Memperbarui data pemesanan yang ada.
- Menghapus pemesanan dari daftar.
- Melihat informasi lengkap pemesanan, termasuk biaya perjalanan yang dihitung berdasarkan jarak.

Aplikasi ini juga dilengkapi dengan fitur Exception Handling untuk menangani input yang tidak valid dan memberikan pesan kesalahan yang informatif.

---

## Fitur
- **CRUD**:
  - Create: Tambahkan pemesanan baru.
  - Read: Lihat daftar pemesanan.
  - Update: Edit informasi pemesanan yang ada.
  - Delete: Hapus pemesanan dari daftar.

- **Perhitungan Biaya**:
  Biaya perjalanan dihitung secara otomatis berdasarkan jarak perjalanan dengan tarif tetap $10/km.

- **Validasi Input**:
  Aplikasi menangani kesalahan input seperti format angka yang salah atau kolom yang kosong.

- **Desain GUI Interaktif**:
  Antarmuka yang sederhana dan mudah digunakan.

---

## Teknologi yang Digunakan
- **Bahasa Pemrograman**: Java
- **Framework GUI**: Swing

---

## Cara Menggunakan

1. **Menjalankan Aplikasi**:
   - Jalankan file `TaxiBookingApp` sebagai program utama.

2. **Menambahkan Pemesanan**:
   - Isi nama pelanggan, tujuan, dan jarak perjalanan di formulir input.
   - Klik tombol "Add Booking" untuk menyimpan pemesanan.

3. **Menghapus Pemesanan**:
   - Pilih pemesanan dari daftar.
   - Klik tombol "Delete Booking".

4. **Memperbarui Pemesanan**:
   - Pilih pemesanan dari daftar.
   - Klik tombol "Update Booking" dan masukkan data baru.

---

## Pengujian
Pengujian dilakukan untuk memastikan:
1. Penanganan input kosong atau tidak valid.
2. Penghitungan biaya perjalanan berdasarkan jarak yang dimasukkan.
3. Fungsionalitas CRUD berjalan dengan benar.
4. Respons aplikasi terhadap skenario penggunaan yang umum dan ekstrem.

---

## Exception Handling
- **Kesalahan Format Input**: Jika pengguna memasukkan jarak dalam format yang salah (bukan angka), aplikasi akan menampilkan pesan kesalahan.
- **Kolom Kosong**: Jika pengguna tidak mengisi semua kolom, aplikasi akan meminta mereka untuk melengkapi input.

---

## Pengembangan Lebih Lanjut
Fitur tambahan yang dapat ditambahkan di masa depan:
- Integrasi dengan API untuk mendapatkan estimasi waktu perjalanan.
- Penyimpanan data permanen menggunakan database.
- Fitur pencarian dan filter untuk daftar pemesanan.

---

## Kontributor
- Nama: Javier Raihan, Deca Finandi Ananda
- NIM: 202310370311308, 202310370311380

