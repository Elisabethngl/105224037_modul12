public abstract class OperasiMataKuliah {
    private String kode;
    private String nama;
    private int sks;

    public OperasiMataKuliah(String kode, String nama, int sks) {
        if (kode == null || kode.isBlank())
            throw new IllegalArgumentException("Kode mata kuliah tidak boleh kosong.");
        if (sks <= 0)
            throw new IllegalArgumentException("SKS harus lebih dari nol.");
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getSks() { return sks; }

    public abstract String getJenis();

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%d SKS)", kode, getJenis(), nama, sks);
    }
}