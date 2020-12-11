package model;
public class Supervisor extends Funcionario {
    private final double taxaPorCargoMaior = 0.3;

    public Supervisor(String nome, String cpf, int idade, double salario, String numeroDeIdentificacao, String horaDeChegada, String horaDeSaida) {
        super(nome, cpf, idade, salario, numeroDeIdentificacao, horaDeChegada, horaDeSaida);
    }

    @Override
  	public double calculaSalario() {
  		return super.getSalario()*(1+this.taxaPorCargoMaior);
  	}
    

}
