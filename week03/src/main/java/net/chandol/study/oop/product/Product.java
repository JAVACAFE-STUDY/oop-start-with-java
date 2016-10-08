package net.chandol.study.oop.product;

import net.chandol.study.oop.common.Money;
import net.chandol.study.oop.infra.EntryPoint;

public class Product extends EntryPoint{
    private String productName;
    private Money amount;

    public Product(String id, String productName, Money amount) {
        super(id);
        this.productName = productName;
        this.amount = amount;
    }

    public String getId(){
        return super.getId();
    }

    public String getProductName() {
        return productName;
    }

    public Money getAmount() {
        return amount;
    }
}
