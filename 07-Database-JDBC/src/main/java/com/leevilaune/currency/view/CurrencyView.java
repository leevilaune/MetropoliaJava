package com.leevilaune.currency.view;

import com.leevilaune.currency.controller.CurrencyController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Set;
import java.util.TreeSet;

public class CurrencyView extends Application {

    private CurrencyController controller;

    @Override
    public void init() throws Exception {
        this.controller = new CurrencyController();
    }

    @Override
    public void start(Stage stage) throws Exception {

        Font normalFont = new Font("sans-serif",14);
        Set<String> currencies = this.controller.getCurrencies();
        Label resultLabel = new Label();
        resultLabel.setFont(normalFont);
        Pane currencyPane = new FlowPane(Orientation.VERTICAL);
        currencyPane.setPadding(new Insets(10,10,10,10));
        Pane currencyFieldsPane = new FlowPane(Orientation.HORIZONTAL);
        TextField amountField = new TextField("Amount");
        amountField.setMaxWidth(185);
        Pane curr1Pane = new VBox();
        ComboBox<String> currency1 = new ComboBox<>();
        curr1Pane.getChildren().add(new Label("FROM"));
        curr1Pane.getChildren().add(currency1);
        Pane curr2Pane = new VBox();
        ComboBox<String> currency2 = new ComboBox<>();
        curr2Pane.getChildren().add(new Label("TO"));
        curr2Pane.getChildren().add(currency2);
        if(currencies == null){
            resultLabel.setText("Database connection failed");
            currency1.getItems().addAll(new TreeSet<>());
            currency2.getItems().addAll(new TreeSet<>());
        }else{
            currency1.getItems().addAll(currencies);
            currency2.getItems().addAll(currencies);
        }

        Button button = new Button("Convert");


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    double amount = Double.parseDouble(amountField.getText());
                    String curr1 = currency1.getValue();
                    String curr2 = currency2.getValue();
                    if(curr1 == null|| curr2==null){
                        resultLabel.setStyle("-fx-text-fill: #ffa500;");
                        resultLabel.setText("One or both currencies are empty");
                        return;
                    }
                    resultLabel.setStyle("-fx-text-fill: black;");
                    double conversion = controller.getConversion(curr1,curr2,amount);
                    if (conversion == -1){
                        resultLabel.setStyle("-fx-text-fill: #ff0000;");
                        resultLabel.setText("Database connection failed");
                    }
                    resultLabel.setText(amountField.getText()+ " " + curr1 +
                            " is " +
                            conversion
                            + " " + curr2);
                }catch(Exception e){
                    resultLabel.setStyle("-fx-text-fill: #ff0000;");
                    resultLabel.setText("Invalid number or currency");

                }
            }
        });
        currencyPane.getChildren().add(amountField);

        currencyFieldsPane.getChildren().add(curr1Pane);
        curr1Pane.setPadding(new Insets(0,10,0,0));

        currencyFieldsPane.getChildren().add(new Label("->"));
        currencyFieldsPane.getChildren().add(curr2Pane);
        curr2Pane.setPadding(new Insets(0,0,0,10));

        currencyFieldsPane.setPadding(new Insets(0,10,10,0));

        currencyPane.getChildren().add(currencyFieldsPane);

        currencyPane.getChildren().add(button);
        currencyPane.getChildren().add(resultLabel);

        Scene scene = new Scene(currencyPane,400,200);
        stage.setScene(scene);
        stage.setTitle("Currency Converter");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
