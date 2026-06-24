import java.util.ArrayList;
import java.util.List;

public class SistemKRSManager {
    private DatabaseConnection db;
    private double uktDasar;
    private List<KalkulasiJalurUKT> daftarKalkulator = new ArrayList<>();

    // Konstruktor sesuai baris 6 & 100 di Main.java
    public SistemKRSManager(DatabaseConnection db, double uktDasar) {
        this.db = db;
        this.uktDasar = uktDasar;
    }

    public void connect() {
        if (db != null) {
            db.connect();
        }
    }

    // Dipanggil di Main baris 10, 14, 18, 22, 27
    public void daftarKalkulatorUKT(KalkulasiJalurUKT kalkulator) {
        daftarKalkulator.add(kalkulator);
    }

    // Dipanggil di Main baris 41-43, 77, 86
    public void daftarMahasiswa(String nim, String nama, String jalur) {
        System.out.println("Mendaftarkan mahasiswa: " + nama + " (" + nim + ") jalur " + jalur);
    }

    // Dipanggil di Main baris 47-49, 51-54, 80, 90
    public void tambahMataKuliah(String nim, OperasiMataKuliah mk) {
        System.out.println("Menambahkan mata kuliah ke NIM " + nim + ": " + mk.getNama());
    }

    // Dipanggil di Main baris 65-67, 83
    public void cetakKRS(String nim) {
        System.out.println("Mencetak KRS untuk NIM: " + nim);
    }

    // Dipanggil di Main baris 70
    public void setujuiKRS(String nim) {
        System.out.println("KRS untuk NIM " + nim + " telah disetujui.");
    }

    // Dipanggil di Main baris 38 & 102
    public String getDatabaseTipe() {
        return db != null ? db.getTipe() : "Belum terhubung";
    }
}