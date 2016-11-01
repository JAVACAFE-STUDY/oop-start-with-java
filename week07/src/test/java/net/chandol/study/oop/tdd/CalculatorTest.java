package net.chandol.study.oop.tdd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void add() {
        //given
        Calculator calculator = new Calculator();
        int a = 0;
        int b = 3;

        //when
        int result = calculator.add(a, b);

        //then
        assertThat(result, is(3));
    }

}