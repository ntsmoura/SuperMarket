package model;

public abstract class Funcionario {
    private String nome;
    private String cpf;
    private int idade;
    private double salario;
    private String numeroDeIdentificacao;
    private String horaDeChegada;
    private String horaDeSaida;

    //Construtor
    public Funcionario(String nome, String cpf, int idade, double salario, String numeroDeIdentificacao,
                       String horaDeChegada, String horaDeSaida) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
