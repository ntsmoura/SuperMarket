/*@author Álvaro Souza e Natan Moura
 *@version 1.0
 */
package model;

public class CaixaLocal extends Funcionario {
    private int quantidadeDeVendas;
    private final float comissao = (float) 0.005;

    //Construtor
    public CaixaLocal(String nome, String cpf, int idade, double salario, String numeroDeIdentificacao, String horaDeChegada,
                      String horaDeSaida, int quantidadeDeVendas) {
        super(nome, cpf, idade, salario, numeroDeIdentificacao, horaDeChegada, horaDeSaida);
        this.quantidadeDeVendas = quantidadeDeVendas;
    }

    //@return Salário adicionado de comissão
    @Override
    public double calculaSalario() {
        return super.getSalario() + this.calculaComissao();
    }

    //@return Comissão calculada com base na quantidade de vendas
    public double calculaComissao() {
        return comissao * ((float) quantidadeDeVendas);
    }

    //Getters e Setters
    public int getQuantidadeDeVendas() {
        return quantidadeDeVendas;
    }

    public void setQuantidadeDeVendas(int quantidadeDeVendas) {
        this.quantidadeDeVendas = quantidadeDeVendas;
    }

}
