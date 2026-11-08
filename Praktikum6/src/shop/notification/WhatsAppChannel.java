package shop.notification;

public class WhatsAppChannel extends AbstractChannel {
    public WhatsAppChannel() { }

    @Override
    public String channelName() { return "WHATSAPP"; }

    @Override
    protected String resolveRecipient(CustomerContact contact) {
        String phone = contact.getPhone();
        if (phone == null || phone.length() < 10) return null;
        if (phone.startsWith("08") || phone.startsWith("+62")) return phone;
        return null;
    }

    @Override
    protected String prepare(String message) {
        return "[Toko UMKM] " + message;
    }

    @Override
    protected boolean deliver(String recipient, String message) {
        System.out.println("[WA to " + recipient + "] " + message);
        return true;
    }
}
