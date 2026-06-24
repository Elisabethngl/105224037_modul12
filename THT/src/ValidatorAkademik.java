public class ValidatorAkademik {
    private static final int MAKS_SKS = 24;
    private static final int MIN_SKS = 1;

    public void validasiSks(int totalSks) {
        if (totalSks < MIN_SKS)
            throw new IllegalArgumentException(
                "Total SKS tidak boleh kurang dari " + MIN_SKS + ".");
        if (totalSks > MAKS_SKS)
            throw new IllegalArgumentException(
                "Total SKS melebihi batas maksimum " + MAKS_SKS + " SKS.");
    }

    public void validasiNim(String nim) {
        if (nim == null || nim.isBlank())
            throw new IllegalArgumentException("NIM tidak boleh kosong.");
    }

    public void validasiNama(String nama) {
        if (nama == null || nama.isBlank())
            throw new IllegalArgumentException("Nama tidak boleh kosong.");
    }
}