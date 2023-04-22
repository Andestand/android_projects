package ru.project.examtest.domain.models;

public class Theory {
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
