package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MAdmin;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import view.Vadmin;
import view.Vlogin;

/**
 *
 * @author rohim
 */
public class CAdmin extends MAdmin {

    Vadmin view;
    Icon logoutIcon1, logoutIcon2, minimizeIcon1, minimizeIcon2, backGrafikIcon1, backGrafikIcon2;
    String username;

    public CAdmin(Vadmin view, String username) throws SQLException {
        this.username = username;
        this.logoutIcon1 = new javax.swing.ImageIcon(getClass().getResource("/image/logout_1.png"));
        this.logoutIcon2 = new javax.swing.ImageIcon(getClass().getResource("/image/logout_2.png"));
        this.minimizeIcon1 = new javax.swing.ImageIcon(getClass().getResource("/image/minimize_1.png"));
        this.minimizeIcon2 = new javax.swing.ImageIcon(getClass().getResource("/image/minimize_2.png"));
        this.backGrafikIcon1 = new javax.swing.ImageIcon(getClass().getResource("/image/Rewind-100.resized.png"));
        this.backGrafikIcon2 = new javax.swing.ImageIcon(getClass().getResource("/image/Rewind-100_2.resized.png"));

        this.view = view;
        this.view.setVisible(true);

        this.view.logoutOnClick(new logoutListener());
        this.view.minimizeOnClick(new minimizeListener());
        this.view.backGrafikOnClick(new backGrafikListener());
        this.view.changeAccountOnClick(new changeAccountListener());
        this.view.backAnalisisOnClick(new backAnalisisListener());

        this.view.homeOnClick(new homeListener());
        this.view.userOnClick(new userListener());
        this.view.kriteriaOnClick(new kriteriaListener());
        this.view.subKriteriaOnClick(new subKriteriaListener());
        this.view.analisisOnClick(new analisisListener());
        this.view.addUserOnClick(new addUserListener());
        this.view.editUserOnClick(new editUserListener());
        this.view.deleteUserOnClick(new deleteUserListener());
        this.view.cancelUserOnClick(new cancelUserListener());
        this.view.saveUserOnClick(new saveUserListener());

        this.view.namaUserOnFocus(new namaUserListener());
        this.view.alamatUserOnFocus(new alamatUserListener());
        this.view.tempatLahirUserOnFocus(new tempatLahirUserListener());

        //========================= Kriteria ===========
        this.view.editKriteriaOnClick(new editKriteriaListener());
//        this.view.deleteKriteriaOnClick(new deleteKriteriaListener());
        this.view.cancelKriteriaOnClick(new cancelKriteriaListener());
        this.view.saveKriteriaOnClick(new saveKriteriaListener());
        this.view.namaKriteriaOnFocus(new namaKriteriaListener());

        //========================= Sub Kriteria ===========
        this.view.editSubKriteriaOnClick(new editSubKriteriaListener());
//        this.view.deleteSubKriteriaOnClick(new deleteSubKriteriaListener());
        this.view.cancelSubKriteriaOnClick(new cancelSubKriteriaListener());
        this.view.saveSubKriteriaOnClick(new saveSubKriteriaListener());
        this.view.namaSubKriteriaOnFocus(new namaSubKriteriaListener());
        this.view.bobotSubKriteriaOnFocus(new bobotSubKriteriaListener());
//        this.view.kesesuaianMinSubKriteriaOnFocus(new nilaiMinSubKriteriaListener());
//        this.view.keseuaianMaxSubKriteriaOnFocus(new nilaiMaxSubKriteriaListener());

        //========================= Kriteria ===========
        this.view.addAlternativeOnClick(new addAlternativeListener());
        this.view.editAlternativeOnClick(new editAlternativeListener());
        this.view.deleteAlternativeOnClick(new deleteAlternativeListener());
        this.view.cancelAlternativeOnClick(new cancelAlternativeListener());
        this.view.saveAlternativeOnClick(new saveAlternativeListener());
        this.view.showAnalisisOnClick(new showAnalisisListener());
        this.view.namaAlternativeOnFocus(new namaAlternativeListener());
        this.view.alamatAlternativeOnFocus(new alamatAlternativeListener());

        //========================= Alternative ===========
        this.view.rincianOnClick(new rincianListener());
        
        //========================= Table Analisis ===============
        this.view.matriksKerjaOnClick(new ratingKerjaListener());
        this.view.matriksPreferensiOnClick(new preferensiListener());
        this.view.dataLahanOnClick(new showDataLahanListener());
    }
    
