package app.julianrosser.androidmvvm.viewmodel

import android.app.Application
import app.julianrosser.androidmvvm.R
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

    @Mock
    lateinit var application: Application

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        stubMoneyResource(0, "£0")
        stubPercentageResource(0, "0%")
        calculatorViewModel = CalculatorViewModel(application, mockCalculator)
    }

    /**
     *  prepares mocked resource responses
     */
    private fun stubMoneyResource(given: Int, returnStub: String) {
        `when`(application.getString(R.string.money_amount, given)).thenReturn(returnStub)
    }

    private fun stubPercentageResource(given: Int, returnStub: String) =
        `when`(application.getString(R.string.percent_amount, given)).thenReturn(returnStub)


    @Test
    fun `test mocked calculateTip()`() {
        calculatorViewModel.inputCurrentWage = "10000"
        calculatorViewModel.inputNewWage = "20000"

        val stub = WageChange("testA", 10000, 20000, 10000, 100)
        `when`(mockCalculator.calculateWageChange(10000, 20000)).thenReturn(stub)

        stubMoneyResource(10000, "£10000")
        stubPercentageResource(100, "100%")

        calculatorViewModel.calculateWageChange()

        // check that the VM's output values have been calculated correctly
        verify(mockCalculator, atLeastOnce()).calculateWageChange(anyInt(), anyInt())
        assertEquals("£10000", calculatorViewModel.outputChangeAmount)
        assertEquals("100%", calculatorViewModel.outputChangePercent)
    }

    @Test
    fun `test bad new wage input`() {
        calculatorViewModel.inputCurrentWage = ""
        calculatorViewModel.inputNewWage = "20000"

        val stub = WageChange("testB", 10000, 20000, 10000, 100)
        `when`(mockCalculator.calculateWageChange(10000, 20000)).thenReturn(stub)

        calculatorViewModel.calculateWageChange()

        // check that the calculator was not called due to bad input
        verify(mockCalculator, never()).calculateWageChange(anyInt(), anyInt())
    }

    @Test
    fun `test bad current wage input`() {
        calculatorViewModel.inputCurrentWage = "10000"
        calculatorViewModel.inputNewWage = ""

        val stub = WageChange("testC", 10000, 20000, 10000, 100)
        `when`(mockCalculator.calculateWageChange(10000, 20000)).thenReturn(stub)

        calculatorViewModel.calculateWageChange()

        // check that the calculator was not called due to bad input
        verify(mockCalculator, never()).calculateWageChange(anyInt(), anyInt())
    }

}