package br.com.java.rasfood.dao;

import br.com.java.rasfood.entity.Ordem;
import br.com.java.rasfood.vo.ItensPrincipaisVo;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDao {
    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final Ordem ordem) {
        this.entityManager.persist(ordem);
//        System.out.println("Entidade Cadastrada:" + ordem);
    }

    public Ordem getById(final Integer id) {
        return this.entityManager.find(Ordem.class, id);
    }

    public List<ItensPrincipaisVo> consultarItensMaisVendidos() {
        String jpql = "SELECT new br.com.java.rasfood.vo.ItensPrincipaisVo(" +
                "c.nome, SUM(oc.quantidade)) FROM Ordem o " +
                "JOIN OrdensCardapio oc on o.id = oc.cardapio.id " +
                "JOIN oc.cardapio c " +
                "GROUP BY c.nome " +
                "ORDER BY SUM(oc.quantidade) DESC";
        return this.entityManager.createQuery(jpql, ItensPrincipaisVo.class).getResultList();
    }

    public Ordem joinFetchCliente(final Integer id) {
        String jpql = "SELECT o FROM Ordem o JOIN FETCH o.cliente WHERE o.id = :id";
        return this.entityManager.createQuery(jpql, Ordem.class).setParameter("id", id).getSingleResult();
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
