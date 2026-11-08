package review.fixed;

import java.util.ArrayList;
import java.util.List;

public class BadShopRefactored {

    interface Payable {
        boolean pay(long amount);
    }

    static class GiftVoucher implements Payable {
        private long balance = 100_000L;

        @Override
        public boolean pay(long amount) {
            if (amount <= 0 || amount > balance) return false;
            balance -= amount;
            return true;
        }

        public long getBalance() { return balance; }
    }

    interface Discount {
        long apply(long price);
    }

    static class MemberDiscount implements Discount {
        @Override
        public long apply(long price) { return price - price * 5 / 100; }
    }

    static class FlashSaleDiscount implements Discount {
        @Override
        public long apply(long price) { return price - price * 30 / 100; }
    }

    abstract static class Courier {
        protected abstract long ratePerKg();

        public final long cost(int kilograms) {
            if (kilograms <= 0) return 0L;
            return kilograms * ratePerKg();
        }
    }

    static class RegularCourier extends Courier {
        @Override
        protected long ratePerKg() { return 10_000L; }
    }

    static class ExpressCourier extends Courier {
        @Override
        protected long ratePerKg() { return 18_000L; }
    }

    static class SameDayCourier extends Courier {
        @Override
        protected long ratePerKg() { return 30_000L; }
    }

    static class Cart {
        private final List<Item> items = new ArrayList<>();

        // Static nested class karena tidak menggunakan state Cart.
        static class Item {
            private final String name;
            private final long price;
            private final int quantity;

            Item(String name, long price, int quantity) {
                if (name == null || name.isBlank() || price < 0 || quantity <= 0) {
                    throw new IllegalArgumentException("Invalid cart item");
                }
                this.name = name;
                this.price = price;
                this.quantity = quantity;
            }

            long subtotal() { return price * quantity; }
            String getName() { return name; }
        }

        void add(Item item) {
            if (item == null) throw new IllegalArgumentException("Item cannot be null");
            items.add(item);
        }

        long total() {
            long result = 0L;
            for (Item item : items) result += item.subtotal();
            return result;
        }
    }

    // Immutable address mencegah pesanan lain mengubah alamat yang sama.
    static final class Address {
        private final String street;
        private final String city;

        Address(String street, String city) {
            if (street == null || street.isBlank() || city == null || city.isBlank()) {
                throw new IllegalArgumentException("Address fields are required");
            }
            this.street = street;
            this.city = city;
        }

        @Override
        public String toString() { return street + ", " + city; }
    }

    static class SimpleOrder {
        private final String id;
        private final Address address;

        SimpleOrder(String id, Address address) {
            if (id == null || id.isBlank() || address == null) {
                throw new IllegalArgumentException("Order ID and address are required");
            }
            this.id = id;
            this.address = address;
        }

        @Override
        public String toString() { return id + " -> " + address; }
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.add(new Cart.Item("Kopi Gayo", 85_000L, 2));
        System.out.println("Total cart: " + cart.total());

        Courier express = new ExpressCourier();
        System.out.println("Ongkir Ekspres 2 kg: " + express.cost(2));

        Address padang = new Address("Jl. Sudirman 10", "Padang");
        Address bukittinggi = new Address("Jl. Sudirman 10", "Bukittinggi");
        SimpleOrder first = new SimpleOrder("ORD-1", padang);
        SimpleOrder second = new SimpleOrder("ORD-2", bukittinggi);
        System.out.println(first);
        System.out.println(second);

        Discount flashSale = new FlashSaleDiscount();
        System.out.println("Harga flash sale: " + flashSale.apply(100_000L));

        GiftVoucher voucher = new GiftVoucher();
        boolean paid = voucher.pay(30_000L);
        System.out.println(paid + " | sisa Rp" + voucher.getBalance());
    }
}
