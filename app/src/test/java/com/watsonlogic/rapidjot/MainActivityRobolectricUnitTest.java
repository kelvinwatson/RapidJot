package com.watsonlogic.rapidjot;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.watsonlogic.rapidjot.view.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Robolectric Unit Test for MainActivity, which will execute on the development machine (host JVM).
 *
 * @author: Kelvin Watson
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class MainActivityRobolectricUnitTest {

    private ActivityController<MainActivity> controller;
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void verifyLifeCycleCallbacks() {
        controller = Robolectric.buildActivity(MainActivity.class);
        createWithIntent("m_extra");
        controller.pause().stop().destroy();
    }

    @Test
    public void verifyActivity() {
        assertThat(activity, notNullValue());
    }

    @Test
    public void verifyViews() throws Exception {
        activity = Robolectric.setupActivity(MainActivity.class);
        View tv1 = activity.findViewById(R.id.tv1);
        assertThat(tv1, is(notNullValue()));
        assertThat(((TextView) activity.findViewById(R.id.tv1)).getText().toString(), is("Hello World!"));
    }

    private void createWithIntent(String extra) {
        Intent intent = new Intent(RuntimeEnvironment.application, MainActivity.class);
        intent.putExtra("activity_extra", extra);
        activity = controller.withIntent(intent).create().start().resume().visible().get();
    }
}