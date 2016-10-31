package net.chandol.study.oop.calculator;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void add() {
        //given
        Calculator calculator = new Calculator();
        int a = 0; int b = 3;

        //when
        int result = calculator.add(a, b);

        //then
        Assert.assertThat(result, CoreMatchers.is(3));
    }

}