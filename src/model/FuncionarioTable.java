/*@author Álvaro Souza e Natan Moura
 *@version 1.0
 */
package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class FuncionarioTable {
    private final SimpleStringProperty nomeCol;
    private final SimpleStringProperty cpfCol;
    private final SimpleDoubleProperty salCol;
    private final SimpleStringProperty numCol;
    private final SimpleStringProperty horC;
    private final SimpleStringProperty horS;

    //Construtor
    public FuncionarioTable(String nomeCol, String cpfCol, Double salCol,
                            String numCol, String horC, String horS) {
        this.nomeCol = new SimpleStringProperty(nomeCol);
        this.cpfCol = new SimpleStringProperty(cpfCol);
        this.salCol = new SimpleDoubleProperty(salCol);
        this.numCol = new SimpleStringProperty(numCol);
        this.horC = new SimpleStringProperty(horC);
        this.horS = new SimpleStringProperty(horS);
    }

    //Getters
    public String getNomeCol() {
        return nomeCol.get();
    }

    public String getCpfCol() {
        return cpfCol.get();
    }

    public Double getSalCol() {
        return salCol.get();
    }

    public String getNumCol() {
        return numCol.get();
    }

    public String getHorC() {
        return horC.get();
    }

    public String getHorS() {
        return horS.get();
    }

}
