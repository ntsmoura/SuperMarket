/*@author Álvaro Souza e Natan Moura
 *@version 1.0
 */
package model;
public class Supervisor extends Funcionario {
    private final double taxaPorCargoMaior = 0.3;

    //Construtor
    public Supervisor(String nome, String cpf, int idade, double salario, String numeroDeIdentificacao,
                      String horaDeChegada, String horaDeSaida) {
        super(nome, cpf, idade, salario, numeroDeIdentificacao, horaDeChegada, horaDeSaida);
    }

    //@return Salário com adição de percentual por cargo maior
    @Override
  	public double calculaSalario() {
  		return super.getSalario()*(1+this.taxaPorCargoMaior);
  	}

}
