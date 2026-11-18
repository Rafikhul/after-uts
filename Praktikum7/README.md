# Praktikum 7 – Exception Handling

## Identitas Mahasiswa

| Keterangan | Informasi |
|---|---|
| Nama | Rafikhul Ramadhan |
| NIM | 2511533012 |
| Program Studi | Informatika |
| Fakultas | Teknologi Informasi |
| Universitas | Universitas Andalas |
| Mata Kuliah | Pemrograman Berorientasi Objek |

## Deskripsi Praktikum

Praktikum 7 membahas konsep **Exception Handling (Penanganan Exception)** dalam Pemrograman Berorientasi Objek (OOP) menggunakan bahasa pemrograman Java[cite: 1]. 

Melalui praktikum ini, aplikasi toko online UMKM dikembangkan dari program yang sebelumnya hanya mengembalikan nilai `false` saat terjadi kegagalan, menjadi sistem yang mampu menjelaskan detail kegagalan secara informatif menggunakan *checked exception*, *custom exception*, pengelolaan berkas dengan *try-with-resources*, serta memastikan integritas data transaksi (*failure atomicity*)[cite: 1, 10, 17, 22].

## Materi yang Dipelajari

- Hierarki *exception* Java serta perbedaan antara *checked* dan *unchecked exception*[cite: 1].
- Implementasi penanganan *exception* menggunakan *try-catch-finally*, *multi-catch*, `throw`/`throws`, dan *try-with-resources*[cite: 1].
- Perancangan *custom exception* yang sesuai dengan aturan bisnis aplikasi (seperti `ShopException`, `OutOfStockException`, `PaymentFailedException`, `InsufficientBalanceException`, dan `CatalogLoadException`)[cite: 1, 3].
- Evaluasi kode penanganan *exception* serta perbaikan *anti-pattern* (seperti menghindari penahanan *exception* secara diam-diam / *swallowing*)[cite: 1, 19, 22].

## Tujuan Praktikum

1. Menjelaskan hierarki *exception* Java serta perbedaan *checked* dan *unchecked exception*[cite: 1].
2. Mengimplementasikan penanganan *exception* dengan *try-catch-finally*, *multi-catch*, `throw`/`throws`, dan *try-with-resources*[cite: 1].
3. Merancang *custom exception* yang tepat untuk aturan bisnis aplikasi[cite: 1].
4. Mengevaluasi kode penanganan *exception* dan memperbaiki *anti-pattern*[cite: 1].

## Teknologi yang Digunakan

- Bahasa Pemrograman: Java 25 (JDK 25)[cite: 1]
- IDE: Visual Studio Code + Extension Pack for Java[cite: 1]

## Struktur Folder

```text
Praktikum7/
├── README.md
├── katalog.csv
└── src/
    ├── review/
    ├── selfcheck/
    ├── shop/
    └── tools/
