public class Main {
    public static void main(String[] args) {

        // ── Setup koneksi database (mudah diganti ke NoSQL) ──
        DatabaseConnection db = new MySQLDatabaseConnection("jdbc:mysql://localhost:3306/siakad");
        SistemKRSManager sistem = new SistemKRSManager(db, 500_000);
        sistem.connect();

        // ── Daftarkan kalkulator UKT per jalur ───────────────
        sistem.daftarKalkulatorUKT(new KalkulasiJalurUKT() {
            public double hitung(int sks, double dasar) { return dasar * sks; }
            public String getNamaJalur() { return "REGULER"; }
        });
        sistem.daftarKalkulatorUKT(new KalkulasiJalurUKT() {
            public double hitung(int sks, double dasar) { return dasar * sks * 0.90; }
            public String getNamaJalur() { return "KARYAWAN"; }
        });
        sistem.daftarKalkulatorUKT(new KalkulasiJalurUKT() {
            public double hitung(int sks, double dasar) { return 0; }
            public String getNamaJalur() { return "BIDIKMISI"; }
        });
        sistem.daftarKalkulatorUKT(new KalkulasiJalurUKT() {
            public double hitung(int sks, double dasar) { return dasar * sks * 1.50; }
            public String getNamaJalur() { return "INTERNASIONAL"; }
        });
        // Jalur MBKM baru — cukup tambah di sini, tidak ada kode lain yang diubah
        sistem.daftarKalkulatorUKT(new KalkulasiJalurUKT() {
            public double hitung(int sks, double dasar) { return dasar * sks * 0.75; }
            public String getNamaJalur() { return "MBKM"; }
        });

        // ── Data mata kuliah ──────────────────────────────────
        MataKuliahTeori mkTeori = new MataKuliahTeori("IF201", "Algoritma & Pemrograman", 3);
        MataKuliahPraktikum mkPrak = new MataKuliahPraktikum(
                "IF202", "Praktikum Jaringan", 2, "Lab Jaringan", "Switch, Router, Kabel UTP");
        MataKuliahTeori mkWeb = new MataKuliahTeori("IF203", "Pemrograman Web", 3);

        System.out.println("=== DATABASE: " + sistem.getDatabaseTipe() + " ===\n");

        // ── Daftarkan mahasiswa ───────────────────────────────
        sistem.daftarMahasiswa("22001", "Andi Saputra",  "REGULER");
        sistem.daftarMahasiswa("22002", "Siti Rahma",    "BIDIKMISI");
        sistem.daftarMahasiswa("22003", "Budi Santoso",  "MBKM");

        // ── Tambah mata kuliah ke KRS ─────────────────────────
        System.out.println();
        sistem.tambahMataKuliah("22001", mkTeori);
        sistem.tambahMataKuliah("22001", mkPrak);
        sistem.tambahMataKuliah("22001", mkWeb);

        sistem.tambahMataKuliah("22002", mkTeori);
        sistem.tambahMataKuliah("22002", mkWeb);

        sistem.tambahMataKuliah("22003", mkTeori);
        sistem.tambahMataKuliah("22003", mkPrak);

        // ── Fitur khusus Praktikum ────────────────────────────
        System.out.println();
        System.out.println("--- Fitur Khusus Praktikum ---");
        mkPrak.alokasiAsistenLab();
        mkPrak.cekPeralatanPraktikum();

        // ── Cetak KRS semua mahasiswa ─────────────────────────
        System.out.println();
        sistem.cetakKRS("22001");
        sistem.cetakKRS("22002");
        sistem.cetakKRS("22003");

        // ── Setujui KRS ───────────────────────────────────────
        sistem.setujuiKRS("22001");
        System.out.println();

        // ── Demonstrasi error handling ────────────────────────
        System.out.println("--- Demonstrasi Error Handling ---");

        // Error 1: NIM duplikat
        sistem.daftarMahasiswa("22001", "Nama Lain", "REGULER");

        // Error 2: Mata kuliah duplikat
        sistem.tambahMataKuliah("22001", mkTeori);

        // Error 3: NIM tidak ditemukan
        sistem.cetakKRS("99999");

        // Error 4: NIM kosong
        sistem.daftarMahasiswa("", "Tanpa NIM", "REGULER");

        // Error 5: SKS melebihi batas (tambah banyak MK)
        for (int i = 1; i <= 5; i++) {
            sistem.tambahMataKuliah("22001",
                new MataKuliahTeori("XX" + i, "Mata Kuliah Ekstra " + i, 5));
        }

        // ── Demonstrasi migrasi ke Cloud NoSQL ───────────────
        System.out.println();
        System.out.println("--- Migrasi ke Cloud NoSQL ---");
        DatabaseConnection noSqlDb =
                new CloudNoSQLDatabaseConnection("https://cloud-nosql.kampus.ac.id");
        SistemKRSManager sistemBaru = new SistemKRSManager(noSqlDb, 500_000);
        sistemBaru.connect();
        System.out.println("Database aktif: " + sistemBaru.getDatabaseTipe());
        System.out.println("[OK] Migrasi berhasil — logika bisnis tidak berubah sama sekali.");
    }
}