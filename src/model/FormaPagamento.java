/*@author Álvaro Souza e Natan Moura
 *@version 1.0
 */
package model;

public abstract class FormaPagamento {
    private String descricao;
    private double valor;

    //Construtor
    public FormaPagamento(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    //Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
