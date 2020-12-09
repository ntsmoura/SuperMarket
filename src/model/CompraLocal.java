package model;

import java.util.ArrayList;
import java.util.Calendar;

public class CompraLocal extends Compra{
	
	private CaixaLocal atendente;

	public CompraLocal(Calendar dataHoraRealizada, int quantidadeItens, double totalCompra, FormaPagamento pagamento,
			ArrayList<Produto> listaProdutos, Cliente cliente, CaixaLocal atendente) {
		super(dataHoraRealizada, quantidadeItens, totalCompra, pagamento, listaProdutos, cliente);
		this.atendente = atendente;
	}

	//Getters e Setters
	public CaixaLocal getAtendente() {
		return atendente;
	}

	public void setAtendente(CaixaLocal atendente) {
		this.atendente = atendente;
	}
	
	

}
