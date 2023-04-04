package br.com.java.rasfood.dao;

import javax.persistence.Id;
import java.io.Serializable;

public class ClienteId implements Serializable {
    private String cpf;
    private String email;

    public ClienteId() {
    }

    public ClienteId(String cpf, String email) {
        this.cpf = cpf;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ClienteId{" +
                "cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
