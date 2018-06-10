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

    private fun stubMoneyResource(given: Int, returnStub: String) {
        `when`(application.getString(R.string.money_amount, given)).thenReturn(returnStub)
    }

    private fun stubPercentageResource(given: Int, returnStub: String) =
        `when`(application.getString(R.string.percent_amount, given)).thenReturn(returnStub)

    @Test
    fun testMockedCalculateTip() {
        calculatorViewModel.inputCurrentWage = "10000"
        calculatorViewModel.inputNewWage = "20000"

        val stub = WageChange(10000, 20000, 10000, 100)
        `when`(mockCalculator.calculateWageChange(10000, 20000)).thenReturn(stub)

        stubMoneyResource(10000, "£10000")
        stubPercentageResource(100, "100%")

        calculatorViewModel.calculateWageChange()

        assertEquals("£10000", calculatorViewModel.outputChangeAmount)
        assertEquals("100%", calculatorViewModel.outputChangePercent)
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