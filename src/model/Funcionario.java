package model;
public abstract class Funcionario extends Pessoa {
    private double salario;
    private String numeroDeIdentificacao;
    private String horaDeChegada;
    private String horaDeSaida;

    public Funcionario(String nome, String cpf, int idade, double salario, String numeroDeIdentificacao, String horaDeChegada, String horaDeSaida) {
        super(nome, cpf, idade);
        this.salario = salario;
        this.numeroDeIdentificacao = numeroDeIdentificacao;
        this.horaDeChegada = horaDeChegada;
        this.horaDeSaida = horaDeSaida;
    }
    
    //Método para cálculo de salário
    public abstract double calculaSalario();
    
    
    //Getters e Setters
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNumeroDeIdentificacao() {
        return numeroDeIdentificacao;
    }

    public void setNumeroDeIdentificacao(String numeroDeIdentificacao) {
        this.numeroDeIdentificacao = numeroDeIdentificacao;
    }

    public String getHoraDeChegada() {
        return horaDeChegada;
    }

    public void setHoraDeChegada(String horaDeChegada) {
        this.horaDeChegada = horaDeChegada;
    }

    public String getHoraDeSaida() {
        return horaDeSaida;
    }

    public void setHoraDeSaida(String horaDeSaida) {
        this.horaDeSaida = horaDeSaida;
    }
}
