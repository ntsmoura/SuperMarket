package model;

import java.util.ArrayList;
import java.util.Calendar;

public class CompraDelivery extends Compra{
	
	private Calendar dataHoraEntrega;
	private Motoboy motoboy;

	//Construtor
	public CompraDelivery(Calendar dataHoraRealizada, int quantidadeItens, double totalCompra, FormaPagamento pagamento,
			ArrayList<Produto> listaProdutos, Cliente cliente, Calendar dataHoraEntrega, Motoboy motoboy) {
		super(dataHoraRealizada, quantidadeItens, totalCompra, pagamento, listaProdutos, cliente);
		this.dataHoraEntrega = dataHoraEntrega;
		this.motoboy = motoboy;
	}

	//Getters e Setters
	public Calendar getDataHoraEntrega() {
		return dataHoraEntrega;
	}

	public void setDataHoraEntrega(Calendar dataHoraEntrega) {
		this.dataHoraEntrega = dataHoraEntrega;
	}

	public Motoboy getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(Motoboy motoboy) {
		this.motoboy = motoboy;
	}
	
	
	
	

}
