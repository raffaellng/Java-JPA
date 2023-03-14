package br.com.java.rasfood.dao;

import br.com.java.rasfood.entity.Ordem;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDao {
    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final Ordem ordem) {
        this.entityManager.persist(ordem);
        System.out.println("Entidade Cadastrada:" + ordem);
    }

    public Ordem getById(final Integer id) {
        return this.entityManager.find(Ordem.class, id);
    }

    public List<Ordem> getByAll(){
        String jpql = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(jpql, Ordem.class).getResultList();
    }

    public void update(final Ordem ordem) {
        this.entityManager.merge(ordem);
        System.out.println("Entidade Atualizada:" + ordem);
    }

    public void remove(final Ordem ordem) {
        this.entityManager.remove(ordem);
        System.out.println("Entidade removida:" + ordem);
    }
}
