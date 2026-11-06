package shop.discount;

/** Kontrak diskon dengan perilaku perhitungan bawaan. */
public interface Discountable {
    int discountPercent();

    default long applyDiscount(long price) {
        return price - percentOf(price, safePercent());
    }

    static long percentOf(long amount, int percent) {
        return amount * percent / 100;
    }

    // Validasi internal agar persentase diskon selalu 0 sampai 100.
    private int safePercent() {
        int percent = discountPercent();
        if (percent < 0) return 0;
        return Math.min(percent, 100);
    }
}
