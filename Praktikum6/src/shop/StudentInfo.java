package shop;

/** Identitas mahasiswa dan parameter tugas yang dihitung dari NIM. */
public final class StudentInfo {
    public static final String NIM = "2511533012";
    public static final String NAME = "Rafikhul Ramadhan";

    // Rumus sesuai tools.NimParams untuk NIM 2511533012.
    public static final int CARD_ADMIN_PERCENT = 3;
    public static final long TRANSFER_ADMIN_FEE = 3_500L;
    public static final int SMS_MAX_LENGTH = 112;

    private StudentInfo() {
        // Class ini hanya menyimpan konstanta.
    }
}
