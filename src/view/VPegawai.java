package view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author rohim
 */
public class VPegawai extends javax.swing.JFrame {

    public VPegawai() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setVisible(true);
        ((JLabel) curahHujan.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) lamaBulanKering.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) lereng.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) kedalamanEfektif.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) tekstur.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) prosentaseBatu.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) genangan.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) ph.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) n.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) p.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) k.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) kejenuhan.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) salinitas.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }
    
    public void changeAccountOnClick(ActionListener action){
        this.changeAccount.addActionListener(action);
    }

    public void minimizeSetIcon(Icon minimizeIcon2) {
        this.minimize.setIcon(minimizeIcon2);
    }

    public void logoutSetIcon(Icon minimizeIcon2) {
        this.logout.setIcon(minimizeIcon2);
    }

    public void minimize() {
        this.setState(Frame.ICONIFIED);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public int showConfirmMessage(String message) {
        return JOptionPane.showConfirmDialog(this, message, "Confirm Message", JOptionPane.YES_NO_OPTION);
    }

    public void logoutOnClick(MouseListener mouse) {
        this.logout.addMouseListener(mouse);
    }

    public void minimizeOnClick(MouseListener mouse) {
        this.minimize.addMouseListener(mouse);
    }

    //======================= Menu ============================================
    public void setPanelUtama(String panel) {
        this.setBackgroundPanel(getPanelUtama(), new Color(96, 91, 120));
        if (panel.equalsIgnoreCase("home")) {
            this.homeImage.setVisible(true);
            this.panelDaftarAlternative.setVisible(false);
            this.formPengisian.setVisible(false);
            this.grafik.setVisible(false);
            this.hasilAnalisis.setVisible(false);
        } else if (panel.equalsIgnoreCase("daftar")) {
            this.homeImage.setVisible(false);
            this.panelDaftarAlternative.setVisible(true);
            this.formPengisian.setVisible(false);
            this.grafik.setVisible(false);
            this.hasilAnalisis.setVisible(false);
        } else if (panel.equalsIgnoreCase("form")) {
            this.homeImage.setVisible(false);
            this.panelDaftarAlternative.setVisible(false);
            this.formPengisian.setVisible(true);
            this.grafik.setVisible(false);
            this.hasilAnalisis.setVisible(false);
        } else if (panel.equalsIgnoreCase("grafik")) {
            this.homeImage.setVisible(false);
            this.panelDaftarAlternative.setVisible(false);
            this.formPengisian.setVisible(false);
            this.grafik.setVisible(true);
            this.hasilAnalisis.setVisible(false);
        } else {
            this.homeImage.setVisible(false);
            this.panelDaftarAlternative.setVisible(false);
            this.formPengisian.setVisible(false);
            this.grafik.setVisible(false);
            this.hasilAnalisis.setVisible(true);
        }
        this.setBackgroundPanel(panel, new Color(136, 133, 151));
    }

    public void setBackgroundPanel(String panel, Color color) {
        if (panel.equalsIgnoreCase("home")) {
            this.panelHome.setBackground(color);
        } else if (panel.equalsIgnoreCase("daftar") || panel.equalsIgnoreCase("form")) {
            this.panelKriteria.setBackground(color);
        } else if (panel.equalsIgnoreCase("showDataLahan")) {
            this.panelShowAnalisis1.setBackground(color);
        } else {
            this.panelAnalisis.setBackground(color);
        }
    }

    public String getPanelUtama() {
        if (homeImage.isVisible()) {
            return "home";
        } else if (panelDaftarAlternative.isVisible()) {
            return "daftar";
        } else if (formPengisian.isVisible()) {
            return "form";
        } else if (hasilAnalisis.isVisible()) {
            return "hasilAnalisis";
        } else {
            return "grafik";
        }
    }

    public void homeOnClick(MouseListener mouse) {
        this.home.addMouseListener(mouse);
    }

    public void tableAlternativeOnClick(MouseListener mouse) {
        this.formParameter.addMouseListener(mouse);
    }

    public void analisisOnClick(MouseListener mouse) {
        this.analisis.addMouseListener(mouse);
    }

    //=============================== Daftar Alternative ========================
    public void setTableAlternative(DefaultTableModel model) {
        tableAlternative.setModel(model);
    }

    public DefaultTableModel getModelTableAlternative() {
        return (DefaultTableModel) tableAlternative.getModel();
    }

    public boolean isTableSelected() {
        if (tableAlternative.getSelectedRow() == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String getIdAlternativeTable() {
        return tableAlternative.getValueAt(tableAlternative.getSelectedRow(), 1).toString();
    }

    public void clearSelection() {
        tableAlternative.clearSelection();
    }

    public void masukkanOnClick(ActionListener action) {
        masukkanAnalisis.addActionListener(action);
    }

    //====================== Form Pengisian ===================================
    public String[] getData(String kategori[]) {
        String[] data = new String[14];
        if (kategori[0].equalsIgnoreCase("benefit")) {
            data[0] = String.valueOf(curahHujan.getSelectedIndex() + 1);
        } else {
            data[0] = String.valueOf(Math.abs(curahHujan.getSelectedIndex() - 4));
        }
        if (kategori[1].equalsIgnoreCase("benefit")) {
            data[1] = String.valueOf(lamaBulanKering.getSelectedIndex() + 1);
        } else {
            data[1] = String.valueOf(Math.abs(lamaBulanKering.getSelectedIndex() - 4));
        }
        if (kategori[2].equalsIgnoreCase("benefit")) {
            data[2] = String.valueOf(lereng.getSelectedIndex() + 1);
        } else {
            data[2] = String.valueOf(Math.abs(lereng.getSelectedIndex() - 4));
        }
        if (kategori[3].equalsIgnoreCase("benefit")) {
            data[3] = String.valueOf(kedalamanEfektif.getSelectedIndex() + 1);
        } else {
            data[3] = String.valueOf(Math.abs(kedalamanEfektif.getSelectedIndex() - 4));
        }
        if (kategori[4].equalsIgnoreCase("benefit")) {
            data[4] = String.valueOf(tekstur.getSelectedIndex() + 1);
        } else {
            data[4] = String.valueOf(Math.abs(tekstur.getSelectedIndex() - 4));
        }
        if (kategori[5].equalsIgnoreCase("benefit")) {
            data[5] = String.valueOf(prosentaseBatu.getSelectedIndex() + 1);
        } else {
            data[5] = String.valueOf(Math.abs(prosentaseBatu.getSelectedIndex() - 4));
        }
        if (kategori[6].equalsIgnoreCase("benefit")) {
            data[6] = String.valueOf(genangan.getSelectedIndex() + 1);
        } else {
            data[6] = String.valueOf(Math.abs(genangan.getSelectedIndex() - 4));
        }
        if (kategori[7].equalsIgnoreCase("benefit")) {
            data[7] = String.valueOf(ph.getSelectedIndex() + 1);
        } else {
            data[7] = String.valueOf(Math.abs(ph.getSelectedIndex() - 4));
        }
        if (kategori[8].equalsIgnoreCase("benefit")) {
            data[8] = String.valueOf(n.getSelectedIndex() + 1);
        } else {
            data[8] = String.valueOf(Math.abs(n.getSelectedIndex() - 4));
        }
        if (kategori[9].equalsIgnoreCase("benefit")) {
            data[9] = String.valueOf(p.getSelectedIndex() + 1);
        } else {
            data[9] = String.valueOf(Math.abs(p.getSelectedIndex() - 4));
        }
        if (kategori[10].equalsIgnoreCase("benefit")) {
            data[10] = String.valueOf(k.getSelectedIndex() + 1);
        } else {
            data[10] = String.valueOf(Math.abs(k.getSelectedIndex() - 4));
        }
        if (kategori[11].equalsIgnoreCase("benefit")) {
            data[11] = String.valueOf(salinitas.getSelectedIndex() + 1);
        } else {
            data[11] = String.valueOf(Math.abs(salinitas.getSelectedIndex() - 4));
        }
        if (kategori[12].equalsIgnoreCase("benefit")) {
            data[12] = String.valueOf(kejenuhan.getSelectedIndex() + 1);
        } else {
            data[12] = String.valueOf(Math.abs(kejenuhan.getSelectedIndex() - 4));
        }
        data[13] = idAlternative.getText();
        return data;
    }

    public void setIdAlternative(String id) {
        idAlternative.setText(id);
    }

    public String getIdAlternative() {
        return idAlternative.getText();
    }

    public void saveOnClick(MouseListener mouse) {
        saveForm.addMouseListener(mouse);
    }

    public void cancelOnClick(MouseListener mouse) {
        cancelForm.addMouseListener(mouse);
    }

    public void saveOnHover(String hover) {
        if (hover.equalsIgnoreCase("enter")) {
            panelSaveForm.setBackground(new Color(132, 132, 132));
        } else {
            panelSaveForm.setBackground(new Color(76, 76, 76));
        }
    }

    public void cancelOnHover(String hover) {
        if (hover.equalsIgnoreCase("enter")) {
            panelCancelForm.setBackground(new Color(132, 132, 132));
        } else {
            panelCancelForm.setBackground(new Color(76, 76, 76));
        }
    }

    public void resetForm() {
        curahHujan.setSelectedIndex(0);
        lamaBulanKering.setSelectedIndex(0);
        lereng.setSelectedIndex(0);
        kedalamanEfektif.setSelectedIndex(0);
        tekstur.setSelectedIndex(0);
        prosentaseBatu.setSelectedIndex(0);
        genangan.setSelectedIndex(0);
        ph.setSelectedIndex(0);
        n.setSelectedIndex(0);
        p.setSelectedIndex(0);
        k.setSelectedIndex(0);
        kejenuhan.setSelectedIndex(0);
        salinitas.setSelectedIndex(0);
    }
    
    //================================ Grafik ========================
    public void setGrafik(ChartPanel grafik) {
        this.panelGrafik.removeAll();
        this.panelGrafik.add(grafik);
    }
    
    public void setSaranLahan(String saran) {
        this.lahanCocok.setText(saran);
    }
    
    public void rincianOnClick(ActionListener action) {
        this.rincianAnalisis.addActionListener(action);
    }
    
    //====================== table analisis ====================================
    public DefaultTableModel getTableAnalisisModel(){
        return (DefaultTableModel) this.tableHasilAnalisis.getModel();
    }
    
    public void dataLahanOnClick(MouseListener mouse){
        this.showDataLahan.addMouseListener(mouse);
    }
    
    public void setTableAnalisisModel(DefaultTableModel model){
        this.tableHasilAnalisis.setModel(model);
    }
    
    public void matriksKerjaOnClick(ActionListener action){
        this.hitungRatingKerja.addActionListener(action);
    }
    
    public void matriksPreferensiOnClick(ActionListener action){
        this.hitungPreferensi.addActionListener(action);
    }
    
    public void backTableAnalisisSetIcon(Icon minimizeIcon2) {
        this.backAnalisisLahan.setIcon(minimizeIcon2);
    }
    
    public void backAnalisisOnClick(MouseListener mouse) {
        this.backAnalisisLahan.addMouseListener(mouse);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        minimize = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        panelKriteria = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        formParameter = new javax.swing.JButton();
        panelAnalisis = new javax.swing.JPanel();
        analisis = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        homeImage = new addComponent.image();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        changeAccount = new javax.swing.JButton();
        panelDaftarAlternative = new addComponent.image2();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAlternative = new javax.swing.JTable();
        masukkanAnalisis = new javax.swing.JButton();
        formPengisian = new addComponent.image2();
        panelSaveForm = new addComponent.roundPanel();
        jLabel38 = new javax.swing.JLabel();
        saveForm = new javax.swing.JButton();
        panelCancelForm = new addComponent.roundPanel();
        jLabel39 = new javax.swing.JLabel();
        cancelForm = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        idAlternative = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel43 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jLabel47 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JSeparator();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JSeparator();
        jLabel51 = new javax.swing.JLabel();
        jSeparator24 = new javax.swing.JSeparator();
        detailSubKriteria1 = new javax.swing.JLabel();
        salinitas = new javax.swing.JComboBox<>();
        curahHujan = new javax.swing.JComboBox<>();
        tekstur = new javax.swing.JComboBox<>();
        n = new javax.swing.JComboBox<>();
        lamaBulanKering = new javax.swing.JComboBox<>();
        prosentaseBatu = new javax.swing.JComboBox<>();
        p = new javax.swing.JComboBox<>();
        lereng = new javax.swing.JComboBox<>();
        genangan = new javax.swing.JComboBox<>();
        k = new javax.swing.JComboBox<>();
        kedalamanEfektif = new javax.swing.JComboBox<>();
        ph = new javax.swing.JComboBox<>();
        kejenuhan = new javax.swing.JComboBox<>();
        grafik = new addComponent.image2();
        jLabel57 = new javax.swing.JLabel();
        panelGrafik = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        lahanCocok = new javax.swing.JLabel();
        rincianAnalisis = new javax.swing.JButton();
        hasilAnalisis = new addComponent.image2();
        jLabel59 = new javax.swing.JLabel();
        backAnalisisLahan = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableHasilAnalisis = new javax.swing.JTable();
        hitungRatingKerja = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        hitungPreferensi = new javax.swing.JButton();
        panelShowAnalisis1 = new addComponent.roundPanel();
        showDataLahan = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(130, 146, 149));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/minimize_1.png"))); // NOI18N
        minimize.setToolTipText("Minimize");
        minimize.setBorder(null);
        minimize.setBorderPainted(false);
        minimize.setContentAreaFilled(false);
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.setFocusPainted(false);
        jPanel3.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 30, 40));

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout_1.png"))); // NOI18N
        logout.setToolTipText("Logout");
        logout.setBorder(null);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.setFocusPainted(false);
        jPanel3.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 30, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 40));

        jPanel1.setBackground(new java.awt.Color(96, 91, 120));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(5, 1));

        panelHome.setBackground(new java.awt.Color(136, 133, 151));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Home-96.resized.png"))); // NOI18N
        home.setToolTipText("Home");
        home.setBorder(null);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.setFocusPainted(false);
        panelHome.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 70));

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 238, 238));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Home");
        panelHome.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 120, -1));

        jPanel4.add(panelHome);

        panelKriteria.setBackground(new java.awt.Color(96, 91, 120));
        panelKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 238, 238));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Masukkan Paramter");
        panelKriteria.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 120, -1));

        formParameter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit Property-104.resized.png"))); // NOI18N
        formParameter.setToolTipText("Manage User");
        formParameter.setBorder(null);
        formParameter.setBorderPainted(false);
        formParameter.setContentAreaFilled(false);
        formParameter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        formParameter.setFocusPainted(false);
        panelKriteria.add(formParameter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 70));

        jPanel4.add(panelKriteria);

        panelAnalisis.setBackground(new java.awt.Color(96, 91, 120));
        panelAnalisis.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        analisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Bullish-96.resized.png"))); // NOI18N
        analisis.setToolTipText("Manage User");
        analisis.setBorder(null);
        analisis.setBorderPainted(false);
        analisis.setContentAreaFilled(false);
        analisis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        analisis.setFocusPainted(false);
        panelAnalisis.add(analisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 70));

        jLabel10.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(250, 238, 238));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Hasil Analisis");
        panelAnalisis.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 120, -1));

        jPanel4.add(panelAnalisis);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 120, 500));

        jPanel2.setLayout(new java.awt.CardLayout());

        homeImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(96, 91, 120));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sistem Penunjang Keputusan ");
        homeImage.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 410, -1));

        jLabel2.setFont(new java.awt.Font("Bebas Neue", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(96, 91, 120));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tingkat Kesesuaian Lahan Tanaman KakAo");
        homeImage.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 410, -1));

        changeAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User Shield-1002.png"))); // NOI18N
        changeAccount.setToolTipText("Change Profile");
        changeAccount.setBorder(null);
        changeAccount.setBorderPainted(false);
        changeAccount.setContentAreaFilled(false);
        changeAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changeAccount.setFocusPainted(false);
        homeImage.add(changeAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 150, 120));

        jPanel2.add(homeImage, "card2");

        panelDaftarAlternative.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableAlternative.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ID Alternative", "Nama Alternative"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAlternative);
        if (tableAlternative.getColumnModel().getColumnCount() > 0) {
            tableAlternative.getColumnModel().getColumn(0).setMinWidth(50);
            tableAlternative.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableAlternative.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        panelDaftarAlternative.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 770, 350));

        masukkanAnalisis.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        masukkanAnalisis.setText("Masukkan Analisis");
        masukkanAnalisis.setBorder(null);
        masukkanAnalisis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        masukkanAnalisis.setFocusPainted(false);
        panelDaftarAlternative.add(masukkanAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 150, 30));

        jPanel2.add(panelDaftarAlternative, "card3");

        formPengisian.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSaveForm.setBackground(new java.awt.Color(76, 76, 76));
        panelSaveForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(250, 238, 238));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Save");
        panelSaveForm.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 31));

        saveForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save-96.resized.png"))); // NOI18N
        saveForm.setToolTipText("Manage User");
        saveForm.setBorder(null);
        saveForm.setBorderPainted(false);
        saveForm.setContentAreaFilled(false);
        saveForm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveForm.setFocusPainted(false);
        panelSaveForm.add(saveForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        formPengisian.add(panelSaveForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 90, 80));

        panelCancelForm.setBackground(new java.awt.Color(76, 76, 76));
        panelCancelForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(250, 238, 238));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Cancel");
        panelCancelForm.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 30));

        cancelForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel Subscription-96.resized.png"))); // NOI18N
        cancelForm.setToolTipText("Manage User");
        cancelForm.setBorder(null);
        cancelForm.setBorderPainted(false);
        cancelForm.setContentAreaFilled(false);
        cancelForm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelForm.setFocusPainted(false);
        panelCancelForm.add(cancelForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        formPengisian.add(panelCancelForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 90, 80));

        jLabel35.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(250, 238, 238));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Curah Hujan");
        formPengisian.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, -1));
        formPengisian.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 170, 10));

        idAlternative.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        idAlternative.setForeground(new java.awt.Color(250, 238, 238));
        idAlternative.setText("--");
        formPengisian.add(idAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 560, -1));

        jLabel36.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(250, 238, 238));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Tekstur");
        formPengisian.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 120, -1));
        formPengisian.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 170, 10));
        formPengisian.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 170, 10));

        jLabel37.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(250, 238, 238));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("N");
        formPengisian.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 120, -1));
        formPengisian.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 170, 10));

        jLabel40.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(250, 238, 238));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText("Salinitas");
        formPengisian.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 120, -1));
        formPengisian.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 170, 10));

        jLabel41.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(250, 238, 238));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("Lama Bulan Kering");
        formPengisian.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 120, -1));

        jLabel42.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(250, 238, 238));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel42.setText("Prosentase Batu");
        formPengisian.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 120, -1));
        formPengisian.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 170, 10));

        jLabel43.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(250, 238, 238));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel43.setText("P");
        formPengisian.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 120, -1));
        formPengisian.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 170, 10));
        formPengisian.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 170, 10));

        jLabel45.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(250, 238, 238));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel45.setText("Lereng");
        formPengisian.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 120, -1));

        jLabel46.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(250, 238, 238));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Genangan Air");
        formPengisian.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 120, -1));
        formPengisian.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 170, 10));
        formPengisian.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 170, 10));

        jLabel47.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(250, 238, 238));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel47.setText("K");
        formPengisian.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 120, -1));
        formPengisian.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 170, 10));

        jLabel49.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(250, 238, 238));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel49.setText("Kedalaman Efektif");
        formPengisian.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 120, -1));

        jLabel50.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(250, 238, 238));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel50.setText("Ph");
        formPengisian.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 120, -1));
        formPengisian.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 170, 10));

        jLabel51.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(250, 238, 238));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("Kejenuhan");
        formPengisian.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 120, -1));
        formPengisian.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 170, 10));

        detailSubKriteria1.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        detailSubKriteria1.setForeground(new java.awt.Color(250, 238, 238));
        detailSubKriteria1.setText("Masukkan analisis Lahan :");
        formPengisian.add(detailSubKriteria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        salinitas.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        salinitas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 5", "5 - 19", "20 - 60", "> 60" }));
        formPengisian.add(salinitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 170, -1));

        curahHujan.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        curahHujan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 1100 mm", "1100 - 1250 mm", "1251 - 1500 mm", "> 1500 mm" }));
        formPengisian.add(curahHujan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 170, -1));

        tekstur.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        tekstur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sandy Loam", "Loamy Sand", "Structured Clay", "Gravel" }));
        formPengisian.add(tekstur, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 170, -1));

        n.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        n.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "Sangat Rendah", "Rendah", "Tinggi" }));
        formPengisian.add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 170, -1));

        lamaBulanKering.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        lamaBulanKering.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1 - 2", "3 - 5", "> 5" }));
        formPengisian.add(lamaBulanKering, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 170, -1));

        prosentaseBatu.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        prosentaseBatu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1 - 6", "7 - 14", "> 15" }));
        formPengisian.add(prosentaseBatu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 170, -1));

        p.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        p.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "Sangat Rendah", "Rendah", "Tinggi" }));
        formPengisian.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 170, -1));

        lereng.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        lereng.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 8 Derajat", "8 - 14 Derajat", "15 - 45 Derajat", "> 45 Derajat" }));
        formPengisian.add(lereng, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 170, -1));

        genangan.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        genangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 Hari", "1 Hari", "2 - 7 Hari", "> 7 Hari" }));
        formPengisian.add(genangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 170, -1));

        k.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        k.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "Sangat Rendah", "Rendah", "Tinggi" }));
        formPengisian.add(k, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 170, -1));

        kedalamanEfektif.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        kedalamanEfektif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 60", "61 - 100", "101 - 150", "> 150" }));
        formPengisian.add(kedalamanEfektif, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 170, -1));

        ph.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        ph.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 4.00", "4.1 - 5.0", "5.1 - 6.0", "> 6.0" }));
        formPengisian.add(ph, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 170, -1));

        kejenuhan.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        kejenuhan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 1", "1 - 2", "3 - 6", "> 6" }));
        formPengisian.add(kejenuhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 170, -1));

        jPanel2.add(formPengisian, "card6");

        grafik.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(250, 238, 238));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Grafik Analisis Keseuaian Lahan");
        grafik.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, -1));

        panelGrafik.setOpaque(false);
        panelGrafik.setLayout(new java.awt.GridLayout(1, 1));
        grafik.add(panelGrafik, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 780, 310));

        jLabel53.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(250, 238, 238));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Berdasarkan Analisis diatas, Lahan yang paling cocok adalah :");
        grafik.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 500, -1));

        lahanCocok.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        lahanCocok.setForeground(new java.awt.Color(236, 211, 54));
        lahanCocok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lahanCocok.setText("Grafik Analisis Keseuaian Lahan");
        grafik.add(lahanCocok, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 810, -1));

        rincianAnalisis.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        rincianAnalisis.setText("Rincian Perhitungan");
        rincianAnalisis.setBorder(null);
        rincianAnalisis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        grafik.add(rincianAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 150, 30));

        jPanel2.add(grafik, "card4");

        hasilAnalisis.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(250, 238, 238));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Analisis Lahan");
        hasilAnalisis.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 70));

        backAnalisisLahan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Rewind-100.resized.png"))); // NOI18N
        backAnalisisLahan.setBorder(null);
        backAnalisisLahan.setBorderPainted(false);
        backAnalisisLahan.setContentAreaFilled(false);
        backAnalisisLahan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backAnalisisLahan.setFocusPainted(false);
        hasilAnalisis.add(backAnalisisLahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, 60));

        tableHasilAnalisis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Alt", "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "S11", "S12", "S13"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tableHasilAnalisis);

        hasilAnalisis.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 780, 240));

        hitungRatingKerja.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        hitungRatingKerja.setText("Nilai Rating Kerja");
        hitungRatingKerja.setBorder(null);
        hitungRatingKerja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hasilAnalisis.add(hitungRatingKerja, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 150, 30));

        jLabel67.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(250, 238, 238));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel67.setText("Nama Alternative");
        hasilAnalisis.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, -1));

        jLabel68.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(250, 238, 238));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel68.setText("Keterangan :");
        hasilAnalisis.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 120, -1));

        jLabel69.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(250, 238, 238));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel69.setText("S1  : Curah Hujan");
        hasilAnalisis.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 120, -1));

        jLabel70.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(250, 238, 238));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel70.setText("S2 : Lama Bulan Kering");
        hasilAnalisis.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 120, -1));

        jLabel71.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(250, 238, 238));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("S5 : Tekstur");
        hasilAnalisis.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 120, -1));

        jLabel72.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(250, 238, 238));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel72.setText("S4 : Kedalaman Efektif");
        hasilAnalisis.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 120, -1));

        jLabel75.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(250, 238, 238));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel75.setText("S6 : Prosentase Batu");
        hasilAnalisis.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 120, -1));

        jLabel76.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(250, 238, 238));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel76.setText("S7 : Genangan Air");
        hasilAnalisis.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 120, -1));

        jLabel77.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(250, 238, 238));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel77.setText("S8 : Ph");
        hasilAnalisis.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 120, -1));

        jLabel80.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(250, 238, 238));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("S9 : N");
        hasilAnalisis.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 120, -1));

        jLabel81.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(250, 238, 238));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("S10 : P");
        hasilAnalisis.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 120, -1));

        jLabel83.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(250, 238, 238));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("S12 : Salinitas");
        hasilAnalisis.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 120, -1));

        jLabel85.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(250, 238, 238));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel85.setText("S13 : Kejenuhan");
        hasilAnalisis.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 120, -1));

        jLabel86.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(250, 238, 238));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel86.setText("S11 : K");
        hasilAnalisis.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 120, -1));

        hitungPreferensi.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        hitungPreferensi.setText("Nilai Preferensi");
        hitungPreferensi.setBorder(null);
        hitungPreferensi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hasilAnalisis.add(hitungPreferensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 150, 30));

        panelShowAnalisis1.setBackground(new java.awt.Color(76, 76, 76));
        panelShowAnalisis1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showDataLahan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hasil.png"))); // NOI18N
        showDataLahan.setToolTipText("Hasil Lapangan");
        showDataLahan.setBorder(null);
        showDataLahan.setBorderPainted(false);
        showDataLahan.setContentAreaFilled(false);
        showDataLahan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showDataLahan.setFocusPainted(false);
        panelShowAnalisis1.add(showDataLahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 90));

        hasilAnalisis.add(panelShowAnalisis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 110, 90));

        jLabel62.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(250, 238, 238));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel62.setText("S3 : Lereng");
        hasilAnalisis.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 120, -1));

        jPanel2.add(hasilAnalisis, "card5");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 810, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analisis;
    private javax.swing.JButton backAnalisisLahan;
    private javax.swing.JButton cancelForm;
    private javax.swing.JButton changeAccount;
    private javax.swing.JComboBox<String> curahHujan;
    private javax.swing.JLabel detailSubKriteria1;
    private javax.swing.JButton formParameter;
    private addComponent.image2 formPengisian;
    private javax.swing.JComboBox<String> genangan;
    private addComponent.image2 grafik;
    private addComponent.image2 hasilAnalisis;
    private javax.swing.JButton hitungPreferensi;
    private javax.swing.JButton hitungRatingKerja;
    private javax.swing.JButton home;
    private addComponent.image homeImage;
    private javax.swing.JLabel idAlternative;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JComboBox<String> k;
    private javax.swing.JComboBox<String> kedalamanEfektif;
    private javax.swing.JComboBox<String> kejenuhan;
    private javax.swing.JLabel lahanCocok;
    private javax.swing.JComboBox<String> lamaBulanKering;
    private javax.swing.JComboBox<String> lereng;
    private javax.swing.JButton logout;
    private javax.swing.JButton masukkanAnalisis;
    private javax.swing.JButton minimize;
    private javax.swing.JComboBox<String> n;
    private javax.swing.JComboBox<String> p;
    private javax.swing.JPanel panelAnalisis;
    private addComponent.roundPanel panelCancelForm;
    private addComponent.image2 panelDaftarAlternative;
    private javax.swing.JPanel panelGrafik;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelKriteria;
    private addComponent.roundPanel panelSaveForm;
    private addComponent.roundPanel panelShowAnalisis1;
    private javax.swing.JComboBox<String> ph;
    private javax.swing.JComboBox<String> prosentaseBatu;
    private javax.swing.JButton rincianAnalisis;
    private javax.swing.JComboBox<String> salinitas;
    private javax.swing.JButton saveForm;
    private javax.swing.JButton showDataLahan;
    private javax.swing.JTable tableAlternative;
    private javax.swing.JTable tableHasilAnalisis;
    private javax.swing.JComboBox<String> tekstur;
    // End of variables declaration//GEN-END:variables
}
