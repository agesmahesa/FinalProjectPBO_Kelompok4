package final_project;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.ArrayList;

public abstract class Nasabah {
    protected IntegerProperty id_nasabah;
    protected StringProperty nama;
    protected StringProperty alamat;
    protected IntegerProperty numRek;
    protected ArrayList <Rekening> rekening;

    public Nasabah(int id_nasabah, String nama, String alamat, ArrayList<Rekening> rekening) {
        this.id_nasabah = new SimpleIntegerProperty(id_nasabah);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.rekening = rekening;
        this.numRek = new SimpleIntegerProperty(rekening.size());
    }

    public Nasabah(int id_nasabah, String nama, String alamat, Rekening rekenings) {
        rekening = new ArrayList<>();
        this.id_nasabah = new SimpleIntegerProperty(id_nasabah);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.rekening.add(rekenings);
        this.numRek = new SimpleIntegerProperty(this.rekening.size());
    }

    public int getId_nasabah() {
        return id_nasabah.get();
    }

    public IntegerProperty id_nasabahProperty() {
        return id_nasabah;
    }

    public void setId_nasabah(int id_nasabah) {
        this.id_nasabah.set(id_nasabah);
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public StringProperty namaProperty() {
        return nama;
    }

    public String getAlamat() {
        return alamat.get();
    }

    public StringProperty alamatProperty() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    public int getNumRek() {
        return numRek.get();
    }

    public IntegerProperty numRekProperty() {
        return numRek;
    }

    public void setNumRek(int numRek) {
        this.numRek.set(numRek);
    }

    public ArrayList<Rekening> getRekening() {
        return rekening;
    }

    public void setRekening(ArrayList<Rekening> rekening) {
        this.rekening = rekening;
    }


}
