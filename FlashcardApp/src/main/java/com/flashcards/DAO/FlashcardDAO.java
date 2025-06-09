package com.flashcards.DAO;

import com.flashcards.Model.Flashcard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlashcardDAO {
    private final Connection connection;
    private final Random random = new Random();

    public FlashcardDAO (Connection connection) {
        this.connection = connection;
    }

    //methods methods methods
}
