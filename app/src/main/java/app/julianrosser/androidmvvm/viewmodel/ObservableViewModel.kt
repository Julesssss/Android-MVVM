package app.julianrosser.androidmvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry
import com.android.databinding.library.baseAdapters.BR

/**
 * Base ViewModel which persists state across device rotation and handles observables.
 * Also provides a simplified function to retrieve application context.
 *
 * @param app: Application reference which is passed to parent class
 */
abstract class ObservableViewModel(app: Application) : AndroidViewModel(app), Observable {

    @delegate:Transient
    private val mCallbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }
    
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallbacks.add(callback)
    }

    /**
     * Notify all properties of changes
     */
    fun notifyChange() {
        mCallbacks.notifyChange(this, BR._all)
    }

    /**
     * Helper function for simplifying application context lookup
     *
     * @return Application: reference to the app context
     */
    fun app() = getApplication<Application>()

}