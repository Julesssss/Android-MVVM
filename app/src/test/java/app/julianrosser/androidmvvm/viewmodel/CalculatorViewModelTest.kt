package app.julianrosser.androidmvvm.viewmodel

import app.julianrosser.androidmvvm.model.Calculator
import app.julianrosser.androidmvvm.model.WageChange
import org.junit.Before
import org.junit.Test
import junit.framework.Assert.assertEquals
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class CalculatorViewModelTest {

    lateinit var calculatorViewModel: CalculatorViewModel

    @Mock
    lateinit var mockCalculator: Calculator

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        calculatorViewModel = CalculatorViewModel(mockCalculator)
    }

    @Test
    fun testCalculateTip() {

        calculatorViewModel = CalculatorViewModel(Calculator())

        calculatorViewModel.inputCurrentWage = "10000"
        calculatorViewModel.inputNewWage = "20000"

        calculatorViewModel.calculateWageChange()

        assertEquals(10000, calculatorViewModel.wageCalculation.currentWage)
        assertEquals(20000, calculatorViewModel.wageCalculation.newWage)
        assertEquals(10000, calculatorViewModel.wageCalculation.wageChange)
        assertEquals(100, calculatorViewModel.wageCalculation.percentChange)
    }

    @Test
    fun testMockedCalculateTip() {
        calculatorViewModel.inputCurrentWage = "10000"
        calculatorViewModel.inputNewWage = "20000"

        val stub = WageChange(10000, 20000, 10000, 100)
        `when`(mockCalculator.calculateWageChange(10000, 20000)).thenReturn(stub)

        calculatorViewModel.calculateWageChange()

        assertEquals(stub, calculatorViewModel.wageCalculation)
    }

    @Test
    fun testBadCurrentWageInput() {
        calculatorViewModel.inputCurrentWage = "10000"
        calculatorViewModel.inputNewWage = ""

        val stub = WageChange(10000, 20000, 10000, 100)
        `when`(mockCalculator.calculateWageChange(10000, 20000)).thenReturn(stub)

        calculatorViewModel.calculateWageChange()

        verify(mockCalculator, never()).calculateWageChange(anyInt(), anyInt())
    }

    @Test
    fun testBadNewWageInput() {
        calculatorViewModel.inputCurrentWage = ""
        calculatorViewModel.inputNewWage = "20000"

        val stub = WageChange(10000, 20000, 10000, 100)
        `when`(mockCalculator.calculateWageChange(10000, 20000)).thenReturn(stub)

        calculatorViewModel.calculateWageChange()

        verify(mockCalculator, never()).calculateWageChange(anyInt(), anyInt())
    }

}