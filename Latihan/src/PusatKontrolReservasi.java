public class PusatKontrolReservasi implements Reservasi {
    private KeretaRepository repository;
    private NIKValidator nikValidator;

    public PusatKontrolReservasi(KeretaRepository repository, NIKValidator nikValidator) {
        this.repository   = repository;
        this.nikValidator = nikValidator;
    }

    @Override
    public void prosesPemesanan(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket)
            throws RuteTidakDitemukanException, TiketHabisException {

        nikValidator.validasi(nik);

        KeretaApi keretaDipilih = repository.cariKereta(kodeKereta);

        if (jumlahTiket > keretaDipilih.getSisaKursi()) {
            throw new TiketHabisException(
                "Kursi tidak mencukupi! Tiket diminta: " + jumlahTiket,
                keretaDipilih.getNamaKereta(),
                keretaDipilih.getSisaKursi());
        }

        keretaDipilih.kurangiKursi(jumlahTiket);
        System.out.println("\nPESANAN TELAH BERHASIL!");
        System.out.println("  Nama Penumpang : " + namaPenumpang);
        System.out.println("  NIK            : " + nik);
        System.out.println("  Kereta         : " + keretaDipilih.getNamaKereta());
        System.out.println("  Rute           : " + keretaDipilih.getRute());
        System.out.println("  Jumlah Tiket   : " + jumlahTiket);
        System.out.println("  Sisa Kursi     : " + keretaDipilih.getSisaKursi());
    }
}