package com.marts.near.api;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Shivam on 5/23/2015.
 */
public interface isProductDetailsReady {

    @GET("/test.php")
    public void getProductDetails(Callback<ProductDetailsApi> response);
}
