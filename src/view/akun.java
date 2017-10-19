
package view;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rohim
 */
public class akun extends javax.swing.JFrame {

    public akun() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    public String[] getAccount(){
        String data[] = new String [2];
        data[0] = username.getText();
        data[1] = password.getText();
        return data;
    }
    
    public void setAccount(String akun[]){
        this.username.setText(akun[0]);
        this.password.setText(akun[1]);
    }
    
    public void saveOnClick(ActionListener action){
        this.save.addActionListener(action);
    }
    
    public void cancelOnClick(ActionListener action){
        this.cancel.addActionListener(action);
    }
    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        image21 = new addComponent.image2();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        password = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        image21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        save.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        save.setText("Save");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        image21.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 170, 110, -1));

        cancel.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        cancel.setText("Cancel");
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        image21.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 100, -1));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 232, 232));
        jLabel1.setText("Password");
        image21.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        username.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(165, 163, 174));
        username.setText("Nama Sub Kriteria");
        username.setBorder(null);
        username.setOpaque(false);
        image21.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 380, 30));
        image21.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 380, 10));

        password.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(165, 163, 174));
        password.setText("Nama Sub Kriteria");
        password.setBorder(null);
        password.setOpaque(false);
        image21.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 380, 30));
        image21.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 380, 10));

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(239, 232, 232));
        jLabel2.setText("Username");
        image21.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image21, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private addComponent.image2 image21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField password;
    private javax.swing.JButton save;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
