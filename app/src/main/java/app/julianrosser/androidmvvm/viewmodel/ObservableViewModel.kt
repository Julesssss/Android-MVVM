package app.julianrosser.androidmvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry
import app.julianrosser.androidmvvm.BR

/**
 * Base ViewModel which persists state across device rotation and handles observables.
 * Also provides a simplified function to retrieve application context.
 *
 * @param app: Application reference which is passed to parent class
 */
abstract class ObservableViewModel(app: Application) : AndroidViewModel(app), Observable {

    /**
     * Lazily instantiated list of callbackRegistry which will be notified when a properties value has changed.
     */
    @delegate:Transient
    private val callbackRegistry: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    /**
     * Add an observable callback to the list
     */
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbackRegistry.add(callback)
    }

    /**
     * Remove an observable callback to the list
     */
    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbackRegistry.add(callback)
    }

    /**
     * Notify all properties of changes
     */
    fun notifyChange() {
        callbackRegistry.notifyChange(this, BR._all)
    }

    /**
     * Helper function for simplifying application context lookup
     *
     * @return Application: reference to the app context
     */
    fun app() = getApplication<Application>()

}