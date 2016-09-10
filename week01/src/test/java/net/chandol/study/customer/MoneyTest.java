package net.chandol.study.customer;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class MoneyTest {
    @Test
    public void testMehodAlaising() {
        Money money = new Money(2000);
        doSomethingWithMoney(money);
        assertNotEquals(new Money(2000), money);
    }

    private void doSomethingWithMoney(final Money money) {
        money.add(new Money(2000));
    }
}