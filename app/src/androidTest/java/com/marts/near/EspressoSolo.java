package com.marts.near;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.CoordinatesProvider;
import android.support.test.espresso.action.GeneralClickAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Tap;
import android.view.View;

import java.util.concurrent.TimeUnit;

/**
 * Created by Shivam on 5/20/2015.
 */
public class EspressoSolo {

    private static ServiceValidatorIdlingResource serviceValidatorIdlingResource = null;

    public static void sleep(long duration) {
        IdlingResource idlingResource2 = new RecordingWaitIdlingResource(duration);
        Espresso.registerIdlingResources(idlingResource2);
        //onView(withId(EspressoRecordingTest.getId("recorderpage_statustext")))
        //      .perform(click());
        Espresso.unregisterIdlingResources(idlingResource2);
    }

    public static void startServiceCheck() {
        if (serviceValidatorIdlingResource == null) {
            serviceValidatorIdlingResource = new ServiceValidatorIdlingResource(InstrumentationRegistry.getTargetContext());
            Espresso.registerIdlingResources(serviceValidatorIdlingResource);
        } else {
            Espresso.registerIdlingResources(serviceValidatorIdlingResource);
        }
    }

    public static void setIdlingResourceTimeout(int days){
        IdlingPolicies.setMasterPolicyTimeout(
                days, TimeUnit.DAYS);
        IdlingPolicies.setIdlingResourceTimeout(
                days, TimeUnit.DAYS);
        Instrumentation instrumentation
                = InstrumentationRegistry.getInstrumentation();
    }

    public static void stopServiceCheck() {
        if (serviceValidatorIdlingResource != null) {
            Espresso.registerIdlingResources(serviceValidatorIdlingResource);
            serviceValidatorIdlingResource = null;
        }
    }

    public static ViewAction clickXY(final int x, final int y) {
        return new GeneralClickAction(
                Tap.SINGLE,
                new CoordinatesProvider() {
                    @Override
                    public float[] calculateCoordinates(View view) {
                        final int[] screenPos = new int[2];
                        view.getLocationOnScreen(screenPos);
                        final float screenX = screenPos[0] + x;
                        final float screenY = screenPos[1] + y;
                        float[] coordinates = {screenX, screenY};
                        return coordinates;
                    }
                },
                Press.FINGER);
    }
}
