package model;
public class Gerente extends Funcionario {
	 private final double taxaPorCargoMaior = 0.5;

    public Gerente(String nome, String cpf, int idade, double salario, String numeroDeIdentificacao, String horaDeChegada, String horaDeSaida) {
        super(nome, cpf, idade, salario, numeroDeIdentificacao, horaDeChegada, horaDeSaida);
    }
    
    @Override
  	public double calculaSalario() {
    	return super.getSalario()*(1+this.taxaPorCargoMaior);
  	}
    

}
