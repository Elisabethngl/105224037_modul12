public class NIKValidator {
    public void validasi(String nik) {
        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException(
                "NIK harus tepat 16 karakter! NIK Anda: " + nik.length() + " karakter.");
        }
        for (char c : nik.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new DataPenumpangTidakValidException(
                    "NIK hanya boleh mengandung angka!");
            }
        }
    }
}