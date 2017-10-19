package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rohim
 */
public final class Koneksi {

    Connection con;
    Statement stm;

    public Koneksi() throws SQLException {
        this.openConnection();
    }

    public void executeQuery(String query) throws SQLException {
        this.stm.execute(query);
    }

    public ResultSet getResult(String query) throws SQLException {
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }
    
    public Connection getConnection(){
        return this.con;
    }
    
    public void closeConnection() throws SQLException{
        this.con.close();
    }
    
    public void openConnection() throws SQLException{
        this.con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/spk_kesesuaian_lahan", "root", "772502");
        this.stm = (Statement) this.con.createStatement();
    }
}
