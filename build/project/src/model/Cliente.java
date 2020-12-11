package model;
public abstract class Cliente {
	private String nome;
	private String cpf;
    private long cnpj;

    // Caso o cliente seja pessoa jur�dica
    public Cliente(String nome, long cnpj) {
    	this.cpf = "";
        this.nome = nome;
        this.cnpj = cnpj;
    }

    //Caso o cliente seja pessoa f�sica
    public Cliente(String nome, String cpf) {
    	this.cnpj = 0;
        this.nome = nome;
        this.cpf = cpf;
    }

    //Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
    
}
