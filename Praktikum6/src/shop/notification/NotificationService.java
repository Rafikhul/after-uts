package shop.notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private final List<NotificationChannel> channels = new ArrayList<>();

    public void register(NotificationChannel channel) {
        if (channel == null) {
            throw new IllegalArgumentException("Channel cannot be null");
        }
        channels.add(channel);
    }

    /** Mengirim pesan dan mengembalikan jumlah kanal yang berhasil. */
    public int broadcast(CustomerContact contact, String message) {
        int successCount = 0;
        for (NotificationChannel channel : channels) {
            if (channel.send(contact, message)) successCount++;
        }
        return successCount;
    }
}
