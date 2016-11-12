package net.chandol.study.oop.tdd.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }


    @Test
    public void 더하기_테스트() {
        // given, when
        int result = calculator.add(4, 9);

        // then
        assertThat(result, is(13));
    }

    @Test
    public void 나누기_테스트() {
        // given, when
        int result = calculator.divide(9, 3);

        // then
        assertThat(result, is(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 분모가0일때_나누기_실패_테스트() {
        calculator.divide(9, 0);
    }

}
