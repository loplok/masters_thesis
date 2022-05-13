package org.example;

public class Flips {

    private String flipSide;
    private int flipLength;

    public Flips(String flipSide, int flipLength) {
        this.flipLength = flipLength;
        this.flipSide = flipSide;
    }

    public String getFlipSide() {
        return flipSide;
    }

    public void setFlipSide(String flipSide) {
        this.flipSide = flipSide;
    }

    public int getFlipLength() {
        return flipLength;
    }

    public void setFlipLength(int flipLength) {
        this.flipLength = flipLength;
    }
}
