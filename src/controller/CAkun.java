
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.user;
import view.akun;

/**
 *
 * @author rohim
 */

public class CAkun extends user {
    
    akun view;
    Component comp;
    String username;
    
    public CAkun(Component comp, String data[]) throws SQLException{
        this.view = new akun();
        this.comp = comp;
        this.username = data[0];
        this.view.setVisible(true);
        this.view.setAccount(data);
        this.comp.setEnabled(false);
        this.view.saveOnClick(new saveListener());
        this.view.cancelOnClick(new cancelListener());
    }
    
    private void cancelAction(){
        this.view.dispose();
        this.comp.setEnabled(true);
    }
    
    private void saveAction(){
        if (saveAkun(view.getAccount(), username)) {
            view.showMessage("Akun Berhasil Di Perbaharui !");
            cancelAction();
        } else {
            view.showMessage("Akun Gagal Di Perbaharui !");
        }
    }
    
    private class cancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cancelAction();
        }
        
    }
    
    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            saveAction();
        }
        
    }
}
