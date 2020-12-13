package model;

public class Cartao extends FormaPagamento {

    private int parcelas;
    private boolean debito;

    //Construtor
    public Cartao(String descricao, double valor, int parcelas, boolean debito) {
        super(descricao, valor);
        this.parcelas = parcelas;
        this.debito = debito;
    }

    //Getters e Setters
    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public boolean isDebito() {
        return debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }

}
