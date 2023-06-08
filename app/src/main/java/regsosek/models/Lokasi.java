package regsosek.models;

/**
 *
 * @author FEZA
 */
public class Lokasi {
    private String provinsi;
    private String kabKot;
    private String kecamatan;
    private String desaKel;
    private String kodeSLS;
    private String kodeSubSLS;
    private String namaSLS;
    private String lokasiPendataan;

    public String getProvinsi() {
        return provinsi;
    }


    public void setProvinsi(String provinsi) throws IllegalArgumentException {
        try {
            if (Integer.parseInt(provinsi) < 1 || Integer.parseInt(provinsi) > 99) {
                throw new IllegalArgumentException("input kode dalam range 1 - 99");
            }
            this.provinsi = provinsi;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public String getKabKot() {
        return kabKot;
    }


    public void setKabKot(String kabKot) throws IllegalArgumentException {
        try {
            if (Integer.parseInt(kabKot) < 1 || Integer.parseInt(kabKot) > 99) {
                throw new IllegalArgumentException("input kode dalam range 1 - 99");
            }
            this.kabKot = kabKot;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public String getKecamatan() {
        return kecamatan;
    }


    public void setKecamatan(String kecamatan) throws IllegalArgumentException {
        try {
            if (Integer.parseInt(kecamatan) < 1 || Integer.parseInt(kecamatan) > 999) {
                throw new IllegalArgumentException("input kode dalam range 1 - 999");
            }
            this.kecamatan = kecamatan;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public String getDesaKel() {
        return desaKel;
    }


    public void setDesaKel(String desaKel) throws IllegalArgumentException {
        try {
            if (Integer.parseInt(desaKel) < 1 || Integer.parseInt(desaKel) > 999) {
                throw new IllegalArgumentException("input kode dalam range 1 - 999");
            }
            this.desaKel = desaKel;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public String getKodeSLS() {
        return kodeSLS;
    }


    public void setKodeSLS(String kodeSLS)throws IllegalArgumentException {
        try {
            if (Integer.parseInt(kodeSLS) < 1 || Integer.parseInt(kodeSLS) > 9999) {
                throw new IllegalArgumentException("input kode dalam range 1 - 9999");
            }
            this.kodeSLS = kodeSLS;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public String getKodeSubSLS() {
        return kodeSubSLS;
    }


    public void setKodeSubSLS(String kodeSubSLS)throws IllegalArgumentException {
        try {
            if (Integer.parseInt(kodeSubSLS) < 1 || Integer.parseInt(kodeSubSLS) > 99) {
                throw new IllegalArgumentException("input kode dalam range 1 - 99");
            }
            this.kodeSubSLS = kodeSubSLS;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getNamaSLS(){
        return namaSLS;
    }

    public void setNamaSLS(String namaSLS){
        this.namaSLS = namaSLS;
    }

    public String getLokasiPendataan() {
        return lokasiPendataan;
    }


    public void setLokasiPendataan(String lokasiPendataan) {
        this.lokasiPendataan = lokasiPendataan;
    }
}