    private void changeAccountAction() throws SQLException{
        new CAkun(view, getDataAccount(username));
    }
    
    private class changeAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                changeAccountAction();
            } catch (SQLException ex) {
                Logger.getLogger(CPegawai.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    private DefaultTableModel dataUser(String[][] dataUser) {
        DefaultTableModel model = view.getModelTableUser();
        model.setRowCount(0);
        for (String[] dataUser1 : dataUser) {
            String row[] = new String[4];
            System.arraycopy(dataUser1, 0, row, 0, 4);
            model.addRow(row);
        }
        return model;
    }

    private void minimizeAction() {
        view.minimize();
        view.minimizeSetIcon(minimizeIcon1);
    }

    private void logoutAction() throws SQLException {
        if (view.showConfirmMessage("Apakah Anda Yakin Akan Keluar ?") == JOptionPane.YES_OPTION) {
            logout(username);
            new CLogin(new Vlogin());
            view.setVisible(false);
        }
    }

    private void homeAction() {
        view.setPanelUtama("home");
    }

    private void userAction() throws SQLException {
        view.setPanelUtama("user");
        view.setModelTableUser(dataUser(getDataUser()));
    }

    private void kriteriaAction() throws SQLException {
        view.setPanelUtama("kriteria");
        view.setModelTableKriteria(dataKriteria(getDataKriteria()));
    }

    private void subKriteriaAction() throws SQLException {
        view.setModelTableSubKriteria(dataSubKriteria(getDataSubKriteria()));
        view.setPanelUtama("subkriteria");
    }

    private void analisisAction() throws SQLException {
        view.setModelTableAlternative(dataAlternative(getDataAlternative()));
        view.setPanelUtama("analisis");
    }

    private void addUserAction() {
        if (view.isTableUserEnable()) {
            view.clearSelectionTableUser();
            view.setPanelFormUser("formUser");
        }
    }

    private void cancelUserAction() {
        view.setPanelFormUser("homeForm");
        view.resetForm();
    }

    private boolean isDataComplete(String data[]) {
        return !(data[0].equalsIgnoreCase("Nama User")
                || data[1].equalsIgnoreCase("Alamat User")
                || data[2].equalsIgnoreCase("Tempat Lahir"));
    }

    private boolean isEdit() {
        return view.getDetailUser().equalsIgnoreCase("Edit User");
    }

    private void saveUserAction() throws SQLException {
        if (isDataComplete(view.getDataUser())) {
            if (isEdit()) {
                if (updateDataUser(view.getSelectedTableUser(), view.getDataUser())) {
                    view.showMessage("Data Berhasil Di Update !");
                } else {
                    view.showMessage("Data Gagal Di Update !");
                }
            } else if (insertDataUser(view.getDataUser())) {
                view.showMessage("Data Berhasil Di Simpan !");
            } else {
                view.showMessage("Data Gagal Di Simpan !");
            }
            view.setModelTableUser(dataUser(getDataUser()));
            view.resetForm();
            view.setPanelFormUser("homeForm");
        } else {
            view.showMessage("Pastikan Semua Data Terisi !");
        }
    }

    private void deleteUserAction() throws SQLException {
        if (view.isTableUserEnable()) {
            if (view.isTableUserSelected()) {
                if (view.showConfirmMessage("Apakah Anda Yakin ?") == JOptionPane.YES_OPTION) {
                    if (deleteDataUser(view.getSelectedTableUser())) {
                        view.showMessage("Data Berhasil Di Hapus");
                    } else {
                        view.showMessage("Data Gagal Di Hapus");
                    }
                }
            } else {
                view.showMessage("Tidak Ada Data");
            }
            view.setModelTableUser(dataUser(getDataUser()));
        }
    }

    private void editUserAction() throws SQLException, ParseException {
        if (view.isTableUserEnable()) {
            if (view.isTableUserSelected()) {
                view.setDetailUser("Edit User");
                view.setDataUser(getData(view.getSelectedTableUser()));
                view.setPanelFormUser("formUser");
            } else {
                view.showMessage("Tidak Ada Data");
            }
        }
    }

    private void backGrafikAction() throws SQLException {
        view.setModelTableAlternative(dataAlternative(getDataAlternative()));
        view.setPanelUtama("analisis");
    }
    
    private void backTableAction() throws SQLException {
        showAnalisisAction();
    }

    private class logoutListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                logoutAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.logoutSetIcon(logoutIcon2);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.logoutSetIcon(logoutIcon1);
        }

    }

    private class minimizeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            minimizeAction();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.minimizeSetIcon(minimizeIcon2);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.minimizeSetIcon(minimizeIcon1);
        }

    }

    private class backGrafikListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                backGrafikAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.backGrafikSetIcon(backGrafikIcon2);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.backGrafikSetIcon(backGrafikIcon1);
        }

    }

    private class backAnalisisListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                backTableAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.backTableAnalisisSetIcon(backGrafikIcon2);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.backTableAnalisisSetIcon(backGrafikIcon1);
        }

    }

    private class homeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            homeAction();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (!"home".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("home", new Color(136, 133, 151));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!"home".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("home", new Color(96, 91, 120));
            }
        }

    }

    private class userListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                userAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (!"user".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("user", new Color(136, 133, 151));
            }

        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!"user".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("user", new Color(96, 91, 120));
            }
        }

    }

    private class kriteriaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                kriteriaAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (!"kriteria".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("kriteria", new Color(136, 133, 151));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!"kriteria".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("kriteria", new Color(96, 91, 120));
            }
        }

    }

    private class subKriteriaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                subKriteriaAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (!"subkriteria".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("subkriteria", new Color(136, 133, 151));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!"subkriteria".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("subkriteria", new Color(96, 91, 120));
            }
        }

    }

    private class analisisListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                analisisAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (!"analisis".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("analisis", new Color(136, 133, 151));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!"analisis".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("analisis", new Color(96, 91, 120));
            }
        }

    }

    private class addUserListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            addUserAction();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (view.isTableUserEnable()) {
                view.setBackgroundPanel("addUser", new Color(132, 132, 132));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (view.isTableUserEnable()) {
                view.setBackgroundPanel("addUser", new Color(76, 76, 76));
            }
        }

    }

    private class editUserListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                editUserAction();
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (view.isTableUserEnable()) {
                view.setBackgroundPanel("editUser", new Color(132, 132, 132));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (view.isTableUserEnable()) {
                view.setBackgroundPanel("editUser", new Color(76, 76, 76));
            }
        }

    }

    private class deleteUserListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                deleteUserAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (view.isTableUserEnable()) {
                view.setBackgroundPanel("deleteUser", new Color(132, 132, 132));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (view.isTableUserEnable()) {
                view.setBackgroundPanel("deleteUser", new Color(76, 76, 76));
            }
        }

    }

    private class cancelUserListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            cancelUserAction();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.setBackgroundPanel("cancelUser", new Color(132, 132, 132));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.setBackgroundPanel("cancelUser", new Color(76, 76, 76));
        }

    }

    private class saveUserListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                saveUserAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.setBackgroundPanel("saveUser", new Color(132, 132, 132));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.setBackgroundPanel("saveUser", new Color(76, 76, 76));
        }

    }

    private class namaUserListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (view.getDataUser()[0].equalsIgnoreCase("Nama User")) {
                view.setNamaUser("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (view.getDataUser()[0].isEmpty()) {
                view.setNamaUser("Nama User");
            }
        }

    }

    private class alamatUserListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (view.getDataUser()[1].equalsIgnoreCase("Alamat User")) {
                view.setAlamatUser("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (view.getDataUser()[1].isEmpty()) {
                view.setAlamatUser("Alamat User");
            }
        }

    }

    private class tempatLahirUserListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (view.getDataUser()[2].equalsIgnoreCase("Tempat Lahir")) {
                view.setTempatLahirUser("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (view.getDataUser()[2].isEmpty()) {
                view.setTempatLahirUser("Tempat Lahir");
            }
        }

    }

    //================================ Kriteria =====================================
    private DefaultTableModel dataKriteria(String[][] dataKriteria) {
        DefaultTableModel model = view.getModelTableKriteria();
        model.setRowCount(0);
        for (String[] dataUser1 : dataKriteria) {
            String row[] = new String[4];
            System.arraycopy(dataUser1, 0, row, 0, 4);
            model.addRow(row);
        }
        return model;
    }

    private void cancelKriteriaAction() {
        view.setPanelFormKriteria("homeForm");
        view.resetFormKriteria();
    }

    private boolean isDataKriteriaComplete(String data) {
        return !(data.equalsIgnoreCase("Nama Kriteria"));
    }

    private boolean isEditKriteria() {
        return view.getDetailKriteria().equalsIgnoreCase("Edit Kriteria");
    }

    private void saveKriteriaAction() throws SQLException {
        if (isDataKriteriaComplete(view.getDataKriteria())) {
            if (isEditKriteria()) {
                if (updateDataKriteria(view.getSelectedTableKriteria(), view.getDataKriteria())) {
                    view.showMessage("Data Berhasil Di Update !");
                } else {
                    view.showMessage("Data Gagal Di Update !");
                }
            } else {
                view.showMessage("Data Gagal Di Simpan !");
            }
            view.setModelTableKriteria(dataKriteria(getDataKriteria()));
            view.resetFormKriteria();
            view.setPanelFormKriteria("homeForm");
        } else {
            view.showMessage("Pastikan Semua Data Terisi !");
        }
    }

