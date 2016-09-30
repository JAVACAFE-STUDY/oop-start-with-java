package net.chandol.study.oop.product;

import net.chandol.study.oop.infra.Registrar;

public class ProductRepository {
    public static void persist(Product product){
        Registrar.add(product, Product.class);
    }

    public static Product get(String id){
        return Registrar.get(id, Product.class);
    }
}
