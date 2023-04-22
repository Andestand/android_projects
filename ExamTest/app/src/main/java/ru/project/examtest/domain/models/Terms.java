package ru.project.examtest.domain.models;


public class Terms {
    private String title;
    private String description;

    public Terms(
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
