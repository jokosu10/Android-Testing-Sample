package com.teamtreehouse.testingbase;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;

/**
 * Created by aldo on 10/6/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void editTextUpdatesTextView() throws Exception {
        // Arrange
        String givenString = "test123";
        activity.editText.setText(givenString);

        // Act
        /**
         * To act, we need a TextView itself.
         * But to have a TextView, we need an instance of MainActivity
         */
        activity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        // Assert
        String actuaString = activity.editText.getText().toString();
        Assert.assertEquals(givenString, actuaString);
    }

    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        // Arrange
        int index = 2;
        int givenColor = Color.GREEN;

        // Act
        activity.changeBackgroundColor(givenColor);

        // Assert
        int actualColor = ((ColorDrawable) activity.linearLayout.getBackground()).getColor();
        Assert.assertEquals(givenColor, actualColor);

    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        // Arrange
        Class clazz = OtherActivity.class;
        Intent expectedIntent = new Intent(activity, clazz);

        // Act
        activity.launchActivityButton.callOnClick();

        // Assert
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        // Fail, this intent has extra space
        // Assert.assertEquals(expectedIntent, actualIntent);
        Assert.assertTrue(expectedIntent.filterEquals(actualIntent));
    }

}
