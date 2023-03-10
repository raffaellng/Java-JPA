package br.com.java.rasfood.service.teste;

import br.com.java.rasfood.dao.CardapioDao;
import br.com.java.rasfood.dao.CategoriaDao;
import br.com.java.rasfood.entity.Cardapio;
import br.com.java.rasfood.entity.Categoria;
import br.com.java.rasfood.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        cadastrarProdutoCardapio(entityManager, cadastrarCategoria(entityManager));
    }

    private static Categoria cadastrarCategoria(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato principal");
        entityManager.getTransaction().begin();
        categoriaDao.create(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoPrincipal;
    }

    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria) {
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setCategoria(categoria);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmão ao molho de maracuja");
        salmao.setDescricao("Salmão grelhado ao molho de maracujá");
        salmao.setDisponivel(true);
        salmao.setCategoria(categoria);
        salmao.setValor(BigDecimal.valueOf(60.00));


        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin(); //Abre Conexão

        cardapioDao.create(risoto); //Manda os dados para o DAO para ter ou nao o commit
        entityManager.flush();
        cardapioDao.create(salmao); //Manda os dados para o DAO para ter ou nao o commit
        entityManager.flush();
//        System.out.println("O prato consultado foi: "+ cardapioDao.getById(1));
//        System.out.println("O prato consultado foi: "+ cardapioDao.getById(2));
        cardapioDao.getAll().forEach(elemento -> System.out.println("O prato consultado foi: " + elemento));
        entityManager.close(); //Fecha conexao do banco

    }
}
