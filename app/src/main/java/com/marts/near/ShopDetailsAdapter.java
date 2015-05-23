package com.marts.near;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.marts.near.api.ProductDetailsApi;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Shivam on 5/23/2015.
 */
public class ShopDetailsAdapter extends BaseAdapter {

    ArrayList<ProductDetailsApi> productDetailApis;
    Activity activity;
    private LayoutInflater inflater;
    ImageView productImage;
    TextView shopName;
    Button visit;

    public ShopDetailsAdapter(Activity activity, ArrayList<ProductDetailsApi> productDetailApis){
        this.productDetailApis = productDetailApis;
    }

    @Override
    public int getCount() {
        return productDetailApis.size();
    }

    @Override
    public Object getItem(int position) {
        return productDetailApis.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.listview_layout, null);
        productImage = (ImageView)activity.findViewById(R.id.lv_pimage);
        shopName = (TextView)activity.findViewById(R.id.lv_shopName);
        visit = (Button)activity.findViewById(R.id.lv_visitshop);

        Picasso.with(activity).load(productDetailApis.get(position).getPurl()).into(productImage);
        shopName.setText(productDetailApis.get(position).getShopname());
        return null;
    }
}
