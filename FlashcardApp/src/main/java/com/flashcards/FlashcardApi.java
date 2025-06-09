package com.flashcards;

import io.javalin.Javalin;

public class FlashcardApi {

    private Javalin javalin;

    public void startApi() {
        javalin = Javalin.create(config -> {
            config.http.defaultContentType = "application/json";
        }).start(7070);

        javalin.get("/ping", ctx -> ctx.result("pong"));

        // Add your future flashcard routes here
    }

    public void stopApi() {
        if (javalin != null) {
            javalin.stop();
        }
    }
}
