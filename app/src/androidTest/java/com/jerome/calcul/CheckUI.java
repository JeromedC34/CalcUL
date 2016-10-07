package com.jerome.calcul;

import android.support.test.InstrumentationRegistry;
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
        onView(withId(R.id.btn_clear)).perform(click());
    }

    @Test
    public void btn1Visible() {
        onView(withId(R.id.btn_1)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void btn1Visible2() {
        onView(withId(R.id.btn_2)).check(matches(isDisplayed()));
    }

    @Test
    public void btn3Visible() {
        onView(withId(R.id.btn_3)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void btn4Visible() {
        onView(withId(R.id.btn_4)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void btn5Visible() {
        onView(withId(R.id.btn_5)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void btn6Visible() {
        onView(withId(R.id.btn_6)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void btn7Visible() {
        onView(withId(R.id.btn_7)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void btn8Visible() {
        onView(withId(R.id.btn_8)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void btn9Visible() {
        onView(withId(R.id.btn_9)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void btn0Visible() {
        onView(withId(R.id.btn_0)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void btnDotVisible() {
        onView(withId(R.id.btn_dot)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void btnEqualVisible() {
        onView(withId(R.id.btn_equal)).check(matches(isDisplayed()));
    }

    @Test
    public void btnPlusVisible() {
        onView(withId(R.id.btn_plus)).check(matches(isDisplayed()));
    }

    @Test
    public void btnMinusVisible() {
        onView(withId(R.id.btn_minus)).check(matches(isDisplayed()));
    }

    @Test
    public void btnMultipleVisible() {
        onView(withId(R.id.btn_multiple)).check(matches(isDisplayed()));
    }

    @Test
    public void btnDivideVisible() {
        onView(withId(R.id.btn_divide)).check(matches(isDisplayed()));
    }

    @Test
    public void btnClearVisible() {
        onView(withId(R.id.btn_clear)).check(matches(isDisplayed()));
    }

    @Test
    public void txtResultVisible() {
        onView(withId(R.id.text_result)).check(matches(isDisplayed()));
    }

    @Test
    public void singleDigitInput() {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("2")));
    }

    @Test
    public void singlePlus() {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_plus)).perform(click());
        onView(withId(R.id.btn_4)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("6")));
    }

    @Test
    public void singlePlusWithDecimal() {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_dot)).perform(click());
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_plus)).perform(click());
        onView(withId(R.id.btn_4)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("6.2")));
    }

    @Test
    public void checkInputDigit() throws Exception {
        onView(withId(R.id.btn_1)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("1")));
    }

    @Test
    public void checkInputCommaDigit() throws Exception {
        onView(withId(R.id.btn_dot)).perform(click());
        onView(withId(R.id.btn_1)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("0.1")));
    }

    @Test
    public void checkComputePlus() throws Exception {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_plus)).perform(click());
        onView(withId(R.id.btn_7)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("9")));
    }

    @Test
    public void checkComputeMinus() throws Exception {
        onView(withId(R.id.btn_9)).perform(click());
        onView(withId(R.id.btn_minus)).perform(click());
        onView(withId(R.id.btn_7)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("2")));
    }

    @Test
    public void checkComputeTimes() throws Exception {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_multiple)).perform(click());
        onView(withId(R.id.btn_7)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("14")));
    }

    @Test
    public void checkComputeDiv() throws Exception {
        onView(withId(R.id.btn_8)).perform(click());
        onView(withId(R.id.btn_divide)).perform(click());
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("4")));
    }

    @Test
    public void checkComputeWithoutSecondOperand() throws Exception {
        onView(withId(R.id.btn_8)).perform(click());
        onView(withId(R.id.btn_multiple)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("64")));
    }

    @Test
    public void checkComputeSeveralOperationsWithoutEqual() throws Exception {
        onView(withId(R.id.btn_8)).perform(click());
        onView(withId(R.id.btn_multiple)).perform(click());
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_plus)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("16")));
    }

    @Test
    public void checkNewNumberInputAfterCompute() throws Exception {
        onView(withId(R.id.btn_8)).perform(click());
        onView(withId(R.id.btn_multiple)).perform(click());
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.btn_5)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("5")));
    }

    @Test
    public void checkNoExtraZeroInInput() throws Exception {
        onView(withId(R.id.btn_8)).perform(click());
        onView(withId(R.id.btn_multiple)).perform(click());
        onView(withId(R.id.btn_5)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("5")));
    }

    @Test
    public void checkWaitOperandAfterEqualThenOperation() throws Exception {
        onView(withId(R.id.btn_8)).perform(click());
        onView(withId(R.id.btn_multiple)).perform(click());
        onView(withId(R.id.btn_4)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.btn_multiple)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("32")));
    }

    @Test
    public void checkClear() throws Exception {
        onView(withId(R.id.btn_8)).perform(click());
        onView(withId(R.id.btn_clear)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("0")));
    }

    @Test
    public void checkDivisionByZero() throws Exception {
        onView(withId(R.id.btn_8)).perform(click());
        onView(withId(R.id.btn_divide)).perform(click());
        onView(withId(R.id.btn_0)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText(InstrumentationRegistry.getTargetContext().getResources().getString(R.string.calc_division_by_zero))));
    }
}