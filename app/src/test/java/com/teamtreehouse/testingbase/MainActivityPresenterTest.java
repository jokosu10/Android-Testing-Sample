package com.teamtreehouse.testingbase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aldo on 10/10/16.
 */
public class MainActivityPresenterTest {

    MainActivityPresenter presenter;

    MainActivityView view;

    class MockedView implements MainActivityView {

        String textViewText;

        @Override
        public void changeTextViewText(String text) {
            textViewText = text;

        }

        @Override
        public void changBackgroundColor(int color) {

        }

        @Override
        public void launchOtherActivity(Class activity) {

        }
    }

    @Before
    public void setUp() throws Exception {
        view = new MockedView();
        presenter = new MainActivityPresenter(view);
    }

    @Test
    public void editTextUpdated() throws Exception {
        // Arrange
        String givenString = "test1";

        // Act
        presenter.editTextUpdated(givenString);

        // Assert
       assertEquals(givenString, ((MockedView) view).textViewText);

    }

    @Test
    public void colorSelected() throws Exception {

    }

    @Test
    public void launchOtherActivityButtonClicked() throws Exception {

    }

}