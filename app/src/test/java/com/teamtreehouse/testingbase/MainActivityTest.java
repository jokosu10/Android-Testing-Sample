package com.teamtreehouse.testingbase;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import android.view.inputmethod.EditorInfo;

/**
 * Created by aldo on 10/6/16.
 */

public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setUp() {
        activity = new MainActivity();
        activity.onCreate(null);
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

}
