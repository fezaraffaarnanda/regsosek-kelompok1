package regsosek.models;

/**
 *
 * @author FEZA
 */
public class Kesulitan {
    private int kesulitan;
    private String jenisKesulitan;

    public Kesulitan(){

    }

    public Kesulitan(int kesulitan, String jenisKesulitan) {
        this.kesulitan = kesulitan;
        this.jenisKesulitan = jenisKesulitan;
    }


   public String getJenisKesulitan(){
    return jenisKesulitan;
   }
    public void setJenisKesulitan(String jenisKesulitan) throws Exception{
        if(Integer.parseInt(jenisKesulitan)<1 || Integer.parseInt(jenisKesulitan)>10){
            throw new Exception("Harap isi dengan angka 1 sampai 10");
        }
        this.jenisKesulitan = jenisKesulitan;
    }


    public int getKesulitan() {
        return kesulitan;
    }

    public void setKesulitan(int kesulitan) throws Exception{
        if(kesulitan<1 || kesulitan>4){
            throw new Exception("Harap isi dengan angka 1 sampai 4");
        }
        this.kesulitan = kesulitan;
    }
}
