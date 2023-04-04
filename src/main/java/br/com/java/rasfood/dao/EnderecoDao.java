package br.com.java.rasfood.dao;

import br.com.java.rasfood.entity.Cliente;
import br.com.java.rasfood.entity.Endereco;
import br.com.java.rasfood.vo.ClienteVo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

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

    public List<Endereco> getByAll() {
        String jpql = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(jpql, Endereco.class).getResultList();
    }

    public List<ClienteVo> getByAllClientes(final String estado, final String cidade, final String rua) {
        String jpql = "SELECT new br.com.java.rasfood.vo.ClienteVo(e.cliente.clienteId.cpf, e.cliente.nome) " +
                "FROM Endereco e WHERE 1=1";

        if (Objects.nonNull(estado)) {
            jpql = jpql.concat("AND UPPER(e.estado) = UPPER(:estado) ");
        }
        if (Objects.nonNull(cidade)) {
            jpql = jpql.concat("AND UPPER(e.cidade) = UPPER(:cidade) ");
        }
        if (Objects.nonNull(rua)) {
            jpql = jpql.concat("AND UPPER(e.rua) = UPPER(:rua) ");
        }

        TypedQuery typedQuery = this.entityManager.createQuery(jpql, ClienteVo.class);

        if (Objects.nonNull(estado)) {
            typedQuery.setParameter("estado", estado);
        }
        if (Objects.nonNull(cidade)) {
            typedQuery.setParameter("cidade", cidade);
        }
        if (Objects.nonNull(rua)) {
            typedQuery.setParameter("rua", rua);
        }

        return typedQuery.getResultList();

    }

    public List<ClienteVo> getByAllClientesUseCriteria(final String estado, final String cidade, final String rua) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteVo> criteriaQuery = builder.createQuery(ClienteVo.class);

        Root<Endereco> root = criteriaQuery.from(Endereco.class);
        criteriaQuery.multiselect(root.get("cliente").get("clienteId").get("cpf"), root.get("cliente").get("nome"));

        Predicate predicate = builder.and();

        if (Objects.nonNull(estado)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("estado")), estado.toUpperCase()));
        }
        if (Objects.nonNull(cidade)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("cidade")), cidade.toUpperCase()));
        }
        if (Objects.nonNull(rua)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("rua")), rua.toUpperCase()));
        }

        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();

    }

    //Versão de cima porem melhorada
    public List<ClienteVo> getByAllClientesUseCriteriaPlus(final String estado, final String cidade, final String rua) {
        String jpql = "SELECT new br.com.java.rasfood.vo.ClienteVo(e.cliente.clienteId.cpf, e.cliente.nome) " +
                "FROM Endereco e WHERE 1=1";

        if (Objects.nonNull(estado)) {
            jpql = jpql.concat("AND LOWER(e.estado) = LOWER('" + estado + "')");
        }
        if (Objects.nonNull(cidade)) {
            jpql = jpql.concat("AND LOWER(e.cidade) = LOWER('" + cidade + "')");
        }
        if (Objects.nonNull(rua)) {
            jpql = jpql.concat("AND LOWER(e.rua) = LOWER('" + rua + "')");
        }
        return this.entityManager.createQuery(jpql, ClienteVo.class).getResultList();
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
