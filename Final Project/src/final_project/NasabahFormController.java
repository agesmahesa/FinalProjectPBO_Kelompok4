package final_project;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class NasabahFormController implements Initializable {

    @FXML
    private TextField tfID_Nasabah_I;

    @FXML
    private TextField tfNama_I;

    @FXML
    private TextField tfAlamat_I;

    @FXML
    private TextField tfNik_I;

    @FXML
    private TextField tfNpwp_I;

    @FXML
    private TextField tfNoRek_I;

    @FXML
    private TextField tfSaldo_I;

    @FXML
    private Button btnClear_I;

    @FXML
    private Button btnRefresh_I;

    @FXML
    private Button btnTambahNasabah_I;

    @FXML
    private TableView<Individu> tbvIndividu;

    @FXML
    private TableColumn<Individu, Integer> colId_Nasabah_I;

    @FXML
    private TableColumn<Individu, String> colNama_I;

    @FXML
    private TableColumn<Individu, String> colAlamat_I;

    @FXML
    private TableColumn<Individu, Long> colNik_I;

    @FXML
    private TableColumn<Individu, Long> colNpwp_I;

    @FXML
    private TableColumn<Individu, Integer> colNoRek_I;

    @FXML
    private TableView<Rekening> tbvRekening_I;

    @FXML
    private TableColumn<Rekening, Integer> colNoRekBaru_I;

    @FXML
    private TableColumn<Rekening, Double> colSaldo_I;

    @FXML
    private TextField tfId_NasabahBaru_I;

    @FXML
    private TextField tfNoRekBaru_I;

    @FXML
    private TextField tfSaldoBaru_I;

    @FXML
    private Button btnTambahRekening_I;

    @FXML
    private TextField tfNominal_I;

    @FXML
    private Button btnTambahSaldo_I;

    @FXML
    private Button btnTarikTunai_I;

    @FXML
    private TextField tfID_Nasabah_P;

    @FXML
    private TextField tfNama_P;

    @FXML
    private TextField tfAlamat_P;

    @FXML
    private TextField tfNib_p;

    @FXML
    private TextField tfNoRek_P;

    @FXML
    private TextField tfSaldo_P;

    @FXML
    private Button btnClear_P;

    @FXML
    private Button btnRefresh_P;

    @FXML
    private Button btnTambahNasabah_P;

    @FXML
    private TableView<Perusahaan> tbvPerusahaan;

    @FXML
    private TableColumn<Perusahaan, Integer> colId_Nasabah_P;

    @FXML
    private TableColumn<Perusahaan, String> colNama_P;

    @FXML
    private TableColumn<Perusahaan, String> colAlamat_P;

    @FXML
    private TableColumn<Perusahaan, String> colNib_P;

    @FXML
    private TableColumn<Perusahaan, Integer> colNoRek_P;

    @FXML
    private TableView<Rekening> tbvRekening_P;

    @FXML
    private TableColumn<Rekening, Integer> colNoRekBaru_P;

    @FXML
    private TableColumn<Rekening, Double> colSaldo_P;

    @FXML
    private TextField tfID_NasabahBaru_P;

    @FXML
    private TextField tfNoRekBaru_P;

    @FXML
    private TextField tfSaldoBaru_P;

    @FXML
    private Button btnTambahRekening_P;

    @FXML
    private TextField tfNominal_P;

    @FXML
    private Button btnTambahSaldo_P;

    @FXML
    private Button btnTarikTunai_P;

    @FXML
    private TextField tfPilihan_I;

    @FXML
    private TextField tfPilihan_P;

    @FXML
    private Label lbStatus;

    @FXML
    private Label lbResult_P;

    @FXML
    private Label lbResult_I;

    private NasabahDataModel ndm;

    private Rekening rekG;

    @FXML
    void handleClearBtn_I(ActionEvent event) {
        try {
            tfID_Nasabah_I.setText("" + ndm.nextId_nasabah_i());
            tfNama_I.setText("");
            tfAlamat_I.setText("");
            tfNik_I.setText("");
            tfNpwp_I.setText("");
            tfNoRek_I.setText(tfID_Nasabah_I.getText() + "01");
            tfSaldo_I.setText("");
            tfNominal_I.setText("");
            tfPilihan_I.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleClearBtn_P(ActionEvent event) {
        try {
            tfID_Nasabah_P.setText("" + ndm.nextId_nasabah_p());
            tfNama_P.setText("");
            tfAlamat_P.setText("");
            tfNib_p.setText("");
            tfNoRek_P.setText(tfID_Nasabah_P.getText() + "01");
            tfSaldo_P.setText("");
            tfNominal_P.setText("");
            tfPilihan_P.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleRefreshBtn_I(ActionEvent event) {
        ObservableList<Individu> data = ndm.getIndividu();
        colId_Nasabah_I.setCellValueFactory(new PropertyValueFactory<>("id_nasabah"));
        colNama_I.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colAlamat_I.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        colNik_I.setCellValueFactory(new PropertyValueFactory<>("nik"));
        colNpwp_I.setCellValueFactory(new PropertyValueFactory<>("npwp"));
        colNoRek_I.setCellValueFactory(new PropertyValueFactory<>("numRek"));
        tbvIndividu.setItems(null);
        tbvIndividu.setItems(data);
        btnTambahRekening_I.setDisable(true);
        tfPilihan_I.setText("");
    }

    @FXML
    void handleRefreshBtn_P(ActionEvent event) {
        ObservableList<Perusahaan> data = ndm.getPerusahaan();
        colId_Nasabah_P.setCellValueFactory(new PropertyValueFactory<>("id_nasabah"));
        colNama_P.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colAlamat_P.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        colNib_P.setCellValueFactory(new PropertyValueFactory<>("nib"));
        colNoRek_P.setCellValueFactory(new PropertyValueFactory<>("numRek"));
        tbvPerusahaan.setItems(null);
        tbvPerusahaan.setItems(data);
        btnTambahRekening_P.setDisable(true);
        tfPilihan_P.setText("");
    }

    @FXML
    void handleTambahNasabahBtn_I(ActionEvent event) {
        Individu indv = new Individu(Integer.parseInt(tfID_Nasabah_I.getText()), tfNama_I.getText(), tfAlamat_I.getText()
                , new Rekening(Integer.parseInt(tfNoRek_I.getText()),Double.parseDouble(tfSaldo_I.getText()))
                , Long.parseLong(tfNik_I.getText()),Long.parseLong(tfNpwp_I.getText()));
        try {
            ndm.tambahNasabah(indv);
            lbResult_I.setText("Rekening Berhasil Dibuat");
            btnRefresh_I.fire();
            btnClear_I.fire();
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleTambahNasabahBtn_P(ActionEvent event) {
        Perusahaan peru = new Perusahaan(Integer.parseInt(tfID_Nasabah_P.getText()), tfNama_P.getText(), tfAlamat_P.getText()
                , new Rekening(Integer.parseInt(tfNoRek_P.getText()),Double.parseDouble(tfSaldo_P.getText()))
                , tfNib_p.getText());
        try {
            ndm.tambahNasabah(peru);
            lbResult_P.setText("Rekening Berhasil Dibuat");
            btnRefresh_P.fire();
            btnClear_P.fire();
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleTambahRekeningBtn_I(ActionEvent event) {
        try {
            Rekening rek = new Rekening(Integer.parseInt(tfNoRekBaru_I.getText()),Double.parseDouble(tfSaldoBaru_I.getText()));
            ndm.tambahRekening(Integer.parseInt(tfId_NasabahBaru_I.getText()),rek);
            viewRekening_I(Integer.parseInt(tfId_NasabahBaru_I.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnRefresh_I.fire();
        tfSaldoBaru_I.setText("");
    }

    @FXML
    void handleTambahRekeningBtn_P(ActionEvent event) {
        try {
            Rekening rek = new Rekening(Integer.parseInt(tfNoRekBaru_P.getText()),Double.parseDouble(tfSaldoBaru_P.getText()));
            ndm.tambahRekening(Integer.parseInt(tfID_NasabahBaru_P.getText()),rek);
            viewRekening_P(Integer.parseInt(tfID_NasabahBaru_P.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnRefresh_P.fire();
        tfSaldoBaru_P.setText("");
    }

    @FXML
    void handleTambahSaldoBtn_I(ActionEvent event) throws SQLException {
        Double saldoBaru = rekG.getSaldo() + Double.parseDouble(tfNominal_I.getText());
        String sqlSaldo = "UPDATE rekening SET saldo = " + saldoBaru
                + " WHERE no_rekening = " + rekG.getNo_rekening();
        PreparedStatement stetSaldo = ndm.conn.prepareStatement(sqlSaldo);
        stetSaldo.execute();
        stetSaldo.close();
        btnRefresh_I.fire();
        btnClear_I.fire();
        viewRekening_I(Integer.parseInt(tfId_NasabahBaru_I.getText()));
        tfPilihan_I.setText("Berhasil");
    }

    @FXML
    void handleTambahSaldoBtn_P(ActionEvent event) throws SQLException {
        Double saldoBaru = rekG.getSaldo() + Double.parseDouble(tfNominal_P.getText());
        String sqlSaldo = "UPDATE rekening SET saldo = " + saldoBaru
                + " WHERE no_rekening = " + rekG.getNo_rekening();
        PreparedStatement stetSaldo = ndm.conn.prepareStatement(sqlSaldo);
        stetSaldo.execute();
        stetSaldo.close();
        btnRefresh_P.fire();
        btnClear_P.fire();
        viewRekening_P(Integer.parseInt(tfID_NasabahBaru_P.getText()));
        tfPilihan_P.setText("Berhasil");
    }

    @FXML
    void handleTarikTunaiBtn_I(ActionEvent event) throws SQLException {
        if (rekG.getSaldo() < Double.parseDouble(tfNominal_I.getText())){
            tfPilihan_I.setText("Saldo Tidak Cukup");
        } else {
            Double saldoBaru = rekG.getSaldo() - Double.parseDouble(tfNominal_I.getText());
            String sqlSaldo = "UPDATE rekening SET saldo = " + saldoBaru
                    + " WHERE no_rekening = " + rekG.getNo_rekening();
            PreparedStatement stetSaldo = ndm.conn.prepareStatement(sqlSaldo);
            stetSaldo.execute();
            stetSaldo.close();
            btnRefresh_I.fire();
            btnClear_I.fire();
            viewRekening_I(Integer.parseInt(tfId_NasabahBaru_I.getText()));
            tfPilihan_I.setText("Berhasil");
        }
    }

    @FXML
    void handleTarikTunaiBtn_P(ActionEvent event) throws SQLException {
        if (rekG.getSaldo() < Double.parseDouble(tfNominal_P.getText())){
            tfPilihan_P.setText("Saldo Tidak Mencukupi");
        } else {
            Double saldoBaru = rekG.getSaldo() - Double.parseDouble(tfNominal_P.getText());
            String sqlSaldo = "UPDATE rekening SET saldo = " + saldoBaru
                    + " WHERE no_rekening = " + rekG.getNo_rekening();
            PreparedStatement stetSaldo = ndm.conn.prepareStatement(sqlSaldo);
            stetSaldo.execute();
            stetSaldo.close();
            btnRefresh_P.fire();
            btnClear_P.fire();
            viewRekening_P(Integer.parseInt(tfID_NasabahBaru_P.getText()));
            tfPilihan_P.setText("Berhasil");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ndm = new NasabahDataModel();
            lbStatus.setText(ndm.conn != null?"Connected":"Not Connected");

            btnClear_I.fire();
            btnRefresh_I.fire();
            btnClear_P.fire();
            btnRefresh_P.fire();

        } catch (SQLException ex) {
            Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Select Tabel Individu
        tbvIndividu.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if (tbvIndividu.getSelectionModel().getSelectedItem() != null){
                Individu individu = tbvIndividu.getSelectionModel().getSelectedItem();
                viewRekening_I(individu.getId_nasabah());
                btnTambahRekening_I.setDisable(false);
                tfId_NasabahBaru_I.setText("" + individu.getId_nasabah());
                lbResult_I.setText("");
                try {
                    tfNoRekBaru_I.setText("" + ndm.nextNo_rekening(individu.getId_nasabah()));
                } catch (SQLException ex) {
                    Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Select Tabel Perusahaan
        tbvPerusahaan.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if (tbvPerusahaan.getSelectionModel().getSelectedItem() != null){
                Perusahaan perusahaan = tbvPerusahaan.getSelectionModel().getSelectedItem();
                viewRekening_P(perusahaan.getId_nasabah());
                btnTambahRekening_P.setDisable(false);
                tfID_NasabahBaru_P.setText("" + perusahaan.getId_nasabah());
                lbResult_P.setText("");
                try {
                    tfNoRekBaru_P.setText("" + ndm.nextNo_rekening(perusahaan.getId_nasabah()));
                } catch (SQLException ex) {
                    Logger.getLogger(NasabahFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Select Tabel Rekening individu
        tbvRekening_I.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if (tbvRekening_I.getSelectionModel().getSelectedItem() != null) {
                rekG = tbvRekening_I.getSelectionModel().getSelectedItem();
                btnTarikTunai_I.setDisable(false);
                btnTambahSaldo_I.setDisable(false);
                tfNominal_I.setDisable(false);
                lbResult_I.setText("");
                tfPilihan_I.setText("" + rekG.getNo_rekening());
            }
        });

        //Select Tabel Rekening perusahaan
        tbvRekening_P.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if (tbvRekening_P.getSelectionModel().getSelectedItem() != null) {
                rekG = tbvRekening_P.getSelectionModel().getSelectedItem();
                btnTarikTunai_P.setDisable(false);
                btnTambahSaldo_P.setDisable(false);
                tfNominal_P.setDisable(false);
                lbResult_P.setText("");
                tfPilihan_P.setText("" + rekG.getNo_rekening());
            }
        });
    }    

    public void viewRekening_I(int id_nasabah){
        ObservableList<Rekening> data = ndm.getRekening(id_nasabah);
        colNoRekBaru_I.setCellValueFactory(new PropertyValueFactory<>("no_rekening"));
        colSaldo_I.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tbvRekening_I.setItems(null);
        tbvRekening_I.setItems(data);
    }

    public void viewRekening_P(int id_nasabah){
        ObservableList<Rekening> data = ndm.getRekening(id_nasabah);
        colNoRekBaru_P.setCellValueFactory(new PropertyValueFactory<>("no_rekening"));
        colSaldo_P.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tbvRekening_P.setItems(null);
        tbvRekening_P.setItems(data);
    }
}
