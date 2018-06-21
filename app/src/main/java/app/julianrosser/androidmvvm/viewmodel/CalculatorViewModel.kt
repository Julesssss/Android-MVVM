package app.julianrosser.androidmvvm.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import app.julianrosser.androidmvvm.R
import app.julianrosser.androidmvvm.model.Calculator
import app.julianrosser.androidmvvm.model.WageChange

open class CalculatorViewModel(private val application: Application, private val calculator: Calculator = Calculator()): BaseObservable() {

    // inbound binding
    var inputCurrentWage = ""
    var inputNewWage = ""

    // outbound binding
    var outputChangeAmount = ""
    var outputChangePercent = ""

    init {
        updateOutputs(WageChange())
    }

    private fun updateOutputs(wageChange: WageChange) {
        outputChangeAmount = application.getString(R.string.money_amount, wageChange.wageChange)
        outputChangePercent = application.getString(R.string.percent_amount, wageChange.percentChange)
    }

    /**
     * calculates wage change and percentage, updates variables and notifies view of change
     */
    fun calculateWageChange() {
        inputCurrentWage.toIntOrNull()?.let { currentWageInt ->
            inputNewWage.toIntOrNull()?.let { newWageInt ->

                updateOutputs(calculator.calculateWageChange(currentWageInt, newWageInt))
                notifyChange()
            }
        }
    }

}