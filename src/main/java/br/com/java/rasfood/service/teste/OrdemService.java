package br.com.java.rasfood.service.teste;

import br.com.java.rasfood.dao.CardapioDao;
import br.com.java.rasfood.dao.ClienteDao;
import br.com.java.rasfood.dao.OrdemDao;
import br.com.java.rasfood.entity.Cliente;
import br.com.java.rasfood.entity.Endereco;
import br.com.java.rasfood.entity.Ordem;
import br.com.java.rasfood.entity.OrdensCardapio;
import br.com.java.rasfood.util.CargaDeDadosUtil;
import br.com.java.rasfood.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();

        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.createProdutosCardapio(entityManager);
        CargaDeDadosUtil.createClientes(entityManager);
        CargaDeDadosUtil.createOrdensClientes(entityManager);

        OrdemDao ordemDao = new OrdemDao(entityManager);
        Ordem ordem = ordemDao.getById(2);
        System.out.println(ordem.getValorTotal());

//        System.out.println(ordemDao.consultarItensMaisVendidos());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
