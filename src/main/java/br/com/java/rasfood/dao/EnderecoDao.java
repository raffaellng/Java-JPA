package br.com.java.rasfood.dao;

import br.com.java.rasfood.entity.Endereco;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDao {
    private final EntityManager entityManager;

    public EnderecoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final Endereco endereco) {
        this.entityManager.persist(endereco);
//        System.out.println("Entidade Cadastrada:" + endereco);
    }

    public Endereco getById(final Integer id) {
        return this.entityManager.find(Endereco.class, id);
    }

    public List<Endereco> getByAll(){
        String jpql = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(jpql, Endereco.class).getResultList();
    }

    public void update(final Endereco endereco) {
        this.entityManager.merge(endereco);
        System.out.println("Entidade Atualizada:" + endereco);
    }

    public void remove(final Endereco endereco) {
        this.entityManager.remove(endereco);
        System.out.println("Entidade removida:" + endereco);
    }
}
