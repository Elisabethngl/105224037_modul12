public class Main {
    public static void main(String[] args) {

        LibraryManager manajer = new LibraryManager(
            new RepositoriBukuMemori(),
            new LayananPeminjamanPerpustakaan(),
            new KalkulatorDendaHarian(),
            new PemformatStrukTeks()
        );

        Buku buku       = manajer.cariBuku("Belajar Java");
        Anggota anggota = new Anggota("Budi", "A001");

        manajer.pinjamBuku(anggota, buku);
        System.out.println(manajer.prosesKembali(anggota, buku, 3));
    }
}