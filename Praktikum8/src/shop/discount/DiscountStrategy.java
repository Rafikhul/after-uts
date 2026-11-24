package shop.discount;

/** Aturan diskon yang bisa ditukar. */
public interface DiscountStrategy {
    long discountFor(long subtotal);
}
