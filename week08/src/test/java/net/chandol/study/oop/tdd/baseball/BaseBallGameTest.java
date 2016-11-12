package net.chandol.study.oop.tdd.baseball;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BaseBallGameTest {
    private BaseBallGame game;

    @Before
    public void setup() {
        game = new BaseBallGame(
                new MockNumberGenerator(1, 4, 5));
    }

    @Test
    public void 아웃테스트() {
        //when
        BaseBallResult result = game.check("639");

        //then
        checkResult(result, 0, 0, 1);
    }

    private void checkResult(BaseBallResult result, int strike, int ball, int out) {
        assertThat(result.getStrike(), is(strike));
        assertThat(result.getBall(), is(ball));
        assertThat(result.getOut(), is(out));
    }

    @Test
    public void 원볼테스트() {
        //when
        BaseBallResult result = game.check("634");

        //then
        checkResult(result, 0, 1, 0);
    }


    @Test
    public void 쓰리스트라이크_테스트() {
        //when
        BaseBallResult result = game.check("145");

        //then
        checkResult(result, 3, 0, 0);
    }

    @Test
    public void 전부숫자인지확인하기() {
        //when
        game.check("135");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 전부숫자아닌경우예외() {
        //when
        game.check("2x3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복숫자_존재시_예외() {
        //when
        game.check("223");
    }

    @Test
    public void 세자리가아닌숫자시예외() {
        //when, then
        checkSourceLength("23");
        checkSourceLength("2333");
    }

    private void checkSourceLength(String source) {
        try {
            game.check(source);
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
    }
}
