package shop.app;

import java.util.List;
import shop.model.Address;
import shop.model.DigitalProduct;
import shop.model.Order;
import shop.model.PhysicalProduct;
import shop.model.Product;
import shop.payment.BankTransferPayment;
import shop.payment.CreditCardPayment;
import shop.payment.EWalletPayment;
import shop.payment.PaymentMethod;
import shop.service.CheckoutService;
import shop.shipping.ExpressShipping;
import shop.shipping.RegularShipping;
import shop.shipping.ShippingService;

/** Program utama latihan L1-L5. */
public class ShopApp {
    public static void main(String[] args) {
        Product coffee = new PhysicalProduct(
                "KOPI-001", "Kopi Arabika Gayo 250g", 85_000L, 300);
        Product rendang = new PhysicalProduct(
                "RDG-002", "Rendang Kemasan 250g", 120_000L, 400);
        Product ebook = new DigitalProduct(
                "EBK-003", "E-book Resep Kue Nusantara", 50_000L,
                "https://toko-umkm.example/unduh/ebk-003");

        List<Product> cart = List.of(coffee, rendang, ebook);

        System.out.println("== Katalog ==");
        for (Product product : cart) {
            System.out.println(product.getInfo());
        }

        CheckoutService checkout = new CheckoutService();
        ShippingService regular = new RegularShipping();
        ShippingService express = new ExpressShipping();

        System.out.println("\n== Ringkasan ==");
        System.out.println("Subtotal      : Rp" + checkout.subtotal(cart));
        System.out.println("Berat kiriman : " + checkout.totalWeight(cart) + " g");
        System.out.println("Total Reguler : Rp" + checkout.total(cart, regular));
        System.out.println("Total Ekspres : Rp" + checkout.total(cart, express));

        // Demo pembayaran dari beberapa implementasi PaymentMethod.
        EWalletPayment wallet = new EWalletPayment("DompetKu", 500_000L);
        PaymentMethod transfer = new BankTransferPayment("Bank Nagari");
        CreditCardPayment card = new CreditCardPayment("Siti Rahma", 1_000_000L);

        System.out.println("\n== Pembayaran ==");
        System.out.println(wallet.getName() + " berhasil? "
                + checkout.checkout(cart, regular, wallet));
        System.out.println("Sisa saldo: Rp" + wallet.getBalance());
        System.out.println(transfer.getName() + " berhasil? "
                + checkout.checkout(cart, express, transfer));
        System.out.println(card.getName() + " berhasil? "
                + checkout.checkout(cart, express, card));

        // Demo refund melalui interface RefundablePayment.
        System.out.println("Refund e-wallet: "
                + checkout.refund(wallet, ebook.getFinalPrice()));

        // Demo nested class static, inner class, dan receipt.
        Address address = new Address("Jl. Moh Hatta No. 10", "Padang", "25121");
        Order order = new Order("ORD-0001", address);
        order.addLine(coffee, 2);
        order.addLine(ebook, 1);
        Order.Line firstLine = new Order.Line(coffee, 1);
        System.out.println("Contoh static nested Line: " + firstLine.subtotal());
        System.out.println("\n" + order.createReceipt().toText());

        // Anonymous class: voucher hanya digunakan pada demo ini.
        PaymentMethod voucher = new PaymentMethod() {
            private long remaining = 50_000L;

            @Override
            public String getName() { return "Voucher Promo Hari Ini"; }

            @Override
            public boolean pay(long amount) {
                if (amount <= 0 || amount > remaining) return false;
                remaining -= amount;
                return true;
            }
        };
        System.out.println("\n" + voucher.getName() + " berhasil? "
                + voucher.pay(20_000L));
    }
}
