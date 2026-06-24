public class MataKuliahTeori extends OperasiMataKuliah {

    public MataKuliahTeori(String kode, String nama, int sks) {
        super(kode, nama, sks);
    }

    @Override
    public String getJenis() {
        return "Teori";
    }
}