package com.jerome.calcul;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MyInstrumentedTest_lan extends MyInstrumentedTest {
    @Test
    public void btnSinVisible() {
        onView(withId(R.id.btn_sin)).check(matches(isDisplayed()));
    }

    @Test
    public void btnCosVisible() {
        onView(withId(R.id.btn_cos)).check(matches(isDisplayed()));
    }

    @Test
    public void btnTanVisible() {
        onView(withId(R.id.btn_tan)).check(matches(isDisplayed()));
    }

    @Test
    public void btnXPow2Visible() {
        onView(withId(R.id.btn_x_pow_2)).check(matches(isDisplayed()));
    }

    @Test
    public void btnSinInvVisible() {
        onView(withId(R.id.btn_sin_inv)).check(matches(isDisplayed()));
    }

    @Test
    public void btnCosInvVisible() {
        onView(withId(R.id.btn_cos_inv)).check(matches(isDisplayed()));
    }

    @Test
    public void btnTanInvVisible() {
        onView(withId(R.id.btn_tan_inv)).check(matches(isDisplayed()));
    }

    @Test
    public void btnXPow3Visible() {
        onView(withId(R.id.btn_x_pow_3)).check(matches(isDisplayed()));
    }

    @Test
    public void btnEPowXVisible() {
        onView(withId(R.id.btn_e_pow_x)).check(matches(isDisplayed()));
    }

    @Test
    public void btn10PowXVisible() {
        onView(withId(R.id.btn_10_pow_x)).check(matches(isDisplayed()));
    }

    @Test
    public void btn1DivXVisible() {
        onView(withId(R.id.btn_1_div_x)).check(matches(isDisplayed()));
    }

    @Test
    public void btnXPowYVisible() {
        onView(withId(R.id.btn_x_pow_y)).check(matches(isDisplayed()));
    }

    @Test
    public void btnLnVisible() {
        onView(withId(R.id.btn_ln)).check(matches(isDisplayed()));
    }

    @Test
    public void btnLogVisible() {
        onView(withId(R.id.btn_log)).check(matches(isDisplayed()));
    }

    @Test
    public void btnSqrtVisible() {
        onView(withId(R.id.btn_sqrt)).check(matches(isDisplayed()));
    }

    @Test
    public void btnPlusMinusVisible() {
        onView(withId(R.id.btn_plus_minus)).check(matches(isDisplayed()));
    }

    @Test
    public void checkCompute2Pow5() throws CalcULException {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_x_pow_y)).perform(click());
        onView(withId(R.id.btn_5)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("32")));
    }

    @Test
    public void checkSetSin() {
        onView(withId(R.id.btn_9)).perform(click());
        onView(withId(R.id.btn_0)).perform(click());
        onView(withId(R.id.btn_sin)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("1")));
    }

    @Test
    public void checkSetCos() {
        onView(withId(R.id.btn_1)).perform(click());
        onView(withId(R.id.btn_8)).perform(click());
        onView(withId(R.id.btn_0)).perform(click());
        onView(withId(R.id.btn_cos)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("-1")));
    }

    @Test
    public void checkSetTan() {
        onView(withId(R.id.btn_1)).perform(click());
        onView(withId(R.id.btn_tan)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("0.017455064928217585")));
    }

    @Test
    public void checkSet2Pow2() {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_x_pow_2)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("4")));
    }

    @Test
    public void checkSetSinInv() {
        onView(withId(R.id.btn_1)).perform(click());
        onView(withId(R.id.btn_sin_inv)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("90")));
    }

    @Test
    public void checkSetCosInv() {
        onView(withId(R.id.btn_1)).perform(click());
        onView(withId(R.id.btn_plus_minus)).perform(click());
        onView(withId(R.id.btn_cos_inv)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("180")));
    }

    @Test
    public void checkSetTanInv() {
        onView(withId(R.id.btn_0)).perform(click());
        onView(withId(R.id.btn_dot)).perform(click());
        onView(withId(R.id.btn_0)).perform(click());
        onView(withId(R.id.btn_1)).perform(click());
        onView(withId(R.id.btn_7)).perform(click());
        onView(withId(R.id.btn_4)).perform(click());
        onView(withId(R.id.btn_5)).perform(click());
        onView(withId(R.id.btn_5)).perform(click());
        onView(withId(R.id.btn_0)).perform(click());
        onView(withId(R.id.btn_6)).perform(click());
        onView(withId(R.id.btn_4)).perform(click());
        onView(withId(R.id.btn_9)).perform(click());
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_8)).perform(click());
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_1)).perform(click());
        onView(withId(R.id.btn_7)).perform(click());
        onView(withId(R.id.btn_5)).perform(click());
        onView(withId(R.id.btn_8)).perform(click());
        onView(withId(R.id.btn_5)).perform(click());
        onView(withId(R.id.btn_tan_inv)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("1")));
    }

    @Test
    public void checkSet2Pow3() {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_x_pow_3)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("8")));
    }

    @Test
    public void checkSetEPow0() {
        onView(withId(R.id.btn_0)).perform(click());
        onView(withId(R.id.btn_e_pow_x)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("1")));
    }

    @Test
    public void checkSetEPow2() {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_e_pow_x)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("7.3890560989306495")));
    }

    public void checkSet10Pow4() {
        onView(withId(R.id.btn_4)).perform(click());
        onView(withId(R.id.btn_10_pow_x)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("10000")));
    }

    @Test
    public void checkSet1Div4() {
        onView(withId(R.id.btn_4)).perform(click());
        onView(withId(R.id.btn_1_div_x)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("0.25")));
    }

    @Test
    public void checkSetLn1() {
        onView(withId(R.id.btn_1)).perform(click());
        onView(withId(R.id.btn_ln)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("0")));
    }

    @Test
    public void checkSetLn2() {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_ln)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("0.6931471805599453")));
    }

    @Test
    public void checkSetLog10000() {
        onView(withId(R.id.btn_1)).perform(click());
        onView(withId(R.id.btn_0)).perform(click());
        onView(withId(R.id.btn_0)).perform(click());
        onView(withId(R.id.btn_0)).perform(click());
        onView(withId(R.id.btn_0)).perform(click());
        onView(withId(R.id.btn_log)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("4")));
    }

    @Test
    public void checkSetSqrt() {
        onView(withId(R.id.btn_9)).perform(click());
        onView(withId(R.id.btn_sqrt)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("3")));
    }

    @Test
    public void checkSetPlusMinus() {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_plus_minus)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("-2")));
    }

    @Test
    public void checkSetPlusMinusMultiple() {
        onView(withId(R.id.btn_2)).perform(click());
        onView(withId(R.id.btn_plus_minus)).perform(click());
        onView(withId(R.id.btn_multiple)).perform(click());
        onView(withId(R.id.btn_7)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.text_result)).check(matches(withText("-14")));
    }
}