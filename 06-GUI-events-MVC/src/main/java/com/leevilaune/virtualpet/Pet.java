package com.leevilaune.virtualpet;

public class Pet {

    private int posX;
    private int posY;

    public Pet(int x,int y){
        this.posX = x;
        this.posY = y;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
}
