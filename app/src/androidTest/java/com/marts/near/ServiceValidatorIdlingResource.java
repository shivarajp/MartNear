package com.marts.near;

import android.content.Context;
import android.support.test.espresso.IdlingResource;
import android.util.Log;

/**
 * Created by Shivam on 5/14/2015.
 */
public class ServiceValidatorIdlingResource implements IdlingResource {

    private final Context context;
    private ResourceCallback resourceCallback;


    public ServiceValidatorIdlingResource(Context context) {
        this.context = context;
    }

    @Override
    public String getName() {
        return ServiceValidatorIdlingResource.class.getName();
    }

    @Override
    public boolean isIdleNow() {
        //isIdleNow() should return true only when there is no service running
        Log.d("idle", "idle");
        boolean idle = !isAnySkyroServiceRunning();
        if(idle){
            resourceCallback.onTransitionToIdle();
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }

    /**
     * This method detects skyro running services.
     * Returns true if any of skyro's service is running else false
     *
     * @return true or false
     */
    private boolean isAnySkyroServiceRunning() {

        return false;
    }
}
