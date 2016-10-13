package net.chandol.study.oop.store;

import lombok.Getter;

@Getter
public class Item {
    private Long id;
    private String name; //이름
    private int price; //가격
    private int stockQuantity; //재고수량

    public Item(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}