package com.teamtreehouse.testingbase;

import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.LinearLayout;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by aldo on 10/12/16.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    // Which activity will be testing
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(
        MainActivity.class);

    @Test
    public void editTextUpdatesTextView() throws Exception {
        // Arrange
        String givenString = "test123";

        // Act
        ViewInteraction editTextInteraction = onView(withId(R.id.editText));
        editTextInteraction.perform(typeText(givenString));
        editTextInteraction.perform(pressImeActionButton());

        // Assert
        onView(withId(R.id.textView)).check(matches(withText(givenString)));
    }

    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        // Arrange
        final int givenColor = Color.GREEN;
        String spinnerItemText = "Green";

        // Act
        onView(withId(R.id.colorSpinner)).perform(click());
        // This is wrong approach, what if we need to click 100th item?
        // It won't show up in list view, use onData instead
        // onView(withText(spinnerItemText)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(spinnerItemText))).perform(click());

        // Assert
        BoundedMatcher<View, LinearLayout> backgroundColorMatcher = new BoundedMatcher<View,
            LinearLayout>(
            LinearLayout.class) {
            @Override
            protected boolean matchesSafely(LinearLayout linearLayout) {
                int actualColor = ((ColorDrawable) linearLayout.getBackground()).getColor();
                return actualColor == givenColor;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Background color should equal: " + givenColor);
            }
        };

        onView(withId(R.id.linearLayout)).check(matches(backgroundColorMatcher));

    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        // Arrange
        String otherActivityString = "Other Activity";

        // Act
        onView(withId(R.id.launchActivityButton)).perform(click());

        // Assert
        onView(withText(otherActivityString)).check(matches(notNullValue()));
    }
}
