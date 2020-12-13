/*@author Álvaro Souza e Natan Moura
 *@version 1.0
 */
package model;

public class Dinheiro extends FormaPagamento {
    private double troco;
    private double recebido;

    //Construtor
    public Dinheiro(String descricao, double valor, double troco, double recebido) {
        super(descricao, valor);
        this.troco = troco;
        this.recebido = recebido;
    }

    //Getters e Setters
    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public double getRecebido() {
        return recebido;
    }

    public void setRecebido(double recebido) {
        this.recebido = recebido;
    }

}
