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

        Scene scene = new Scene(currencyPane,400,200);

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
        Button addCurrencyButton = new Button("Add");
        addCurrencyButton.setOnAction(event -> {
            Stage s = new Stage();
            s.setScene(new Scene(addCurrencyPane(currency1,currency2)));
            s.show();
        });

        currencyPane.getChildren().add(addCurrencyButton);

        if(currencies == null){
            stage.setScene(dbErrorScene(stage,scene,currency1,currency2));
        }else{
            stage.setScene(scene);
        }
        stage.setTitle("Currency Converter");
        stage.show();
    }

    public Pane addCurrencyPane(ComboBox<String> curr1, ComboBox<String> curr2){
        Pane pane = new VBox();
        pane.setPadding(new Insets(10,10,10,10));
        TextField code = new TextField("code");
        TextField name = new TextField("name");
        TextField usd = new TextField("as usd");
        Button submit = new Button("Submit");
        Label failLabel = new Label();
        failLabel.setVisible(false);
        submit.setOnAction(event -> {
            try{
                controller.addCurrency(code.getText(), name.getText(), Double.parseDouble(usd.getText()));
                curr1.getItems().add(code.getText());
                curr2.getItems().add(code.getText());
            }catch (Exception e){
                System.out.println("Exception");
                failLabel.setText("Some value cant be used");
                failLabel.setVisible(true);
            }
        });
        pane.getChildren().addAll(code,name,usd,submit,failLabel);
        return pane;
    }
    public Scene dbErrorScene(Stage s, Scene converterScene,ComboBox<String> curr1, ComboBox<String> curr2){
        Pane pane = new VBox();
        Scene errorScene = new Scene(pane);
        Label errorLabel = new Label("Database connection failed");
        errorLabel.setStyle("-fx-fill-color: red;");
        Button errorButton = new Button("Retry");
        pane.getChildren().addAll(errorLabel,errorButton);
        errorButton.setOnAction(event -> {
            if(controller.getCurrencies() != null){
                s.setScene(converterScene);
                curr1.getItems().addAll(this.controller.getCurrencies());
                curr2.getItems().addAll(this.controller.getCurrencies());

            }
        });

        return errorScene;
    }

    public static void main(String[] args) {
        launch();
    }
}
