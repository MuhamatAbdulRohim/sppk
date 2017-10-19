package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rohim
 */
public class user extends saw {

    public user() throws SQLException {
        con = new Koneksi();
    }

    protected String cekAccount(String[] account) throws SQLException {
        String valid;
        String query = "select u.level, p.status_delete from user u join pegawai p on u.id_pegawai = p.id_pegawai where username = '" + account[0] + "' and password = '" + account[1] + "';";
        ResultSet rs = this.con.getResult(query);
        if (rs.next()) {
            if (rs.getString(2).equalsIgnoreCase("0")) {
                valid = rs.getString(1);
                String query2 = "update user set status = 'online' where username = '" + account[0] + "';";
                con.executeQuery(query2);
            } else {
                valid = "invalid";
            }
        } else {
            valid = "invalid";
        }
        return valid;
    }

    protected void logout(String username) throws SQLException {
        String query = "update user set status = 'Offline' where username = '" + username + "';";
        con.executeQuery(query);
    }

    protected void analisis() throws SQLException {
        String[][] ratingKinerja = getRatingKerja();
        String[][] nilaiPreferensi = getPreferensi(ratingKinerja);
        double jumlah = 0;
        for (int i = 0; i < nilaiPreferensi.length; i++) {
            jumlah = 0;
            for (int j = 1; j < nilaiPreferensi[i].length; j++) {
                jumlah += Double.valueOf(nilaiPreferensi[i][j]);
            }
            String query = "update alternative set nilai = " + jumlah + " where id_alternative = '" + nilaiPreferensi[i][0] + "';";
            con.executeQuery(query);
        }
    }

    protected String[][] getDataGrafik() throws SQLException {
        String dataAlternative[][];
        int index = -1;
        String query = "select nama_alternative, nilai from alternative a join data_lahan d on (a.id_alternative = d.id_alternative ) where status_delete = 0;";
        ResultSet rs = con.getResult(query);
        rs.last();
        dataAlternative = new String[rs.getRow()][2];
        rs.beforeFirst();
        while (rs.next()) {
            index++;
            for (int i = 0; i < 2; i++) {
                dataAlternative[index][i] = rs.getString(i + 1);
            }
        }
        return dataAlternative;
    }

    protected String[] getSaran() throws SQLException {
        String saran[] = new String[2];
        String query = "select nama_alternative, alamat_alternative from alternative order by nilai desc;";
        ResultSet rs = con.getResult(query);
        if (rs.next()) {
            saran[0] = rs.getString(1);
            saran[1] = rs.getString(2);
        }
        return saran;
    }

    protected String[][] getDataLahan() throws SQLException {
        String dataLahan[][];
        int index = -1;
        String query = "select * from data_lahan;";
        ResultSet rs = con.getResult(query);
        rs.last();
        dataLahan = new String[rs.getRow()][14];
        rs.beforeFirst();
        while (rs.next()) {
            index++;
            for (int i = 0; i < 14; i++) {
                dataLahan[index][i] = rs.getString(i + 2);
            }
        }
        return dataLahan;
    }

    protected String[] getDataAccount(String username) throws SQLException {
        String data[] = new String[2];
        String query = "select username, password from user where username = '"+username+"';";
        ResultSet rs = con.getResult(query);
        if (rs.next()) {
            data[0] = rs.getString(1);
            data[1] = rs.getString(2);
        }
        return data;
    }
    
    protected boolean saveAkun(String data[], String username){
        boolean valid = false;
        String query = "update user set username = '"+data[0]+"', password = '"+data[1]+"' where username = '"+username+"';";
        try {
            con.executeQuery(query);
            valid = true;
        } catch (SQLException ex) {
            valid = true;
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valid;
    }
}
