package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class FolhaDePagamentoTable {
    private final SimpleStringProperty nomeCol;
    private final SimpleStringProperty cargoCol;
    private final SimpleDoubleProperty salarioCol;
    private final SimpleDoubleProperty comissoesCol;
    private final SimpleDoubleProperty totalCol;

    //Construtor
    public FolhaDePagamentoTable(String nomeCol, String cargoCol, Double salarioCol,
                                 Double comissoesCol, Double totalCol) {
        this.nomeCol = new SimpleStringProperty(nomeCol);
        this.cargoCol = new SimpleStringProperty(cargoCol);
        this.salarioCol = new SimpleDoubleProperty(salarioCol);
        this.comissoesCol = new SimpleDoubleProperty(comissoesCol);
        this.totalCol = new SimpleDoubleProperty(totalCol);
    }

    //Getters
    public String getNomeCol() {
        return nomeCol.get();
    }

    public String getCargoCol() {
        return cargoCol.get();
    }

    public Double getSalarioCol() {
        return salarioCol.get();
    }

    public Double getComissoesCol() {
        return comissoesCol.get();
    }

    public Double getTotalCol() {
        return totalCol.get();
    }
}
