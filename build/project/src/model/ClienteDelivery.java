package model;
public class ClienteDelivery extends Cliente{
    private String telefone;
    private String endereco;

    // Caso a compra for por cnpj
    public ClienteDelivery(String nome, long cnpj, String telefone, String endereco) {
        super(nome, cnpj);
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // caso a compra for por cpf
    public ClienteDelivery(String nome, String cpf, String telefone,String endereco) {
        super(nome, cpf);
        this.telefone = telefone;
        this.endereco = endereco;
        
    }

    
    //Getters e Setters
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    
    
    
    
}
