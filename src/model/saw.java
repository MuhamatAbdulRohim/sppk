package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rohim
 */
public class saw {

    Koneksi con;

    public saw() throws SQLException {
        this.con = new Koneksi();
    }

    public String[][] getRatingKerja() throws SQLException {
        String[] kategori = new String[13];
        String[] subKriteria = new String[13];
        String sql = "select kategori, nama from subkriteria order by length(id_subkriteria), id_subkriteria asc;";
        ResultSet rs2 = con.getResult(sql);
        byte i = 0;
        while (rs2.next()) {
            kategori[i] = rs2.getString(1);
            subKriteria[i] = rs2.getString(2);
            i++;
        }

        String[][] dataLahan;
        String[][] ratingKerja;
        int index = -1;
        String query = "select * from data_lahan";
        ResultSet rs = con.getResult(query);
        rs.last();
        dataLahan = new String[rs.getRow()][14];
        ratingKerja = new String[dataLahan.length][14];
        rs.beforeFirst();
        
        while (rs.next()) {
            index++;
            dataLahan[index][0] = rs.getString(2);
            for (int j = 1; j < dataLahan[index].length; j++) {
                dataLahan[index][j] = rs.getString(j+2);
            }
        }
        
        for (int j = 0; j < dataLahan.length; j++) {
            ratingKerja [j][0] = dataLahan[j][0];
            for (int k = 1; k < dataLahan[j].length; k++) {
                double nilai = 0;
                if (kategori[k-1].equalsIgnoreCase("benefit")) {
                    nilai = Double.valueOf(dataLahan[j][k])/Double.valueOf(getRating(subKriteria[k-1], "benefit"));
                    ratingKerja[j][k] = String.valueOf(nilai);
                } else {
                    nilai = Double.valueOf(getRating(subKriteria[k-1], "cost"))/Double.valueOf(dataLahan[j][k]);
                    ratingKerja[j][k] = String.valueOf(nilai);                    
                }
            }
        }
        return ratingKerja;
    }
    

    public String[][] getPreferensi(String data[][]) throws SQLException {
        String[] bobot = new String[13];
        String sql = "select bobot from subkriteria where status_delete = 0 order by length(id_subkriteria), id_subkriteria asc;";
        ResultSet rs = con.getResult(sql);
        byte index = 0;
        while (rs.next()) {
            bobot[index] = rs.getString(1);
            index++;
        }
        String[][] preferensi = new String[data.length][14];
        for (int i = 0; i < data.length; i++) {
            preferensi[i][0] = data[i][0];
            for (int j = 1; j < 14; j++) {
                double hasil = Double.valueOf(bobot[j - 1]) * Double.valueOf(data[i][j]);
                preferensi[i][j] = String.valueOf(hasil);
            }
        }
        return preferensi;
    }

    public Double getRating(String subKriteria, String kategori) throws SQLException {
        double rating = 0;
        String query = "";

        if (kategori.equalsIgnoreCase("benefit")) {
            query = "select max(" + subKriteria + ") from data_lahan";
        } else {
            query = "select min(" + subKriteria + ") from data_lahan";
        }
        ResultSet rs = con.getResult(query);
        rs.next();
        rating = Double.valueOf(rs.getString(1));
        return rating;
    }
}
