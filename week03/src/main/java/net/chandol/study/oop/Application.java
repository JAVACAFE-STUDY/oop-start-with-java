package net.chandol.study.oop;

import net.chandol.study.oop.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner{
    @Autowired
    EntityManagerFactory emf;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(new Product("신라면", 700));
        em.persist(new Product("신라면", 700));
        em.persist(new Product("신라면", 700));
        em.persist(new Product("신라면", 700));

        Query query = em.createQuery("SELECT A FROM Product A");
        List<Product> resultList = query.getResultList();

        System.out.println(resultList);

        tx.commit();
        em.close();
        emf.close();
    }
}
