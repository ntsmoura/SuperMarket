/*@author Álvaro Souza e Natan Moura
 *@version 1.0
 */
package model;

public class Motoboy extends Funcionario {
    private final double taxaDePericulosidade = 0.05;
    private String placaDaMoto;

    public Motoboy(String nome, String cpf, int idade, double salario, String numeroDeIdentificacao, String horaDeChegada,
                   String horaDeSaida, String placaDaMoto) {
        super(nome, cpf, idade, salario, numeroDeIdentificacao, horaDeChegada, horaDeSaida);
        this.placaDaMoto = placaDaMoto;
    }

    //return Salário com adição de uma taxa percentual por periculosidade
    public double calculaSalario() {
        return (super.getSalario() * (1 + this.taxaDePericulosidade));
    }

    //Getters e Setters
    public String getPlacaDaMoto() {
        return placaDaMoto;
    }

    public void setPlacaDaMoto(String placaDaMoto) {
        this.placaDaMoto = placaDaMoto;
    }

}
