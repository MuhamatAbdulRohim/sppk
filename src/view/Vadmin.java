/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author rohim
 */
public class Vadmin extends javax.swing.JFrame {

    SimpleDateFormat formatDate = new SimpleDateFormat("dd MMM yyyy");
    SimpleDateFormat formatDateSql = new SimpleDateFormat("yyyy-MM-dd");
    Date date;

    public Vadmin() {
        initComponents();
        date = new Date();
        setTanggalMasukUser(formatDate.format(date));
        this.tanggalLahirUser.setDate(date);
        this.setLocationRelativeTo(this);
    }

    public String getPanelUtama() {
        if (homeImage.isVisible()) {
            return "home";
        } else if (userImage.isVisible()) {
            return "user";
        } else if (kriteriaImage.isVisible()) {
            return "kriteria";
        } else if (subKriteriaImage.isVisible()) {
            return "subkriteria";
        } else {
            return "analisis";
        }
    }

    public void minimizeSetIcon(Icon minimizeIcon2) {
        this.minimize.setIcon(minimizeIcon2);
    }

    public void logoutSetIcon(Icon minimizeIcon2) {
        this.logout.setIcon(minimizeIcon2);
    }

    public void backGrafikSetIcon(Icon minimizeIcon2) {
        this.backGrafik.setIcon(minimizeIcon2);
    }

