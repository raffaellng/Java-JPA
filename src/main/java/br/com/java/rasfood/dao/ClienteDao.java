package br.com.java.rasfood.dao;

import br.com.java.rasfood.entity.Categoria;
import br.com.java.rasfood.entity.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {
    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final Cliente cliente) {
        this.entityManager.persist(cliente);
//        System.out.println("Entidade Cadastrada:" + cliente);
    }

    public Cliente getById(final Integer id) {
        return this.entityManager.find(Cliente.class, id);
    }

    public List<Cliente> getByAll(){
        String jpql = "SELECT c FROM Cliente c";
        return this.entityManager.createQuery(jpql, Cliente.class).getResultList();
    }

    public void update(final Cliente cliente) {
        this.entityManager.merge(cliente);
        System.out.println("Entidade Atualizada:" + cliente);
    }

    public void remove(final Cliente cliente) {
        this.entityManager.remove(cliente);
        System.out.println("Entidade removida:" + cliente);
    }
}
