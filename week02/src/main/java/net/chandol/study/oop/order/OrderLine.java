package net.chandol.study.oop.order;

import net.chandol.study.oop.product.Product;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        setQuantity(quantity);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        if (quantity < 1)
            throw new IllegalArgumentException("상품의 갯수는 0보다 작을 수 없습니다.");
        else
            this.quantity = quantity;
    }

    public int getItemAmount(){
        return this.product.getAmount().multiply(quantity).value();
    }

    public void changeQuantity(int quantity) {
        setQuantity(quantity);
    }
}
