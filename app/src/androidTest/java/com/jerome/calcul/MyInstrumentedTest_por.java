package com.jerome.calcul;

import android.content.pm.ActivityInfo;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MyInstrumentedTest_por extends MyInstrumentedTest {

    @Before
    public void init() {
        super.init();
        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getInstrumentation().waitForIdleSync();
    }

    @Test
    public void btnSinInvisible() {
        onView(withId(R.id.btn_sin)).check(doesNotExist());
    }

    @Test
    public void btnCosInvisible() {
        onView(withId(R.id.btn_cos)).check(doesNotExist());
    }

    @Test
    public void btnTanInvisible() {
        onView(withId(R.id.btn_tan)).check(doesNotExist());
    }

    @Test
    public void btnXPow2Invisible() {
        onView(withId(R.id.btn_x_pow_2)).check(doesNotExist());
    }

    @Test
    public void btnSinInvInvisible() {
        onView(withId(R.id.btn_sin_inv)).check(doesNotExist());
    }

    @Test
    public void btnCosInvInvisible() {
        onView(withId(R.id.btn_cos_inv)).check(doesNotExist());
    }

    @Test
    public void btnTanInvInvisible() {
        onView(withId(R.id.btn_tan_inv)).check(doesNotExist());
    }

    @Test
    public void btnXPow3Invisible() {
        onView(withId(R.id.btn_x_pow_3)).check(doesNotExist());
    }

    @Test
    public void btnEPowXInvisible() {
        onView(withId(R.id.btn_e_pow_x)).check(doesNotExist());
    }

    @Test
    public void btn10PowXInvisible() {
        onView(withId(R.id.btn_10_pow_x)).check(doesNotExist());
    }

    @Test
    public void btn1DivXInvisible() {
        onView(withId(R.id.btn_1_div_x)).check(doesNotExist());
    }

    @Test
    public void btnXPowYInvisible() {
        onView(withId(R.id.btn_x_pow_y)).check(doesNotExist());
    }

    @Test
    public void btnLnInvisible() {
        onView(withId(R.id.btn_ln)).check(doesNotExist());
    }

    @Test
    public void btnLogInvisible() {
        onView(withId(R.id.btn_log)).check(doesNotExist());
    }

    @Test
    public void btnSqrtInvisible() {
        onView(withId(R.id.btn_sqrt)).check(doesNotExist());
    }

    @Test
    public void btnPlusMinusInvisible() {
        onView(withId(R.id.btn_plus_minus)).check(doesNotExist());
    }

}