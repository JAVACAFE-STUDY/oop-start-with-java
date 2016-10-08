package net.chandol.study.oop.store.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer amount;
    @ManyToOne
    private Category category;

    protected Product(){}

    public Product(String name, Integer amount, Category category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }
}
