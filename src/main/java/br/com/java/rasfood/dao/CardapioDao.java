package br.com.java.rasfood.dao;

import br.com.java.rasfood.entity.Cardapio;

import javax.persistence.EntityManager;
import java.util.List;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final Cardapio cardapio) {
        this.entityManager.persist(cardapio);
        System.out.println("Entidade Cadastrada:" + cardapio);
    }

    public Cardapio getById(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public void update(Cardapio cardapio) {
        this.entityManager.merge(cardapio);
        System.out.println("Entidade Atualizada:" + cardapio);
    }

    public void remove(final Cardapio cardapio) {
        this.entityManager.remove(cardapio);
        System.out.println("Entidade removida:" + cardapio);
    }

    public List<Cardapio> getAll() {
        String sql = "SELECT c FROM Cardapio c";
        return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
    }
}
