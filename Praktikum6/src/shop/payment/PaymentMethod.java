package shop.payment;

/** Kontrak umum untuk setiap metode pembayaran. */
public interface PaymentMethod {
    String getName();
    boolean pay(long amount);

    /** Biaya admin default untuk metode tanpa biaya khusus adalah nol. */
    default long adminFee(long amount) { return 0L; }
}
