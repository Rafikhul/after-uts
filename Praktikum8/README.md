# Praktikum 8 – SOLID Principles

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

Praktikum 8 membahas konsep **SOLID Principles** dalam Pemrograman Berorientasi Objek (OOP) menggunakan bahasa pemrograman Java.

Melalui praktikum ini, aplikasi toko online UMKM dikembangkan dengan menerapkan lima prinsip dasar SOLID untuk menghasilkan struktur program yang lebih terorganisasi, mudah dipahami, dikembangkan, dan dipelihara. Perbaikan dilakukan dengan memisahkan tanggung jawab setiap class, menggunakan abstraksi untuk mengurangi ketergantungan, serta merancang interface sesuai kebutuhan masing-masing objek.

## Materi yang Dipelajari

- **Single Responsibility Principle (SRP):** Memisahkan tanggung jawab program ke dalam beberapa class agar setiap class memiliki satu tanggung jawab utama.
- **Open/Closed Principle (OCP):** Membuat program terbuka untuk pengembangan fitur baru tanpa harus mengubah kode yang sudah ada.
- **Liskov Substitution Principle (LSP):** Memastikan objek turunan dapat menggantikan objek induknya tanpa merusak perilaku program.
- **Interface Segregation Principle (ISP):** Memisahkan interface berdasarkan kebutuhan agar class tidak dipaksa mengimplementasikan method yang tidak digunakan.
- **Dependency Inversion Principle (DIP):** Mengurangi ketergantungan langsung antarclass dengan menggunakan interface dan dependency injection.
- Refactoring aplikasi toko online UMKM menggunakan prinsip SOLID.
- Penerapan strategi diskon, metode pembayaran, dan pemisahan tanggung jawab proses checkout.
- Pengujian program menggunakan SelfCheck dan FakePaymentMethod.

## Tujuan Praktikum

1. Memahami lima prinsip SOLID dalam pemrograman berorientasi objek.
2. Mengidentifikasi pelanggaran prinsip SOLID pada program Java.
3. Menerapkan SRP dengan memisahkan tanggung jawab ke dalam class yang berbeda.
4. Menerapkan OCP dan DIP melalui penggunaan interface serta dependency injection.
5. Menerapkan LSP dan ISP dalam perancangan class dan interface.
6. Melakukan refactoring agar program lebih fleksibel, terstruktur, dan mudah dikembangkan.
7. Menguji hasil implementasi menggunakan SelfCheck.

## Teknologi yang Digunakan

- Bahasa Pemrograman: Java 25 (JDK 25)
- IDE: Visual Studio Code + Extension Pack for Java
- Version Control: Git dan GitHub

## Struktur Folder

```text
Praktikum8/
├── README.md
├── .gitignore
├── src/
│   ├── shop/
│   │   ├── app/
│   │   ├── discount/
│   │   ├── model/
│   │   ├── payment/
│   │   ├── service/
│   │   ├── testdouble/
│   │   └── util/
│   └── tools/
└── bahan/
    └── L5/
        └── ReviewMe.java
```

## Cara Menjalankan Program

1. Buka folder `Praktikum8` menggunakan Visual Studio Code.
2. Buka terminal PowerShell pada folder utama proyek.
3. Kompilasi seluruh file Java menggunakan perintah:

```powershell
New-Item -ItemType Directory -Force bin
javac -d bin (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
```

4. Jalankan aplikasi:

```powershell
java -cp bin shop.app.ShopApp
```

5. Jalankan pengujian SelfCheck:

```powershell
java -cp bin tools.SelfCheck
```

