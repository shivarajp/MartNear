package com.marts.near;

import android.support.test.espresso.IdlingResource;

/**
 * Created by Shivam on 5/13/2015.
 */
public class RecordingWaitIdlingResource implements IdlingResource {
    private long startTime = 0;
    private long waitingTime = 0;
    private ResourceCallback resourceCallback;

    public RecordingWaitIdlingResource(long waitingTime) {
        this.startTime = System.currentTimeMillis();
        this.waitingTime = waitingTime;
    }

    @Override
    public String getName() {
        return RecordingWaitIdlingResource.class.getName();
    }

    @Override
    public boolean isIdleNow() {
        long elapsed = System.currentTimeMillis() - startTime;
        boolean idle = (elapsed >= waitingTime);
        if (idle) {
            resourceCallback.onTransitionToIdle();
        }
        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }

}

