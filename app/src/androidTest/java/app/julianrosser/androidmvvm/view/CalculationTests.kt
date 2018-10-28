package app.julianrosser.androidmvvm.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import app.julianrosser.androidmvvm.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CalculationTests {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    private val currentWage = "20000"
    private val newWage = "30000"
    private val outputChange = "£10000"
    private val outputPercentage = "50%"

    @Test
    fun calculationTests() {
        // Enter current wage
        with(onView(withId(R.id.editTextCurrentWage))) {
            perform(click())
            perform(replaceText(currentWage), closeSoftKeyboard())
            perform(pressImeActionButton())
        }

        // Enter new wage
        with(onView(withId(R.id.editTextNewWage))) {
            perform(replaceText(newWage), closeSoftKeyboard())
            perform(pressImeActionButton())
        }

        // Hit calculate button
        onView(withId(R.id.buttonCalculate)).perform(click())

        // Verify difference is correct
        onView(withId(R.id.textResultDifference)).check(matches(withText(outputChange)))
        onView(withId(R.id.textResultPercentChange)).check(matches(withText(outputPercentage)))
    }

}
