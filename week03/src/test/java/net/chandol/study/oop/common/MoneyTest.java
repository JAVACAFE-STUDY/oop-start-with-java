package net.chandol.study.oop.common;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class MoneyTest {

    @Test
    public void moneyEqualTest() {
        // given

        // when
        Money money1 = Money.of(1000);
        Money money2 = Money.of(1000);

        // then
        assertThat(money1, is(not(sameInstance(money2))));
        assertThat(money1, is(money2));
    }

    @Test
    public void moneyAddTest() {
        // given
        Money money1 = Money.of(1000);
        Money money2 = Money.of(1000);

        // when
        Money money3 = money1.add(money2);

        // then
        assertThat(money1.value(), is(1000));
        assertThat(money2.value(), is(1000));
        assertThat(money3.value(), is(2000));
    }

    @Test
    public void moneyMultiplyTest() {
        // given
        Money money = Money.of(1000);
        int count = 3;

        // when
        Money result = money.multiply(count);

        // then
        assertThat(money.value(), is(1000));
        assertThat(result.value(), is(3000));
    }
}