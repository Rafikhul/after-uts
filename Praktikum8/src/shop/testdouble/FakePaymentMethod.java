package shop.testdouble;

import shop.exception.PaymentFailedException;
import shop.payment.PaymentMethod;

/** Pembayaran palsu untuk pengujian tanpa saldo atau kartu sungguhan. */
public class FakePaymentMethod implements PaymentMethod {
    private long lastAmount;
    private int callCount;

    @Override
    public String name() { return "Fake"; }

    @Override
    public void pay(long amount) throws PaymentFailedException {
        lastAmount = amount;
        callCount++;
    }

    public long getLastAmount() { return lastAmount; }
    public int getCallCount() { return callCount; }
}
