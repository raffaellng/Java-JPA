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

//        CardapioDao cardapioDao = new CardapioDao(entityManager);
//        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

//        Endereco endereco = new Endereco("00000000", "Sei la", "sem complemento", "Uberlandia", "MG");
//        Cliente cliente = new Cliente("11111111", "felipe", "teste@teste");
//        cliente.addEndereco(endereco);
//        Ordem ordem = new Ordem(cliente);
//        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.getById(1), 2));
//        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.getById(2), 3));
//
//        clienteDao.create(cliente);
//        ordemDao.create(ordem);

         System.out.println(ordemDao.consultarItensMaisVendidos());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
