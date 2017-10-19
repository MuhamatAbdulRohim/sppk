package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MPegawai;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import view.VPegawai;
import view.Vlogin;

/**
 *
 * @author rohim
 */
public class CPegawai extends MPegawai {

    private VPegawai view;
    Icon logoutIcon1, logoutIcon2, minimizeIcon1, minimizeIcon2, backGrafikIcon1, backGrafikIcon2;
    String username;

    public CPegawai(VPegawai view, String username) throws SQLException {
        this.view = view;
        this.username = username;
        this.logoutIcon1 = new javax.swing.ImageIcon(getClass().getResource("/image/logout_1.png"));
        this.logoutIcon2 = new javax.swing.ImageIcon(getClass().getResource("/image/logout_2.png"));
        this.minimizeIcon1 = new javax.swing.ImageIcon(getClass().getResource("/image/minimize_1.png"));
        this.minimizeIcon2 = new javax.swing.ImageIcon(getClass().getResource("/image/minimize_2.png"));
        this.backGrafikIcon1 = new javax.swing.ImageIcon(getClass().getResource("/image/Rewind-100.resized.png"));
        this.backGrafikIcon2 = new javax.swing.ImageIcon(getClass().getResource("/image/Rewind-100_2.resized.png"));

        this.view.logoutOnClick(new logoutListener());
        this.view.minimizeOnClick(new minimizeListener());
        this.view.changeAccountOnClick(new changeAccountListener());

        //=========== menu ============
        this.view.homeOnClick(new homeListener());
        this.view.tableAlternativeOnClick(new tableAlternativeListener());
        this.view.analisisOnClick(new grafikListener());

        //=========== daftar alternative ===========
        this.view.masukkanOnClick(new masukkanListener());

        //=========== Form Pengisian ===============
        this.view.saveOnClick(new saveFormListener());
        this.view.cancelOnClick(new cancelFormListener());

        //========================= Alternative ===========
        this.view.rincianOnClick(new rincianListener());

        //========================= Table Analisis ===============
        this.view.matriksKerjaOnClick(new ratingKerjaListener());
        this.view.matriksPreferensiOnClick(new preferensiListener());
        this.view.dataLahanOnClick(new showDataLahanListener());

        this.view.backAnalisisOnClick(new backAnalisisListener());
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

    private void changeAccountAction() throws SQLException {
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

    private void showAnalisisAction() throws SQLException {
        view.setPanelUtama("grafik");
        analisis();
        view.setGrafik(grafik());
        view.setSaranLahan(getSaran()[0]);
    }

    private void backTableAction() throws SQLException {
        showAnalisisAction();
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

    //========================= Menu ==========================================
    private void homeAction() {
        view.setPanelUtama("home");
    }

    private void tableAlternativeAction() throws SQLException {
        view.setTableAlternative(setTableAlternative(getDataAlternative()));
        view.setPanelUtama("daftar");
    }

    private void analisisAction() throws SQLException {
        view.setPanelUtama("grafik");
        analisis();
        view.setGrafik(grafik());
        view.setSaranLahan(getSaran()[0]);
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

    private class tableAlternativeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                tableAlternativeAction();
            } catch (SQLException ex) {
                Logger.getLogger(CPegawai.class.getName()).log(Level.SEVERE, null, ex);
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
            if (!"daftar".equalsIgnoreCase(view.getPanelUtama()) && !"form".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("daftar", new Color(136, 133, 151));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!"daftar".equalsIgnoreCase(view.getPanelUtama()) && !"form".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("daftar", new Color(96, 91, 120));
            }
        }

    }

    private class grafikListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                analisisAction();
            } catch (SQLException ex) {
                Logger.getLogger(CPegawai.class.getName()).log(Level.SEVERE, null, ex);
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
            if (!"grafik".equalsIgnoreCase(view.getPanelUtama()) && !"hasilAnalisis".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("grafik", new Color(136, 133, 151));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!"grafik".equalsIgnoreCase(view.getPanelUtama()) && !"hasilAnalisis".equalsIgnoreCase(view.getPanelUtama())) {
                view.setBackgroundPanel("grafik", new Color(96, 91, 120));
            }
        }

    }

    // ======================= Daftar Alternative =============================
    private DefaultTableModel setTableAlternative(String[][] data) {
        DefaultTableModel model = view.getModelTableAlternative();
        model.setRowCount(0);
        for (String[] dataAlternative : data) {
            String row[] = new String[3];
            System.arraycopy(dataAlternative, 0, row, 0, row.length);
            model.addRow(row);
        }
        return model;
    }

    private void masukkanAction() {
        if (view.isTableSelected()) {
            view.setIdAlternative(view.getIdAlternativeTable());
            view.setPanelUtama("form");
        } else {
            view.showMessage("Tidak ada Data !");
        }
    }

    private class masukkanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            masukkanAction();
        }

    }

    //=================== Form Pengisian ===============
    private void cancelAction() throws SQLException {
        if (view.showConfirmMessage("Apakah Anda Yakin ?") == JOptionPane.YES_OPTION) {
            view.resetForm();
            tableAlternativeAction();
        }
    }

    private void saveAction() {
        try {
            if (!isUpdate(view.getData(getKategori()))) {
                if (save(view.getData(getKategori()))) {
                    view.showMessage("Data Berhasil Disimpan !");
                } else {
                    view.showMessage("Data Gagal Disimpan !");
                }
            } else {
                if (update(view.getData(getKategori()))) {
                    view.showMessage("Data Berhasil Diupdate !");
                } else {
                    view.showMessage("Data Gagal Disimpan !");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CPegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class saveFormListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            saveAction();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.saveOnHover("enter");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.saveOnHover("exit");
        }

    }

    private class cancelFormListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                cancelAction();
            } catch (SQLException ex) {
                Logger.getLogger(CPegawai.class.getName()).log(Level.SEVERE, null, ex);
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
            view.cancelOnHover("enter");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.cancelOnHover("exit");
        }

    }

    //================= Grafik ===================
    private ChartPanel grafik() throws SQLException {
        String data[][] = getDataGrafik();
        DefaultCategoryDataset a = new DefaultCategoryDataset();
        for (int i = 0; i < data.length; i++) {
            a.addValue(Double.valueOf(data[i][1]), "Alternative", data[i][0]);
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
