package ru.project.examtest.domain.models;


import java.io.Serializable;

public class Term implements Serializable {
    private String title;
    private String description;

    public Term(
            String title,
            String description
    ) {
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
