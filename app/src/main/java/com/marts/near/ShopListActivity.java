package com.marts.near;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.marts.near.api.ProductDetailsApi;
import com.marts.near.api.isProductDetailsReady;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ShopListActivity extends ActionBarActivity {

    ArrayList<ProductDetailsApi> productDetailsApis = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        final ListView shopList = (ListView)findViewById(R.id.shopdetails_listView);
        final ShopDetailsAdapter adapter = new ShopDetailsAdapter(this,productDetailsApis);
        shopList.setAdapter(adapter);

        Thread fetch = new Thread(new Runnable() {
            @Override
            public void run() {
                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint("http://127.0.0.1/Public/hackthon")
                        .build();

                isProductDetailsReady isPr = restAdapter.create(isProductDetailsReady.class);
                isPr.getProductDetails(new Callback<ProductDetailsApi>() {
                    @Override
                    public void success(ProductDetailsApi productDetails, Response response) {
                        productDetailsApis.add(productDetails);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d("", "Failed to fetch :-" + error);
                    }
                });
            }
        });

        fetch.start();

        shopList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductDetailsApi details = (ProductDetailsApi)parent.getItemAtPosition(position);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shop_list, menu);
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
