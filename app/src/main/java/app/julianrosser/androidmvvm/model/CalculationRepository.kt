package app.julianrosser.androidmvvm.model

class CalculationRepository {

    private val memoryStorage = mutableMapOf<String, WageChange>()

    fun saveWageChange(wageChange: WageChange) {
        memoryStorage[wageChange.title] = wageChange
    }

    fun loadWageChange(wageChangeTitle: String) = memoryStorage[wageChangeTitle]

}