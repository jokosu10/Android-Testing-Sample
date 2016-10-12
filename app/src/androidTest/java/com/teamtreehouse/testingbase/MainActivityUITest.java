package com.teamtreehouse.testingbase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

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


        // Act


        // Assert

    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        // Arrange


        // Act


        // Assert

    }
}
