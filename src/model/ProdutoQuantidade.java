package model;

public class ProdutoQuantidade extends Produto {
    private int quantidade;

    //Construtor
    public ProdutoQuantidade(String descricao, String marca, double preco, String codigoDeBarras, int quantidade) {
        super(descricao, marca, preco, codigoDeBarras);
        this.quantidade = quantidade;
    }

    //@return O preço do produto pelo número de produtos comprados
    @Override
    public double calculaPrecoTotal() {
        return (super.getPreco() * this.quantidade);
    }

    //Getters e setters
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
