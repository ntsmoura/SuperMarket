package model;

import java.util.ArrayList;
import java.util.Date;

public class CompraDelivery extends Compra{
	
	private String dataHoraEntrega;
	private Motoboy motoboy;

	//Construtor
	public CompraDelivery(Date dataHoraRealizada, int quantidadeItens, double totalCompra, FormaPagamento pagamento,
			ArrayList<Produto> listaProdutos, Cliente cliente,String dataHoraEntrega, Motoboy motoboy) {
		super(dataHoraRealizada, quantidadeItens, totalCompra, pagamento, listaProdutos, cliente);
		this.dataHoraEntrega = dataHoraEntrega;
		this.motoboy = motoboy;
	}

	//Getters e Setters
	public String getDataHoraEntrega() {
		return dataHoraEntrega;
	}

	public void setDataHoraEntrega(String dataHoraEntrega) {
		this.dataHoraEntrega = dataHoraEntrega;
	}

	public Motoboy getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(Motoboy motoboy) {
		this.motoboy = motoboy;
	}
	
	
	
	

}
