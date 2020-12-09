package model;
public class ClienteLocal extends Cliente {
    private boolean usandoEstacionamento;

    // caso o cliente queira fazer uma compra com cnpj ele se cadastra com cnpj
    public ClienteLocal(String nome, long cnpj, boolean usandoEstacionamento) {
        super(nome, cnpj);
        this.usandoEstacionamento = usandoEstacionamento;
    }

    // Overload em cnpj, caso a compra seja em pessoa física
    public ClienteLocal(String nome, String cpf, boolean usandoEstacionamento) {
        super(nome, cpf);
        this.usandoEstacionamento = usandoEstacionamento;
    }

    
    //Getters e Setters
    public boolean isUsandoEstacionamento() {
        return usandoEstacionamento;
    }

    public void setUsandoEstacionamento(boolean usandoEstacionamento) {
        this.usandoEstacionamento = usandoEstacionamento;
    }
}
