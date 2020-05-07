package com.spdigital.seekweather.activity

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.spdigital.seekweather.R
import com.spdigital.seekweather.view.WeatherDetailActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class WeatherDetailActivityTest {

    @get: Rule
    val activityTestRule = ActivityTestRule(WeatherDetailActivity::class.java, true, false)


    @Before
    fun beforeEach() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun checkIfAllElementsAreDisplayed() {
        onView(withId(R.id.weather_image)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.weather_textview)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.location_name_textview)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.celcius_textview)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.fahraneit_textview)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.humidity_textview)).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun checkAllTheChildOfViewGroup() {
        onView(withId(R.id.parent_container)).check(matches(hasChildCount(7)))
    }
}