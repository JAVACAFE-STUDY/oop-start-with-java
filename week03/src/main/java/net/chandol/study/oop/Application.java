package net.chandol.study.oop;

import net.chandol.study.oop.store.model.Category;
import net.chandol.study.oop.store.model.Product;
import net.chandol.study.oop.store.repository.CategoryRepository;
import net.chandol.study.oop.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... strings) {
        Category foodCategory = categoryRepository.save(
                new Category("식품")
        );

        productRepository.save(new Product("신라면", 700, foodCategory));
        productRepository.save(new Product("신라면", 700, foodCategory));
        productRepository.save(new Product("신라면", 700, foodCategory));
        productRepository.save(new Product("신라면", 700, foodCategory));
        productRepository.save(new Product("신라면", 700, foodCategory));

        List<Product> all = productRepository.findAll();
        System.out.println(all);
    }
}
