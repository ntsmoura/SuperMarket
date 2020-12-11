package model;
public class ProdutoPesado extends Produto {
    private double peso;

    public ProdutoPesado(String descricao, String marca, double preco, String codigoDeBarras, double peso) {
        super(descricao, marca, preco, codigoDeBarras);
        this.peso = peso;
    }

    // Calcula o preço pelo peso do produto
    // Assumindo que o preco do produto seja por quilo
    @Override
    public double calculaPrecoTotal(){
        return (super.getPreco()*this.peso);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
