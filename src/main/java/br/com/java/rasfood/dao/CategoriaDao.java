package br.com.java.rasfood.dao;

import br.com.java.rasfood.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final Categoria categoria) {
        this.entityManager.persist(categoria);
//        System.out.println("Entidade Cadastrada:" + categoria);
    }

    public Categoria getById(final Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }

    public void update(final Categoria categoria) {
        this.entityManager.merge(categoria);
//        System.out.println("Entidade Atualizada:" + categoria);
    }

    public void remove(final Categoria categoria) {
        this.entityManager.remove(categoria);
        System.out.println("Entidade removida:" + categoria);
    }

    public List<Categoria> getbyAll() {
        String jpql = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(jpql,Categoria.class).getResultList();
    }
}
