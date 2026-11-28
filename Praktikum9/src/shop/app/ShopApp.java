
package shop.app;

import check.NimParams;
import shop.config.StoreConfig;
import shop.model.Address;
import shop.model.Customer;
import shop.model.Order;
import shop.model.Product;
import shop.service.InvoicePrinter;
import shop.service.OrderCalculator;
import shop.service.OrderNumberGenerator;
import shop.service.ReorderService;
import shop.service.Rupiah;

public class ShopApp {

    public static void main(String[] args) {

        // Pengaturan ongkir toko
        StoreConfig adminConfig = StoreConfig.getInstance();

        adminConfig.setShippingPerKg(
                NimParams.newShippingPerKg()
        );

        System.out.println("Admin: ongkir diubah menjadi "
                + Rupiah.format(adminConfig.getShippingPerKg())
                + "/kg");

        System.out.println();

        // Service toko
        OrderCalculator calculator = new OrderCalculator();
        InvoicePrinter printer = new InvoicePrinter(calculator);

        OrderNumberGenerator numbers =
                OrderNumberGenerator.getInstance();

        ReorderService reorderService =
                new ReorderService(printer);

        // Produk
        Product kopi = new Product(
                "Kopi Arabika 250g", 85_000, 300
        );

        Product teh = new Product(
                "Teh Melati 100g", 25_000, 150
        );

        // Pelanggan
        Customer budi = new Customer.Builder(
                "Budi", "081234567890")
                .memberLevel("GOLD")
                .build();

        Customer sari = new Customer.Builder(
                "Sari", "085711112222")
                .email("sari@mail.com")
                .address("Bukittinggi")
                .memberLevel("SILVER")
                .build();

        Customer andi = new Customer.Builder(
                "Andi", "081399998888")
                .build();

        // Pesanan A1
        Order a1 = new Order.Builder(
                "A1", new Address("Budi", "Padang"))
                .addLine(kopi, 1)
                .express()
                .build();

        // Pesanan A2
        Order a2 = new Order.Builder(
                "A2", new Address("Sari", "Bukittinggi"))
                .addLine(kopi, 2)
                .addLine(teh, 1)
                .note("Tolong jangan dibanting")
                .giftWrap()
                .build();

        // Pesanan A3
        Order a3 = new Order.Builder(
                "A3", new Address("Andi", "Solok"))
                .addLine(teh, 8)
                .build();

        // Cetak invoice
        printer.print(numbers.next(), budi, a1);
        printer.print(numbers.next(), sari, a2);
        printer.print(numbers.next(), andi, a3);

        // Pemesanan ulang
        reorderService.reorder(budi, a1);
    }
}
