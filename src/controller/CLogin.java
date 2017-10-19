package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import model.MPegawai;
import model.user;
import view.VPegawai;
import view.Vadmin;
import view.Vlogin;

/**
 *
 * @author rohim
 */
public class CLogin extends user {

    Vlogin view;
    Icon closeIcon1, closeIcon2, minimizeIcon1, minimizeIcon2;

    public CLogin(Vlogin view) throws SQLException {
        this.closeIcon1 = new javax.swing.ImageIcon(getClass().getResource("/image/close_1.png"));
        this.closeIcon2 = new javax.swing.ImageIcon(getClass().getResource("/image/close_2.png"));
        this.minimizeIcon1 = new javax.swing.ImageIcon(getClass().getResource("/image/minimize_1.png"));
        this.minimizeIcon2 = new javax.swing.ImageIcon(getClass().getResource("/image/minimize_2.png"));

        this.view = view;
        this.view.setVisible(true);
        this.view.closeOnClick(new closeListener());
        this.view.minimizeOnClick(new minimizeListener());
        this.view.usernameOnFocus(new usernameListener());
        this.view.passwordOnFocus(new passwordListener());
        this.view.showPassOnClick(new showPassListener());
        this.view.loginOnClick(new loginListener());
    }

    private void closeAction() {
        if (view.showConfirmMessage("Apakah Anda Yakin Akan Keluar ?") == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void minimizeAction() {
        view.minimize();
        view.minimizeSetIcon(minimizeIcon1);
    }

    private void loginAction() throws SQLException {
        if (view.getAccount()[0].isEmpty() || view.getAccount()[1].isEmpty()) {
            view.showMessage("Pastikan Username dan Password Terisi");
        } else if (cekAccount(view.getAccount()).equalsIgnoreCase("admin")) {
            new CAdmin(new Vadmin(), view.getAccount()[0]);
            view.setVisible(false);
        } else if (cekAccount(view.getAccount()).equalsIgnoreCase("pegawai")) {
            new CPegawai(new VPegawai(), view.getAccount()[0]);
            view.setVisible(false);
        } else {
            view.showMessage("Username atau Password Salah !");
        }
    }

    private class closeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            closeAction();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.closeSetIcon(closeIcon2);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.closeSetIcon(closeIcon1);
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

    private class usernameListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (view.getAccount()[0].equalsIgnoreCase("Your Username")) {
                view.setUsername("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (view.getAccount()[0].isEmpty()) {
                view.setUsername("Your Username");
            }
        }

    }

    private class passwordListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (view.getAccount()[1].equalsIgnoreCase("Your Password")) {
                view.setPassword("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (view.getAccount()[1].isEmpty()) {
                view.setPassword("Your Password");
            }
        }

    }

    private class showPassListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.isShowCheked()) {
                view.setVisiblePass((char) 0);
            } else {
                view.setVisiblePass('*');
            }
        }

    }

    private class loginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                loginAction();
            } catch (SQLException ex) {
                Logger.getLogger(CLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
