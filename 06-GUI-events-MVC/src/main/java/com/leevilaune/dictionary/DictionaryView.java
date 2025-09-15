package com.leevilaune.dictionary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    private DictionaryController dictionaryController;

    public DictionaryView(){
        this.dictionaryController = new DictionaryController(new Dictionary());

    }

    @Override
    public void start(Stage stage) throws Exception {
        TextField textField = new TextField("Word");
        Button searchButton = new Button("Search");
        Label defLabel = new Label();
        Pane pane = new FlowPane(Orientation.VERTICAL);
        pane.setPadding(new Insets(10,10,10,10));

        pane.getChildren().add(textField);
        pane.getChildren().add(searchButton);
        pane.getChildren().add(defLabel);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                defLabel.setText(dictionaryController.fetchWord(textField.getText()));
            }
        });
        Scene view = new Scene(pane,400, 200);
        stage.setTitle("Dictionary");
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
