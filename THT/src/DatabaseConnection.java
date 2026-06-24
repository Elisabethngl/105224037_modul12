public interface DatabaseConnection {
    void connect(); // Diubah ke connect() agar class implementasinya tidak merah
    void simpanKRS(String mahasiswa, String matakuliah);
    String getTipe();
}