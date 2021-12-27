package final_project;

import Database.DBHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NasabahDataModel {
    public final Connection conn;


    public NasabahDataModel() throws SQLException {
        this.conn = DBHelper.getConnection();
    }

    public void tambahNasabah(Individu individu) throws SQLException {
        String insertNasabah = "INSERT INTO nasabah (id_nasabah, nama, alamat)"
                + " VALUES (?, ?, ?)";
        String insertIndividu = "INSERT INTO individu (id_nasabah, nik, npwp)"
                + " VALUES (?, ?, ?)";
        String insertRekening = "INSERT INTO rekening (no_rekening, saldo, id_nasabah)"
                + " VALUES (?, ?, ?)";
        
        PreparedStatement stetNasabah = conn.prepareStatement(insertNasabah);
        stetNasabah.setInt(1,individu.getId_nasabah());
        stetNasabah.setString(2,individu.getNama());
        stetNasabah.setString(3, individu.getAlamat());
        stetNasabah.execute();

        PreparedStatement stetIndividu = conn.prepareStatement(insertIndividu);
        stetIndividu.setInt(1,individu.getId_nasabah());
        stetIndividu.setLong(2,individu.getNik());
        stetIndividu.setLong(3, individu.getNpwp());
        stetIndividu.execute();

        PreparedStatement stetRekening = conn.prepareStatement(insertRekening);
        stetRekening.setInt(1,individu.getRekening().get(0).getNo_rekening());
        stetRekening.setDouble(2,individu.getRekening().get(0).getSaldo());
        stetRekening.setLong(3, individu.getId_nasabah());
        stetRekening.execute();
    }

    public void tambahNasabah(Perusahaan perusahaan) throws SQLException {
        String insertNasabah = "INSERT INTO nasabah (id_nasabah, nama, alamat)"
                + " VALUES (?, ?, ?)";
        String insertPerusahaan = "INSERT INTO perusahaan (id_nasabah, nib)"
                + " VALUES (?, ?)";
        String insertRekening = "INSERT INTO rekening (no_rekening, saldo, id_nasabah)"
                + " VALUES (?, ?, ?)";

        PreparedStatement stetNasabah = conn.prepareStatement(insertNasabah);
        stetNasabah.setInt(1,perusahaan.getId_nasabah());
        stetNasabah.setString(2,perusahaan.getNama());
        stetNasabah.setString(3, perusahaan.getAlamat());
        stetNasabah.execute();

        PreparedStatement stetPerusahaan = conn.prepareStatement(insertPerusahaan);
        stetPerusahaan.setInt(1,perusahaan.getId_nasabah());
        stetPerusahaan.setString(2,perusahaan.getNib());
        stetPerusahaan.execute();

        PreparedStatement stetRekening = conn.prepareStatement(insertRekening);
        stetRekening.setInt(1,perusahaan.getRekening().get(0).getNo_rekening());
        stetRekening.setDouble(2,perusahaan.getRekening().get(0).getSaldo());
        stetRekening.setLong(3, perusahaan.getId_nasabah());
        stetRekening.execute();
    }

    public ObservableList<Individu> getIndividu(){
        ObservableList<Individu> data = FXCollections.observableArrayList();
        String sql="SELECT `id_nasabah`, `nama`,`alamat`, `nik`, `npwp` "
                + "FROM `nasabah` NATURAL JOIN `individu` "
                + "ORDER BY id_nasabah";
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            while (resultSet.next()){
                String sqlRek = "SELECT no_rekening, saldo "
                        + "FROM rekening WHERE id_nasabah="+resultSet.getInt(1);
                ResultSet rsRek = conn.createStatement().executeQuery(sqlRek);
                ArrayList<Rekening> dataRekening = new ArrayList<>();
                while (rsRek.next()){
                    dataRekening.add(new Rekening(rsRek.getInt(1),rsRek.getDouble(2)));
                }
                data.add(new Individu(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),dataRekening,resultSet.getLong(4),resultSet.getLong(5)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(NasabahDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public ObservableList<Perusahaan> getPerusahaan(){
        ObservableList<Perusahaan> data = FXCollections.observableArrayList();
        String sql="SELECT `id_nasabah`, `nama`,`alamat`, `nib` "
                + "FROM `nasabah` NATURAL JOIN `perusahaan` "
                + "ORDER BY id_nasabah";
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            while (resultSet.next()){
                String sqlRek = "SELECT no_rekening, saldo "
                        + "FROM rekening WHERE id_nasabah="+resultSet.getInt(1);
                ResultSet rsRek = conn.createStatement().executeQuery(sqlRek);
                ArrayList<Rekening> dataRekening = new ArrayList<>();
                while (rsRek.next()){
                    dataRekening.add(new Rekening(rsRek.getInt(1),rsRek.getDouble(2)));
                }
                data.add(new Perusahaan(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),dataRekening,resultSet.getString(4)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(NasabahDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public ObservableList<Rekening> getRekening (int id_nasabah){
        ObservableList<Rekening> data = FXCollections.observableArrayList();
        String sql = "SELECT no_rekening, saldo " +
                "FROM rekening WHERE id_nasabah=" + id_nasabah;
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            while (resultSet.next()){
                data.add(new Rekening(resultSet.getInt(1), resultSet.getDouble(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NasabahDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    public int nextId_nasabah_i () throws SQLException {
        String sql = "SELECT MAX(id_nasabah) " +
                "FROM individu";
        ResultSet resultSet = conn.createStatement().executeQuery(sql);
        while (resultSet.next()){
            return resultSet.getInt(1)==0?1100001:resultSet.getInt(1)+1;
        }
        return 1100001;
    }

    public int nextId_nasabah_p () throws SQLException {
        String sql = "SELECT MAX(id_nasabah) " +
                "FROM perusahaan";
        ResultSet resultSet = conn.createStatement().executeQuery(sql);
        while (resultSet.next()){
            return resultSet.getInt(1)==0?1200001:resultSet.getInt(1)+1;
        }
        return 1200001;
    }

    public int nextNo_rekening(int id_nasabah) throws SQLException {
        String sql = "SELECT MAX(no_rekening) " +
                "FROM rekening WHERE id_nasabah=" + id_nasabah;
        ResultSet resultSet = conn.createStatement().executeQuery(sql);
        while (resultSet.next()){
            return resultSet.getInt(1)+1;
        }
        return 0;
    }

    public void tambahRekening(int id_nasaah,Rekening rek) throws SQLException {
        String insertRekening = "INSERT INTO rekening (no_rekening, saldo, id_nasabah)"
                + " VALUES (?, ?, ?)";

        PreparedStatement stetRekening = conn.prepareStatement(insertRekening);
        stetRekening.setInt(1,rek.getNo_rekening());
        stetRekening.setDouble(2,rek.getSaldo());
        stetRekening.setInt(3, id_nasaah);
        stetRekening.execute();
    }
}
