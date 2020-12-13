/*@author Álvaro Souza e Natan Moura
 *@version 1.0
 */
package model;
public abstract class Produto {
    private String marca;
    private String descricao;
    private double preco;
    private String codigoDeBarras;

    //Construtor
    public Produto(String descricao, String marca, double preco, String codigoDeBarras) {
        this.marca = marca;
        this.preco = preco;
        this.descricao = descricao;
        this.codigoDeBarras = codigoDeBarras;
    }
    //@return o preço pelo peso(em Kg) ou quantidade de produto
    public abstract double calculaPrecoTotal(); //Calcula preço do produto na compra
    
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
