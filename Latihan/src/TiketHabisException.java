public class TiketHabisException extends Exception {
    private String namaKereta;
    private int sisaKursi;

    public TiketHabisException(String message, String namaKereta, int sisaKursi) {
        super(message);
        this.namaKereta = namaKereta;
        this.sisaKursi  = sisaKursi;
    }

    public String getNamaKereta() { return namaKereta; }
    public int    getSisaKursi()  { return sisaKursi; }
}