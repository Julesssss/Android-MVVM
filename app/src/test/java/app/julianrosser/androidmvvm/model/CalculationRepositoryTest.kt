package app.julianrosser.androidmvvm.model

import org.junit.Before
import org.junit.Test
import junit.framework.Assert.assertEquals

class CalculationRepositoryTest {

     lateinit var repository: CalculationRepository

    @Before
    fun setup() {
        repository = CalculationRepository()
    }

    @Test
    fun `save wage change`() {
        val wageChange = WageChange("test wage", 10000, 15000, 5000, 100)

        repository.saveWageChange(wageChange)

        assertEquals(wageChange, repository.loadWageChange(wageChange.title))
    }

}