package com.marts.near;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.squareup.spoon.Spoon;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ApplicationTest{

    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.marts.near.MainActivity";
    private static Class<? extends Activity> activityClass;

    static {
        try {
            activityClass = (Class<? extends Activity>) Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Rule
    public final ActivityTestRule<?> activityRule
            = new ActivityTestRule<>(activityClass);


    @Test
    public void testProducts() throws Exception {

        Spoon.screenshot(activityRule.getActivity(), "");
        onView(withId(getId("search_now")));

        IdlingResource idlingResource3 = new RecordingWaitIdlingResource(2000);
        Espresso.registerIdlingResources(idlingResource3);
        onView(withId(getId("actual_price")));
        Espresso.unregisterIdlingResources(idlingResource3);
        Spoon.screenshot(activityRule.getActivity(), "");
        //Espresso.pressBack();
    }

    public static int getId(String id) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        String packageName = targetContext.getPackageName();
        return targetContext.getResources().getIdentifier(id, "id", packageName);
    }
}

