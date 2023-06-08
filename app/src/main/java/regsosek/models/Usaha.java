package regsosek.models;

/**
 *
 * @author FEZA
 */
public class Usaha {
    private String jumlahUsaha;
    private String lapanganUsaha;
    private int statusKepemilikan;

    public Usaha(){}
    
    public Usaha(int statusKepemilikan, String jumlahUsaha, String lapanganUsaha){
        this.statusKepemilikan = statusKepemilikan;
        this.jumlahUsaha = jumlahUsaha;
        this.lapanganUsaha = lapanganUsaha;
    }

    /**
     * @return the jumlahUsaha
     */
    public String getJumlahUsaha() {
        return jumlahUsaha;
    }

    /**
     * @param jumlahUsaha the jumlahUsaha to set
     * @throws java.lang.Exception
     */
    
    //(zein ini hasil kodingan astri dan ninis tapi masih bingung cara ngakses lenght int)
    public void setJumlahUsaha(String jumlahUsaha) throws Exception {
        if (Integer.parseInt(jumlahUsaha)<1 || Integer.parseInt(jumlahUsaha)>99) {
            throw new Exception("Harap isi Lapangan Usaha dengan 2 digit angka");
        }
        this.jumlahUsaha = jumlahUsaha;
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
        // try {
        //         if (Integer.parseInt(lapanganUsaha)<1||Integer.parseInt(lapanganUsaha)>26){
        //             throw new Exception("Harap isi Lapangan Usaha dengan angka 01 sampai 26");
                
        //     }
            
        //     } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        this.lapanganUsaha = lapanganUsaha;
    }

    public int getStatusKepemilikan(){
        return statusKepemilikan;
    }

    public void setStatusKepemilikan(int statusKepemilikan) throws Exception{
        if(statusKepemilikan != 1 && statusKepemilikan != 2 ){
            throw new Exception("Harap isi status kepemilikan usaha dengan angka 1 atau 2");
        }
        this.statusKepemilikan = statusKepemilikan;
    }

}
