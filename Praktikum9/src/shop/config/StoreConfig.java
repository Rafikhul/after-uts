package shop.config;

/** Pengaturan toko. Versi awal: siapa pun bisa membuat objeknya dengan new. */
public class StoreConfig {
    private static StoreConfig instance;              // bahan 1

    private String storeName = "Toko Kopi Andalas";
    private long shippingPerKg = 8_000;
    private long giftWrapFee = 5_000;

    private StoreConfig() { }                         // bahan 2

    public static StoreConfig getInstance() {         // bahan 3
        if (instance == null) {                       // belum ada? buat sekali
            instance = new StoreConfig();
        }
        return instance;                              // selalu objek yang sama
    }


    public String getStoreName() {
        return storeName;
    }

    public long getShippingPerKg() {
        return shippingPerKg;
    }

    public long getGiftWrapFee() {
        return giftWrapFee;
    }

    public void setShippingPerKg(long value) {
        shippingPerKg = value;
    }
}