//    private void deleteKriteriaAction() throws SQLException {
//        if (view.isTableKriteriaEnable()) {
//            if (view.isTableKriteriaSelected()) {
//                if (view.showConfirmMessage("Apakah Anda Yakin ?") == JOptionPane.YES_OPTION) {
//                    if (deleteDataKriteria(view.getSelectedTableKriteria())) {
//                        view.showMessage("Data Berhasil Di Hapus");
//                    } else {
//                        view.showMessage("Data Gagal Di Hapus");
//                    }
//                }
//            } else {
//                view.showMessage("Tidak Ada Data");
//            }
//            view.setModelTableKriteria(dataKriteria(getDataKriteria()));
//        }
//    }
    private void editKriteriaAction() throws SQLException, ParseException {
        if (view.isTableKriteriaEnable()) {
            if (view.isTableKriteriaSelected()) {
                view.setDetailKriteria("Edit Kriteria");
                view.setDataKriteria(getDataKriteria(view.getSelectedTableKriteria()));
                view.setPanelFormKriteria("formUser");
            } else {
                view.showMessage("Tidak Ada Data");
            }
        }
    }

    private class editKriteriaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                editKriteriaAction();
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (view.isTableKriteriaEnable()) {
                view.setBackgroundPanel("editKriteria", new Color(132, 132, 132));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (view.isTableKriteriaEnable()) {
                view.setBackgroundPanel("editKriteria", new Color(76, 76, 76));
            }
        }

    }

