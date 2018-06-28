package app.julianrosser.androidmvvm.model

import android.arch.lifecycle.LiveData
import kotlin.math.roundToInt

/**
 * Model class for performing calculations. Has a dependency on Repository and quick access functions.
 */
class Calculator(private val repository: CalculationRepository = CalculationRepository()) {

    /**
     * Takes current and new wage inputs, calculates any useful information and outputs {@link WageChange} object.
     */
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

    /*
     * Repository helper functions
     */

    fun saveWageCalulation(wageChange: WageChange) {
        repository.saveWageChange(wageChange)
    }

    fun loadWageCalculationByName(wageChangeName: String): WageChange? =
            repository.loadWageChangeByName(wageChangeName)

    fun loadObservableWageCalculations(): LiveData<List<WageChange>> =
            repository.loadObservableWageChanges()

}