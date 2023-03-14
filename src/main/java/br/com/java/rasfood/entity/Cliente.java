package br.com.java.rasfood.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String cpj;
    private String nome;
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecoList = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String cpj, String nome, String email) {
        this.cpj = cpj;
        this.nome = nome;
        this.email = email;
    }

    public void addEndereco(Endereco endereco){
        endereco.setCliente(this);
        this.enderecoList.add(endereco);
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

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpj='" + cpj + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", enderecoList='" + enderecoList + '\'' +
                '}';
    }
}
