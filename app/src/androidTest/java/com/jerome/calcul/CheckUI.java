package com.jerome.calcul;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CheckUI {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void init() {
    }

    @Test
    public void btn1Visible() {
        onView(withId(R.id.btn_1)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void btn1Visible2() {
        onView(withId(R.id.btn_1)).check(matches(isDisplayed()));
    }

    @Test
    public void btnEqualVisible() {
        onView(withId(R.id.btn_equal)).check(matches(isDisplayed()));
    }

    @Test
    public void singleDigitInput() {
        // Click the "2" button.
        onView(withId(R.id.btn_2))
                .perform(click());

        // Check that the text was changed.
        onView(withId(R.id.text_result))
                .check(matches(withText("2")));
    }

    @Test
    public void singlePlus() {
        // Click the "2" button.
        onView(withId(R.id.btn_2))
                .perform(click());
        // Click the "2" button.
        onView(withId(R.id.btn_plus))
                .perform(click());
        // Click the "4" button.
        onView(withId(R.id.btn_4))
                .perform(click());
        // Click the "2" button.
        onView(withId(R.id.btn_equal))
                .perform(click());

        // Check that the text was changed.
        onView(withId(R.id.text_result))
                .check(matches(withText("6")));
    }
}