/*@author Álvaro Souza e Natan Moura
 *@version 1.0
 */
package model;
public class ProdutoPesado extends Produto {
    private double peso;

    //Construtor
    public ProdutoPesado(String descricao, String marca, double preco, String codigoDeBarras, double peso) {
        super(descricao, marca, preco, codigoDeBarras);
        this.peso = peso;
    }

    //@return O preço pelo peso do produto assumindo que o preço seja por quilo
    @Override
    public double calculaPrecoTotal(){
        return (super.getPreco()*this.peso);
    }

    //Getters e setters
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

}
