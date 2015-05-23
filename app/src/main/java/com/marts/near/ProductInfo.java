package com.marts.near;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.marts.near.api.ProductDetailsApi;
import com.marts.near.api.isProductDetailsReady;
import com.squareup.picasso.Picasso;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ProductInfo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Thread fetch = new Thread(new Runnable() {
            @Override
            public void run() {
                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint("https://gist.githubusercontent.com/shivarajp/02f234be94c9eb67f6d9/raw/539720b9964739b60fcdc3a67d82037519b6cece")
                        .build();

                isProductDetailsReady isPr = restAdapter.create(isProductDetailsReady.class);
                isPr.getProductDetails(new Callback<ProductDetailsApi>() {
                    @Override
                    public void success(ProductDetailsApi productDetails, Response response) {
                        ImageView productImage = (ImageView)findViewById(R.id.product_image);
                        TextView actual_price = (TextView)findViewById(R.id.actual_price);
                        TextView selling_price = (TextView)findViewById(R.id.selling_price);
                        TextView discount = (TextView)findViewById(R.id.discount);
                        TextView shopname = (TextView)findViewById(R.id.shop_name);
                        TextView shopaddress = (TextView)findViewById(R.id.shop_address);

                        Picasso.with(getApplicationContext()).load(productDetails.getPurl()).into(productImage);
                        actual_price.setText(actual_price.getText()+productDetails.getPactualPrice());
                        selling_price.setText(selling_price.getText()+productDetails.getPsellingprice());
                        discount.setText(discount.getText()+productDetails.getPdiscount());
                        shopname.setText(shopname.getText()+productDetails.getShopname());
                        shopaddress.setText(shopaddress.getText()+productDetails.getShoplolcation());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d("","Failed to fetch :-"+error);
                    }
                });
            }
        });

        fetch.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
