package com.example.android.githubapi.model;

import com.google.gson.annotations.SerializedName;

public class GithuRepo {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("language")
    private String language;

    public GithuRepo(String name, String description, String language) {
        this.setName(name);
        this.setDescription(description);
        this.setLanguage(language);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
