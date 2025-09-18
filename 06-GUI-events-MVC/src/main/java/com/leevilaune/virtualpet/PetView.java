package com.leevilaune.virtualpet;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PetView extends Application {

    private PetController controller;
    private GraphicsContext gc;
    private Canvas canvas;

    @Override
    public void init() throws Exception {
        this.controller = new PetController();
        this.canvas = new Canvas(400,400);
        this.gc = canvas.getGraphicsContext2D();

    }

    @Override
    public void start(Stage s){

        this.gc.drawImage(new Image("file:src/main/resources/pet.png"),0,0);
        this.canvas.getGraphicsContext2D().save();

        Pane pane = new FlowPane();
        pane.getChildren().add(this.canvas);
        Scene scene = new Scene(pane);

        s.setScene(scene);
        s.show();
        this.canvas.setOnMouseMoved(event->{
            int targetX = (int) event.getX();
            int targetY = (int) event.getY();
            this.controller.move(targetX, targetY);
            updateCanvas(this.controller.getPetX()-25,this.controller.getPetY()-25);
            /*
            Thread t = new Thread(()->{
                while(this.controller.getPetX() != targetX || this.controller.getPetY() != targetY){
                    //System.out.printf("moving %d, %d",targetX,targetY);
                    this.controller.setPetX(this.controller.getPetX()+1);
                    this.controller.setPetY(this.controller.getPetY()+1);
                    updateCanvas(this.controller.getPetX(),this.controller.getPetY());
                    try {
                        Thread.sleep(10);
                    } catch(Exception ignored){

                    }
                }
            });
            Platform.runLater(t);
            */
        });
    }

    public void updateCanvas(int playerX, int playerY) {
        this.gc.clearRect(0, 0, 400, 400);
        this.gc.drawImage(new Image("file:src/main/resources/pet.png"),playerX,playerY);
    }

    public static void main(String[] args) {
        launch();
    }
}
