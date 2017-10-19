package view;

import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author rohim
 */
public class Vlogin extends javax.swing.JFrame {

    public Vlogin() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    public void setUsername(String username){
        this.username.setText(username);
    }
    
    public void setPassword(String password){
        this.pass.setText(password);
    }
    
    public void setVisiblePass(char echoChar){
        this.pass.setEchoChar(echoChar);
    }

    public String[] getAccount() {
        String account[] = new String[2];
        account[0] = this.username.getText();
        account[1] = String.valueOf(this.pass.getPassword());
        return account;
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public int showConfirmMessage(String Message){
        return JOptionPane.showConfirmDialog(this, Message, "Confirm Message", JOptionPane.YES_NO_OPTION);
    }

    public void loginOnClick(ActionListener acion) {
        this.login.addActionListener(acion);
    }
    
    public void closeOnClick(MouseListener acion) {
        this.close.addMouseListener(acion);
    }
    
    public void closeSetIcon(Icon icon){
        this.close.setIcon(icon);
    }
    
    public void minimizeOnClick(MouseListener acion) {
        this.minimize.addMouseListener(acion);
    }
    
    public void minimize(){
       this.setState(Frame.ICONIFIED);
    }
    
    public void minimizeSetIcon(Icon icon){
        this.minimize.setIcon(icon);
    }
    
    public void usernameOnFocus(FocusListener focus){
        this.username.addFocusListener(focus);
    }
    
    public void passwordOnFocus(FocusListener focus){
        this.pass.addFocusListener(focus);
    }
    
    public void showPassOnClick(ActionListener action){
        this.showPass.addActionListener(action);
    }
    
    public boolean isShowCheked(){
        return this.showPass.isSelected();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        pass = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        showPass = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        close = new javax.swing.JButton();
        minimize = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(123, 188, 247));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Lock-104(1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 167, 160));

        jLabel2.setBackground(new java.awt.Color(238, 231, 224));
        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(234, 247, 249));
        jLabel2.setText("___________");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, 50));

        jLabel4.setBackground(new java.awt.Color(238, 231, 224));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(234, 247, 249));
        jLabel4.setText("Sistem Penentu Kesesuaian Lahan");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel7.setBackground(new java.awt.Color(238, 231, 224));
        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(234, 247, 249));
        jLabel7.setText("Login Panel");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        jLabel8.setBackground(new java.awt.Color(238, 231, 224));
        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(234, 247, 249));
        jLabel8.setText("___________________");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, 50));

        jLabel9.setBackground(new java.awt.Color(238, 231, 224));
        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(234, 247, 249));
        jLabel9.setText("___________________");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 380, 490));

        jPanel2.setBackground(new java.awt.Color(96, 91, 120));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 280, 20));

        jLabel3.setBackground(new java.awt.Color(238, 231, 224));
        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(234, 247, 249));
        jLabel3.setText("Username");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        username.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(238, 234, 234));
        username.setText("Your Username");
        username.setBorder(null);
        username.setOpaque(false);
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 280, 30));

        jLabel6.setBackground(new java.awt.Color(238, 231, 224));
        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(234, 247, 249));
        jLabel6.setText("Password");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 280, 20));

        pass.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        pass.setForeground(new java.awt.Color(241, 239, 239));
        pass.setText("Your Password");
        pass.setBorder(null);
        pass.setOpaque(false);
        jPanel2.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 280, 30));

        login.setBackground(new java.awt.Color(123, 188, 247));
        login.setFont(new java.awt.Font("Agency FB", 1, 15)); // NOI18N
        login.setForeground(new java.awt.Color(244, 240, 240));
        login.setText("Masuk");
        login.setBorder(null);
        login.setBorderPainted(false);
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.setFocusPainted(false);
        jPanel2.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 100, 30));

        jLabel10.setBackground(new java.awt.Color(238, 231, 224));
        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(234, 247, 249));
        jLabel10.setText("Masukkan Username dan Password");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        showPass.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        showPass.setForeground(new java.awt.Color(245, 235, 235));
        showPass.setText("Tampilkan Password");
        showPass.setContentAreaFilled(false);
        showPass.setFocusPainted(false);
        jPanel2.add(showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 380, 490));

        jPanel3.setBackground(new java.awt.Color(130, 146, 149));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close_1.png"))); // NOI18N
        close.setBorder(null);
        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.setFocusPainted(false);
        jPanel3.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 30, 40));

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/minimize_1.png"))); // NOI18N
        minimize.setBorder(null);
        minimize.setBorderPainted(false);
        minimize.setContentAreaFilled(false);
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.setFocusPainted(false);
        jPanel3.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 30, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton login;
    private javax.swing.JButton minimize;
    private javax.swing.JPasswordField pass;
    private javax.swing.JCheckBox showPass;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
