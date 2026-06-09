public interface Reservasi {
    void prosesPemesanan(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket)
            throws RuteTidakDitemukanException, TiketHabisException;
}