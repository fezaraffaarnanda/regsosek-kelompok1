package regsosek.entity;

/**
 *
 * @author FEZA
 */
public class Pekerjaan {
    private String lapanganUsaha;
    private String statusKependudukan;
    private int statusBekerja;

    public Pekerjaan(){

    }

    public Pekerjaan(String lapanganUsaha, String statusKependudukan, int statusBekerja){
        this.lapanganUsaha = lapanganUsaha;
        this.statusKependudukan = statusKependudukan;
        this.statusBekerja = statusBekerja;
    }
    /**
     * @return the lapanganUsaha
     */
    public String getLapanganUsaha() {
        return lapanganUsaha;
    }

/**
     * @param lapanganUsaha the lapanganUsaha to set
     * @throws java.lang.Exception
     */
    
    //(zein ini hasil kodingan astri dan ninis)
    public void setLapanganUsaha(String lapanganUsaha) throws Exception {    
        this.lapanganUsaha = lapanganUsaha;
    }

    /**
     * @return the statusKependudukan
     */
    public String getStatusKependudukan() {
        return statusKependudukan;
    }

  /**
     * @param statusKependudukan the statusKependudukan to set
     * @throws java.lang.Exception
     */
    
    //(zein ini hasil kodingan astri dan ninis)
    public void setStatusKependudukan(int statusKependudukan) throws Exception {
       try {
                if (statusKependudukan<1||statusKependudukan>8){
                    throw new Exception("Harap isi Status Kedudukan dengan angka 1 sampai 8");
                    }
                
            
            this.statusKependudukan = String.valueOf(statusKependudukan);
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getStatusBekerja(){
        return statusBekerja;
    }

   public void setStatusBekerja(int statusBekerja) throws Exception{
        if(statusBekerja != 1 && statusBekerja != 2 ){
            throw new Exception("Harap isi status bekerja dengan angka 1 atau 2");
        }
        this.statusBekerja = statusBekerja;
   }

}
