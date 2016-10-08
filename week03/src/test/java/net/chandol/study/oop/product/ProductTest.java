package net.chandol.study.oop.product;

import net.chandol.study.oop.common.Money;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class ProductTest {

    @Test
    public void productCreateTest(){
        //given

        //when
        Product product = new Product("1", "신라면", Money.of(800));

        //then
        assertThat(product.getAmount(), is(Money.of(800)));
        assertThat(product.getProductName(), is("신라면"));
    }

    @Test
    public void productPersistTest(){
        //given
        Product product = new Product("1", "신라면", Money.of(800));

        //when
        ProductRepository.persist(product);

        //then
        Product quriedProduct = ProductRepository.get("1");
        assertThat(quriedProduct, is(sameInstance(product)));
    }

}