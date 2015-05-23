package com.marts.near;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Shivam on 5/23/2015.
 */
public interface gitApi {

    @GET("/users/{user}")
    public GitUser getFeed(@Path("user") String user);
}