    public void backTableAnalisisSetIcon(Icon minimizeIcon2) {
        this.backTableAnalisis.setIcon(minimizeIcon2);
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

    public void setPanelUtama(String panel) {
        this.setBackgroundPanel(getPanelUtama(), new Color(96, 91, 120));
        if (panel.equalsIgnoreCase("home")) {
            this.homeImage.setVisible(true);
            this.userImage.setVisible(false);
            this.kriteriaImage.setVisible(false);
            this.subKriteriaImage.setVisible(false);
            this.analisisImage.setVisible(false);
            this.grafikImage.setVisible(false);
            this.tableAnalisisImage.setVisible(false);
        } else if (panel.equalsIgnoreCase("user")) {
            this.homeImage.setVisible(false);
            this.userImage.setVisible(true);
            this.kriteriaImage.setVisible(false);
            this.subKriteriaImage.setVisible(false);
            this.analisisImage.setVisible(false);
            this.grafikImage.setVisible(false);
            this.tableAnalisisImage.setVisible(false);
        } else if (panel.equalsIgnoreCase("kriteria")) {
            this.homeImage.setVisible(false);
            this.userImage.setVisible(false);
            this.kriteriaImage.setVisible(true);
            this.subKriteriaImage.setVisible(false);
            this.analisisImage.setVisible(false);
            this.grafikImage.setVisible(false);
            this.tableAnalisisImage.setVisible(false);
        } else if (panel.equalsIgnoreCase("subkriteria")) {
            this.homeImage.setVisible(false);
            this.userImage.setVisible(false);
            this.kriteriaImage.setVisible(false);
            this.subKriteriaImage.setVisible(true);
            this.analisisImage.setVisible(false);
            this.grafikImage.setVisible(false);
            this.tableAnalisisImage.setVisible(false);
        } else if (panel.equalsIgnoreCase("analisis")) {
            this.homeImage.setVisible(false);
            this.userImage.setVisible(false);
            this.kriteriaImage.setVisible(false);
            this.subKriteriaImage.setVisible(false);
            this.analisisImage.setVisible(true);
            this.grafikImage.setVisible(false);
            this.tableAnalisisImage.setVisible(false);
        } else if (panel.equalsIgnoreCase("tableAnalisis")) {
            this.homeImage.setVisible(false);
            this.userImage.setVisible(false);
            this.kriteriaImage.setVisible(false);
            this.subKriteriaImage.setVisible(false);
            this.analisisImage.setVisible(false);
            this.grafikImage.setVisible(false);
            this.tableAnalisisImage.setVisible(true);
        } else {
            this.homeImage.setVisible(false);
            this.userImage.setVisible(false);
            this.kriteriaImage.setVisible(false);
            this.subKriteriaImage.setVisible(false);
            this.analisisImage.setVisible(false);
            this.grafikImage.setVisible(true);
            this.tableAnalisisImage.setVisible(false);
        }
        this.setBackgroundPanel(panel, new Color(136, 133, 151));
    }

    public void setBackgroundPanel(String panel, Color color) {
        if (panel.equalsIgnoreCase("home")) {
            this.panelHome.setBackground(color);
        } else if (panel.equalsIgnoreCase("user")) {
            this.panelUser.setBackground(color);
        } else if (panel.equalsIgnoreCase("kriteria")) {
            this.panelKriteria.setBackground(color);
        } else if (panel.equalsIgnoreCase("subkriteria")) {
            this.panelSubKriteria.setBackground(color);
        } else if (panel.equalsIgnoreCase("analisis")) {
            this.panelAnalisis.setBackground(color);
        } else if (panel.equalsIgnoreCase("addUser")) {
            this.panelAddUser.setBackground(color);
        } else if (panel.equalsIgnoreCase("editUser")) {
            this.panelEditUser.setBackground(color);
        } else if (panel.equalsIgnoreCase("deleteUser")) {
            this.panelHapusUser.setBackground(color);
        } else if (panel.equalsIgnoreCase("cancelUser")) {
            this.panelCancelUser.setBackground(color);
        } else if (panel.equalsIgnoreCase("saveUser")) {
            this.panelSaveUser.setBackground(color);
        } else if (panel.equalsIgnoreCase("editKriteria")) {
            this.panelEditKriteria.setBackground(color);
        } else if (panel.equalsIgnoreCase("cancelKriteria")) {
            this.panelCancelKriteria.setBackground(color);
        } else if (panel.equalsIgnoreCase("saveKriteria")) {
            this.panelSaveKriteria.setBackground(color);
        } else if (panel.equalsIgnoreCase("editSubKriteria")) {
            this.panelEditSubKriteria.setBackground(color);
        } else if (panel.equalsIgnoreCase("cancelSubKriteria")) {
            this.panelCancelSubKriteria.setBackground(color);
        } else if (panel.equalsIgnoreCase("saveSubKriteria")) {
            this.panelSaveSubKriteria.setBackground(color);
        } else if (panel.equalsIgnoreCase("addAlternative")) {
            this.panelAddAlternative.setBackground(color);
        } else if (panel.equalsIgnoreCase("editAlternative")) {
            this.panelEditAlternative.setBackground(color);
        } else if (panel.equalsIgnoreCase("deleteAlternative")) {
            this.panelHapusAlternative.setBackground(color);
        } else if (panel.equalsIgnoreCase("cancelAlternative")) {
            this.panelCancelAlternative.setBackground(color);
        } else if (panel.equalsIgnoreCase("saveAlternative")) {
            this.panelSaveAlternative.setBackground(color);
        } else if (panel.equalsIgnoreCase("showAnalisis")) {
            this.panelShowAnalisis.setBackground(color);
        } else if (panel.equalsIgnoreCase("showDataLahan")) {
            this.panelDataLahan.setBackground(color);
        }
    }

    public void setModelTableUser(DefaultTableModel model) {
        this.tableUser.setModel(model);
    }

    public DefaultTableModel getModelTableUser() {
        return (DefaultTableModel) tableUser.getModel();
    }

    public void setTableUserEnable(boolean enable) {
        this.tableUser.setEnabled(enable);
        this.addUser.setEnabled(enable);
        this.editUser.setEnabled(enable);
        this.hapusUser.setEnabled(enable);
    }

    public String getSelectedTableUser() {
        return tableUser.getValueAt(tableUser.getSelectedRow(), 1).toString();
    }

    public boolean isTableUserSelected() {
        if (tableUser.getSelectedRow() == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void clearSelectionTableUser() {
        this.tableUser.clearSelection();
    }

    public boolean isTableUserEnable() {
        return tableUser.isEnabled();
    }

    public void setPanelFormUser(String panel) {
        if (panel.equalsIgnoreCase("homeForm")) {
            this.panelAddUser.setBackground(new Color(76, 76, 76));
            this.panelEditUser.setBackground(new Color(76, 76, 76));
            this.panelHapusUser.setBackground(new Color(76, 76, 76));
            this.homeForm.setVisible(true);
            this.panelFormUser.setVisible(false);
            setTableUserEnable(true);
        } else {
            this.panelFormUser.setVisible(true);
            this.homeForm.setVisible(false);
            setTableUserEnable(false);
        }
    }

    public void resetForm() {
        setDetailUser("Detail User");
        setNamaUser("Nama User");
        setAlamatUser("Alamat User");
        setTempatLahirUser("Tempat Lahir");
        this.tanggalLahirUser.setDate(date);
        setTanggalMasukUser(formatDate.format(date));
    }

    public String getDetailUser() {
        return this.detailUser.getText();
    }

    public void setDetailUser(String text) {
        this.detailUser.setText(text);
    }

    public void setNamaUser(String nama) {
        this.namaUser.setText(nama);
    }

    public void setAlamatUser(String nama) {
        this.alamatUser.setText(nama);
    }

    public void setTempatLahirUser(String nama) {
        this.tempatLahirUser.setText(nama);
    }

    public void setTanggalLahirUser(String nama) throws ParseException {
        Date tanggal = formatDateSql.parse(nama);
        this.tanggalLahirUser.setDate(tanggal);
    }

    public void setTanggalMasukUser(String nama) {
        this.tanggalMasukUser.setText(nama);
    }

    public void setDataUser(String dataUser[]) throws ParseException {
        setNamaUser(dataUser[0]);
        setAlamatUser(dataUser[1]);
        setTempatLahirUser(dataUser[2]);
        setTanggalLahirUser(dataUser[3]);
        setTanggalMasukUser(dataUser[4]);
    }

    public String[] getDataUser() {
        String dataUser[] = new String[4];
        dataUser[0] = namaUser.getText();
        dataUser[1] = alamatUser.getText();
        dataUser[2] = tempatLahirUser.getText();
        dataUser[3] = formatDateSql.format(tanggalLahirUser.getDate());
        return dataUser;
    }

    public void changeAccountOnClick(ActionListener action){
        this.changeAccount.addActionListener(action);
    }
    
    public void logoutOnClick(MouseListener mouse) {
        this.logout.addMouseListener(mouse);
    }

    public void minimizeOnClick(MouseListener mouse) {
        this.minimize.addMouseListener(mouse);
    }

    public void backGrafikOnClick(MouseListener mouse) {
        this.backGrafik.addMouseListener(mouse);
    }

    public void backAnalisisOnClick(MouseListener mouse) {
        this.backTableAnalisis.addMouseListener(mouse);
    }

    public void homeOnClick(MouseListener mouse) {
        this.home.addMouseListener(mouse);
    }

    public void userOnClick(MouseListener mouse) {
        this.user.addMouseListener(mouse);
    }

    public void kriteriaOnClick(MouseListener mouse) {
        this.kriteria.addMouseListener(mouse);
    }

    public void subKriteriaOnClick(MouseListener mouse) {
        this.subkriteria.addMouseListener(mouse);
    }

    public void analisisOnClick(MouseListener mouse) {
        this.analisis.addMouseListener(mouse);
    }

    public void addUserOnClick(MouseListener mouse) {
        this.addUser.addMouseListener(mouse);
    }

    public void editUserOnClick(MouseListener mouse) {
        this.editUser.addMouseListener(mouse);
    }

    public void deleteUserOnClick(MouseListener mouse) {
        this.hapusUser.addMouseListener(mouse);
    }

    public void cancelUserOnClick(MouseListener mouse) {
        this.cancelUser.addMouseListener(mouse);
    }

    public void saveUserOnClick(MouseListener mouse) {
        this.saveUser.addMouseListener(mouse);
    }

    public void namaUserOnFocus(FocusListener focus) {
        this.namaUser.addFocusListener(focus);
    }

    public void alamatUserOnFocus(FocusListener focus) {
        this.alamatUser.addFocusListener(focus);
    }

    public void tempatLahirUserOnFocus(FocusListener focus) {
        this.tempatLahirUser.addFocusListener(focus);
    }

    public void tglLahirUserOnFocus(FocusListener focus) {
        this.tanggalLahirUser.addFocusListener(focus);
    }

    //======================= Kriteria ======================================
    public void setModelTableKriteria(DefaultTableModel model) {
        setTanggalMasukKriteria(formatDate.format(date));
        this.tableKriteria.setModel(model);
    }

    public DefaultTableModel getModelTableKriteria() {
        return (DefaultTableModel) tableKriteria.getModel();
    }

    public void setDetailKriteria(String text) {
        this.detailKriteria.setText(text);
    }

    public void setNamaKriteria(String nama) {
        this.namaKriteria.setText(nama);
    }

    public void setTanggalMasukKriteria(String nama) {
        this.tanggalMasukKriteria.setText(nama);
    }

    public void setTableKriteriaEnable(boolean enable) {
        this.tableKriteria.setEnabled(enable);
        this.editKriteria.setEnabled(enable);
    }

    public String getSelectedTableKriteria() {
        return tableKriteria.getValueAt(tableKriteria.getSelectedRow(), 1).toString();
    }

    public void clearSelectionTableKriteria() {
        this.tableKriteria.clearSelection();
    }

    public boolean isTableKriteriaEnable() {
        return tableKriteria.isEnabled();
    }

    public void setPanelFormKriteria(String panel) {
        if (panel.equalsIgnoreCase("homeForm")) {
            this.panelEditKriteria.setBackground(new Color(76, 76, 76));
            this.homeFormKriteria.setVisible(true);
            this.panelFormKriteria.setVisible(false);
            setTableKriteriaEnable(true);
        } else {
            this.panelFormKriteria.setVisible(true);
            this.homeFormKriteria.setVisible(false);
            setTableKriteriaEnable(false);
        }
    }

    public void resetFormKriteria() {
        setDetailKriteria("Detail Kriteria");
        setNamaKriteria("Nama Kriteria");
        setTanggalMasukKriteria(formatDate.format(date));
    }

    public void setDataKriteria(String dataKriteria[]) throws ParseException {
        setNamaKriteria(dataKriteria[0]);
        setTanggalMasukKriteria(dataKriteria[1]);
    }

    public boolean isTableKriteriaSelected() {
        if (tableKriteria.getSelectedRow() == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String getDataKriteria() {
        return namaKriteria.getText();
    }

    public String getDetailKriteria() {
        return this.detailKriteria.getText();
    }

    public void editKriteriaOnClick(MouseListener mouse) {
        this.editKriteria.addMouseListener(mouse);
    }

    public void cancelKriteriaOnClick(MouseListener mouse) {
        this.cancelKriteria.addMouseListener(mouse);
    }

    public void saveKriteriaOnClick(MouseListener mouse) {
        this.saveKriteria.addMouseListener(mouse);
    }

    public void namaKriteriaOnFocus(FocusListener focus) {
        this.namaKriteria.addFocusListener(focus);
    }

    //====================== Sub Kriteria =====================================
    public void setModelTableSubKriteria(DefaultTableModel model) {
        this.tableSubKriteria.setModel(model);
    }

    public DefaultTableModel getModelTableSubKriteria() {
        return (DefaultTableModel) tableSubKriteria.getModel();
    }

    public void setDetailSubKriteria(String text) {
        this.detailSubKriteria.setText(text);
    }

    public void setKriteria(String kriteria) {
        this.comboBoxKriteria.setText(kriteria);
    }

    public void setNamaSubKriteria(String nama) {
        this.namaSubKriteria.setText(nama);
    }

    public void setKategori(String kategori) {
        this.comboBoxKategori.setSelectedItem(kategori);
    }

    public void setBobotSubKriteria(String bobot) {
        this.bobotSubKriteria.setText(bobot);
    }
//
//    public void setKesesuaianMinSubKriteria(String kesesuaian) {
//        this.nilaiKesesuaianMin.setText(kesesuaian);
//    }
//
//    public void setKesesuaianMaxSubKriteria(String kesesuaian) {
//        this.nilaiKesesuaianMax.setText(kesesuaian);
//    }

    public void setTableSubKriteriaEnable(boolean enable) {
        this.tableSubKriteria.setEnabled(enable);
        this.editSubKriteria.setEnabled(enable);
    }

    public String getSelectedTableSubKriteria() {
        return tableSubKriteria.getValueAt(tableSubKriteria.getSelectedRow(), 1).toString();
    }

    public void clearSelectionTableSubKriteria() {
        this.tableSubKriteria.clearSelection();
    }

    public boolean isTableSubKriteriaEnable() {
        return tableSubKriteria.isEnabled();
    }

    public void setPanelFormSubKriteria(String panel) {
        if (panel.equalsIgnoreCase("homeForm")) {
            this.panelEditSubKriteria.setBackground(new Color(76, 76, 76));
            this.homeFormSubKriteria.setVisible(true);
            this.panelFormSubKriteria.setVisible(false);
            setTableSubKriteriaEnable(true);
        } else {
            this.panelFormSubKriteria.setVisible(true);
            this.homeFormSubKriteria.setVisible(false);
            setTableSubKriteriaEnable(false);
        }
    }

    public void resetFormSubKriteria() {
        setDetailSubKriteria("Detail Sub Kriteria");
        this.comboBoxKriteria.setText("Nama Kriteria");
        setNamaSubKriteria("Nama Sub Kriteria");
        this.comboBoxKategori.setSelectedIndex(0);
        setBobotSubKriteria("Nilai Bobot");
//        setKesesuaianMinSubKriteria("Nilai Keseuaian");
//        setKesesuaianMaxSubKriteria("Nilai Keseuaian");
    }

    public void setDataSubKriteria(String dataSubKriteria[]) throws ParseException {
        setKriteria(dataSubKriteria[0]);
        setNamaSubKriteria(dataSubKriteria[1]);
        setKategori(dataSubKriteria[2]);
        setBobotSubKriteria(dataSubKriteria[3]);
//        setKesesuaianMinSubKriteria(dataSubKriteria[4]);
//        setKesesuaianMaxSubKriteria(dataSubKriteria[5]);
    }

    public boolean isTableSubKriteriaSelected() {
        if (tableSubKriteria.getSelectedRow() == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String[] getDataSubKriteria() {
        String data[] = new String[6];
        data[0] = this.comboBoxKriteria.getText();
        data[1] = this.namaSubKriteria.getText();
        data[2] = this.comboBoxKategori.getSelectedItem().toString();
        data[3] = this.bobotSubKriteria.getText();
        return data;
    }

    public String getDetailSubKriteria() {
        return this.detailSubKriteria.getText();
    }

    public void editSubKriteriaOnClick(MouseListener mouse) {
        this.editSubKriteria.addMouseListener(mouse);
    }

    public void cancelSubKriteriaOnClick(MouseListener mouse) {
        this.cancelSubKriteria.addMouseListener(mouse);
    }

    public void saveSubKriteriaOnClick(MouseListener mouse) {
        this.saveSubKriteria.addMouseListener(mouse);
    }

    public void namaSubKriteriaOnFocus(FocusListener focus) {
        this.comboBoxKriteria.addFocusListener(focus);
    }

    public void bobotSubKriteriaOnFocus(FocusListener focus) {
        this.bobotSubKriteria.addFocusListener(focus);
    }

//    public void kesesuaianMinSubKriteriaOnFocus(FocusListener focus) {
//        this.nilaiKesesuaianMin.addFocusListener(focus);
//    }
//
//    public void keseuaianMaxSubKriteriaOnFocus(FocusListener focus) {
//        this.nilaiKesesuaianMax.addFocusListener(focus);
//    }

    //======================= Alternative ======================================
    public void setModelTableAlternative(DefaultTableModel model) {
        this.tableAlternative.setModel(model);
    }

    public DefaultTableModel getModelTableAlternative() {
        return (DefaultTableModel) tableAlternative.getModel();
    }

    public void setDetailAlternative(String text) {
        this.detailAlternative.setText(text);
    }

    public void setNamaAlternative(String nama) {
        this.namaAlternative.setText(nama);
    }

    public void setAlamatAlternative(String nama) {
        this.alamatAlternative.setText(nama);
    }

    public void setTableAlternativeEnable(boolean enable) {
        this.tableAlternative.setEnabled(enable);
        this.addAlternative.setEnabled(enable);
        this.editAlternative.setEnabled(enable);
        this.hapusAlternative.setEnabled(enable);
    }

    public String getSelectedTableAlternative() {
        return tableAlternative.getValueAt(tableAlternative.getSelectedRow(), 1).toString();
    }

    public void clearSelectionTableAlternative() {
        this.tableAlternative.clearSelection();
    }

    public boolean isTableAlternativeEnable() {
        return tableAlternative.isEnabled();
    }

    public void setPanelFormAlternative(String panel) {
        if (panel.equalsIgnoreCase("homeForm")) {
            this.panelAddAlternative.setBackground(new Color(76, 76, 76));
            this.panelEditAlternative.setBackground(new Color(76, 76, 76));
            this.panelHapusAlternative.setBackground(new Color(76, 76, 76));
            this.homeFormAlternative.setVisible(true);
            this.panelFormAlternative.setVisible(false);
            setTableAlternativeEnable(true);
        } else {
            this.panelFormAlternative.setVisible(true);
            this.homeFormAlternative.setVisible(false);
            setTableAlternativeEnable(false);
        }
    }

    public void resetFormAlternative() {
        setDetailAlternative("Detail Alternative");
        setNamaAlternative("Nama Alternative");
        setAlamatAlternative("Alamat Alternative");
    }

    public void setDataAlternative(String dataKriteria[]) throws ParseException {
        setNamaAlternative(dataKriteria[0]);
        setAlamatAlternative(dataKriteria[1]);
    }

    public boolean isTableAlternativeSelected() {
        if (tableAlternative.getSelectedRow() == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String[] getDataAlternative() {
        String data[] = new String[2];
        data[0] = namaAlternative.getText();
        data[1] = alamatAlternative.getText();
        return data;
    }

    public String getDetailAlternative() {
        return this.detailAlternative.getText();
    }

    public void showAnalisisOnClick(MouseListener mouse) {
        this.showAnalisis.addMouseListener(mouse);
    }

    public void addAlternativeOnClick(MouseListener mouse) {
        this.addAlternative.addMouseListener(mouse);
    }

    public void editAlternativeOnClick(MouseListener mouse) {
        this.editAlternative.addMouseListener(mouse);
    }

    public void deleteAlternativeOnClick(MouseListener mouse) {
        this.hapusAlternative.addMouseListener(mouse);
    }

    public void cancelAlternativeOnClick(MouseListener mouse) {
        this.cancelAlternative.addMouseListener(mouse);
    }

    public void saveAlternativeOnClick(MouseListener mouse) {
        this.saveAlternative.addMouseListener(mouse);
    }

    public void namaAlternativeOnFocus(FocusListener focus) {
        this.namaAlternative.addFocusListener(focus);
    }

    public void alamatAlternativeOnFocus(FocusListener focus) {
        this.alamatAlternative.addFocusListener(focus);
    }

    //============================ Analisis ====================================
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
        panelUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JButton();
        panelKriteria = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        kriteria = new javax.swing.JButton();
        panelSubKriteria = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        subkriteria = new javax.swing.JButton();
        panelAnalisis = new javax.swing.JPanel();
        analisis = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        homeImage = new addComponent.image();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        changeAccount = new javax.swing.JButton();
        userImage = new addComponent.image2();
        panelTableUser = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        panelAddUser = new addComponent.roundPanel();
        jLabel15 = new javax.swing.JLabel();
        addUser = new javax.swing.JButton();
        panelEditUser = new addComponent.roundPanel();
        jLabel16 = new javax.swing.JLabel();
        editUser = new javax.swing.JButton();
        panelHapusUser = new addComponent.roundPanel();
        jLabel8 = new javax.swing.JLabel();
        hapusUser = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        homeForm = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        panelFormUser = new javax.swing.JPanel();
        detailUser = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        namaUser = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        alamatUser = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        tempatLahirUser = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        tanggalMasukUser = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        panelSaveUser = new addComponent.roundPanel();
        jLabel18 = new javax.swing.JLabel();
        saveUser = new javax.swing.JButton();
        panelCancelUser = new addComponent.roundPanel();
        jLabel17 = new javax.swing.JLabel();
        cancelUser = new javax.swing.JButton();
        tanggalLahirUser = new com.toedter.calendar.JDateChooser();
        kriteriaImage = new addComponent.image2();
        panelTableKriteria = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableKriteria = new javax.swing.JTable();
        panelEditKriteria = new addComponent.roundPanel();
        jLabel22 = new javax.swing.JLabel();
        editKriteria = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        homeFormKriteria = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        panelFormKriteria = new javax.swing.JPanel();
        detailKriteria = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        namaKriteria = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        tanggalMasukKriteria = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        panelSaveKriteria = new addComponent.roundPanel();
        jLabel31 = new javax.swing.JLabel();
        saveKriteria = new javax.swing.JButton();
        panelCancelKriteria = new addComponent.roundPanel();
        jLabel32 = new javax.swing.JLabel();
        cancelKriteria = new javax.swing.JButton();
        subKriteriaImage = new addComponent.image2();
        panelTableUser1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSubKriteria = new javax.swing.JTable();
        panelEditSubKriteria = new addComponent.roundPanel();
        jLabel41 = new javax.swing.JLabel();
        editSubKriteria = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        homeFormSubKriteria = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        panelFormSubKriteria = new javax.swing.JPanel();
        detailSubKriteria = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        comboBoxKriteria = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        bobotSubKriteria = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        panelSaveSubKriteria = new addComponent.roundPanel();
        jLabel38 = new javax.swing.JLabel();
        saveSubKriteria = new javax.swing.JButton();
        panelCancelSubKriteria = new addComponent.roundPanel();
        jLabel39 = new javax.swing.JLabel();
        cancelSubKriteria = new javax.swing.JButton();
        comboBoxKategori = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        namaSubKriteria = new javax.swing.JTextField();
        analisisImage = new addComponent.image2();
        panelTableUser2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAlternative = new javax.swing.JTable();
        panelAddAlternative = new addComponent.roundPanel();
        jLabel47 = new javax.swing.JLabel();
        addAlternative = new javax.swing.JButton();
        panelEditAlternative = new addComponent.roundPanel();
        jLabel48 = new javax.swing.JLabel();
        editAlternative = new javax.swing.JButton();
        panelHapusAlternative = new addComponent.roundPanel();
        jLabel49 = new javax.swing.JLabel();
        hapusAlternative = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        homeFormAlternative = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        panelShowAnalisis = new addComponent.roundPanel();
        showAnalisis = new javax.swing.JButton();
        panelFormAlternative = new javax.swing.JPanel();
        detailAlternative = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        namaAlternative = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        alamatAlternative = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        panelSaveAlternative = new addComponent.roundPanel();
        jLabel55 = new javax.swing.JLabel();
        saveAlternative = new javax.swing.JButton();
        panelCancelAlternative = new addComponent.roundPanel();
        jLabel56 = new javax.swing.JLabel();
        cancelAlternative = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        grafikImage = new addComponent.image2();
        panelGrafik = new javax.swing.JPanel();
        lahanCocok = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        backGrafik = new javax.swing.JButton();
        rincianAnalisis = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        tableAnalisisImage = new addComponent.image2();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableHasilAnalisis = new javax.swing.JTable();
        jLabel59 = new javax.swing.JLabel();
        backTableAnalisis = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        hitungRatingKerja = new javax.swing.JButton();
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
        panelDataLahan = new addComponent.roundPanel();
        showDataLahan = new javax.swing.JButton();

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

        panelUser.setBackground(new java.awt.Color(96, 91, 120));
        panelUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 238, 238));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage User");
        panelUser.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 120, -1));

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User Group Man Man-96.resized.png"))); // NOI18N
        user.setToolTipText("Manage User");
        user.setBorder(null);
        user.setBorderPainted(false);
        user.setContentAreaFilled(false);
        user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        user.setFocusPainted(false);
        panelUser.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 70));

        jPanel4.add(panelUser);

        panelKriteria.setBackground(new java.awt.Color(96, 91, 120));
        panelKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 238, 238));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Manage Criteria");
        panelKriteria.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 120, -1));

        kriteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit Property-104.resized.png"))); // NOI18N
        kriteria.setToolTipText("Manage User");
        kriteria.setBorder(null);
        kriteria.setBorderPainted(false);
        kriteria.setContentAreaFilled(false);
        kriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kriteria.setFocusPainted(false);
        panelKriteria.add(kriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 70));

        jPanel4.add(panelKriteria);

        panelSubKriteria.setBackground(new java.awt.Color(96, 91, 120));
        panelSubKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(250, 238, 238));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Manage Subcriteria");
        panelSubKriteria.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 120, -1));

        subkriteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit Property-96.resized.png"))); // NOI18N
        subkriteria.setToolTipText("Manage User");
        subkriteria.setBorder(null);
        subkriteria.setBorderPainted(false);
        subkriteria.setContentAreaFilled(false);
        subkriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subkriteria.setFocusPainted(false);
        panelSubKriteria.add(subkriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 70));

        jPanel4.add(panelSubKriteria);

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
        jLabel10.setText("Alternative");
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

        jLabel2.setFont(new java.awt.Font("Bebas Neue", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(96, 91, 120));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tingkat Kesesuaian Lahan Tanaman KakAo");
        homeImage.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 410, -1));

        jLabel3.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(96, 91, 120));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sistem Penunjang Keputusan ");
        homeImage.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 410, -1));

        changeAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User Shield-1002.png"))); // NOI18N
        changeAccount.setToolTipText("Change Profile");
        changeAccount.setBorder(null);
        changeAccount.setBorderPainted(false);
        changeAccount.setContentAreaFilled(false);
        changeAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changeAccount.setFocusPainted(false);
        homeImage.add(changeAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 150, 120));

        jPanel2.add(homeImage, "card2");

        userImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTableUser.setOpaque(false);
        panelTableUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "ID Pegawai", "Nama", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUser.setOpaque(false);
        tableUser.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(tableUser);
        if (tableUser.getColumnModel().getColumnCount() > 0) {
            tableUser.getColumnModel().getColumn(0).setMinWidth(50);
            tableUser.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableUser.getColumnModel().getColumn(0).setMaxWidth(50);
            tableUser.getColumnModel().getColumn(3).setMinWidth(80);
            tableUser.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableUser.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        panelTableUser.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 310));

        panelAddUser.setBackground(new java.awt.Color(76, 76, 76));
        panelAddUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(250, 238, 238));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Add");
        panelAddUser.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 30));

        addUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add User Male-96.resized.png"))); // NOI18N
        addUser.setToolTipText("Manage User");
        addUser.setBorder(null);
        addUser.setBorderPainted(false);
        addUser.setContentAreaFilled(false);
        addUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUser.setFocusPainted(false);
        panelAddUser.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelTableUser.add(panelAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 90, 80));

        panelEditUser.setBackground(new java.awt.Color(76, 76, 76));
        panelEditUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(250, 238, 238));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Edit");
        panelEditUser.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 30));

        editUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit User Male-96.resized.png"))); // NOI18N
        editUser.setToolTipText("Manage User");
        editUser.setBorder(null);
        editUser.setBorderPainted(false);
        editUser.setContentAreaFilled(false);
        editUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editUser.setFocusPainted(false);
        panelEditUser.add(editUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelTableUser.add(panelEditUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 90, 80));

        panelHapusUser.setBackground(new java.awt.Color(76, 76, 76));
        panelHapusUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(250, 238, 238));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Delete");
        panelHapusUser.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 31));

        hapusUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete-96.resized.png"))); // NOI18N
        hapusUser.setToolTipText("Manage User");
        hapusUser.setBorder(null);
        hapusUser.setBorderPainted(false);
        hapusUser.setContentAreaFilled(false);
        hapusUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hapusUser.setFocusPainted(false);
        panelHapusUser.add(hapusUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelTableUser.add(panelHapusUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 90, 80));

        userImage.add(panelTableUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 470));

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.CardLayout());

        homeForm.setOpaque(false);
        homeForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User Shield-100.png"))); // NOI18N
        homeForm.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel19.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(192, 189, 205));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Sistem Penunjang Keputusan ");
        homeForm.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 310, -1));

        jLabel20.setFont(new java.awt.Font("Bebas Neue", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(192, 189, 205));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Tingkat Kesesuaian Lahan Tanaman KakAo");
        homeForm.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 330, -1));

        jPanel5.add(homeForm, "card2");

        panelFormUser.setOpaque(false);
        panelFormUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        detailUser.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        detailUser.setForeground(new java.awt.Color(250, 238, 238));
        detailUser.setText("Detail User");
        panelFormUser.add(detailUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(250, 238, 238));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Nama");
        panelFormUser.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, -1));

        namaUser.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        namaUser.setForeground(new java.awt.Color(165, 163, 174));
        namaUser.setText("Nama User");
        namaUser.setBorder(null);
        namaUser.setOpaque(false);
        panelFormUser.add(namaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 310, 30));

        jLabel12.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(250, 238, 238));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Alamat");
        panelFormUser.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, -1));
        panelFormUser.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 310, -1));

        alamatUser.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        alamatUser.setForeground(new java.awt.Color(165, 163, 174));
        alamatUser.setText("Alamat User");
        alamatUser.setBorder(null);
        alamatUser.setOpaque(false);
        panelFormUser.add(alamatUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 310, 30));
        panelFormUser.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 310, -1));

        jLabel13.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(250, 238, 238));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Tempat Tanggal Lahir");
        panelFormUser.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 120, -1));

        tempatLahirUser.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        tempatLahirUser.setForeground(new java.awt.Color(165, 163, 174));
        tempatLahirUser.setText("Tempat Lahir");
        tempatLahirUser.setBorder(null);
        tempatLahirUser.setOpaque(false);
        panelFormUser.add(tempatLahirUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, 30));
        panelFormUser.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 100, -1));
        panelFormUser.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 190, -1));

        jLabel14.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(250, 238, 238));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Tanggal Masuk");
        panelFormUser.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 120, -1));

        tanggalMasukUser.setEditable(false);
        tanggalMasukUser.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        tanggalMasukUser.setForeground(new java.awt.Color(165, 163, 174));
        tanggalMasukUser.setText("Tanggal Masuk");
        tanggalMasukUser.setBorder(null);
        tanggalMasukUser.setOpaque(false);
        panelFormUser.add(tanggalMasukUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 310, 30));
        panelFormUser.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 310, -1));

        panelSaveUser.setBackground(new java.awt.Color(76, 76, 76));
        panelSaveUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(250, 238, 238));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Save");
        panelSaveUser.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 31));

        saveUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save-96.resized.png"))); // NOI18N
        saveUser.setToolTipText("Manage User");
        saveUser.setBorder(null);
        saveUser.setBorderPainted(false);
        saveUser.setContentAreaFilled(false);
        saveUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveUser.setFocusPainted(false);
        panelSaveUser.add(saveUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelFormUser.add(panelSaveUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 90, 80));

        panelCancelUser.setBackground(new java.awt.Color(76, 76, 76));
        panelCancelUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(250, 238, 238));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Cancel");
        panelCancelUser.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 30));

        cancelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel Subscription-96.resized.png"))); // NOI18N
        cancelUser.setToolTipText("Manage User");
        cancelUser.setBorder(null);
        cancelUser.setBorderPainted(false);
        cancelUser.setContentAreaFilled(false);
        cancelUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelUser.setFocusPainted(false);
        panelCancelUser.add(cancelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelFormUser.add(panelCancelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 90, 80));

        tanggalLahirUser.setBorder(null);
        tanggalLahirUser.setForeground(new java.awt.Color(165, 163, 174));
        tanggalLahirUser.setDateFormatString("dd MMM yyyy");
        tanggalLahirUser.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        tanggalLahirUser.setOpaque(false);
        panelFormUser.add(tanggalLahirUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 190, 20));

        jPanel5.add(panelFormUser, "card2");

        userImage.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 330, 460));

        jPanel2.add(userImage, "card3");

        kriteriaImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTableKriteria.setOpaque(false);
        panelTableKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableKriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No.", "ID Kriteria", "Nama"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKriteria.setOpaque(false);
        tableKriteria.setShowHorizontalLines(false);
        jScrollPane3.setViewportView(tableKriteria);
        if (tableKriteria.getColumnModel().getColumnCount() > 0) {
            tableKriteria.getColumnModel().getColumn(0).setMinWidth(50);
            tableKriteria.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableKriteria.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        panelTableKriteria.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 310));

        panelEditKriteria.setBackground(new java.awt.Color(76, 76, 76));
        panelEditKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(250, 238, 238));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Edit");
        panelEditKriteria.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 30));

        editKriteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit User Male-96.resized.png"))); // NOI18N
        editKriteria.setToolTipText("Manage User");
        editKriteria.setBorder(null);
        editKriteria.setBorderPainted(false);
        editKriteria.setContentAreaFilled(false);
        editKriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editKriteria.setFocusPainted(false);
        panelEditKriteria.add(editKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelTableKriteria.add(panelEditKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 90, 80));

        kriteriaImage.add(panelTableKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 470));

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.CardLayout());

        homeFormKriteria.setOpaque(false);
        homeFormKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User Shield-100.png"))); // NOI18N
        homeFormKriteria.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel25.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(192, 189, 205));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Sistem Penunjang Keputusan ");
        homeFormKriteria.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 310, -1));

        jLabel26.setFont(new java.awt.Font("Bebas Neue", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(192, 189, 205));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Tingkat Kesesuaian Lahan Tanaman KakAo");
        homeFormKriteria.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 330, -1));

        jPanel6.add(homeFormKriteria, "card2");

        panelFormKriteria.setOpaque(false);
        panelFormKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        detailKriteria.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        detailKriteria.setForeground(new java.awt.Color(250, 238, 238));
        detailKriteria.setText("Detail User");
        panelFormKriteria.add(detailKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel27.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(250, 238, 238));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Nama");
        panelFormKriteria.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, -1));

        namaKriteria.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        namaKriteria.setForeground(new java.awt.Color(165, 163, 174));
        namaKriteria.setText("Nama Kriteria");
        namaKriteria.setBorder(null);
        namaKriteria.setOpaque(false);
        panelFormKriteria.add(namaKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 310, 30));
        panelFormKriteria.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 310, -1));

        jLabel30.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(250, 238, 238));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Tanggal Input Kriteria");
        panelFormKriteria.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, -1));

        tanggalMasukKriteria.setEditable(false);
        tanggalMasukKriteria.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        tanggalMasukKriteria.setForeground(new java.awt.Color(165, 163, 174));
        tanggalMasukKriteria.setText("Tanggal Input");
        tanggalMasukKriteria.setBorder(null);
        tanggalMasukKriteria.setOpaque(false);
        panelFormKriteria.add(tanggalMasukKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 310, 30));
        panelFormKriteria.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 310, -1));

        panelSaveKriteria.setBackground(new java.awt.Color(76, 76, 76));
        panelSaveKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(250, 238, 238));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Save");
        panelSaveKriteria.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 31));

        saveKriteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save-96.resized.png"))); // NOI18N
        saveKriteria.setToolTipText("Manage User");
        saveKriteria.setBorder(null);
        saveKriteria.setBorderPainted(false);
        saveKriteria.setContentAreaFilled(false);
        saveKriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveKriteria.setFocusPainted(false);
        panelSaveKriteria.add(saveKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelFormKriteria.add(panelSaveKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 90, 80));

        panelCancelKriteria.setBackground(new java.awt.Color(76, 76, 76));
        panelCancelKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(250, 238, 238));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Cancel");
        panelCancelKriteria.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 30));

        cancelKriteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel Subscription-96.resized.png"))); // NOI18N
        cancelKriteria.setToolTipText("Manage User");
        cancelKriteria.setBorder(null);
        cancelKriteria.setBorderPainted(false);
        cancelKriteria.setContentAreaFilled(false);
        cancelKriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelKriteria.setFocusPainted(false);
        panelCancelKriteria.add(cancelKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelFormKriteria.add(panelCancelKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 90, 80));

        jPanel6.add(panelFormKriteria, "card2");

        kriteriaImage.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 330, 460));

        jPanel2.add(kriteriaImage, "card4");

        subKriteriaImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTableUser1.setOpaque(false);
        panelTableUser1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableSubKriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "ID Sub", "Sub Kriteria", "Kriteria", "Kategori"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSubKriteria.setOpaque(false);
        tableSubKriteria.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(tableSubKriteria);
        if (tableSubKriteria.getColumnModel().getColumnCount() > 0) {
            tableSubKriteria.getColumnModel().getColumn(0).setMinWidth(50);
            tableSubKriteria.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableSubKriteria.getColumnModel().getColumn(0).setMaxWidth(50);
            tableSubKriteria.getColumnModel().getColumn(4).setMinWidth(80);
            tableSubKriteria.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableSubKriteria.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        panelTableUser1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 310));

        panelEditSubKriteria.setBackground(new java.awt.Color(76, 76, 76));
        panelEditSubKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(250, 238, 238));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Edit");
        panelEditSubKriteria.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 30));

        editSubKriteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit User Male-96.resized.png"))); // NOI18N
        editSubKriteria.setToolTipText("Manage User");
        editSubKriteria.setBorder(null);
        editSubKriteria.setBorderPainted(false);
        editSubKriteria.setContentAreaFilled(false);
        editSubKriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editSubKriteria.setFocusPainted(false);
        panelEditSubKriteria.add(editSubKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelTableUser1.add(panelEditSubKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 90, 80));

        subKriteriaImage.add(panelTableUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 470));

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.CardLayout());

        homeFormSubKriteria.setOpaque(false);
        homeFormSubKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User Shield-100.png"))); // NOI18N
        homeFormSubKriteria.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel29.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(192, 189, 205));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Sistem Penunjang Keputusan ");
        homeFormSubKriteria.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 310, -1));

        jLabel33.setFont(new java.awt.Font("Bebas Neue", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(192, 189, 205));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Tingkat Kesesuaian Lahan Tanaman KakAo");
        homeFormSubKriteria.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 330, -1));

        jPanel7.add(homeFormSubKriteria, "card2");

        panelFormSubKriteria.setOpaque(false);
        panelFormSubKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        detailSubKriteria.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        detailSubKriteria.setForeground(new java.awt.Color(250, 238, 238));
        detailSubKriteria.setText("Detail User");
        panelFormSubKriteria.add(detailSubKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel34.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(250, 238, 238));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Kriteria");
        panelFormSubKriteria.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, -1));

        jLabel35.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(250, 238, 238));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Nama Sub Kriteria");
        panelFormSubKriteria.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, -1));
        panelFormSubKriteria.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 310, -1));

        comboBoxKriteria.setEditable(false);
        comboBoxKriteria.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        comboBoxKriteria.setForeground(new java.awt.Color(165, 163, 174));
        comboBoxKriteria.setText("Nama Sub Kriteria");
        comboBoxKriteria.setBorder(null);
        comboBoxKriteria.setOpaque(false);
        panelFormSubKriteria.add(comboBoxKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 310, 30));
        panelFormSubKriteria.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 170, 10));

        bobotSubKriteria.setEditable(false);
        bobotSubKriteria.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        bobotSubKriteria.setForeground(new java.awt.Color(165, 163, 174));
        bobotSubKriteria.setText("Bobot Sub Kriteria");
        bobotSubKriteria.setBorder(null);
        bobotSubKriteria.setOpaque(false);
        panelFormSubKriteria.add(bobotSubKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 310, 30));
        panelFormSubKriteria.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 310, 10));

        jLabel37.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(250, 238, 238));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Kategori");
        panelFormSubKriteria.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 120, -1));
        panelFormSubKriteria.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 120, 10));

        panelSaveSubKriteria.setBackground(new java.awt.Color(76, 76, 76));
        panelSaveSubKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(250, 238, 238));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Save");
        panelSaveSubKriteria.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 31));

        saveSubKriteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save-96.resized.png"))); // NOI18N
        saveSubKriteria.setToolTipText("Manage User");
        saveSubKriteria.setBorder(null);
        saveSubKriteria.setBorderPainted(false);
        saveSubKriteria.setContentAreaFilled(false);
        saveSubKriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveSubKriteria.setFocusPainted(false);
        panelSaveSubKriteria.add(saveSubKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelFormSubKriteria.add(panelSaveSubKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 90, 80));

        panelCancelSubKriteria.setBackground(new java.awt.Color(76, 76, 76));
        panelCancelSubKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(250, 238, 238));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Cancel");
        panelCancelSubKriteria.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 30));

        cancelSubKriteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel Subscription-96.resized.png"))); // NOI18N
        cancelSubKriteria.setToolTipText("Manage User");
        cancelSubKriteria.setBorder(null);
        cancelSubKriteria.setBorderPainted(false);
        cancelSubKriteria.setContentAreaFilled(false);
        cancelSubKriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelSubKriteria.setFocusPainted(false);
        panelCancelSubKriteria.add(cancelSubKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelFormSubKriteria.add(panelCancelSubKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 90, 80));

        comboBoxKategori.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        comboBoxKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cost", "Benefit" }));
        panelFormSubKriteria.add(comboBoxKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 120, -1));

        jLabel44.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(250, 238, 238));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText("Bobot");
        panelFormSubKriteria.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 120, -1));

        namaSubKriteria.setEditable(false);
        namaSubKriteria.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        namaSubKriteria.setForeground(new java.awt.Color(165, 163, 174));
        namaSubKriteria.setText("Nama Sub Kriteria");
        namaSubKriteria.setBorder(null);
        namaSubKriteria.setOpaque(false);
        panelFormSubKriteria.add(namaSubKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 170, 30));

        jPanel7.add(panelFormSubKriteria, "card2");

        subKriteriaImage.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 330, 460));

        jPanel2.add(subKriteriaImage, "card5");

        analisisImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTableUser2.setOpaque(false);
        panelTableUser2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableAlternative.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "ID Alternative", "Nama Alternative"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAlternative.setOpaque(false);
        tableAlternative.setShowHorizontalLines(false);
        jScrollPane4.setViewportView(tableAlternative);
        if (tableAlternative.getColumnModel().getColumnCount() > 0) {
            tableAlternative.getColumnModel().getColumn(0).setMinWidth(50);
            tableAlternative.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableAlternative.getColumnModel().getColumn(0).setMaxWidth(50);
            tableAlternative.getColumnModel().getColumn(1).setMinWidth(150);
            tableAlternative.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableAlternative.getColumnModel().getColumn(1).setMaxWidth(150);
        }

        panelTableUser2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 310));

        panelAddAlternative.setBackground(new java.awt.Color(76, 76, 76));
        panelAddAlternative.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(250, 238, 238));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Add");
        panelAddAlternative.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 30));

        addAlternative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add User Male-96.resized.png"))); // NOI18N
        addAlternative.setToolTipText("Manage User");
        addAlternative.setBorder(null);
        addAlternative.setBorderPainted(false);
        addAlternative.setContentAreaFilled(false);
        addAlternative.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addAlternative.setFocusPainted(false);
        panelAddAlternative.add(addAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelTableUser2.add(panelAddAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 90, 80));

        panelEditAlternative.setBackground(new java.awt.Color(76, 76, 76));
        panelEditAlternative.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(250, 238, 238));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Edit");
        panelEditAlternative.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 30));

        editAlternative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit User Male-96.resized.png"))); // NOI18N
        editAlternative.setToolTipText("Manage User");
        editAlternative.setBorder(null);
        editAlternative.setBorderPainted(false);
        editAlternative.setContentAreaFilled(false);
        editAlternative.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editAlternative.setFocusPainted(false);
        panelEditAlternative.add(editAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelTableUser2.add(panelEditAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 90, 80));

        panelHapusAlternative.setBackground(new java.awt.Color(76, 76, 76));
        panelHapusAlternative.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(250, 238, 238));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Delete");
        panelHapusAlternative.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 31));

        hapusAlternative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete-96.resized.png"))); // NOI18N
        hapusAlternative.setToolTipText("Manage User");
        hapusAlternative.setBorder(null);
        hapusAlternative.setBorderPainted(false);
        hapusAlternative.setContentAreaFilled(false);
        hapusAlternative.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hapusAlternative.setFocusPainted(false);
        panelHapusAlternative.add(hapusAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelTableUser2.add(panelHapusAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 90, 80));

        analisisImage.add(panelTableUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 470));

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.CardLayout());

        homeFormAlternative.setOpaque(false);
        homeFormAlternative.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User Shield-100.png"))); // NOI18N
        homeFormAlternative.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel50.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(192, 189, 205));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Sistem Penunjang Keputusan ");
        homeFormAlternative.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 310, -1));

        jLabel51.setFont(new java.awt.Font("Bebas Neue", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(192, 189, 205));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Tingkat Kesesuaian Lahan Tanaman KakAo");
        homeFormAlternative.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 330, -1));

        panelShowAnalisis.setBackground(new java.awt.Color(76, 76, 76));
        panelShowAnalisis.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/analisisi.png"))); // NOI18N
        showAnalisis.setToolTipText("Lihat Hasil Analisis");
        showAnalisis.setBorder(null);
        showAnalisis.setBorderPainted(false);
        showAnalisis.setContentAreaFilled(false);
        showAnalisis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showAnalisis.setFocusPainted(false);
        panelShowAnalisis.add(showAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 140));

        homeFormAlternative.add(panelShowAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 180, 140));

        jPanel8.add(homeFormAlternative, "card2");

        panelFormAlternative.setOpaque(false);
        panelFormAlternative.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        detailAlternative.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        detailAlternative.setForeground(new java.awt.Color(250, 238, 238));
        detailAlternative.setText("Detail User");
        panelFormAlternative.add(detailAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel52.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(250, 238, 238));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel52.setText("Nama Alternative");
        panelFormAlternative.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, -1));

        namaAlternative.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        namaAlternative.setForeground(new java.awt.Color(165, 163, 174));
        namaAlternative.setText("Nama Alternative");
        namaAlternative.setBorder(null);
        namaAlternative.setOpaque(false);
        panelFormAlternative.add(namaAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 310, 30));
        panelFormAlternative.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 310, -1));

        alamatAlternative.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        alamatAlternative.setForeground(new java.awt.Color(165, 163, 174));
        alamatAlternative.setText("Alamat Alternative");
        alamatAlternative.setBorder(null);
        alamatAlternative.setOpaque(false);
        panelFormAlternative.add(alamatAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 310, 30));
        panelFormAlternative.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 310, -1));

        panelSaveAlternative.setBackground(new java.awt.Color(76, 76, 76));
        panelSaveAlternative.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(250, 238, 238));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Save");
        panelSaveAlternative.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 31));

        saveAlternative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save-96.resized.png"))); // NOI18N
        saveAlternative.setToolTipText("Manage User");
        saveAlternative.setBorder(null);
        saveAlternative.setBorderPainted(false);
        saveAlternative.setContentAreaFilled(false);
        saveAlternative.setFocusPainted(false);
        panelSaveAlternative.add(saveAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelFormAlternative.add(panelSaveAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 90, 80));

        panelCancelAlternative.setBackground(new java.awt.Color(76, 76, 76));
        panelCancelAlternative.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(250, 238, 238));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Cancel");
        panelCancelAlternative.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 30));

        cancelAlternative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel Subscription-96.resized.png"))); // NOI18N
        cancelAlternative.setToolTipText("Manage User");
        cancelAlternative.setBorder(null);
        cancelAlternative.setBorderPainted(false);
        cancelAlternative.setContentAreaFilled(false);
        cancelAlternative.setFocusPainted(false);
        panelCancelAlternative.add(cancelAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 60));

        panelFormAlternative.add(panelCancelAlternative, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 90, 80));

        jLabel58.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(250, 238, 238));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel58.setText("Alamat Lahan");
        panelFormAlternative.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, -1));

        jPanel8.add(panelFormAlternative, "card2");

        analisisImage.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 330, 460));

        jPanel2.add(analisisImage, "card6");

        grafikImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGrafik.setOpaque(false);
        panelGrafik.setLayout(new java.awt.GridLayout(1, 1));
        grafikImage.add(panelGrafik, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 780, 310));

        lahanCocok.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        lahanCocok.setForeground(new java.awt.Color(236, 211, 54));
        lahanCocok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lahanCocok.setText("Grafik Analisis Keseuaian Lahan");
        grafikImage.add(lahanCocok, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 810, -1));

        jLabel57.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(250, 238, 238));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Grafik Analisis Keseuaian Lahan");
        grafikImage.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, -1));

        backGrafik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Rewind-100.resized.png"))); // NOI18N
        backGrafik.setBorder(null);
        backGrafik.setBorderPainted(false);
        backGrafik.setContentAreaFilled(false);
        backGrafik.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backGrafik.setFocusPainted(false);
        grafikImage.add(backGrafik, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, 60));

        rincianAnalisis.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        rincianAnalisis.setText("Rincian Perhitungan");
        rincianAnalisis.setBorder(null);
        rincianAnalisis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        grafikImage.add(rincianAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 150, 30));

        jLabel66.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(250, 238, 238));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Berdasarkan Analisis diatas, Lahan yang paling cocok adalah :");
        grafikImage.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 500, -1));

        jPanel2.add(grafikImage, "card7");

        tableAnalisisImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        tableAnalisisImage.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 780, 260));

        jLabel59.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(250, 238, 238));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Analisis Lahan");
        tableAnalisisImage.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 70));

        backTableAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Rewind-100.resized.png"))); // NOI18N
        backTableAnalisis.setBorder(null);
        backTableAnalisis.setBorderPainted(false);
        backTableAnalisis.setContentAreaFilled(false);
        backTableAnalisis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backTableAnalisis.setFocusPainted(false);
        tableAnalisisImage.add(backTableAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, 60));

        jLabel60.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(250, 238, 238));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel60.setText("S3 : Lereng");
        tableAnalisisImage.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 120, -1));

        hitungRatingKerja.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        hitungRatingKerja.setText("Nilai Rating Kerja");
        hitungRatingKerja.setBorder(null);
        hitungRatingKerja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableAnalisisImage.add(hitungRatingKerja, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 150, 30));

        jLabel68.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(250, 238, 238));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel68.setText("Keterangan :");
        tableAnalisisImage.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 120, -1));

        jLabel69.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(250, 238, 238));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel69.setText("S1  : Curah Hujan");
        tableAnalisisImage.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 120, -1));

        jLabel70.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(250, 238, 238));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel70.setText("S2 : Lama Bulan Kering");
        tableAnalisisImage.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 120, -1));

        jLabel71.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(250, 238, 238));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("S5 : Tekstur");
        tableAnalisisImage.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 120, -1));

        jLabel72.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(250, 238, 238));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel72.setText("S4 : Kedalaman Efektif");
        tableAnalisisImage.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 120, -1));

        jLabel75.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(250, 238, 238));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel75.setText("S6 : Prosentase Batu");
        tableAnalisisImage.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 120, -1));

        jLabel76.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(250, 238, 238));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel76.setText("S7 : Genangan Air");
        tableAnalisisImage.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 120, -1));

        jLabel77.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(250, 238, 238));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel77.setText("S8 : Ph");
        tableAnalisisImage.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 120, -1));

        jLabel80.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(250, 238, 238));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("S9 : N");
        tableAnalisisImage.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 120, -1));

        jLabel81.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(250, 238, 238));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("S10 : P");
        tableAnalisisImage.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 120, -1));

        jLabel83.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(250, 238, 238));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("S12 : Salinitas");
        tableAnalisisImage.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 120, -1));

        jLabel85.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(250, 238, 238));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel85.setText("S13 : Kejenuhan");
        tableAnalisisImage.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 120, -1));

        jLabel86.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(250, 238, 238));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel86.setText("S11 : K");
        tableAnalisisImage.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 120, -1));

        hitungPreferensi.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        hitungPreferensi.setText("Nilai Preferensi");
        hitungPreferensi.setBorder(null);
        hitungPreferensi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableAnalisisImage.add(hitungPreferensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 150, 30));

        panelDataLahan.setBackground(new java.awt.Color(76, 76, 76));
        panelDataLahan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showDataLahan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hasil.png"))); // NOI18N
        showDataLahan.setToolTipText("Hasil Lapangan");
        showDataLahan.setBorder(null);
        showDataLahan.setBorderPainted(false);
        showDataLahan.setContentAreaFilled(false);
        showDataLahan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showDataLahan.setFocusPainted(false);
        panelDataLahan.add(showDataLahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 90));

        tableAnalisisImage.add(panelDataLahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 110, 90));

        jPanel2.add(tableAnalisisImage, "card8");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 810, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAlternative;
    private javax.swing.JButton addUser;
    private javax.swing.JTextField alamatAlternative;
    private javax.swing.JTextField alamatUser;
    private javax.swing.JButton analisis;
    private addComponent.image2 analisisImage;
    private javax.swing.JButton backGrafik;
    private javax.swing.JButton backTableAnalisis;
    private javax.swing.JTextField bobotSubKriteria;
    private javax.swing.JButton cancelAlternative;
    private javax.swing.JButton cancelKriteria;
    private javax.swing.JButton cancelSubKriteria;
    private javax.swing.JButton cancelUser;
    private javax.swing.JButton changeAccount;
    private javax.swing.JComboBox<String> comboBoxKategori;
    private javax.swing.JTextField comboBoxKriteria;
    private javax.swing.JLabel detailAlternative;
    private javax.swing.JLabel detailKriteria;
    private javax.swing.JLabel detailSubKriteria;
    private javax.swing.JLabel detailUser;
    private javax.swing.JButton editAlternative;
    private javax.swing.JButton editKriteria;
    private javax.swing.JButton editSubKriteria;
    private javax.swing.JButton editUser;
    private addComponent.image2 grafikImage;
    private javax.swing.JButton hapusAlternative;
    private javax.swing.JButton hapusUser;
    private javax.swing.JButton hitungPreferensi;
    private javax.swing.JButton hitungRatingKerja;
    private javax.swing.JButton home;
    private javax.swing.JPanel homeForm;
    private javax.swing.JPanel homeFormAlternative;
    private javax.swing.JPanel homeFormKriteria;
    private javax.swing.JPanel homeFormSubKriteria;
    private addComponent.image homeImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton kriteria;
    private addComponent.image2 kriteriaImage;
    private javax.swing.JLabel lahanCocok;
    private javax.swing.JButton logout;
    private javax.swing.JButton minimize;
    private javax.swing.JTextField namaAlternative;
    private javax.swing.JTextField namaKriteria;
    private javax.swing.JTextField namaSubKriteria;
    private javax.swing.JTextField namaUser;
    private addComponent.roundPanel panelAddAlternative;
    private addComponent.roundPanel panelAddUser;
    private javax.swing.JPanel panelAnalisis;
    private addComponent.roundPanel panelCancelAlternative;
    private addComponent.roundPanel panelCancelKriteria;
    private addComponent.roundPanel panelCancelSubKriteria;
    private addComponent.roundPanel panelCancelUser;
    private addComponent.roundPanel panelDataLahan;
    private addComponent.roundPanel panelEditAlternative;
    private addComponent.roundPanel panelEditKriteria;
    private addComponent.roundPanel panelEditSubKriteria;
    private addComponent.roundPanel panelEditUser;
    private javax.swing.JPanel panelFormAlternative;
    private javax.swing.JPanel panelFormKriteria;
    private javax.swing.JPanel panelFormSubKriteria;
    private javax.swing.JPanel panelFormUser;
    private javax.swing.JPanel panelGrafik;
    private addComponent.roundPanel panelHapusAlternative;
    private addComponent.roundPanel panelHapusUser;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelKriteria;
    private addComponent.roundPanel panelSaveAlternative;
    private addComponent.roundPanel panelSaveKriteria;
    private addComponent.roundPanel panelSaveSubKriteria;
    private addComponent.roundPanel panelSaveUser;
    private addComponent.roundPanel panelShowAnalisis;
    private javax.swing.JPanel panelSubKriteria;
    private javax.swing.JPanel panelTableKriteria;
    private javax.swing.JPanel panelTableUser;
    private javax.swing.JPanel panelTableUser1;
    private javax.swing.JPanel panelTableUser2;
    private javax.swing.JPanel panelUser;
    private javax.swing.JButton rincianAnalisis;
    private javax.swing.JButton saveAlternative;
    private javax.swing.JButton saveKriteria;
    private javax.swing.JButton saveSubKriteria;
    private javax.swing.JButton saveUser;
    private javax.swing.JButton showAnalisis;
    private javax.swing.JButton showDataLahan;
    private addComponent.image2 subKriteriaImage;
    private javax.swing.JButton subkriteria;
    private javax.swing.JTable tableAlternative;
    private addComponent.image2 tableAnalisisImage;
    private javax.swing.JTable tableHasilAnalisis;
    private javax.swing.JTable tableKriteria;
    private javax.swing.JTable tableSubKriteria;
    private javax.swing.JTable tableUser;
    private com.toedter.calendar.JDateChooser tanggalLahirUser;
    private javax.swing.JTextField tanggalMasukKriteria;
    private javax.swing.JTextField tanggalMasukUser;
    private javax.swing.JTextField tempatLahirUser;
    private javax.swing.JButton user;
    private addComponent.image2 userImage;
    // End of variables declaration//GEN-END:variables

}
