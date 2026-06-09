import java.util.ArrayList;
import java.util.List;

public class KeretaRepository implements KelolaKereta {
    private List<KeretaApi> daftarKereta = new ArrayList<>();

    @Override
    public void tambahKereta(KeretaApi kereta) {
        daftarKereta.add(kereta);
    }

    @Override
    public List<KeretaApi> getDaftarKereta() {
        return daftarKereta;
    }

    public KeretaApi cariKereta(String kodeKereta) throws RuteTidakDitemukanException {
        for (KeretaApi k : daftarKereta) {
            if (k.getKodeKereta().equalsIgnoreCase(kodeKereta)) {
                return k;
            }
        }
        throw new RuteTidakDitemukanException(
            "Kereta dengan kode '" + kodeKereta + "' tidak ditemukan!");
    }
}