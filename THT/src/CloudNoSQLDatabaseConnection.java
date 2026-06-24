public class CloudNoSQLDatabaseConnection implements DatabaseConnection {
    private String url;

    // Konstruktor kosong jika dibutuhkan
    public CloudNoSQLDatabaseConnection() {}

    // Konstruktor dengan parameter untuk mengatasi baris 99 di Main
    public CloudNoSQLDatabaseConnection(String url) {
        this.url = url;
    }

    @Override
    public void connect() {
        System.out.println("Menghubungkan ke Cloud NoSQL Database...");
    }

    @Override
    public void simpanKRS(String mahasiswa, String matakuliah) {
        System.out.println("DATA TERSIMPAN: KRS Mahasiswa " + mahasiswa + " sukses masuk Cluster NoSQL.");
    }

    @Override
    public String getTipe() {
        return "Cloud NoSQL";
    }
}