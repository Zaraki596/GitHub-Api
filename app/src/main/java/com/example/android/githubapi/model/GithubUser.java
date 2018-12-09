package com.example.android.githubapi.model;

import com.google.gson.annotations.SerializedName;

public class GithubUser {

    @SerializedName("name")
    private String email;
    @SerializedName("followers")
    private String name;
    @SerializedName("following")
    private String followers;
    @SerializedName("avatar")
    private String following;
    @SerializedName("login")
    private String avatar;
    @SerializedName("email")
    private String login;


    public GithubUser(String login, String email, String name, String followers, String following, String avatar) {
        this.setLogin(login);
        this.setEmail(email);
        this.setName(name);
        this.setFollowers(followers);
        this.setFollowing(following);
        this.setAvatar(avatar);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
