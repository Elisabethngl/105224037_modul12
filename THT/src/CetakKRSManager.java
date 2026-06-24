import java.util.List;

public class CetakKRSManager {

    public void cetakKRS(String nim, String nama, String jalur,
    List<OperasiMataKuliah> daftarMK,
    int totalSks, double ukt, String statusKRS) {
        System.out.println("\n KARTU RENCANA STUDI");
        System.out.printf("NIM       : %s%n", nim);
        System.out.printf("Nama      : %s%n", nama);
        System.out.printf("Jalur UKT : %s%n", jalur);
        System.out.println("Mata Kuliah yang Diambil:");
        for (OperasiMataKuliah mk : daftarMK) {
            System.out.println("  " + mk);
        }
        System.out.printf("Total SKS : %d%n", totalSks);
        System.out.printf("UKT       : Rp%.0f%n", ukt);
        System.out.printf("Status    : %s%n", statusKRS);
        System.out.println();
    }

    public void cetakPesanBerhasil(String pesan) {
        System.out.println("[OK] " + pesan);
    }

    public void cetakPeringatan(String pesan) {
        System.out.println("Peringatan: " + pesan);
    }
}