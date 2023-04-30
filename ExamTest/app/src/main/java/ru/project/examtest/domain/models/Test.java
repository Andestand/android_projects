package ru.project.examtest.domain.models;

public class Test {
    private String text;

    private String correct_answer;

    public Test(String text, String correct_answer) {
        this.text = text;
        this.correct_answer = correct_answer;
    }

    public String getText() {
        return text;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }
}
