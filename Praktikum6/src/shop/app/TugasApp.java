package shop.app;

import java.util.List;
import shop.StudentInfo;
import shop.model.DigitalProduct;
import shop.model.PhysicalProduct;
import shop.model.Product;
import shop.notification.CustomerContact;
import shop.notification.EmailChannel;
import shop.notification.NotificationChannel;
import shop.notification.NotificationService;
import shop.notification.SmsChannel;
import shop.notification.WhatsAppChannel;
import shop.payment.BankTransferPayment;
import shop.payment.CreditCardPayment;
import shop.payment.EWalletPayment;
import shop.service.CheckoutService;
import shop.shipping.ExpressShipping;
import shop.shipping.ShippingService;

public class TugasApp {
    public static void main(String[] args) {
        System.out.println("Tugas oleh " + StudentInfo.NAME + " (" + StudentInfo.NIM + ")");

        List<Product> cart = List.of(
                new PhysicalProduct("KOPI-001", "Kopi Arabika Gayo 250g", 85_000L, 300),
                new PhysicalProduct("RDG-002", "Rendang Kemasan 250g", 120_000L, 400),
                new DigitalProduct("EBK-003", "E-book Resep Kue Nusantara", 50_000L,
                        "https://toko-umkm.example/unduh/ebk-003"));

        CheckoutService checkout = new CheckoutService();
        ShippingService express = new ExpressShipping();
        EWalletPayment wallet = new EWalletPayment("DompetKu", 500_000L);
        BankTransferPayment transfer = new BankTransferPayment("Bank Nagari");
        CreditCardPayment card = new CreditCardPayment("Siti Rahma", 1_000_000L);

        System.out.println("\n== T1: Total dengan biaya admin (Ekspres) ==");
        long base = checkout.total(cart, express);
        System.out.println(wallet.getName() + " : Rp" + checkout.grandTotal(cart, express, wallet)
                + " (admin Rp" + wallet.adminFee(base) + ")");
        System.out.println(transfer.getName() + " : Rp" + checkout.grandTotal(cart, express, transfer)
                + " (admin Rp" + transfer.adminFee(base) + ")");
        System.out.println(card.getName() + " : Rp" + checkout.grandTotal(cart, express, card)
                + " (admin Rp" + card.adminFee(base) + ")");

        System.out.println("\nKebijakan kartu kredit : " + card.policy());
        System.out.println("Kebijakan e-wallet     : " + wallet.policy());

        System.out.println("\n== T2: Notifikasi status pesanan ==");
        NotificationService service = new NotificationService();
        service.register(new EmailChannel());
        service.register(new SmsChannel(StudentInfo.SMS_MAX_LENGTH));
        service.register(new WhatsAppChannel());

        service.register(new NotificationChannel() {
            @Override
            public String channelName() { return "LOG"; }

            @Override
            public boolean send(CustomerContact contact, String message) {
                if (contact == null || message == null || message.isBlank()) return false;
                System.out.println("[LOG] " + contact.getName() + ": " + message);
                return true;
            }
        });

        String message = "Pesanan ORD-0001 sudah dikirim dengan kurir Ekspres. "
                + "Nomor resi akan muncul di aplikasi dalam 1x24 jam. "
                + "Terima kasih telah berbelanja produk UMKM Sumatera Barat di toko kami! "
                + "Silakan periksa aplikasi secara berkala untuk melihat perkembangan pengiriman.";

        CustomerContact siti = new CustomerContact(
                "Siti Rahma", "siti@example.com", "081234567890");
        CustomerContact budi = new CustomerContact(
                "Budi", "", "+6281298765432");

        int sitiDelivered = service.broadcast(siti, message);
        System.out.println("Terkirim ke Siti lewat " + sitiDelivered + " kanal");
        int budiDelivered = service.broadcast(budi, message);
        System.out.println("Terkirim ke Budi lewat " + budiDelivered + " kanal");
    }
}
