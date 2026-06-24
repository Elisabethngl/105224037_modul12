public class MataKuliahPraktikum extends OperasiMataKuliah implements OperasiPraktikum {
    private String namaLab;
    private String peralatan;

    public MataKuliahPraktikum(String kode, String nama, int sks,
    String namaLab, String peralatan) {
        super(kode, nama, sks);
        this.namaLab = namaLab;
        this.peralatan = peralatan;
    }

    @Override
    public void alokasiAsistenLab() {
        System.out.println("  Asisten lab dialokasikan untuk: " + namaLab);
    }

    @Override
    public void cekPeralatanPraktikum() {
        System.out.println("  Peralatan dicek: " + peralatan);
    }

    @Override
    public String getJenis() { return "Praktikum"; }
}