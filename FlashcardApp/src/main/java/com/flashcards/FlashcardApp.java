package com.flashcards;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FlashcardApp extends Application {

    private FlashcardApi flashcardApi = new FlashcardApi();

    @Override
    public void start(Stage primaryStage) {
        // Start API in a background thread
        new Thread(() -> flashcardApi.startApi()).start();

        // Sample UI
        VBox root = new VBox();
        root.setSpacing(10);
        root.getChildren().add(new Label("Flashcard App is running!"));

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Flashcards");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Stop API when the window closes
        primaryStage.setOnCloseRequest(event -> {
            flashcardApi.stopApi();
        });
    }
}
