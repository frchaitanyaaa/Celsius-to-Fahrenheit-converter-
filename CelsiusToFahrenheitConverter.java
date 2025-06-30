package com.example;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CelsiusToFahrenheitConverter extends Application{
	public void start(Stage primaryStage) {
        // Title
        Label title = new Label("Celsius to Fahrenheit Converter");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        title.setTextFill(Color.DARKBLUE);

        // Input field
        TextField celsiusInput = new TextField();
        celsiusInput.setPromptText("Enter Celsius");

        // Output label
        Label resultLabel = new Label();
        resultLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        resultLabel.setTextFill(Color.RED);

        // Convert button
        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> {
            try {
                double celsius = Double.parseDouble(celsiusInput.getText());
                double fahrenheit = (celsius * 9 / 5) + 32;
                resultLabel.setText(String.format("%.2f °C = %.2f °F", celsius, fahrenheit));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
                resultLabel.setTextFill(Color.RED);
            }
        });

        // Layout
        VBox root = new VBox(10, title, celsiusInput, convertButton, resultLabel);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20; -fx-background-color: #f0f8ff;");

        // Scene and Stage
        Scene scene = new Scene(root, 350, 250);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
	

}
