package com.leevilaune.virtualpet.controller;

import com.leevilaune.virtualpet.model.Pet;
import com.leevilaune.virtualpet.view.PetView;

public class PetController {
    private Pet pet;
    private PetView view;
    private double targetX;
    private double targetY;
    private boolean active;

    public PetController(Pet pet, PetView view) {
        this.view = view;
        this.pet = new Pet(50,50);
        this.active = false;
    }

    public void setTarget(double x, double y) {
        this.targetX = x;
        this.targetY = y;
        this.active = true;
    }

    public void stopMoving() {
        this.active = false;
    }

    public void update() {
        if (this.active) {
            this.pet.moveTowards(this.targetX, this.targetY);

            if (Math.abs(this.pet.getX() - this.targetX) < 1 && Math.abs(this.pet.getY() - this.targetY) < 1) {
                this.active = false;
            }
        }
        this.view.updateCanvas(this.pet.getX(), this.pet.getY());
    }
}