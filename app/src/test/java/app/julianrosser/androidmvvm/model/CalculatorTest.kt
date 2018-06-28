package app.julianrosser.androidmvvm.model

import junit.framework.Assert
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun setup() {
        calculator = Calculator()
    }

    @Test
    fun `test basic wage change calculation`() {

        val currentWage = 20000
        val newWage = 25000

        val testCalc = WageChange(currentWage = currentWage, newWage = newWage, wageChange = 5000, percentChange = 25)

        Assert.assertEquals(testCalc, calculator.calculateWageChange(currentWage, newWage))
    }

    @Test
    fun `test no change to wage`() {

        val currentWage = 20000
        val newWage = 20000

        val testCalc = WageChange(currentWage = currentWage, newWage = newWage, wageChange = 0, percentChange = 0)

        Assert.assertEquals(testCalc, calculator.calculateWageChange(currentWage, newWage))
    }

    @Test
    fun `test negative wage change calculation`() {

        val baseTestCalculation = WageChange(currentWage = 20000, newWage = 14000, wageChange = -6000)

        val testCalc = baseTestCalculation.copy(percentChange = -30)
        val incorrectTestCalc = baseTestCalculation.copy(percentChange = 100)

        Assert.assertEquals(testCalc, calculator.calculateWageChange(baseTestCalculation.currentWage, baseTestCalculation.newWage))
        Assert.assertNotSame(incorrectTestCalc, calculator.calculateWageChange(baseTestCalculation.currentWage, baseTestCalculation.newWage))
    }

    @Test
    fun `test multiple wage change calculations`() {

        listOf(
                WageChange(currentWage = 28000, newWage = 32200, wageChange = 4200, percentChange = 15),
                WageChange(currentWage = 28000, newWage = 29400, wageChange = 1400, percentChange = 5),
                WageChange(currentWage = 28000, newWage = 56000, wageChange = 28000, percentChange = 100),
                WageChange(currentWage = 28000, newWage = 14000, wageChange = -14000, percentChange = -50),
                WageChange(currentWage = 28000, newWage = 7000, wageChange = -21000, percentChange = -75)
        ).forEach {
            Assert.assertEquals(it, calculator.calculateWageChange(currentWage = it.currentWage, newWage = it.newWage))
        }

    }

}