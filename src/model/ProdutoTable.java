package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProdutoTable {
	private final SimpleStringProperty descricao;
	private final SimpleIntegerProperty qtd;
	private final SimpleDoubleProperty peso;
	private final SimpleDoubleProperty precoUnit;
	private final SimpleDoubleProperty precoTotal;

	//Construtor
	public ProdutoTable(String descricao, Integer qtd, Double peso, Double precoUnit, Double precoTotal) {
		this.descricao = new SimpleStringProperty(descricao);
		this.qtd = new SimpleIntegerProperty(qtd);
		this.peso = new SimpleDoubleProperty(peso);
		this.precoUnit = new SimpleDoubleProperty(precoUnit);
		this.precoTotal = new SimpleDoubleProperty(precoTotal);
	}

	//Getters e setters
	public String getDescricao() {
		return descricao.get();
	}
	
	public Integer getQtd() {
		return qtd.get();
	}
	
	public Double getPeso() {
		return peso.get();
	}
	
	public Double getPrecoUnit() {
		return precoUnit.get();
	}
	
	public Double getPrecoTotal() {
		return precoTotal.get();
	}

}
