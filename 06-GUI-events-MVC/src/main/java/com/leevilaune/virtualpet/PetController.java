package com.leevilaune.virtualpet;

import javafx.scene.canvas.GraphicsContext;

public class PetController {

    private Pet pet;

    public PetController(){
        this.pet = new Pet(0,0);
    }

    public void move(int x, int y){
        this.pet.setPosX(x);
        this.pet.setPosY(y);
    }

    public void moveTowards(int x, int y){

    }

    public int getPetX(){
        return this.pet.getPosX();
    }
    public int getPetY(){
        return this.pet.getPosY();
    }
    public void setPetX(int x){
        this.pet.setPosX(x);
    }
    public void setPetY(int y){
        this.pet.setPosY(y);
    }
}
