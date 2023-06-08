package regsosek.Util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import regsosek.entity.Kesulitan;
import regsosek.entity.Lokasi;
import regsosek.entity.Pekerjaan;

import regsosek.entity.Ruta;
import regsosek.entity.Usaha;

public class ActionHandler implements ActionListener{
    AppManager appManager;

    public ActionHandler(AppManager appManager){
        this.appManager = appManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String command = e.getActionCommand();

        switch (command){
            case "kembali-page-1":
                appManager.routing.showScreen(0);
                break;
            case "kembali-page-2":
                appManager.routing.showScreen(1);
                break;
            case "kembali-page-4":
                appManager.routing.showScreen(3);
                break;
            case "kembali-page-5":
                appManager.routing.showScreen(4);
                break;
            case "kembali-page-6":
                appManager.routing.showScreen(5);
                break;
            case "Home":
                appManager.routing.showScreen(0);
                break;
            case "page-2":
                if(!appManager.ui.provinsiTextField.getText().equals("") && !appManager.ui.kabKotTextField.getText().equals("") && !appManager.ui.kecamatanTextField.getText().equals("") && !appManager.ui.desaKelTextField.getText().equals("")){
                    if(appManager.ui.provinsiTextField.getText().length() == 2 && appManager.ui.kabKotTextField.getText().length() == 2 && appManager.ui.kecamatanTextField.getText().length() == 3 && appManager.ui.desaKelTextField.getText().length() == 3){
                        if(Integer.parseInt(appManager.ui.provinsiTextField.getText()) > 0 && Integer.parseInt(appManager.ui.provinsiTextField.getText()) < 100 && Integer.parseInt(appManager.ui.kabKotTextField.getText()) > 0 && Integer.parseInt(appManager.ui.kabKotTextField.getText()) < 100 && Integer.parseInt(appManager.ui.kecamatanTextField.getText()) > 0 && Integer.parseInt(appManager.ui.kecamatanTextField.getText()) < 1000 && Integer.parseInt(appManager.ui.desaKelTextField.getText()) > 0 && Integer.parseInt(appManager.ui.desaKelTextField.getText()) < 1000){
                            appManager.routing.showScreen(1);
                        }
                        else if(Integer.parseInt(appManager.ui.provinsiTextField.getText()) <= 0 || Integer.parseInt(appManager.ui.kabKotTextField.getText()) <= 0 || Integer.parseInt(appManager.ui.kecamatanTextField.getText()) <= 0 || Integer.parseInt(appManager.ui.desaKelTextField.getText()) <= 0){
                            JOptionPane.showMessageDialog(null, "Kode harus lebih besar dari 0!");
                        }
                        else if(Integer.parseInt(appManager.ui.provinsiTextField.getText()) >= 100){
                            JOptionPane.showMessageDialog(null, "Kode Provinsi maksimal adalah 99!");
                        }
                        else if(Integer.parseInt(appManager.ui.kabKotTextField.getText()) >= 100){
                            JOptionPane.showMessageDialog(null, "Kode Kabupaten/Kota maksimal adalah 99!");
                        }
                        else if(Integer.parseInt(appManager.ui.kecamatanTextField.getText()) >= 1000){
                            JOptionPane.showMessageDialog(null, "Kode Kecamatan maksimal adalah 999!");
                        }
                        else if(Integer.parseInt(appManager.ui.desaKelTextField.getText()) >= 1000){
                            JOptionPane.showMessageDialog(null, "Kode Desa/Kelurahan maksimal adalah 999!");
                        }
                    }else if(appManager.ui.provinsiTextField.getText().length() != 2){
                        JOptionPane.showMessageDialog(null, "Isi field Provinsi dengan kode 2 digit!");
                    }else if(appManager.ui.kabKotTextField.getText().length() != 2){
                        JOptionPane.showMessageDialog(null, "Isi field Kabupaten/Kota dengan kode 2 digit!");
                    }else if(appManager.ui.provinsiTextField.getText().length() != 3){
                        JOptionPane.showMessageDialog(null, "Isi field Kecamatan dengan kode 3 digit!");
                    }else if(appManager.ui.kabKotTextField.getText().length() != 3){
                        JOptionPane.showMessageDialog(null, "Isi field Desa/Kelurahan dengan kode 3 digit!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tidak boleh ada field kosong!");
                }
                break;
            case "page-3":
                if(!appManager.ui.slsTextField.getText().equals("") && !appManager.ui.subSlsTextField.getText().equals("") && !appManager.ui.namaSlsTextField.getText().equals("") && !appManager.ui.lokasiPendataanTextField.getText().equals("") && !appManager.ui.kelKeluargaTextField.getText().equals("")){
                    if(appManager.ui.slsTextField.getText().length() == 4 && appManager.ui.subSlsTextField.getText().length() == 2 && appManager.ui.kelKeluargaTextField.getText().length() == 2){
                        if(Integer.parseInt(appManager.ui.slsTextField.getText()) > 0 && Integer.parseInt(appManager.ui.slsTextField.getText()) < 10000 && Integer.parseInt(appManager.ui.subSlsTextField.getText()) > 0 && Integer.parseInt(appManager.ui.subSlsTextField.getText()) < 100 && Integer.parseInt(appManager.ui.kelKeluargaTextField.getText()) > 0 && (Integer.parseInt(appManager.ui.kelKeluargaTextField.getText()) < 12)){
                            appManager.routing.showScreen(2);
                        }
                        else if(Integer.parseInt(appManager.ui.slsTextField.getText()) <= 0 || Integer.parseInt(appManager.ui.subSlsTextField.getText()) <= 0 || Integer.parseInt(appManager.ui.kelKeluargaTextField.getText()) <= 0){
                            JOptionPane.showMessageDialog(null, "Kode harus lebih besar dari 0!");
                        }
                        else if(Integer.parseInt(appManager.ui.slsTextField.getText()) >= 10000){
                            JOptionPane.showMessageDialog(null, "Kode SLS maksimal adalah 9999!");
                        }
                        else if(Integer.parseInt(appManager.ui.subSlsTextField.getText()) >= 100){
                            JOptionPane.showMessageDialog(null, "Kode sub-SLS maksimal adalah 99!");
                        }
                        else if(Integer.parseInt(appManager.ui.kelKeluargaTextField.getText()) >= 12){
                            JOptionPane.showMessageDialog(null, "Kode Kelompok Keluarga maksimal adalah 11!");
                        }
                    }
                    else if(appManager.ui.slsTextField.getText().length() != 4){
                        JOptionPane.showMessageDialog(null, "Isi field SLS dengan kode 4 dan 2 digit!");
                    }
                    else if(appManager.ui.subSlsTextField.getText().length() != 2){
                        JOptionPane.showMessageDialog(null, "Isi field SLS dengan kode 4 dan 2 digit!");
                    }
                    else if(appManager.ui.kelKeluargaTextField.getText().length() != 2){
                        JOptionPane.showMessageDialog(null, "Isi field Kelompok Keluarga dengan kode 2 digit!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Tidak boleh ada field kosong!");
                }
                break;
            case "page-4":
                if(!appManager.ui.namaKepalaKeluargaTextField.getText().equals("") && !appManager.ui.urutBangunanTextField.getText().equals("") && !appManager.ui.urutKelTextField.getText().equals("") && !appManager.ui.landmarkTextField.getText().equals("")){
                    if(appManager.ui.urutBangunanTextField.getText().length() == 4 && appManager.ui.urutKelTextField.getText().length() == 4 && appManager.ui.landmarkTextField.getText().length() == 6){
                        if(Integer.parseInt(appManager.ui.urutBangunanTextField.getText()) > 0 && Integer.parseInt(appManager.ui.urutBangunanTextField.getText()) < 10000 && Integer.parseInt(appManager.ui.urutKelTextField.getText()) > 0 && Integer.parseInt(appManager.ui.urutKelTextField.getText()) < 10000 && Integer.parseInt(appManager.ui.landmarkTextField.getText()) > 0 && (Integer.parseInt(appManager.ui.landmarkTextField.getText()) < 1000000)){
                            appManager.routing.showScreen(3);
                            Lokasi loc = new Lokasi();
                            appManager.ruta.setLokasi(loc);
                            appManager.ruta.getLokasi().setProvinsi(appManager.ui.provinsiTextField.getText());
                            appManager.ruta.getLokasi().setKabKot(appManager.ui.kabKotTextField.getText());
                            appManager.ruta.getLokasi().setKecamatan(appManager.ui.kecamatanTextField.getText());
                            appManager.ruta.getLokasi().setDesaKel(appManager.ui.desaKelTextField.getText());
                            appManager.ruta.getLokasi().setKodeSLS(appManager.ui.slsTextField.getText());
                            appManager.ruta.getLokasi().setKodeSubSLS(appManager.ui.subSlsTextField.getText());
                            appManager.ruta.getLokasi().setNamaSLS(appManager.ui.namaSlsTextField.getText());
                            appManager.ruta.getLokasi().setLokasiPendataan(appManager.ui.lokasiPendataanTextField.getText());
                            appManager.ruta.setKelompokKeluarga(appManager.ui.kelKeluargaTextField.getText());
                            appManager.ruta.setKepalaKeluarga(appManager.ui.namaKepalaKeluargaTextField.getText());
                            appManager.ruta.setNoUrutBangunan(appManager.ui.urutBangunanTextField.getText());
                            appManager.ruta.setNoUrutKeluarga(appManager.ui.urutKelTextField.getText());
                            appManager.ruta.setIdLandmark(appManager.ui.landmarkTextField.getText());
                        }
                        else if(Integer.parseInt(appManager.ui.urutBangunanTextField.getText()) <= 0 || Integer.parseInt(appManager.ui.urutKelTextField.getText()) <= 0 || Integer.parseInt(appManager.ui.landmarkTextField.getText()) <= 0){
                            JOptionPane.showMessageDialog(null, "Kode harus lebih besar dari 0!");
                        }
                        else if(Integer.parseInt(appManager.ui.urutBangunanTextField.getText()) >= 10000){
                            JOptionPane.showMessageDialog(null, "Kode No. Urut Bangunan maksimal adalah 9999!");
                        }
                        else if(Integer.parseInt(appManager.ui.urutKelTextField.getText()) >= 10000){
                            JOptionPane.showMessageDialog(null, "Kode No. Urut Bangunan maksimal adalah 9999!");
                        }
                        else if(Integer.parseInt(appManager.ui.landmarkTextField.getText()) >= 1000000){
                            JOptionPane.showMessageDialog(null, "Kode No. Urut Bangunan maksimal adalah 999999!");
                        }
                    }
                    else if(appManager.ui.urutBangunanTextField.getText().length() != 4){
                        JOptionPane.showMessageDialog(null, "Isi field No. Urut Bangunan dengan kode 4 digit!");
                    }
                    else if(appManager.ui.urutKelTextField.getText().length() != 4){
                        JOptionPane.showMessageDialog(null, "Isi field No. Urut Keluarga dengan kode 4 digit!");
                    }
                    else if(appManager.ui.landmarkTextField.getText().length() != 6){
                        JOptionPane.showMessageDialog(null, "Isi field ID Landmark dengan kode 6 digit!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Tidak boleh ada field kosong!");
                }
                break;
            case "page-5":
                if(!appManager.ui.noUrutTextField.getText().equals("") && !appManager.ui.namaTextField.getText().equals("") && !appManager.ui.nikTextField.getText().equals("") && !appManager.ui.umurTextField.getText().equals("")){
                    if(appManager.ui.noUrutTextField.getText().length() == 3 && appManager.ui.nikTextField.getText().length() == 16 && appManager.ui.umurTextField.getText().length() == 2){
                        if(Integer.parseInt(appManager.ui.noUrutTextField.getText()) > 0 && Integer.parseInt(appManager.ui.noUrutTextField.getText()) < 1000 && Integer.parseInt(appManager.ui.umurTextField.getText()) > 0 && (Integer.parseInt(appManager.ui.umurTextField.getText()) < 100)){
                            appManager.routing.showScreen(4);
                        }
                        else if(Integer.parseInt(appManager.ui.noUrutTextField.getText()) <= 0 || Integer.parseInt(appManager.ui.nikTextField.getText()) <= 0 || Integer.parseInt(appManager.ui.umurTextField.getText()) <= 0){
                            JOptionPane.showMessageDialog(null, "Kode harus lebih besar dari 0!");
                        }
                        else if(Integer.parseInt(appManager.ui.noUrutTextField.getText()) >= 1000){
                            JOptionPane.showMessageDialog(null, "Kode No. Urut maksimal adalah 999!");
                        }
                        else if(Integer.parseInt(appManager.ui.umurTextField.getText()) >= 100){
                            JOptionPane.showMessageDialog(null, "Maksimal umur adalah 99!");
                        }
                    }
                    else if(appManager.ui.nikTextField.getText().length() != 16){
                        JOptionPane.showMessageDialog(null, "Isi field NIK dengan 16 digit unik!");
                    }
                    else if(appManager.ui.urutBangunanTextField.getText().length() != 3){
                        JOptionPane.showMessageDialog(null, "Isi field No. Urut dengan kode 3 digit!");
                    }
                    else if(appManager.ui.umurTextField.getText().length() != 2){
                        JOptionPane.showMessageDialog(null, "Isi field umur dengan 2 digit!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Tidak boleh ada field kosong!");
                }
                break;
            case "page-6":
                if(appManager.ui.gKesulitanDropdown.getSelectedIndex() != 3){
                    if(!appManager.ui.statusHubKepalaTextField.getText().equals("") && !appManager.ui.jGangguanTextField.getText().equals("")){
                        if(appManager.ui.statusHubKepalaTextField.getText().length() == 1 && appManager.ui.jGangguanTextField.getText().length() == 2){
                            if(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()) > 0 && Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()) < 9 && Integer.parseInt(appManager.ui.jGangguanTextField.getText()) > 0 && Integer.parseInt(appManager.ui.jGangguanTextField.getText()) < 11){
                                appManager.routing.showScreen(5);
                            }
                            else if(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()) <= 0 || Integer.parseInt(appManager.ui.jGangguanTextField.getText()) <= 0){
                                JOptionPane.showMessageDialog(null, "Kode harus lebih besar dari 0!");
                            }
                            else if(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()) >= 9){
                                JOptionPane.showMessageDialog(null, "Kode Status Hub. dengan Kpl. Keluarga maksimal adalah 8!");
                            }
                            else if(Integer.parseInt(appManager.ui.jGangguanTextField.getText()) >= 11){
                                JOptionPane.showMessageDialog(null, "Kode Jenis Gangguan maksimal adalah 10!");
                            }
                        }
                        else if(appManager.ui.statusHubKepalaTextField.getText().length() != 1){
                            JOptionPane.showMessageDialog(null, "Isi field Status Hub. dengan Kpl. Keluarga dengan kode 1 digit!");
                        }
                        else if(appManager.ui.jGangguanTextField.getText().length() != 2){
                            JOptionPane.showMessageDialog(null, "Isi field Jenis Gangguan dengan kode 2 digit!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Tidak boleh ada field kosong!");
                    }
                }else{
                    if(!appManager.ui.statusHubKepalaTextField.getText().equals("")){
                        if(appManager.ui.statusHubKepalaTextField.getText().length() == 1){
                            if(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()) > 0 && Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()) < 9){
                                appManager.routing.showScreen(5);
                            }
                            else if(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()) <= 0){
                                JOptionPane.showMessageDialog(null, "Kode harus lebih besar dari 0!");
                            }
                            else if(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()) >= 9){
                                JOptionPane.showMessageDialog(null, "Kode Status Hub. dengan Kpl. Keluarga maksimal adalah 8!");
                            }
                        }
                        else if(appManager.ui.statusHubKepalaTextField.getText().length() != 1){
                            JOptionPane.showMessageDialog(null, "Isi field Status Hub. dengan Kpl. Keluarga dengan kode 1 digit!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Tidak boleh ada field kosong!");
                    } 
                }
                break;
            case "page-7":
                if(appManager.ui.statKerjaDropdown.getSelectedIndex() == 0){
                    if(!appManager.ui.jLapanganTextField.getText().equals("") && !appManager.ui.statKedTextField.getText().equals("")){
                        if(appManager.ui.statKedTextField.getText().length() == 1){
                            if(Integer.parseInt(appManager.ui.statKedTextField.getText()) > 0 && Integer.parseInt(appManager.ui.statKedTextField.getText()) < 9){
                                appManager.routing.showScreen(6);
                            }
                            else if(Integer.parseInt(appManager.ui.statKedTextField.getText()) <= 0){
                                JOptionPane.showMessageDialog(null, "Kode harus lebih besar dari 0!");
                            }
                            else if(Integer.parseInt(appManager.ui.statKedTextField.getText()) >= 9){
                                JOptionPane.showMessageDialog(null, "Kode Status Kedudukan maksimal adalah 8!");
                            }
                        }
                        else if(appManager.ui.statKedTextField.getText().length() != 1){
                            JOptionPane.showMessageDialog(null, "Isi field Status Kedudukan dengan kode 1 digit!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Tidak boleh ada field kosong!");
                    }
                } else {
                    appManager.routing.showScreen(6);
                }
                break;
            case "Isi Lagi":
                if(appManager.ui.statMilikDropdown.getSelectedIndex() == 0){
                    if(!appManager.ui.jUsahaTextField.getText().equals("") && !appManager.ui.lUsahaTextField.getText().equals("")){
                        if(appManager.ui.jUsahaTextField.getText().length() == 2){
                            if(Integer.parseInt(appManager.ui.jUsahaTextField.getText()) > 0 && Integer.parseInt(appManager.ui.jUsahaTextField.getText()) < 100){
                                // appManager.routing.showScreen(6);
                                try{
                                    appManager.penduduk.setNoUrut(appManager.ui.noUrutTextField.getText());
                                    appManager.penduduk.setNama(appManager.ui.namaTextField.getText());
                                    appManager.penduduk.setNIK(appManager.ui.nikTextField.getText());
                                    if(appManager.ui.jenisKelaminDropdown.getSelectedItem().equals("1. Laki-laki")){
                                        appManager.penduduk.setJenisKelamin(1);
                                    } else {
                                        appManager.penduduk.setJenisKelamin(2);
                                    }
                                    appManager.penduduk.setUsia(appManager.ui.umurTextField.getText());
                                    appManager.penduduk.setStatusKepala(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()));
                                    int temp =  appManager.ui.gKesulitanDropdown.getSelectedIndex();
                                    Kesulitan kes = new Kesulitan();
                                    kes.setKesulitan(temp+1);
                                    if(temp != 3){
                                        kes.setJenisKesulitan(appManager.ui.jGangguanTextField.getText());
                                    }
                                    appManager.penduduk.setKesulitan(kes);
                                    int temp1 = appManager.ui.ijazahDropdown.getSelectedIndex();
                                    appManager.penduduk.setPendidikanTertinggi(temp1+1);
                                    Pekerjaan pek = new Pekerjaan();                  
                                    int temp2 = appManager.ui.statKerjaDropdown.getSelectedIndex();
                                    pek.setStatusBekerja(temp2 + 1);
                                    if(temp2 == 0){
                                        pek.setLapanganUsaha(appManager.ui.jLapanganTextField.getText());
                                        pek.setStatusKependudukan(Integer.parseInt(appManager.ui.statKedTextField.getText()));
                                    }
                                    appManager.penduduk.setPekerjaan(pek);
                                    
                                    Usaha us = new Usaha();
                                    int temp3 = appManager.ui.statMilikDropdown.getSelectedIndex();
                                    
                                    us.setStatusKepemilikan(temp3+1);
                                    
                                    if(temp3 == 0){
                                        us.setJumlahUsaha(appManager.ui.jUsahaTextField.getText());
                                        
                                        us.setLapanganUsaha(appManager.ui.lUsahaTextField.getText());
                                        
                                    }
                                    appManager.penduduk.setUsaha(us);
                                    
                                    appManager.ruta.addAnggotaRumahTangga(appManager.penduduk);
                                    
                                } catch(Exception error) {
                                    // System.out.println(error.getMessage());
                                }
                                appManager.changePenduduk();
                                appManager.routing.showScreen(3);
                            }
                            else if(Integer.parseInt(appManager.ui.jUsahaTextField.getText()) <= 0){
                                JOptionPane.showMessageDialog(null, "Minimal jumlah usaha adalah 1!");
                            }
                            else if(Integer.parseInt(appManager.ui.jUsahaTextField.getText()) >= 100){
                                JOptionPane.showMessageDialog(null, "Minimal jumlah usaha adalah 99!");
                            }
                        }
                        else if(appManager.ui.statKedTextField.getText().length() != 2){
                            JOptionPane.showMessageDialog(null, "Isi field Jumlah Usaha dengan 2 digit!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Tidak boleh ada field kosong!");
                    }
                } else {
                    try{
                        
                        appManager.penduduk.setNoUrut(appManager.ui.noUrutTextField.getText());
                        
                        appManager.penduduk.setNama(appManager.ui.namaTextField.getText());
                        appManager.penduduk.setNIK(appManager.ui.nikTextField.getText());
                        if(appManager.ui.jenisKelaminDropdown.getSelectedItem().equals("1. Laki-laki")){
                            appManager.penduduk.setJenisKelamin(1);
                        } else {
                            appManager.penduduk.setJenisKelamin(2);
                        }
                        appManager.penduduk.setUsia(appManager.ui.umurTextField.getText());
                        appManager.penduduk.setStatusKepala(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()));
                        int temp =  appManager.ui.gKesulitanDropdown.getSelectedIndex();
                        Kesulitan kes = new Kesulitan();
                        kes.setKesulitan(temp+1);
                        if(temp != 3){
                            kes.setJenisKesulitan(appManager.ui.jGangguanTextField.getText());
                            
                        }
                        appManager.penduduk.setKesulitan(kes);
                        int temp1 = appManager.ui.ijazahDropdown.getSelectedIndex();
                        appManager.penduduk.setPendidikanTertinggi(temp1+1);
                        Pekerjaan pek = new Pekerjaan();                  
                        int temp2 = appManager.ui.statKerjaDropdown.getSelectedIndex();
                        pek.setStatusBekerja(temp2 + 1);
                        if(temp2 == 0){
                            pek.setLapanganUsaha(appManager.ui.jLapanganTextField.getText());
                            pek.setStatusKependudukan(Integer.parseInt(appManager.ui.statKedTextField.getText()));
                            
                        }
                        appManager.penduduk.setPekerjaan(pek);
                        
                        Usaha us = new Usaha();
                        int temp3 = appManager.ui.statMilikDropdown.getSelectedIndex();
                        
                        us.setStatusKepemilikan(temp3+1);
                        
                        if(temp3 == 0){
                            us.setJumlahUsaha(appManager.ui.jUsahaTextField.getText());
                            
                            us.setLapanganUsaha(appManager.ui.lUsahaTextField.getText());
                            
                        }
                        appManager.penduduk.setUsaha(us);
                        
                        appManager.ruta.addAnggotaRumahTangga(appManager.penduduk);
                        
                    } catch(Exception error) {
                        // System.out.println(error.getMessage());
                    }
                    appManager.changePenduduk();
                    appManager.routing.showScreen(3);
                }
                break;
            case "selesai":
                if(appManager.ui.statMilikDropdown.getSelectedIndex() == 0){
                    if(!appManager.ui.jUsahaTextField.getText().equals("") && !appManager.ui.lUsahaTextField.getText().equals("")){
                        if(appManager.ui.jUsahaTextField.getText().length() == 2){
                            if(Integer.parseInt(appManager.ui.jUsahaTextField.getText()) > 0 && Integer.parseInt(appManager.ui.jUsahaTextField.getText()) < 100){
                                try{
                                    
                                    appManager.penduduk.setNoUrut(appManager.ui.noUrutTextField.getText());
                                    
                                    appManager.penduduk.setNama(appManager.ui.namaTextField.getText());
                                    appManager.penduduk.setNIK(appManager.ui.nikTextField.getText());
                                    if(appManager.ui.jenisKelaminDropdown.getSelectedItem().equals("1. Laki-laki")){
                                        appManager.penduduk.setJenisKelamin(1);
                                    } else {
                                        appManager.penduduk.setJenisKelamin(2);
                                    }
                                    appManager.penduduk.setUsia(appManager.ui.umurTextField.getText());
                                    appManager.penduduk.setStatusKepala(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()));
                                    int temp =  appManager.ui.gKesulitanDropdown.getSelectedIndex();
                                    Kesulitan kes = new Kesulitan();
                                    kes.setKesulitan(temp+1);
                                    if(temp != 3){
                                        kes.setJenisKesulitan(appManager.ui.jGangguanTextField.getText());
                                        
                                    }
                                    appManager.penduduk.setKesulitan(kes);
                                    int temp1 = appManager.ui.ijazahDropdown.getSelectedIndex();
                                    appManager.penduduk.setPendidikanTertinggi(temp1+1);
                                    Pekerjaan pek = new Pekerjaan();                  
                                    int temp2 = appManager.ui.statKerjaDropdown.getSelectedIndex();
                                    pek.setStatusBekerja(temp2 + 1);
                                    if(temp2 == 0){
                                        pek.setLapanganUsaha(appManager.ui.jLapanganTextField.getText());
                                        pek.setStatusKependudukan(Integer.parseInt(appManager.ui.statKedTextField.getText()));
                                        
                                    }
                                    appManager.penduduk.setPekerjaan(pek);
                                    
                                    Usaha us = new Usaha();
                                    int temp3 = appManager.ui.statMilikDropdown.getSelectedIndex();
                                    
                                    us.setStatusKepemilikan(temp3+1);
                                    
                                    if(temp3 == 0){
                                        us.setJumlahUsaha(appManager.ui.jUsahaTextField.getText());
                                        
                                        us.setLapanganUsaha(appManager.ui.lUsahaTextField.getText());
                                        
                                    }
                                    appManager.penduduk.setUsaha(us);
                                    
                                    appManager.ruta.addAnggotaRumahTangga(appManager.penduduk);
                                    appManager.ruta.save();
                                } catch(Exception error) {
                                    // System.out.println(error.getMessage());
                                }
                                Ruta ruta = new Ruta();
                                appManager.setRuta(ruta);
                                appManager.changePenduduk();
                                appManager.ui.clearField();
                                appManager.routing.showScreen(0);
                            }
                            else if(Integer.parseInt(appManager.ui.jUsahaTextField.getText()) <= 0){
                                JOptionPane.showMessageDialog(null, "Minimal jumlah usaha adalah 1!");
                            }
                            else if(Integer.parseInt(appManager.ui.jUsahaTextField.getText()) >= 100){
                                JOptionPane.showMessageDialog(null, "Minimal jumlah usaha adalah 99!");
                            }
                        }
                        else if(appManager.ui.statKedTextField.getText().length() != 2){
                            JOptionPane.showMessageDialog(null, "Isi field Jumlah Usaha dengan 2 digit!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Tidak boleh ada field kosong!");
                    }
                } else {
                    try{
                        
                        appManager.penduduk.setNoUrut(appManager.ui.noUrutTextField.getText());
                        
                        appManager.penduduk.setNama(appManager.ui.namaTextField.getText());
                        appManager.penduduk.setNIK(appManager.ui.nikTextField.getText());
                        if(appManager.ui.jenisKelaminDropdown.getSelectedItem().equals("1. Laki-laki")){
                            appManager.penduduk.setJenisKelamin(1);
                        } else {
                            appManager.penduduk.setJenisKelamin(2);
                        }
                        appManager.penduduk.setUsia(appManager.ui.umurTextField.getText());
                        appManager.penduduk.setStatusKepala(Integer.parseInt(appManager.ui.statusHubKepalaTextField.getText()));
                        int temp =  appManager.ui.gKesulitanDropdown.getSelectedIndex();
                        Kesulitan kes = new Kesulitan();
                        kes.setKesulitan(temp+1);
                        if(temp != 3){
                            kes.setJenisKesulitan(appManager.ui.jGangguanTextField.getText());
                            
                        }
                        appManager.penduduk.setKesulitan(kes);
                        int temp1 = appManager.ui.ijazahDropdown.getSelectedIndex();
                        appManager.penduduk.setPendidikanTertinggi(temp1+1);
                        Pekerjaan pek = new Pekerjaan();                  
                        int temp2 = appManager.ui.statKerjaDropdown.getSelectedIndex();
                        pek.setStatusBekerja(temp2 + 1);
                        if(temp2 == 0){
                            pek.setLapanganUsaha(appManager.ui.jLapanganTextField.getText());
                            pek.setStatusKependudukan(Integer.parseInt(appManager.ui.statKedTextField.getText()));
                            
                        }
                        appManager.penduduk.setPekerjaan(pek);
                        
                        Usaha us = new Usaha();
                        int temp3 = appManager.ui.statMilikDropdown.getSelectedIndex();
                        
                        us.setStatusKepemilikan(temp3+1);
                        
                        if(temp3 == 0){
                            us.setJumlahUsaha(appManager.ui.jUsahaTextField.getText());
                            
                            us.setLapanganUsaha(appManager.ui.lUsahaTextField.getText());
                            
                        }
                        appManager.penduduk.setUsaha(us);
                        
                        appManager.ruta.addAnggotaRumahTangga(appManager.penduduk);
                        
                        appManager.ruta.save();
                        
                    } catch(Exception error) {
                        // System.out.println(error.getMessage());
                    }
                    Ruta ruta = new Ruta();
                    appManager.setRuta(ruta);
                    appManager.changePenduduk();
                    appManager.ui.clearField();
                    appManager.routing.showScreen(0);
                }
                break;
        }
    }
}
