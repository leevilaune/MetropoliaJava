package com.leevilaune.virtualpet.view;

import com.leevilaune.virtualpet.controller.PetController;
import com.leevilaune.virtualpet.model.Pet;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PetView extends Application {
    private int width;
    private int height;

    private Pet pet;
    private PetController controller;
    private Canvas canvas;
    private GraphicsContext gc;
    private Image petImage;

    public PetView(){
        this.width = 400;
        this.height = 400;
    }

    @Override
    public void start(Stage stage) {
        this.controller = new PetController(this.pet, this);

        this.canvas = new Canvas(this.width, this.height);
        this.gc = this.canvas.getGraphicsContext2D();

        this.petImage = new Image("pet.png", 100, 100, true, true);

        this.canvas.setOnMouseMoved(e -> this.controller.setTarget(e.getX(), e.getY()));
        this.canvas.setOnMouseExited(e -> this.controller.stopMoving());

        StackPane root = new StackPane(this.canvas);
        Scene scene = new Scene(root, this.width, this.height);
        stage.setScene(scene);
        stage.setTitle("Virtual Pet");
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.update();
            }
        };
        timer.start();
    }

    public void updateCanvas(double x, double y) {
        this.gc.clearRect(0, 0, this.width, this.height);
        this.gc.drawImage(this.petImage, x - this.petImage.getWidth() / 2, y - this.petImage.getHeight() / 2);
    }

    public static void main(String[] args) {
        launch();
    }
}