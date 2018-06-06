package app.julianrosser.androidmvvm.model

import kotlin.math.roundToInt

class Calculator {

    fun calculateWageChange(currentWage: Int, newWage: Int): WageChange {

        val change: Int = newWage - currentWage

        var percentChange = newWage.toDouble() / currentWage

        val percentChangeRounded: Int =

                if (newWage >= currentWage) {
                    percentChange -= 1
                    percentChange *= 100
                    percentChange.roundToInt()
                } else {
                    -((1 - percentChange) * 100)
                            .roundToInt()
                }

        return WageChange(
                currentWage = currentWage,
                newWage = newWage,
                wageChange = change,
                percentChange = percentChangeRounded
        )
    }

}