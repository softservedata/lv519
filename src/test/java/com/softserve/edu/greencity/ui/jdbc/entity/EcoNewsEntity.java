package com.softserve.edu.greencity.ui.jdbc.entity;

public class EcoNewsEntity {
    private long id;
    private long creation_date;
    private String image_path;
    private long author_id;
    private String text;
    private String title;

    public EcoNewsEntity() {
        creation_date = 0;
        image_path = "";
        author_id = 0;
        text = "";
        title = "";
    }

    public EcoNewsEntity(long creation_date, String image_path, long author_id, String text, String title) {
        this.creation_date = creation_date;
        this.image_path = image_path;
        this.author_id = author_id;
        this.text = text;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(long creation_date) {
        this.creation_date = creation_date;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
