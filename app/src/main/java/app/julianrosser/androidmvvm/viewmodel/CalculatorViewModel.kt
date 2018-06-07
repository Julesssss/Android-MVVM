package app.julianrosser.androidmvvm.viewmodel

import android.databinding.BaseObservable
import android.util.Log
import app.julianrosser.androidmvvm.model.Calculator
import app.julianrosser.androidmvvm.model.WageChange

class CalculatorViewModel(val calculator: Calculator = Calculator()): BaseObservable() {

    var inputCurrentWage = ""
    var inputNewWage = ""

    var wageCalculation = WageChange()

    fun calculateWageChange() {

        inputCurrentWage.toIntOrNull()?.let { currentWageInt ->
            inputNewWage.toIntOrNull()?.let { newWageInt ->

                Log.i("ttt", "values: $inputCurrentWage  -> $inputNewWage ")

                wageCalculation = calculator.calculateWageChange(currentWageInt, newWageInt)
            }
        }
    }

}