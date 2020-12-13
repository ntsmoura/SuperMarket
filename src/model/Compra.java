/*@author Álvaro Souza e Natan Moura
 *@version 1.0
 */
package model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Compra {
    private Date dataHoraRealizada;
    private int quantidadeItens;
    private double TotalCompra;
    private FormaPagamento pagamento;
    private ArrayList<Produto> listaProdutos;
    private Cliente cliente;

    //Construtor
    public Compra(Date dataHoraRealizada, int quantidadeItens, double totalCompra, FormaPagamento pagamento,
                  ArrayList<Produto> listaProdutos, Cliente cliente) {
        this.dataHoraRealizada = dataHoraRealizada;
        this.quantidadeItens = quantidadeItens;
        TotalCompra = totalCompra;
        this.pagamento = pagamento;
        this.listaProdutos = listaProdutos;
        this.cliente = cliente;
    }

    //Getters e Setters
    public Date getDataHoraRealizada() {
        return dataHoraRealizada;
    }

    public void setDataHoraRealizada(Date dataHoraRealizada) {
        this.dataHoraRealizada = dataHoraRealizada;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public double getTotalCompra() {
        return TotalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        TotalCompra = totalCompra;
    }

    public FormaPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
