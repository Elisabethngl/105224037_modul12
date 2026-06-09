interface RepositoriBuku {
    Buku cariByJudul(String judul);
}

interface LayananPeminjaman {
    void pinjamBuku(Anggota anggota, Buku buku);
    void kembalikanBuku(Anggota anggota, Buku buku);
}

interface KalkulatorDenda {
    double hitung(int hariTerlambat);
}

interface PemformatStruk {
    String format(InfoDenda infoDenda);
}

class Buku {
    String judul, penulis;
    Buku(String judul, String penulis) { this.judul = judul; this.penulis = penulis; }
}

class Anggota {
    String nama, idAnggota;
    Anggota(String nama, String id) { this.nama = nama; this.idAnggota = id; }
}

class InfoDenda {
    Anggota anggota; Buku buku; int hariTerlambat; double totalDenda;
    InfoDenda(Anggota a, Buku b, int h, double t) {
        anggota = a; buku = b; hariTerlambat = h; totalDenda = t;
    }
}

class RepositoriBukuMemori implements RepositoriBuku {
    java.util.List<Buku> daftar = java.util.Arrays.asList(
        new Buku("Belajar Java", "Budi Santoso")
    );
    public Buku cariByJudul(String judul) {
        return daftar.stream().filter(b -> b.judul.equalsIgnoreCase(judul)).findFirst().orElse(null);
    }
}

class LayananPeminjamanPerpustakaan implements LayananPeminjaman {
    public void pinjamBuku(Anggota a, Buku b)     { System.out.println(a.nama + " meminjam: " + b.judul); }
    public void kembalikanBuku(Anggota a, Buku b) { System.out.println(a.nama + " mengembalikan: " + b.judul); }
}

class KalkulatorDendaHarian implements KalkulatorDenda {
    public double hitung(int hari) { return hari <= 0 ? 0 : hari * 1000.0; }
}

class PemformatStrukTeks implements PemformatStruk {
    public String format(InfoDenda i) {
        return "Anggota: " + i.anggota.nama + "Buku: " + i.buku.judul + "Terlambat: " + i.hariTerlambat + " hari\nDenda: Rp" + i.totalDenda;
    }
}

class PemformatStrukTabel implements PemformatStruk {
    public String format(InfoDenda i){
        return String.format(i.anggota.nama, i.buku.judul, i.hariTerlambat, i.totalDenda);
    }
}

public class LibraryManager {
    private final RepositoriBuku repo;
    private final LayananPeminjaman layanan;
    private final KalkulatorDenda kalkulator;
    private final PemformatStruk formatter;

    public LibraryManager(RepositoriBuku repo, LayananPeminjaman layanan,
KalkulatorDenda kalkulator, PemformatStruk formatter) {
        this.repo = repo; this.layanan = layanan;
        this.kalkulator = kalkulator; this.formatter = formatter;
    }

    public Buku cariBuku(String judul){ 
        return repo.cariByJudul(judul); 
    }
    public void pinjamBuku(Anggota a, Buku b){ 
        layanan.pinjamBuku(a, b); 
    }
    public String prosesKembali(Anggota a, Buku b, int h){
        layanan.kembalikanBuku(a, b);
        InfoDenda info = new InfoDenda(a, b, h, kalkulator.hitung(h));
        return formatter.format(info);
    }
}