//    private class deleteKriteriaListener implements MouseListener {
//
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            try {
//                deleteKriteriaAction();
//            } catch (SQLException ex) {
//                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//            if (view.isTableKriteriaEnable()) {
//                view.setBackgroundPanel("deleteKriteria", new Color(132, 132, 132));
//            }
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//            if (view.isTableKriteriaEnable()) {
//                view.setBackgroundPanel("deleteKriteria", new Color(76, 76, 76));
//            }
//        }
//
//    }
    private class cancelKriteriaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            cancelKriteriaAction();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.setBackgroundPanel("cancelKriteria", new Color(132, 132, 132));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.setBackgroundPanel("cancelKriteria", new Color(76, 76, 76));
        }

    }

    private class saveKriteriaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                saveKriteriaAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.setBackgroundPanel("saveKriteria", new Color(132, 132, 132));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.setBackgroundPanel("saveKriteria", new Color(76, 76, 76));
        }

    }

    private class namaKriteriaListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (view.getDataKriteria().equalsIgnoreCase("Nama Kriteria")) {
                view.setNamaKriteria("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (view.getDataKriteria().isEmpty()) {
                view.setNamaKriteria("Nama Kriteria");
            }
        }

    }

    //================================ Sub Kriteria =====================================
    private DefaultTableModel dataSubKriteria(String[][] dataSubKriteria) {
        DefaultTableModel model = view.getModelTableSubKriteria();
        model.setRowCount(0);
        for (String[] dataUser1 : dataSubKriteria) {
            String row[] = new String[5];
            System.arraycopy(dataUser1, 0, row, 0, 5);
            model.addRow(row);
        }
        return model;
    }

    private void cancelSubKriteriaAction() {
        view.setPanelFormSubKriteria("homeForm");
        view.resetFormSubKriteria();
    }

    private boolean isDataSubKriteriaComplete(String data[]) {
        return !(data[0].equalsIgnoreCase("- Pilih Kriteria -")
                || data[1].equalsIgnoreCase("Nama Sub Kriteria")
                || data[3].equalsIgnoreCase("Nilai bobot"));
    }

    private boolean isEditSubKriteria() {
        return view.getDetailSubKriteria().equalsIgnoreCase("Edit Sub Kriteria");
    }

    private void saveSubKriteriaAction() throws SQLException {
        if (isDataSubKriteriaComplete(view.getDataSubKriteria())) {
            if (isEditSubKriteria()) {
                if (updateDataSubKriteria(view.getSelectedTableSubKriteria(), view.getDataSubKriteria())) {
                    view.showMessage("Data Berhasil Di Update !");
                } else {
                    view.showMessage("Data Gagal Di Update !");
                }
            } else {
                view.showMessage("Data Gagal Di Simpan !");
            }
            view.setModelTableSubKriteria(dataSubKriteria(getDataSubKriteria()));
            view.resetFormSubKriteria();
            view.setPanelFormSubKriteria("homeForm");
        } else {
            view.showMessage("Pastikan Semua Data Terisi !");
        }
    }

