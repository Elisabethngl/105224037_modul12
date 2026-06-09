public class KeretaApi {
    private String kodeKereta;
    private String namaKereta;
    private String rute;
    private int    kapasitas;
    private int    sisaKursi;

    public KeretaApi(String kodeKereta, String namaKereta, String rute, int kapasitas) {
        this.kodeKereta = kodeKereta;
        this.namaKereta = namaKereta;
        this.rute       = rute;
        this.kapasitas  = kapasitas;
        this.sisaKursi  = kapasitas;
    }

    public String getKodeKereta() { return kodeKereta; }
    public String getNamaKereta() { return namaKereta; }
    public String getRute()       { return rute; }
    public int    getKapasitas()  { return kapasitas; }
    public int    getSisaKursi()  { return sisaKursi; }

    public void kurangiKursi(int jumlah) {
        this.sisaKursi -= jumlah;
    }

    @Override
    public String toString() {
        return String.format("| %-5s | %-15s | %-10s | %d/%d kursi tersedia",
                kodeKereta, namaKereta, rute, sisaKursi, kapasitas);
    }
}