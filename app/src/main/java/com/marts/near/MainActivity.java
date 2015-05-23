package com.marts.near;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button search = (Button)findViewById(R.id.search_now);

        /*GPSTracker gpsTracker = new GPSTracker(this);
        if(gpsTracker.getIsGPSTrackingEnabled()){
            String latt = String.valueOf(gpsTracker.latitude);
            latt = latt+String.valueOf(gpsTracker.longitude);

            //latt = String.valueOf(gpsTracker.location);
            TextView tv = (TextView)findViewById(R.id.your_location);
            tv.setText(latt);
        }else {
            gpsTracker.showSettingsAlert();
        }*/

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ProductInfo.class));
                //startActivity(new Intent(getApplicationContext(),ShopListActivity.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
