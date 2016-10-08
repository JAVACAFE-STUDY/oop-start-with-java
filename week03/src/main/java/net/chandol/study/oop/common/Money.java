package net.chandol.study.oop.common;

public class Money {
    private final int value;

    private Money(int value) {
        this.value = value;
    }

    public static Money of(int value){
        return new Money(value);
    }

    public int value() {
        return value;
    }

    public Money add(Money money){
        return Money.of(this.value + money.value());
    }

    public Money subtract(Money money){
        return Money.of(this.value - money.value());
    }

    public Money multiply(int count){
        return Money.of(this.value * count);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return value == money.value;

    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }
}
