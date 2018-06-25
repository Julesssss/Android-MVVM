package app.julianrosser.androidmvvm.viewmodel

import android.app.Application
import app.julianrosser.androidmvvm.R
import app.julianrosser.androidmvvm.model.Calculator
import app.julianrosser.androidmvvm.model.WageChange

/**
 * Two way data binding ViewModel for performing wage calculations. Extends ObservableViewModel for
 * simple view notification on property change and AndroidViewModel for lifecycle awareness.
 */
open class CalculatorViewModel @JvmOverloads constructor (
        app: Application, private val calculator: Calculator = Calculator()): ObservableViewModel(app) {

    /**
     * Inbound bindings
     */
    // Current wage taken from EditText
    var inputCurrentWage = ""
    // New wage taken from EditText
    var inputNewWage = ""

    /**
     * Outbound bindings
     */
    // Difference between current and new wage.
    var outputChangeAmount = ""
    // Percentage of wage increase or decrease.
    var outputChangePercent = ""

    /**
     * Ensure output values are initialised when ViewModel is created.
     */
    init {
        updateOutputs(WageChange())
    }

    /**
     * Update output properties after calculation.
     *
     * @param wageChange: the completed calculation form which we will read values
     */
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