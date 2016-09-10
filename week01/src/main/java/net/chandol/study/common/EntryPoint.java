package net.chandol.study.common;

public abstract class EntryPoint {
    private final String identity;

    public EntryPoint(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }

}