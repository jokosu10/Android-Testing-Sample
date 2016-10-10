package com.teamtreehouse.testingbase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import android.graphics.Color;

/**
 * Created by aldo on 10/10/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    MainActivityPresenter presenter;

    @Mock
    MainActivityView view;

    @Before
    public void setUp() throws Exception {
        presenter = new MainActivityPresenter(view);
    }

    @Test
    public void editTextUpdated() throws Exception {
        // Arrange
        String givenString = "test1";

        // Act
        presenter.editTextUpdated(givenString);

        // Assert
        Mockito.verify(view).changeTextViewText(givenString);
    }

    @Test
    public void colorSelected() throws Exception {
        // Arrange
        int index = 2;
        int givenColor = Color.GREEN;

        // Act
        presenter.colorSelected(index);

        // Assert
        Mockito.verify(view).changeBackgroundColor(givenColor);
    }

    @Test
    public void launchOtherActivityButtonClicked() throws Exception {
        // Arrange
        Class clazz = OtherActivity.class;

        // Act
        presenter.launchOtherActivityButtonClicked(clazz);

        // Assert
        Mockito.verify(view).launchOtherActivity(clazz);
    }

}