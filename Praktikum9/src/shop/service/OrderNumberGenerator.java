package shop.service;

/** Membuat nomor invoice berurutan: INV-1001, INV-1002, ... */
public class OrderNumberGenerator {
    private static OrderNumberGenerator instance;

    private int counter = 1000;

    private  OrderNumberGenerator() { }

    public String next() {
        counter++;
        return "INV-" + counter;
    }

    public static OrderNumberGenerator getInstance() {         // bahan 3
        if (instance == null) {                       // belum ada? buat sekali
            instance = new OrderNumberGenerator();
        }
        return instance;                              // selalu objek yang sama
    }
}
