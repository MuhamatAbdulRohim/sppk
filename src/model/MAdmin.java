package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rohim
 */
public class MAdmin extends user {

    public MAdmin() throws SQLException {
        con = new Koneksi();
    }

    protected String[][] getDataUser() throws SQLException {
        String dataUser[][];
        byte no = 0;
        int index = -1;
        String query = "select p.id_pegawai, p.nama, u.status from pegawai p join user u on u.id_pegawai = p.id_pegawai where p.status_delete = 0;";
        ResultSet rs = con.getResult(query);
        rs.last();
        dataUser = new String[rs.getRow()][4];
        rs.beforeFirst();
        while (rs.next()) {
            no++;
            index++;
            dataUser[index][0] = String.valueOf(no);
            for (int i = 1; i < 4; i++) {
                dataUser[index][i] = rs.getString(i);
            }
        }
        return dataUser;
    }

    protected String newIdPegawai() throws SQLException {
        String id = "PEG";
        String sql, idPeg;
        int nowID;
        sql = "select id_pegawai from pegawai order by length(id_pegawai), id_pegawai asc";
        ResultSet rs = con.getResult(sql);
        rs.last();
        idPeg = rs.getString(1);
        nowID = Integer.valueOf(idPeg.substring(3, idPeg.length())) + 1;
        idPeg = id + nowID;
        return idPeg;
    }

