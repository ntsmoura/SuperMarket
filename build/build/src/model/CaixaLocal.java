package model;

public class CaixaLocal extends Funcionario {
    private int quantidadeDeVendas;
    private final float comissao = (float)0.005;

    public CaixaLocal(String nome, String cpf, int idade, double salario, String numeroDeIdentificacao, String horaDeChegada, String horaDeSaida, int quantidadeDeVendas) {
        super(nome, cpf, idade, salario, numeroDeIdentificacao, horaDeChegada, horaDeSaida);
        this.quantidadeDeVendas = quantidadeDeVendas;
    }

    //@return Sal�rio adicionado de comiss�o
    @Override
	public double calculaSalario() {
		return super.getSalario() + this.calculaComissao();
	}
    
    //@return Comiss�o calculada com base na quantidade de vendas
    public double calculaComissao() {
    	return (double)(comissao*((float)quantidadeDeVendas));
    }
    
    //Getters e Setters
    public int getQuantidadeDeVendas() {
        return quantidadeDeVendas;
    }

    public void setQuantidadeDeVendas(int quantidadeDeVendas) {
        this.quantidadeDeVendas = quantidadeDeVendas;
    }

}
