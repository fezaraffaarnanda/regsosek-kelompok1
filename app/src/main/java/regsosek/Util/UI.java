package regsosek.Util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class UI {
    private AppManager appManager;
    public JFrame window;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];
    public JComboBox<String> jenisKelaminDropdown, gKesulitanDropdown, ijazahDropdown, statKerjaDropdown, statMilikDropdown;
    public JLabel provinsiLabel, kabKotLabel, kecamatanLabel, desaKelLabel, noUrutLabel, nikLabel, umurLabel, jenisKelaminLabel, kelKeluargaLabel, urutBangunanLabel, urutKelLabel, landmarkLabel, gKesulitanLabel, jGangguanLabel, ijazahLabel, statKerjaLabel, addKerjaLabel, jLapanganLabel, jLapangAddLabel, statKedLabel,statKedAddLabel, statMilikLabel, jUsahaLabel, lUsahaLabel, lUsahaAddLabel, slsLabel, subSlsLabel, namaSlsLabel, lokasiPendataanLabel, namaKepalaKeluargLabel, namaLabel, statusHubKepalaLabel;
    public JTextField provinsiTextField, kabKotTextField, kecamatanTextField, jGangguanTextField,desaKelTextField, kelKeluargaTextField, noUrutTextField, nikTextField, umurTextField, urutBangunanTextField, urutKelTextField, landmarkTextField, slsTextField, subSlsTextField, namaSlsTextField, lokasiPendataanTextField, namaKepalaKeluargaTextField, namaTextField, statusHubKepalaTextField, jLapanganTextField, statKedTextField, jUsahaTextField, lUsahaTextField;


    public UI(AppManager appManager){
        this.appManager = appManager;
        createMainField();
        generateScreen();
        // inputField1();
        // inputField2();
        // inputField3();
        // inputField4();
        // inputField5();
        // inputField6();
        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(1920*3/4, 1080*3/4);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(null);
        window.setLayout(null);
        window.setResizable(false);
    }

    public void createBackgroundFull(int bgNum, String bgPath) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(0, 0, 1920*3/4, 1080*3/4);
        bgPanel[bgNum].setBackground(Color.black);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 1920*3/4, 1080*3/4);

        ImageIcon bgIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(bgPath)).getImage()
                .getScaledInstance(1920*3/4, 1080*3/4, Image.SCALE_SMOOTH));
        bgLabel[bgNum].setIcon(bgIcon);
        // bgPanel[bgNum].setVisible(false);
    }

    public void generateScreen() {
        // Start
        inputField1();
        inputField2();
        inputField3();
        inputField4();
        inputField5();
        inputField6();
        inputField7();
        // fieldTabel();
    }

    public JLabel createLabel(int bgNum, int x, int y, int width, int height, String text, int size){
        JLabel newLabel = new JLabel(text);
        newLabel.setLayout(null);
        newLabel.setBounds(x, y, width, height);
        newLabel.setFont(new Font("Helvetica", Font.PLAIN, size));

        bgPanel[bgNum].add(newLabel);

        return newLabel;
    }

    public JTextField createTextField(int bgNum, int x, int y, int width, int height, int size, int column){
        JTextField newTextField = new JTextField(column) {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                RoundRectangle2D roundedRect = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, height, height);
                g2.setColor(Color.WHITE);
                g2.draw(roundedRect);
                
                g2.setPaint(getBackground());
                g2.fill(roundedRect);

                g2.dispose();
                super.paintComponent(g);
            }
        };

        newTextField.setBounds(x, y, width, height);
        newTextField.setFont(new Font(newTextField.getFont().getName(), newTextField.getFont().getStyle(), size));
        newTextField.setBorder(BorderFactory.createEmptyBorder());
        newTextField.setOpaque(false);
        newTextField.setBackground(Color.WHITE);

        bgPanel[bgNum].add(newTextField);

        return newTextField;
    }

    public void clearField() {
        appManager.ui.provinsiTextField.setText(null); 
        appManager.ui.kabKotTextField.setText(null);
        appManager.ui.kecamatanTextField.setText(null);
        appManager.ui.desaKelTextField.setText(null);
        appManager.ui.slsTextField.setText(null);
        appManager.ui.subSlsTextField.setText(null);
        appManager.ui.namaSlsTextField.setText(null);
        appManager.ui.lokasiPendataanTextField.setText(null);
        appManager.ui.kelKeluargaTextField.setText(null);
        appManager.ui.namaKepalaKeluargaTextField.setText(null);
        appManager.ui.urutBangunanTextField.setText(null);
        appManager.ui.urutKelTextField.setText(null);
        appManager.ui.landmarkTextField.setText(null);
        appManager.ui.noUrutTextField.setText(null);
        appManager.ui.namaTextField.setText(null);
        appManager.ui.nikTextField.setText(null);
        appManager.ui.nikTextField.setText(null);       
        appManager.ui.umurTextField.setText(null);
        appManager.ui.statusHubKepalaTextField.setText(null);
        appManager.ui.jGangguanTextField.setText(null);
        appManager.ui.jLapanganTextField.setText(null);
        appManager.ui.statKedTextField.setText(null);
        appManager.ui.jUsahaTextField.setText(null);
        appManager.ui.lUsahaTextField.setText(null);
    }

    public JComboBox<String> createDropdown(int bgNum, int x, int y, int width, int height, int size, String[] isi){
        JComboBox<String> newDropdown = new JComboBox<String>(isi);
        newDropdown.setBounds(x, y, width, height);
        newDropdown.setFont(new Font(newDropdown.getFont().getName(),newDropdown.getFont().getStyle(),size));

        bgPanel[bgNum].add(newDropdown);

        return newDropdown;
    }

    public void button(int bgNum, int x, int y, int width, int height, String text, String command) {
        JButton btn = new JButton(text) {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int arcSize = Math.min(width, height); 

                Shape border = new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arcSize, arcSize);
                g2.setStroke(new BasicStroke(2));
                g2.setColor(Color.WHITE);
                g2.draw(border);

                g2.setPaint(getBackground()); 
                g2.fill(border);

                g2.dispose();
                super.paintComponent(g);
            }
        };

        btn.setBounds(x, y, width, height);
        btn.setText(text);
        btn.setFont(new Font("Helvetica", Font.PLAIN, 20));
        btn.setForeground(Color.BLACK);
        btn.setBackground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.addActionListener(appManager.actionHandler);
        btn.setActionCommand(command);
        btn.setBorderPainted(false);
        btn.setOpaque(false);
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setForeground(Color.GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setForeground(Color.BLACK);
            }
        });
        bgPanel[bgNum].add(btn, 0);
    }

    public void inputField1(){
        createBackgroundFull(0, "bg2.png");
        provinsiTextField = createTextField(0, 600, 203, 100, 40, 30, 3);
        kabKotTextField = createTextField(0, 600, 303, 100, 40, 30, 3);
        kecamatanTextField = createTextField(0, 600, 403, 130, 40, 30, 4);
        desaKelTextField = createTextField(0, 600, 503, 130, 40, 30, 4);
        provinsiLabel = createLabel(0, 260, 203, 500, 40, "Provinsi", 30);
        kabKotLabel = createLabel(0, 260, 303, 500, 40, "Kabupaten/Kota", 30);
        kecamatanLabel = createLabel(0, 260, 403, 500, 40, "Kecamatan", 30);
        desaKelLabel = createLabel(0, 260, 503, 500, 40, "Desa/Kelurahan", 30);
        button(0, 1000, 600, 200, 50, "Selanjutnya >", "page-2");

        bgPanel[0].add(bgLabel[0]);
        bgPanel[0].setVisible(false);
    }   

    public void inputField2(){
        createBackgroundFull(1, "bg2.png");
        slsTextField = createTextField(1, 600, 203, 160, 40, 30, 5);
        subSlsTextField = createTextField(1, 800, 203, 100, 40, 30, 3);
        namaSlsTextField = createTextField(1, 600, 303, 520, 40, 30, 14);
        lokasiPendataanTextField = createTextField(1, 600, 403, 520, 40, 30, 14);
        kelKeluargaTextField = createTextField(1, 600, 503, 100, 40, 30, 3);
        slsLabel = createLabel(1, 260, 203, 500, 40, "Kode SLS", 30);
        subSlsLabel = createLabel(1, 775, 203, 500, 40, "-", 30);
        namaSlsLabel = createLabel(1, 260, 303, 500, 40, "Nama SLS", 30);
        lokasiPendataanLabel = createLabel(1, 260, 403, 500, 40, "Lokasi Pendataan", 30);
        kelKeluargaLabel = createLabel(1, 260, 503, 500, 40, "Kelompok Keluarga", 30);
        button(1, 1000, 600, 200, 50, "Selanjutnya >", "page-3");
        button(1, 200, 600, 200, 50, "< Kembali", "kembali-page-1");

        bgPanel[1].add(bgLabel[1]);
        bgPanel[1].setVisible(false);
    }

    public void inputField3(){
        createBackgroundFull(2, "bg2.png");
        namaKepalaKeluargaTextField = createTextField(2, 600, 203, 520, 40, 30, 14);
        urutBangunanTextField = createTextField(2, 600, 303, 160, 40, 30, 5);
        urutKelTextField = createTextField(2, 600, 403, 160, 40, 30, 5);
        landmarkTextField = createTextField(2, 600, 503, 220, 40, 30, 7);

        namaKepalaKeluargLabel = createLabel(2, 260, 203, 500, 40, "Nama Kepala Keluarga", 30);
        urutBangunanLabel = createLabel(2, 260, 303, 500, 40, "No Urut Bangunan", 30);
        urutKelLabel = createLabel(2, 260, 403, 500, 40, "No Urut Keluarga", 30);
        landmarkLabel = createLabel(2, 260, 503, 500, 40, "ID Landmark", 30);
        
        button(2, 1000, 600, 200, 50, "Selanjutnya >", "page-4");
        button(2, 200, 600, 200, 50, "< Kembali", "kembali-page-2");
        
        bgPanel[2].add(bgLabel[2]);
        bgPanel[2].setVisible(false);
        // blok 1 selesai
    } 
    
    public void inputField4(){
        createBackgroundFull(3, "bg.png");
        noUrutTextField = createTextField(3, 600, 153, 130, 40, 30, 4);
        namaTextField = createTextField(3, 600, 253, 520, 40, 30, 14);
        nikTextField = createTextField(3, 600, 353, 520, 40, 30, 14);
        jenisKelaminDropdown = createDropdown(3, 600, 453, 250, 40, 30, new String[]{"1. Laki-laki", "2. Perempuan"});
        umurTextField = createTextField(3, 600, 553, 100, 40, 30, 3);
        noUrutLabel = createLabel(3, 260, 153, 500, 40, "No Urut", 30);
        namaLabel = createLabel(3, 260, 253, 500, 40, "Nama", 30);
        nikLabel = createLabel(3, 260, 353, 500, 40, "NIK", 30);
        jenisKelaminLabel = createLabel(3, 260, 453, 500, 40, "Jenis Kelamin", 30);
        umurLabel = createLabel(3, 260, 553, 500, 40, "Umur", 30);

        button(3, 1000, 650, 200, 50, "Selanjutnya >", "page-5");
        
        bgPanel[3].add(bgLabel[3]);
        bgPanel[3].setVisible(false);
    } 
    
    
    public void inputField5(){
        createBackgroundFull(4, "bg.png");
        statusHubKepalaTextField = createTextField(4, 600, 203, 70, 40, 30, 2);
        gKesulitanDropdown = createDropdown(4, 600, 303, 700, 40, 30, new String[]{"1. Ya, sama sekali tidak bisa","2. Ya, banyak kesulitan dan butuh bantuan","3. Ya, sedikit kesulitan dan tidak membutuhkan butuh bantuan","4. Tidak mengalami kesulitan sama sekali"});
        jGangguanTextField = createTextField(4, 600, 403, 100, 40, 30, 3);
        ijazahDropdown = createDropdown(4, 600, 503, 520, 40, 30, new String[]{"1. Belum pernah bersekolah", "2. SD/Sederajat", "3. SMP/Sederajat", "4. SMA/Sederajat", "5. Perguruan Tinggi"});
    //     statKerjaDropdown = createDropdown(4, 600, 503, 500, 40, 30, new String[]{"Ya","Tidak"});
        
        statusHubKepalaLabel = createLabel(4, 240, 203, 500, 40, "Status hub. (kpl. keluarga)", 30);
        gKesulitanLabel = createLabel(4, 240, 303, 500, 40, "Gangguan Kesulitan", 30);
        jGangguanLabel = createLabel(4, 240, 403, 500, 40, "Jenis Gangguan", 30);
        ijazahLabel = createLabel(4, 240, 503, 500, 40, "Ijazah Terakhir", 30);
    //     statKerjaLabel = createLabel(4, 240, 503, 500, 40, "Status Bekerja", 30);
    //     addKerjaLabel = createLabel(4, 240, 550, 500, 40, "*dalam seminggu terakhir", 18);
        
        button(4, 1000, 600, 200, 50, "Selanjutnya >", "page-6");
        button(4, 200, 600, 200, 50, "< Kembali", "kembali-page-4");

        gKesulitanDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gKesulitanDropdown.getSelectedItem().equals("4. Tidak mengalami kesulitan sama sekali")) {
                    jGangguanLabel.setVisible(false);
                    jGangguanTextField.setVisible(false);
                } else {
                    jGangguanLabel.setVisible(true);
                    jGangguanTextField.setVisible(true);
                }
            }
        });
        
        bgPanel[4].add(bgLabel[4]);
        bgPanel[4].setVisible(false);
    }
    
    public void inputField6(){
        createBackgroundFull(5, "bg.png");
        statKerjaDropdown = createDropdown(5, 600, 203, 220, 40, 30, new String[]{"1. Ya","2. Tidak"});
        jLapanganTextField = createTextField(5, 600, 303, 520, 40, 30, 14);
        statKedTextField = createTextField(5, 600, 403, 70, 40, 30, 2);
    //     statMilikDropdown = createDropdown(5, 600, 403, 500, 40, 30, new String[]{"Ya","Tidak"});
        
        statKerjaLabel = createLabel(5, 240, 203, 500, 40, "Status Bekerja", 30);
        addKerjaLabel = createLabel(5, 240, 250, 500, 40, "*dalam seminggu terakhir", 18);
        jLapanganLabel = createLabel(5, 240, 303, 500, 40, "Jenis Lapangan Usaha", 30);
        jLapangAddLabel = createLabel(5, 240, 350, 500, 40, "*dalam pekerjaan utama", 18);
        statKedLabel = createLabel(5, 240, 403, 500, 40, "Status Kedudukan", 30);
        statKedAddLabel = createLabel(5, 240, 450, 500, 40, "*dalam pekerjaan utama", 18);
    //     statMilikLabel = createLabel(5, 240, 403, 500, 40, "Status Kepemilikan Usaha", 30);
        
        button(5, 1000, 600, 200, 50, "Selanjutnya >", "page-7");
        button(5, 200, 600, 200, 50, "< Kembali", "kembali-page-5");

        statKerjaDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statKerjaDropdown.getSelectedItem().equals("2. Tidak")) {
                    jLapanganTextField.setVisible(false);
                    jLapanganLabel.setVisible(false);
                    jLapangAddLabel.setVisible(false);
                    statKedTextField.setVisible(false);
                    statKedLabel.setVisible(false);
                    statKedAddLabel.setVisible(false);
                } else {
                    jLapanganTextField.setVisible(true);
                    jLapanganLabel.setVisible(true);
                    jLapangAddLabel.setVisible(true);
                    statKedTextField.setVisible(true);
                    statKedLabel.setVisible(true);
                    statKedAddLabel.setVisible(true);
                }
            }
        });
        
        bgPanel[5].add(bgLabel[5]);
        bgPanel[5].setVisible(false);
    }
    
    public void inputField7(){
        createBackgroundFull(6, "bg.png");
        statMilikDropdown = createDropdown(6, 600, 203, 500, 40, 30, new String[]{"1. Ya","2. Tidak"});
        jUsahaTextField = createTextField(6, 600, 303, 100, 40, 30, 3);
        lUsahaTextField = createTextField(6, 600, 403, 520, 40, 30, 14);
        
        statMilikLabel = createLabel(6, 200, 203, 500, 40, "Status Kepemilikan Usaha", 30);
        jUsahaLabel = createLabel(6, 200, 303, 500, 40, "Jumlah Usaha yang Dimiliki", 30);
        lUsahaLabel = createLabel(6, 200, 403, 500, 40, "Lapangan Usaha", 30);
        lUsahaAddLabel = createLabel(6, 200, 450, 500, 40, "*dari usaha utama", 18);
        
        button(6, 200, 600, 200, 50, "< Kembali", "kembali-page-6");
        button(6, 1000, 600, 200, 50, "Selesai", "selesai");
        button(6, 600, 600, 200, 50, "Isi Lagi", "Isi Lagi");

        statMilikDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statMilikDropdown.getSelectedItem().equals("2. Tidak")) {
                    jUsahaTextField.setVisible(false);
                    jUsahaLabel.setVisible(false);
                    lUsahaTextField.setVisible(false);
                    lUsahaLabel.setVisible(false);
                    lUsahaAddLabel.setVisible(false);
                } else {
                    jUsahaTextField.setVisible(true);
                    jUsahaLabel.setVisible(true);
                    lUsahaTextField.setVisible(true);
                    lUsahaLabel.setVisible(true);
                    lUsahaAddLabel.setVisible(true);
                }
            }
        });

        bgPanel[6].add(bgLabel[6]);
        bgPanel[6].setVisible(false);
    }

    // public void fieldTabel(){
    //     createBackgroundFull(7, "bg.png");

        
    //     Object[][] data = null;
    //     data = new Object[3][3];
    //     // try {
    //         //     List<String[]> dataList = Penduduk.getAll(0);
    //         //     data = new Object[dataList.size()][3];
    //         //     int i = 0;
    //         //     for (String[] row : dataList) {
    //             //         data[i] = (Object[]) row;
    //             //     }
    //             // } catch (SQLException e) {
    //                 //     JOptionPane.showMessageDialog(null, "Ambil Data Gagal! SQL Error!");
    //                 // }

    //     JTable jt = new JTable(data, new String[] { "Ruta ID", "Nama", "No Urut"});
    //     jt.setEnabled(false);
    //     JScrollPane js = new JScrollPane(jt);
    //     js.setBounds(150, 160, 1920 * 3 / 4 - 300, 420);
        
    //     bgPanel[7].add(js);

    //     button(7, 650, 600, 200, 50, "Home", "Home");

    //     bgPanel[7].add(bgLabel[7]);
    //     bgPanel[7].setVisible(false);
    // }
}
