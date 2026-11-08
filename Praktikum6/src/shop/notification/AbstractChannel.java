package shop.notification;

public abstract class AbstractChannel implements NotificationChannel {
    private int sentCount;
    private String lastDelivered = "";

    @Override
    public final boolean send(CustomerContact contact, String message) {
        if (contact == null || message == null || message.isBlank()) {
            return false;
        }

        String recipient = resolveRecipient(contact);
        if (recipient == null || recipient.isBlank()) {
            return false;
        }

        String preparedMessage = prepare(message);
        if (preparedMessage == null || preparedMessage.isBlank()) {
            return false;
        }

        boolean success = deliver(recipient, preparedMessage);
        if (success) {
            sentCount++;
            lastDelivered = preparedMessage;
        }
        return success;
    }

    protected abstract String resolveRecipient(CustomerContact contact);
    protected abstract boolean deliver(String recipient, String message);

    protected String prepare(String message) { return message; }

    public int getSentCount() { return sentCount; }
    public String getLastDelivered() { return lastDelivered; }
}
