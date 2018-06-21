package app.julianrosser.androidmvvm.viewmodel

import android.app.Application
import app.julianrosser.androidmvvm.R
import app.julianrosser.androidmvvm.model.Calculator
import app.julianrosser.androidmvvm.model.WageChange

open class CalculatorViewModel @JvmOverloads constructor (
        app: Application, private val calculator: Calculator = Calculator()): ObservableViewModel(app) {

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
        outputChangeAmount = app().getString(R.string.money_amount, wageChange.wageChange)
        outputChangePercent = app().getString(R.string.percent_amount, wageChange.percentChange)
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