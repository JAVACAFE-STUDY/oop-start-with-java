package net.chandol.study.oop.tdd.baseball;

public class BaseBallResult {
    private int strike;
    private int ball;
    private int out;

    private BaseBallResult(int strike, int ball, int out) {
        this.strike = strike;
        this.ball = ball;
        this.out = out;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getOut() {
        return out;
    }

    public static BaseBallResult notOutResult(int strike, int ball){
        return new BaseBallResult(strike, ball, 0);
    }

    public static BaseBallResult outResult(){
        return new BaseBallResult(0,0,1);
    }

}