//    private void deleteSubKriteriaAction() throws SQLException {
//        if (view.isTableSubKriteriaEnable()) {
//            if (view.isTableSubKriteriaSelected()) {
//                if (view.showConfirmMessage("Apakah Anda Yakin ?") == JOptionPane.YES_OPTION) {
//                    if (deleteDataSubKriteria(view.getSelectedTableSubKriteria())) {
//                        view.showMessage("Data Berhasil Di Hapus");
//                    } else {
//                        view.showMessage("Data Gagal Di Hapus");
//                    }
//                }
//            } else {
//                view.showMessage("Tidak Ada Data");
//            }
//            view.setModelTableSubKriteria(dataSubKriteria(getDataSubKriteria()));
//        }
//    }
    private void editSubKriteriaAction() throws SQLException, ParseException {
        if (view.isTableSubKriteriaEnable()) {
            if (view.isTableSubKriteriaSelected()) {
                view.setDetailSubKriteria("Edit Sub Kriteria");
                view.setDataSubKriteria(getDataSubKriteria(view.getSelectedTableSubKriteria()));
                view.setPanelFormSubKriteria("formUser");
            } else {
                view.showMessage("Tidak Ada Data");
            }
        }
    }

    private class editSubKriteriaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                editSubKriteriaAction();
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (view.isTableSubKriteriaEnable()) {
                view.setBackgroundPanel("editSubKriteria", new Color(132, 132, 132));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (view.isTableSubKriteriaEnable()) {
                view.setBackgroundPanel("editSubKriteria", new Color(76, 76, 76));
            }
        }

    }

//    private class deleteSubKriteriaListener implements MouseListener {
//
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            try {
//                deleteSubKriteriaAction();
//            } catch (SQLException ex) {
//                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//            if (view.isTableSubKriteriaEnable()) {
//                view.setBackgroundPanel("deleteSubKriteria", new Color(132, 132, 132));
//            }
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//            if (view.isTableSubKriteriaEnable()) {
//                view.setBackgroundPanel("deleteSubKriteria", new Color(76, 76, 76));
//            }
//        }
//
//    }
    private class cancelSubKriteriaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            cancelSubKriteriaAction();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.setBackgroundPanel("cancelSubKriteria", new Color(132, 132, 132));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.setBackgroundPanel("cancelSubKriteria", new Color(76, 76, 76));
        }

    }

    private class saveSubKriteriaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                saveSubKriteriaAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.setBackgroundPanel("saveSubKriteria", new Color(132, 132, 132));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.setBackgroundPanel("saveSubKriteria", new Color(76, 76, 76));
        }

    }

    private class namaSubKriteriaListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (view.getDataSubKriteria()[1].equalsIgnoreCase("Nama Sub Kriteria")) {
                view.setNamaSubKriteria("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (view.getDataSubKriteria()[1].isEmpty()) {
                view.setNamaSubKriteria("Nama Sub Kriteria");
            }
        }

    }

    private class bobotSubKriteriaListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (view.getDataSubKriteria()[3].equalsIgnoreCase("Bobot Sub Kriteria")) {
                view.setBobotSubKriteria("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (view.getDataSubKriteria()[3].isEmpty()) {
                view.setBobotSubKriteria("Bobot Sub Kriteria");
            }
        }

    }

