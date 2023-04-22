package ru.project.examtest.domain.models;

import java.io.Serializable;

public class Theory implements Serializable {
    private String text;

    public Theory(
            String text
    ) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
