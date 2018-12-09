package com.example.android.githubapi.rest;

import com.example.android.githubapi.model.GithubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubUserEndPoints {

    @GET("/users/{user}")
    Call<GithubUser> getUser(@Path("user") String user);

}