//    private class nilaiMinSubKriteriaListener implements FocusListener {
//
//        @Override
//        public void focusGained(FocusEvent e) {
//            if (view.getDataSubKriteria()[4].equalsIgnoreCase("Nilai Kesesuaian")) {
//                view.setKesesuaianMinSubKriteria("");
//            }
//        }
//
//        @Override
//        public void focusLost(FocusEvent e) {
//            if (view.getDataSubKriteria()[4].isEmpty()) {
//                view.setKesesuaianMinSubKriteria("Nilai Kesesuaian");
//            }
//        }
//
//    }
//    private class nilaiMaxSubKriteriaListener implements FocusListener {
//
//        @Override
//        public void focusGained(FocusEvent e) {
//            if (view.getDataSubKriteria()[5].equalsIgnoreCase("Nilai Kesesuaian")) {
//                view.setKesesuaianMaxSubKriteria("");
//            }
//        }
//
//        @Override
//        public void focusLost(FocusEvent e) {
//            if (view.getDataSubKriteria()[5].isEmpty()) {
//                view.setKesesuaianMaxSubKriteria("Nilai Kesesuaian");
//            }
//        }
//
//    }
    //================================ Alternative =====================================
    private DefaultTableModel dataAlternative(String[][] dataAlternative) {
        DefaultTableModel model = view.getModelTableAlternative();
        model.setRowCount(0);
        for (String[] dataUser1 : dataAlternative) {
            String row[] = new String[3];
            System.arraycopy(dataUser1, 0, row, 0, 3);
            model.addRow(row);
        }
        return model;
    }

    private void addAlternativeAction() {
        if (view.isTableAlternativeEnable()) {
            view.clearSelectionTableAlternative();
            view.setPanelFormAlternative("formUser");
        }
    }

    private void cancelAlternativeAction() {
        view.setPanelFormAlternative("homeForm");
        view.resetFormAlternative();
    }

    private boolean isDataAlternativeComplete(String data[]) {
        return !(data[0].equalsIgnoreCase("Nama Alternative")
                || data[1].equalsIgnoreCase("Alamat Alternative"));
    }

    private boolean isEditAlternative() {
        return view.getDetailAlternative().equalsIgnoreCase("Edit Alternative");
    }

    private void showAnalisisAction() throws SQLException {
        view.setPanelUtama("grafik");
        analisis();
        view.setGrafik(grafik());
        view.setSaranLahan(getSaran()[0]);
    }

    private void saveAlternativeAction() throws SQLException {
        if (isDataAlternativeComplete(view.getDataAlternative())) {
            if (isEditAlternative()) {
                if (updateDataAlternative(view.getSelectedTableAlternative(), view.getDataAlternative())) {
                    view.showMessage("Data Berhasil Di Update !");
                } else {
                    view.showMessage("Data Gagal Di Update !");
                }
            } else if (insertDataAlternative(view.getDataAlternative())) {
                view.showMessage("Data Berhasil Di Simpan !");
            } else {
                view.showMessage("Data Gagal Di Simpan !");
            }
            view.setModelTableAlternative(dataAlternative(getDataAlternative()));
            view.resetFormAlternative();
            view.setPanelFormAlternative("homeForm");
        } else {
            view.showMessage("Pastikan Semua Data Terisi !");
        }
    }

    private void deleteAlternativeAction() throws SQLException {
        if (view.isTableAlternativeEnable()) {
            if (view.isTableAlternativeSelected()) {
                if (view.showConfirmMessage("Apakah Anda Yakin ?") == JOptionPane.YES_OPTION) {
                    if (deleteDataAlternative(view.getSelectedTableAlternative())) {
                        view.showMessage("Data Berhasil Di Hapus");
                    } else {
                        view.showMessage("Data Gagal Di Hapus");
                    }
                }
            } else {
                view.showMessage("Tidak Ada Data");
            }
            view.setModelTableAlternative(dataAlternative(getDataAlternative()));
        }
    }

    private void editAlternativeAction() throws SQLException, ParseException {
        if (view.isTableAlternativeEnable()) {
            if (view.isTableAlternativeSelected()) {
                view.setDetailAlternative("Edit Alternative");
                view.setDataAlternative(getDataAlternative(view.getSelectedTableAlternative()));
                view.setPanelFormAlternative("formUser");
            } else {
                view.showMessage("Tidak Ada Data");
            }
        }
    }

    private class addAlternativeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            addAlternativeAction();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (view.isTableAlternativeEnable()) {
                view.setBackgroundPanel("addAlternative", new Color(132, 132, 132));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (view.isTableAlternativeEnable()) {
                view.setBackgroundPanel("addAlternative", new Color(76, 76, 76));
            }
        }

    }

    private class editAlternativeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                editAlternativeAction();
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (view.isTableAlternativeEnable()) {
                view.setBackgroundPanel("editAlternative", new Color(132, 132, 132));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (view.isTableAlternativeEnable()) {
                view.setBackgroundPanel("editAlternative", new Color(76, 76, 76));
            }
        }

    }

    private class deleteAlternativeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                deleteAlternativeAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (view.isTableAlternativeEnable()) {
                view.setBackgroundPanel("deleteAlternative", new Color(132, 132, 132));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (view.isTableAlternativeEnable()) {
                view.setBackgroundPanel("deleteAlternative", new Color(76, 76, 76));
            }
        }

    }

    private class cancelAlternativeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            cancelAlternativeAction();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.setBackgroundPanel("cancelAlternative", new Color(132, 132, 132));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.setBackgroundPanel("cancelAlternative", new Color(76, 76, 76));
        }

    }

    private class saveAlternativeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                saveAlternativeAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.setBackgroundPanel("saveAlternative", new Color(132, 132, 132));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.setBackgroundPanel("saveAlternative", new Color(76, 76, 76));
        }

    }

    private class showAnalisisListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                showAnalisisAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.setBackgroundPanel("showAnalisis", new Color(132, 132, 132));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.setBackgroundPanel("showAnalisis", new Color(76, 76, 76));
        }

    }

    private class namaAlternativeListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (view.getDataAlternative()[0].equalsIgnoreCase("Nama Alternative")) {
                view.setNamaAlternative("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (view.getDataAlternative()[0].isEmpty()) {
                view.setNamaAlternative("Nama Alternative");
            }
        }

    }

    private class alamatAlternativeListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (view.getDataAlternative()[1].equalsIgnoreCase("Alamat Alternative")) {
                view.setAlamatAlternative("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (view.getDataAlternative()[1].isEmpty()) {
                view.setAlamatAlternative("Alamat Alternative");
            }
        }

    }

    //============================= Grafik ===================================
    private ChartPanel grafik() throws SQLException {
        String data[][] = getDataGrafik();
        DefaultCategoryDataset a = new DefaultCategoryDataset();
        for (int i = 0; i < data.length; i++) {
            a.addValue(Double.valueOf(data[i][1]), "Total Preferensi", data[i][0]);
        }

        JFreeChart chart = ChartFactory.createBarChart3D("Hasil Analisis", null, null, a, PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel panel = new ChartPanel(chart);
        return panel;
    }

    private DefaultTableModel dataLahan(String[][] dataKriteria) {
        DefaultTableModel model = view.getTableAnalisisModel();
        model.setRowCount(0);
        for (String[] dataLahan : dataKriteria) {
            String row[] = new String[14];
            System.arraycopy(dataLahan, 0, row, 0, row.length);
            model.addRow(row);
        }
        return model;
    }

    private void rincianAction() throws SQLException, ParseException {
        view.setTableAnalisisModel(dataLahan(getDataLahan()));
        view.setPanelUtama("tableAnalisis");
    }

    private void ratingKerjaAction() throws SQLException {
        view.setTableAnalisisModel(dataLahan(getRatingKerja()));
    }

    private void preferensiAction() throws SQLException {
        view.setTableAnalisisModel(dataLahan(getPreferensi(getRatingKerja())));
    }

    private class rincianListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                rincianAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class ratingKerjaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ratingKerjaAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class preferensiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                preferensiAction();
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    private class showDataLahanListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                view.setTableAnalisisModel(dataLahan(getDataLahan()));
            } catch (SQLException ex) {
                Logger.getLogger(CAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.setBackgroundPanel("showDataLahan", new Color(132, 132, 132));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.setBackgroundPanel("showDataLahan", new Color(76, 76, 76));
        }

    }
}
