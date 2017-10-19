package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rohim
 */
public class MPegawai extends user {

    public MPegawai() throws SQLException {
        con = new Koneksi();
    }

    protected String[][] getDataAlternative() throws SQLException {
        String dataAlternative[][];
        byte no = 0;
        int index = -1;
        String query = "select id_alternative, nama_alternative from alternative where status_delete = 0;";
        ResultSet rs = con.getResult(query);
        rs.last();
        dataAlternative = new String[rs.getRow()][3];
        rs.beforeFirst();
        while (rs.next()) {
            no++;
            index++;
            dataAlternative[index][0] = String.valueOf(no);
            for (int i = 1; i < 3; i++) {
                dataAlternative[index][i] = rs.getString(i);
            }
        }
        return dataAlternative;
    }

    protected String[] getKategori() throws SQLException {
        String[] data = new String[13];
        String sql = "select kategori from subkriteria order by length(id_subkriteria), id_subkriteria asc;";
        ResultSet rs = con.getResult(sql);
        byte index = 0;
        while (rs.next()) {
            data[index] = rs.getString(1);
            index++;
        }
        return data;
    }

    protected boolean save(String data[]) throws SQLException {
        String sql = "insert into data_lahan values (null,'" + data[13] + "'," + data[0] + "," + data[1] + ","
                + "" + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8] + ","
                + "" + data[9] + "," + data[10] + "," + data[11] + "," + data[12] + ");";
        try {
            con.executeQuery(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MPegawai.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    protected boolean isUpdate(String data[]) throws SQLException{
        String query = "select id_alternative from data_lahan where id_alternative = '"+data[13]+"';";
        ResultSet rs = con.getResult(query);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }
    
    protected boolean update(String data[]){
        String query = "update data_lahan set curah_hujan = "+data[0]+", lama_bulan_kering = "+data[1]+", lereng = "+data[2]+", kedalaman_efektif = "+data[3]+", tekstur = "+data[4]+", prosentase_batu = "+data[5]+","
                + "genangan = "+data[6]+", ph = "+data[7]+", nitrogen = "+data[8]+", phospor = "+data[9]+", kalium = "
                +data[10]+", salinitas = "+data[11]+", kejenuhan = "+data[12]+" where id_alternative = '"+data[13]+"';";
        try {
            con.executeQuery(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MPegawai.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
