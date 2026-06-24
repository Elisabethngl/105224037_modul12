public class MySQLDatabaseConnection implements DatabaseConnection {
    private String url;

    // Konstruktor kosong jika dibutuhkan
    public MySQLDatabaseConnection() {}

    // Konstruktor dengan parameter untuk mengatasi baris 5 di Main
    public MySQLDatabaseConnection(String url) {
        this.url = url;
    }

    @Override
    public void connect() {
        System.out.println("Menghubungkan ke MySQL Database Server Kampus...");
    }

    @Override
    public void simpanKRS(String mahasiswa, String matakuliah) {
        System.out.println("DATA TERSIMPAN: KRS Mahasiswa " + mahasiswa + " sukses masuk tabel MySQL.");
    }

    @Override
    public String getTipe() {
        return "MySQL";
    }
}