    protected boolean insertDataUser(String data[]) {
        String query;
        try {
            query = "insert into pegawai values ('" + newIdPegawai() + "','" + data[0] + "','" + data[1] + "','" + data[2] + "','"
                    + data[3] + "',null,0);";
            con.executeQuery(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    protected boolean deleteDataUser(String id) {
        String query = "update pegawai set status_delete = 1 where id_pegawai = '" + id + "';";
        try {
            con.executeQuery(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    protected boolean updateDataUser(String id, String data[]) {
        String query = "update pegawai set nama = '" + data[0] + "', alamat = '" + data[1] + "', tempat_lahir = '" + data[2] + "', tgl_lahir = '" + data[3] + "' "
                + "where id_pegawai = '" + id + "';";
        try {
            con.executeQuery(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    protected String[] getData(String id) throws SQLException {
        String data[] = new String[5];
        String query = "select nama, alamat, tempat_lahir, tgl_lahir, tgl_masuk from pegawai where id_pegawai = '" + id + "';";
        ResultSet rs = con.getResult(query);
        if (rs.next()) {
            for (int i = 0; i < 5; i++) {
                data[i] = rs.getString(i + 1);
            }
        }
        return data;
    }

    // ========================= Kriteria =================================
//    protected String newIdKriteria() throws SQLException {
//        String id = "KRT";
//        String sql, idKrt;
//        int nowID;
//        sql = "select id_kriteria from kriteria order by length(id_kriteria), id_kriteria asc";
//        ResultSet rs = con.getResult(sql);
//        rs.last();
//        idKrt = rs.getString(1);
//        nowID = Integer.valueOf(idKrt.substring(3, idKrt.length())) + 1;
//        idKrt = id + nowID;
//        return idKrt;
//    }
    protected String[][] getDataKriteria() throws SQLException {
        String dataKriteria[][];
        byte no = 0;
        int index = -1;
        String query = "select id_kriteria, nama, tgl_masuk from kriteria where status_delete = 0;";
        ResultSet rs = con.getResult(query);
        rs.last();
        dataKriteria = new String[rs.getRow()][4];
        rs.beforeFirst();
        while (rs.next()) {
            no++;
            index++;
            dataKriteria[index][0] = String.valueOf(no);
            for (int i = 1; i < 4; i++) {
                dataKriteria[index][i] = rs.getString(i);
            }
        }
        return dataKriteria;
    }

    protected boolean updateDataKriteria(String id, String data) {
        String query = "update kriteria set nama = '" + data + "' where id_kriteria = '" + id + "';";
        try {
            con.executeQuery(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

//    protected boolean insertDataKriteria(String data) {
//        String query;
//        try {
//            query = "insert into kriteria values ('" + newIdKriteria() + "','" + data + "',null,0);";
//            con.executeQuery(query);
//            return true;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }
//    protected boolean deleteDataKriteria(String id) {
//        String query = "update kriteria set status_delete = 1 where id_kriteria = '" + id + "';";
//        try {
//            con.executeQuery(query);
//            return true;
//        } catch (SQLException ex) {
//            Logger.getLogger(MAdmin.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }

    protected String[] getDataKriteria(String id) throws SQLException {
        String data[] = new String[2];
        String query = "select nama,  tgl_masuk from kriteria where id_kriteria = '" + id + "';";
        ResultSet rs = con.getResult(query);
        if (rs.next()) {
            for (int i = 0; i < 2; i++) {
                data[i] = rs.getString(i + 1);
            }
        }
        return data;
    }

    // ========================= Kriteria =================================
//    protected String newIdSubKriteria() throws SQLException {
//        String id = "SUB";
//        String sql, idSub;
//        int nowID;
//        sql = "select id_subkriteria from subkriteria order by length(id_subkriteria), id_subkriteria asc";
//        ResultSet rs = con.getResult(sql);
//        rs.last();
//        idSub = rs.getString(1);
//        nowID = Integer.valueOf(idSub.substring(3, idSub.length())) + 1;
//        idSub = id + nowID;
//        return idSub;
//    }
    protected String[][] getDataSubKriteria() throws SQLException {
        String dataSubKriteria[][];
        byte no = 0;
        int index = -1;
        String query = "select s.id_subkriteria, s.nama, k.nama, s.kategori "
                + "from subkriteria s join kriteria k on (s.id_kriteria = k.id_kriteria) where s.status_delete = 0 order by length(id_subkriteria), id_subkriteria asc;";
        ResultSet rs = con.getResult(query);
        rs.last();
        dataSubKriteria = new String[rs.getRow()][5];
        rs.beforeFirst();
        while (rs.next()) {
            no++;
            index++;
            dataSubKriteria[index][0] = String.valueOf(no);
            for (int i = 1; i < 5; i++) {
                dataSubKriteria[index][i] = rs.getString(i);
            }
        }
        return dataSubKriteria;
    }

    protected boolean updateDataSubKriteria(String id, String data[]) {
        String query = "update subkriteria set nama = '" + data[1] + "', kategori = '" + data[2] + "', "
                + "bobot = " + data[3] + " where id_subkriteria = '" + id + "';";
        try {
            con.executeQuery(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

//    protected boolean insertDataSubKriteria(String[] data) throws SQLException {
//        String query;
//        String idKriteria = "";
//        String query2 = "select id_kriteria from kriteria where nama = '" + data[0] + "';";
//        ResultSet rs = con.getResult(query2);
//        if (rs.next()) {
//            idKriteria = rs.getString(1);
//        }
//        try {
//            query = "insert into subkriteria values ('" + newIdSubKriteria() + "','" + idKriteria + "','"
//                    + data[1] + "','" + data[2] + "', " + data[3] + ", " + data[4] + "," + data[5] + ",null,0);";
//            con.executeQuery(query);
//            return true;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }

//    protected boolean deleteDataSubKriteria(String id) {
//        String query = "update subkriteria set status_delete = 1 where id_subkriteria = '" + id + "';";
//        try {
//            con.executeQuery(query);
//            return true;
//        } catch (SQLException ex) {
//            Logger.getLogger(MAdmin.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }

    protected String[] getDataSubKriteria(String id) throws SQLException {
        String data[] = new String[4];
        String query = "select k.nama, s.nama, s.kategori, s.bobot from subkriteria s join kriteria k on (s.id_kriteria = k.id_kriteria)"
                + " where id_subkriteria = '" + id + "';";
        ResultSet rs = con.getResult(query);
        if (rs.next()) {
            for (int i = 0; i < data.length; i++) {
                data[i] = rs.getString(i + 1);
            }
        }
        return data;
    }

    protected String[] getKriteria() throws SQLException {
        String data[];
        String query = "select nama from kriteria where status_delete = 0;";
        ResultSet rs = con.getResult(query);
        rs.last();
        data = new String[rs.getRow()];
        rs.beforeFirst();
        int index = 0;
        while (rs.next()) {
            data[index] = rs.getString(1);
            index++;
        }
        return data;
    }

    // ========================= Alternative =================================
    protected String newIdAlternative() throws SQLException {
        String id = "ALT";
        String sql, idAlt;
        int nowID;
        sql = "select id_alternative from alternative order by length(id_alternative), id_alternative asc";
        ResultSet rs = con.getResult(sql);
        rs.last();
        idAlt = rs.getString(1);
        nowID = Integer.valueOf(idAlt.substring(3, idAlt.length())) + 1;
        idAlt = id + nowID;
        return idAlt;
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

    protected boolean updateDataAlternative(String id, String data[]) {
        String query = "update alternative set nama_alternative = '" + data[0] + "', alamat_alternative = '" + data[1] + "' where id_alternative = '" + id + "';";
        try {
            con.executeQuery(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    protected boolean insertDataAlternative(String data[]) {
        String query;
        try {
            query = "insert into alternative values ('" + newIdAlternative() + "','" + data[0] + "','" + data[1] + "',0,null,0);";
            con.executeQuery(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    protected boolean deleteDataAlternative(String id) {
        String query = "delete from alternative where id_alternative = '" + id + "';";
        try {
            con.executeQuery(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    protected String[] getDataAlternative(String id) throws SQLException {
        String data[] = new String[2];
        String query = "select nama_alternative,  alamat_alternative from alternative where id_alternative = '" + id + "';";
        ResultSet rs = con.getResult(query);
        if (rs.next()) {
            for (int i = 0; i < 2; i++) {
                data[i] = rs.getString(i + 1);
            }
        }
        return data;
    }

    protected String getNilaiAlternative(String id) throws SQLException {
        String nilai = "0";
        String query = "select nilai from alternative where id_alternative = '" + id + "';";
        ResultSet rs = con.getResult(query);
        if (rs.next()) {
            nilai = rs.getString(1);
        }
        return nilai;
    }

    protected boolean setNilaiAlternative(String id, String nilai) {
        String query = "update alternative set nilai = " + nilai + " where id_alternative = '" + id + "';";
        boolean succes;
        try {
            con.executeQuery(query);
            succes = true;
        } catch (SQLException ex) {
            succes = false;
            Logger.getLogger(MAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return succes;
    }

}
