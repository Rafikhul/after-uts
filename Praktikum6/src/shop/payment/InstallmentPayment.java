package shop.payment;

public interface InstallmentPayment extends PaymentMethod {
    int maxInstallmentMonths();

    /** Menghitung cicilan dengan pembulatan ke atas. */
    default long monthlyInstallment(long amount, int months) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (months < 1 || months > maxInstallmentMonths()) {
            throw new IllegalArgumentException(
                    "Months must be between 1 and " + maxInstallmentMonths());
        }
        return (amount + months - 1L) / months;
    }

    default String policy() {
        return "Cicilan maksimal " + maxInstallmentMonths() + " bulan";
    }
}
