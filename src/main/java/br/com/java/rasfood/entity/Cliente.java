package br.com.java.rasfood.entity;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String cpj;
    private String nome;
    private String email;
    private String cep;

    public Cliente() {
    }

    public Cliente(String cpj, String nome, String email, String cep) {
        this.cpj = cpj;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpj() {
        return cpj;
    }

    public void setCpj(String cpj) {
        this.cpj = cpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpj='" + cpj + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
