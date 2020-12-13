/*@author Álvaro Souza e Natan Moura
 *@version 1.0
 */
package model;

public class Gerente extends Funcionario {
    private final double taxaPorCargoMaior = 0.5;

    //Construtor
    public Gerente(String nome, String cpf, int idade, double salario, String numeroDeIdentificacao, String horaDeChegada,
                   String horaDeSaida) {
        super(nome, cpf, idade, salario, numeroDeIdentificacao, horaDeChegada, horaDeSaida);
    }

    //@return Salário com adição de uma taxa percentual por cargo maior
    @Override
    public double calculaSalario() {
        return super.getSalario() * (1 + this.taxaPorCargoMaior);
    }

}
