package shop.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final String orderId;
    private final Address shippingAddress;
    private final List<Line> lines = new ArrayList<>();

    public Order(String orderId, Address shippingAddress) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("Order ID cannot be blank");
        }
        if (shippingAddress == null) {
            throw new IllegalArgumentException("Shipping address is required");
        }
        this.orderId = orderId;
        this.shippingAddress = shippingAddress;
    }

    public String getOrderId() { return orderId; }
    public Address getShippingAddress() { return shippingAddress; }

    public void addLine(Product product, int quantity) {
        lines.add(new Line(product, quantity));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public long getItemsTotal() {
        long total = 0L;
        for (Line line : lines) total += line.subtotal();
        return total;
    }

    public Receipt createReceipt() { return new Receipt(); }

    /** Static nested class: satu baris item tidak perlu mengakses Order. */
    public static class Line {
        private final Product product;
        private final int quantity;

        public Line(Product product, int quantity) {
            if (product == null) throw new IllegalArgumentException("Product is required");
            if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() { return product; }
        public int getQuantity() { return quantity; }
        public long subtotal() { return product.getFinalPrice() * quantity; }
    }

    /** Inner class: struk membaca data dari objek Order yang menaunginya. */
    public class Receipt {
        public String toText() {
            StringBuilder result = new StringBuilder();
            result.append("STRUK PESANAN ").append(orderId).append("\n");
            for (Line line : lines) {
                result.append(line.getProduct().getName())
                      .append(" x").append(line.getQuantity())
                      .append(" = Rp").append(line.subtotal()).append("\n");
            }
            result.append("Total barang: Rp").append(getItemsTotal()).append("\n");
            result.append("Kirim ke: ").append(shippingAddress);
            return result.toString();
        }
    }
}
