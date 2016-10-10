package com.teamtreehouse.testingbase;

/**
 * Created by aldo on 10/6/16.
 */

public interface MainActivityView {

    void changeTextViewText(String text);

    void changBackgroundColor(int color);

    void launchOtherActivity(Class activity);
}
