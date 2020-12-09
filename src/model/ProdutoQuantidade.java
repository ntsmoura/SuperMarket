package model;
public class ProdutoQuantidade extends Produto {
    private int quantidade;


    public ProdutoQuantidade(String descricao, String marca, double preco, String codigoDeBarras, int quantidade) {
        super(descricao, marca, preco, codigoDeBarras);
        this.quantidade = quantidade;
    }
    

    // Calcula preço pela numero de produtos comprados
    @Override
    public double calculaPrecoTotal(){
        return (super.getPreco()*this.quantidade);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
