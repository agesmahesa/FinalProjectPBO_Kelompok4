package final_project;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Rekening {
    private IntegerProperty no_rekening;
    private DoubleProperty saldo;

    public Rekening(int no_rekening, double saldo) {
        this.no_rekening = new SimpleIntegerProperty(no_rekening);
        this.saldo = new SimpleDoubleProperty(saldo);
    }

    public int getNo_rekening() {
        return no_rekening.get();
    }

    public void setNo_rekening(int no_rekening) {
        this.no_rekening.set(no_rekening);
    }

    public double getSaldo() {
        return saldo.get();
    }

    public void setSaldo(double saldo) {
        this.saldo.set(saldo);
    }

    public void tambahSaldo(double jumlah){
        this.saldo.set(this.saldo.get() + jumlah);
    }

    public void tarikTunai(double jumlah){
        this.saldo.set(this.saldo.get() - jumlah);
    }

    public IntegerProperty no_rekeningProperty() {
        return no_rekening;
    }

    public DoubleProperty saldoProperty() {
        return saldo;
    }
}
