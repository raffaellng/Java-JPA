package br.com.java.rasfood.service.teste;

import br.com.java.rasfood.dao.*;
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
        Ordem ordem = ordemDao.joinFetchCliente(2);

        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        System.out.println(enderecoDao.getByAllClientes("SP","Sao Paulo",null));
        System.out.println(enderecoDao.getByAllClientesUseCriteria(null,null,"lapa"));
        System.out.println(enderecoDao.getByAllClientesUseCriteriaPlus("SP","Sao Paulo",null));


        ClienteDao clienteDao = new ClienteDao(entityManager);
        System.out.println(clienteDao.getByAll());
        System.out.println(clienteDao.getById(new ClienteId("111111111123","tayane@email.com")));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
