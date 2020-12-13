package model;

public class ClienteLocal extends Cliente {
    private boolean usandoEstacionamento;

    //Construtor Pessoa Jurídica
    public ClienteLocal(String nome, long cnpj, boolean usandoEstacionamento) {
        super(nome, cnpj);
        this.usandoEstacionamento = usandoEstacionamento;
    }

    //Construtor Pessoa Física
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
