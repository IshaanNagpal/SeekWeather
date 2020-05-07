package com.spdigital.seekweather.activity

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.spdigital.seekweather.R
import com.spdigital.seekweather.view.SearchLocationActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class LocationsListActivityTest {

    @get: Rule
    val activityTestRule = ActivityTestRule(SearchLocationActivity::class.java, true, false)

    @Before
    fun beforeEach() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun checkIfShimmerIsShown() {
        onView(withId(R.id.shimmer_view_container)).check(matches(withEffectiveVisibility(Visibility.GONE)))
    }

    @Test
    fun checkIfRecyclerViewIsShown() {
        onView(withId(R.id.location_recyclerview)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun checkIfErrorScreenIsNotShownByDefault() {
        onView(withId(R.id.error_layout)).check(matches(withEffectiveVisibility(Visibility.GONE)))
    }

    @Test
    fun checkIfSearchViewIsAlwaysVisible() {
        onView(withId(R.id.location_searchview)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.location_searchview)).check(matches(isCompletelyDisplayed()))
    }

}