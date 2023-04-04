package br.com.java.rasfood.vo;

public class ClienteVo {
    private String Cpf;
    private String Nome;

    public ClienteVo(String cpf, String nome) {
        Cpf = cpf;
        Nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    @Override
    public String toString() {
        return "ClienteVo{" +
                "Cpf='" + Cpf + '\'' +
                ", Nome='" + Nome + '\'' +
                '}';
    }
}
