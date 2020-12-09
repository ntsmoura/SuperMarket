package model;
public class Motoboy extends Funcionario{
    private String placaDaMoto;
    private final double taxaDePericulosidade = 0.3;

    public Motoboy(String nome, String cpf, int idade, double salario, String numeroDeIdentificacao, String horaDeChegada, String horaDeSaida, String placaDaMoto) {
        super(nome, cpf, idade, salario, numeroDeIdentificacao, horaDeChegada, horaDeSaida);
        this.placaDaMoto = placaDaMoto;
    }

    // Calcula o salário do motoboy
    public double calculaSalario(){
        return (super.getSalario()*(1 + this.taxaDePericulosidade));
    }

    
    //Getters e Setters
    public String getPlacaDaMoto() {
        return placaDaMoto;
    }

    public void setPlacaDaMoto(String placaDaMoto) {
        this.placaDaMoto = placaDaMoto;
    }

}
