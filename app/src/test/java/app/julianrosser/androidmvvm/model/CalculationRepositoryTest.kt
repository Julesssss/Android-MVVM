package app.julianrosser.androidmvvm.model

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Test
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.rules.TestRule

class CalculationRepositoryTest {

    // Necessary in order to test live data architecture component
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var repository: CalculationRepository

    @Before
    fun setup() {
        repository = CalculationRepository()
    }

    @Test
    fun `save wage change`() {
        val wageChange = WageChange("test wage", 10000, 15000, 5000, 100)

        repository.saveWageChange(wageChange)

        assertEquals(wageChange, repository.loadWageChangeByName(wageChange.title))
    }

    @Test
    fun `load saved wage change`() {
        val wageChange = WageChange("test wage", 10000, 15000, 5000, 100)

        repository.saveWageChange(wageChange)
        repository.saveWageChange(wageChange.copy(title = "test wage 2"))


        repository.loadObservableWageChanges().observeForever { tipCalculations ->
            assertEquals(2, tipCalculations?.size)
        }
    }

}