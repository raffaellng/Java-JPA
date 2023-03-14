package br.com.java.rasfood.dao;

import br.com.java.rasfood.entity.Cardapio;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Collections;
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
        try {
            String jpql = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(jpql, Cardapio.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Cardapio> getByValue(final String filtro) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("valor", filtro).getResultList();//GetResultList espera uma lista
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Cardapio getByName(final String filtro) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:nome)"; // a UPPER server para trazer tudo em maiusculo
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("nome", filtro).getSingleResult(); //o GetSinglesResult espera apenas um ojeto
        } catch (Exception e) {
            return null;
        }
    }

    public List<Cardapio> getByNameLike(final String filtro) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE c.nome LIKE :nome"; // a UPPER server para trazer tudo em maiusculo
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("nome", "%" + filtro + "%").getResultList(); //o GetSinglesResult espera apenas um ojeto
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
