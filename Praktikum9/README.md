# Praktikum 9 – Design Pattern

## Identitas Mahasiswa

| **Keterangan** | **Informasi** |
| -------------- | ------------- |
| Nama           | Rafikhul Ramadhan |
| NIM            | 2511533012 |
| Program Studi  | Informatika |
| Fakultas       | Teknologi Informasi |
| Universitas    | Universitas Andalas |
| Mata Kuliah    | Pemrograman Berorientasi Objek |

## Deskripsi Praktikum

Praktikum 9 membahas konsep **Design Pattern** dalam Pemrograman Berorientasi Objek (OOP) menggunakan bahasa pemrograman Java.

Melalui praktikum ini, aplikasi toko kopi dikembangkan dengan menerapkan dua pola desain, yaitu Singleton dan Builder. Singleton digunakan untuk memastikan suatu class hanya memiliki satu objek yang digunakan bersama oleh bagian program lainnya. Sementara itu, Builder digunakan untuk mempermudah proses pembuatan objek yang memiliki beberapa atribut wajib maupun pilihan.

Perbaikan dilakukan pada pengelolaan konfigurasi toko, pembuatan nomor invoice, serta proses pembuatan data pelanggan dan pesanan agar struktur program menjadi lebih terorganisasi, fleksibel, dan mudah dipelihara.

## Materi yang Dipelajari

- **Singleton Pattern:** Membatasi pembuatan objek agar hanya terdapat satu instance yang digunakan bersama oleh seluruh bagian program.
- **Builder Pattern:** Mempermudah proses pembuatan objek dengan menyediakan method untuk mengatur atribut wajib dan atribut pilihan.
- Penerapan Singleton pada class StoreConfig untuk mengelola konfigurasi toko.
- Penerapan Singleton pada class OrderNumberGenerator untuk menghasilkan nomor invoice secara berurutan dan menghindari nomor yang sama.
- Penerapan Builder pada class Order untuk membuat pesanan dengan berbagai pilihan seperti catatan, bungkus kado, dan pengiriman ekspres.
- Penerapan Builder pada class Customer untuk membuat data pelanggan dengan validasi nama dan nomor HP.
- Penggunaan method chaining dalam proses pembuatan objek.
- Pengujian hasil implementasi menggunakan SelfCheck dan CustomerCheckDemo.

## Tujuan Praktikum

1. Memahami konsep Design Pattern dalam pemrograman berorientasi objek.
2. Memahami fungsi dan penerapan Singleton Pattern pada program Java.
3. Memahami fungsi dan penerapan Builder Pattern untuk pembuatan objek.
4. Menerapkan Singleton pada pengelolaan konfigurasi toko dan nomor invoice.
5. Menerapkan Builder pada pembuatan objek Order dan Customer.
6. Menerapkan validasi data untuk memastikan objek dibuat dengan informasi yang sesuai.
7. Mengembangkan struktur program agar lebih terorganisasi, fleksibel, dan mudah dipelihara.
8. Menguji hasil implementasi menggunakan SelfCheck.

## Teknologi yang Digunakan

- Bahasa Pemrograman: Java 25 (JDK 25)
- IDE: Visual Studio Code + Extension Pack for Java
- Version Control: Git dan GitHub

## Struktur Folder

```text
Praktikum9/
├── README.md
├── src/
│   ├── check/
│   │   ├── NimParams.java
│   │   └── SelfCheck.java
│   └── shop/
│       ├── app/
│       │   ├── MyNim.java
│       │   └── ShopApp.java
│       ├── config/
│       │   └── StoreConfig.java
│       ├── model/
│       │   ├── Address.java
│       │   ├── Customer.java
│       │   ├── Order.java
│       │   └── Product.java
│       ├── service/
│       │   ├── InvoicePrinter.java
│       │   ├── OrderCalculator.java
│       │   ├── OrderNumberGenerator.java
│       │   ├── ReorderService.java
│       │   └── Rupiah.java
│       └── demo/
│           └── CustomerCheckDemo.java
└── bahan/
    └── CustomerCheckDemo.java
```

## Cara Menjalankan Program

1. Buka folder `Praktikum9` menggunakan Visual Studio Code.
2. Pastikan JDK sudah terpasang dan dapat dijalankan melalui terminal.
3. Buka terminal PowerShell pada folder utama proyek.
4. Kompilasi seluruh file Java menggunakan perintah:

```powershell
New-Item -ItemType Directory -Force bin
javac -d bin (Get-ChildItem -Recurse -Filter *.java | Where-Object { $_.FullName -notmatch '\\bahan\\' } | ForEach-Object { $_.FullName })
```

5. Jalankan aplikasi utama:

```powershell
java -cp bin shop.app.ShopApp
```

6. Jalankan pengujian CustomerCheckDemo:

```powershell
java -cp bin shop.demo.CustomerCheckDemo
```

7. Jalankan pengujian SelfCheck:

```powershell
java -cp bin check.SelfCheck
```

Pastikan seluruh pemeriksaan SelfCheck berhasil untuk memastikan implementasi Singleton dan Builder telah berjalan sesuai dengan ketentuan praktikum.
