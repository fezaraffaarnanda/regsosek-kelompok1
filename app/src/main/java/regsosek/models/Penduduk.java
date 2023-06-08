package regsosek.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FEZA
 */
public class Penduduk implements Model {
    private int id;
    private int rutaId;
    private String noUrut;
    private String NIK;
    private String nama;
    private int jenisKelamin;
    private int statusKepala;
    private String usia;
    private Kesulitan kesulitan;
    private int pendidikanTertinggi;
    private Pekerjaan pekerjaan;
    private Usaha usaha;

    public Penduduk() {

    }
    public Penduduk(int id) {

        this.id = id;
    }

    @Override
    public String getInsertStatement() {
        return "INSERT INTO penduduk (ruta_id, no_urut, nik, nama,"
                + "jenis_kelamin, status_kepala,"
                + "usia, kesulitan, jenis_kesulitan, pendidikan, status_kerja,"
                + "lapangan_usaha, status_kedudukan, kepemilikan, jumlah_usaha, usaha_utama, id)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public void prepareInsertStatement(PreparedStatement pstmt) throws SQLException {
        
        pstmt.setInt(1, rutaId);
        pstmt.setString(2, noUrut);
        pstmt.setString(3, NIK);
        pstmt.setString(4, nama);
        pstmt.setInt(5, jenisKelamin);
        pstmt.setInt(6, statusKepala);
        pstmt.setString(7, usia);
        pstmt.setInt(8, kesulitan.getKesulitan());
        if (kesulitan.getKesulitan() != 4) {
            pstmt.setString(9, kesulitan.getJenisKesulitan());
        } else {
            pstmt.setNull(9, Types.VARCHAR);
        }
        pstmt.setInt(10, pendidikanTertinggi);
        pstmt.setInt(11, pekerjaan.getStatusBekerja());
        if (pekerjaan.getStatusBekerja() != 2) {
            pstmt.setString(12, pekerjaan.getLapanganUsaha());
            pstmt.setString(13, pekerjaan.getStatusKependudukan());
        } else {
            pstmt.setNull(12, Types.VARCHAR);
            pstmt.setNull(13, Types.VARCHAR);
        }
        pstmt.setInt(14, usaha.getStatusKepemilikan());
        if (usaha.getStatusKepemilikan()!= 2) {
            pstmt.setString(15, usaha.getJumlahUsaha());
            pstmt.setString(16, usaha.getLapanganUsaha());
        } else {
            pstmt.setInt(15, 0);
            pstmt.setNull(16, Types.VARCHAR);
        }
        pstmt.setInt(17,0);
    }

    @Override
    public void save() throws SQLException {
        Database.getInstance().save(this);
    }

    public static List<Penduduk> getAll(int ruta_id) throws SQLException {
        List<Penduduk> art = new ArrayList<>();
        try (Connection con = Database.getInstance().getConnection()) {
            String viewSql = String.format("SELECT * from Penduduk WHERE ruta_id = %d", ruta_id);
            try(Statement pstmt = con.createStatement()){
                try (ResultSet rs = pstmt.executeQuery(viewSql)) {
                    while (rs.next()) {
                        Penduduk penduduk = new Penduduk(rs.getInt("id"));
                        
                        penduduk.setRutaId(ruta_id);
                        penduduk.setNoUrut(rs.getString("no_urut"));
                        penduduk.setNIK(rs.getString("nik"));
                        penduduk.setNama(rs.getString("nama"));
                        penduduk.setJenisKelamin(rs.getInt("jenis_kelamin"));
                        penduduk.setStatusKepala(rs.getInt("status_kepala"));
                        penduduk.setUsia(rs.getString("usia"));
                        Kesulitan kes = new Kesulitan(rs.getInt("kesulitan"), rs.getString("jenis_kesulitan"));
                        penduduk.setKesulitan(kes);
                        penduduk.setPendidikanTertinggi(rs.getInt("pendidikan"));
                        Pekerjaan pek = new Pekerjaan(rs.getString("lapangan_usaha"), rs.getString("status_kedudukan"), rs.getInt("status_kerja"));
                        penduduk.setPekerjaan(pek);
                        Usaha us = new Usaha(rs.getInt("kepemilikan"), rs.getString("jumlah_usaha"), rs.getString("usaha_utama"));
                        penduduk.setUsaha(us);

                        art.add(penduduk);
                    }
                } catch(Exception err) {
                    System.out.println("Error: " + err);
                }
            }
        }

        return art;
    }

    public int getId() {
        return id;
    }


    public int getRutaId() {
        return rutaId;
    }


    public String getNoUrut() {
        return noUrut;
    }


    
    public void setNoUrut(String noUrut) throws Exception {
         try {
                if (noUrut.length() != 3) {
                    throw new Exception("Harap isi Nomor Urut Anggota Keluarga dengan 3 digit angka");
                   }
            this.noUrut = noUrut;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public String getNIK() {
        return NIK;
    }


    
    public void setNIK(String NIK) throws Exception {
        try {
                if (NIK.length() != 16) {
                    throw new Exception("Harap isi NIK dengan 16 digit angka");
                }
            this.NIK = NIK;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public String getNama() {
        return nama;
    }


    public void setNama(String nama) {
        this.nama = nama;
    }


    public int isJenisKelamin() {
        return jenisKelamin;
    }


    
    public void setJenisKelamin(int jenisKelamin) throws Exception {
        this.jenisKelamin = jenisKelamin;
    }


    public int getStatusKepala() {
        return statusKepala;
    }


    public void setStatusKepala(int statusKepala) throws Exception {
        this.statusKepala = statusKepala;
    }


    public String getUsia() {
        return usia;
    }


    
    public void setUsia(String usia) throws Exception {
        try {
                if (Integer.parseInt(usia)<1 || Integer.parseInt(usia)>99) {
                    throw new Exception("Harap isi Usia dengan 2 digit angka");
                }
            this.usia = usia;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public Kesulitan getKesulitan() {
        return kesulitan;
    }


    
    public void setKesulitan(Kesulitan kesulitan) throws Exception {
        this.kesulitan = kesulitan;
    }


    public int getPendidikanTertinggi() {
        return pendidikanTertinggi;
    }

    
    public void setPendidikanTertinggi(int pendidikanTertinggi) throws Exception{
        try {
             if (pendidikanTertinggi>5||pendidikanTertinggi<1){
                    throw new Exception("Harap isi Pendidikan Tertinggi dengan angka 1 sampai 5");
            }
             
            this.pendidikanTertinggi = pendidikanTertinggi;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public Pekerjaan getPekerjaan() {
        return pekerjaan;
    }


    public void setPekerjaan(Pekerjaan pekerjaan) throws Exception {
      try {
            this.pekerjaan = pekerjaan;
             
            } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }


    public Usaha getUsaha() {
        return usaha;
    }

    public void setUsaha(Usaha usaha) throws Exception {
        // try {
        //      if (usia< 5) {
        //         throw new Exception("Usia harus lebih dari 5 tahun");
        //      }
        //     this.usaha = usaha;
        //     } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }  
        this.usaha = usaha;
    }

    public void setRutaId(int rutaId) {
        this.rutaId = rutaId;
    }

}
