package com.flashcards;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AppUi implements Initializable {

    @FXML
    private TextArea myTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myTextArea.setText("Hello, Flashcards! This is the initial content.");
    }
}
