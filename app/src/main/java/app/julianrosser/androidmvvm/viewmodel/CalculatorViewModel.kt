package app.julianrosser.androidmvvm.viewmodel

import app.julianrosser.androidmvvm.model.Calculator
import app.julianrosser.androidmvvm.model.WageChange

class CalculatorViewModel(val calculator: Calculator = Calculator()) {

    var inputCurrentWage = ""

    var inputNewWage = ""

    var wageCalculation = WageChange()

    fun calculateWageChange() {

        inputCurrentWage.toIntOrNull()?.let { currentWageInt ->
            inputNewWage.toIntOrNull()?.let { newWageInt ->

                wageCalculation = calculator.calculateWageChange(currentWageInt, newWageInt)
            }
        }
    }

}