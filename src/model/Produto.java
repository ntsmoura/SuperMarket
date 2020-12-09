package model;
public abstract class Produto {
    private String marca;
    private String descricao;
    private double preco; // O preço é pela unidade ou por quilo de produto e quem calcula o preço final são as classes específicas
    private String codigoDeBarras;

    public Produto(String descricao, String marca, double preco, String codigoDeBarras) {
        this.marca = marca;
        this.preco = preco;
        this.descricao = descricao;
        this.codigoDeBarras = codigoDeBarras;
    }

    public abstract double calculaPrecoTotal(); //Calcula pre�o do produto na compra
    
    //Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    
}
