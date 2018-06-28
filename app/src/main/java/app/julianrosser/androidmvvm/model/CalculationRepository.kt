package app.julianrosser.androidmvvm.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

/**
 * Basic repository for temporarily persisting WageChanges. Keeps wage changes in memory and
 * provides a variety of saving, access methods.
 */
class CalculationRepository {

    // Temporary data storage
    private val memoryStorage = mutableMapOf<String, WageChange>()

    /**
     * Add a WageChange calculation to the storage map
     */
    fun saveWageChange(wageChange: WageChange) {
        memoryStorage[wageChange.title] = wageChange
    }

    /**
     * Load a single WageChange calculation by name
     */
    fun loadWageChangeByName(wageChangeTitle: String) = memoryStorage[wageChangeTitle]

    /**
     * Retrieve a LiveData observable containing all WageChange calculations. Is aware of
     * subscriber's lifecycle.
     */
    fun loadObservableWageChanges(): LiveData<List<WageChange>> {
        val liveData = MutableLiveData<List<WageChange>>()
        liveData.value = memoryStorage.values.toList()
        return liveData
    }

}