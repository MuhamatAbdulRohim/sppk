package sppk;

import controller.CLogin;
import java.sql.SQLException;
import view.Vlogin;

/**
 *
 * @author rohim
 */
public class SPPK {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        new CLogin(new Vlogin());
    }
    
}
