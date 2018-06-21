[app](../../index.md) / [app.julianrosser.androidmvvm.viewmodel](../index.md) / [ObservableViewModel](./index.md)

# ObservableViewModel

`abstract class ObservableViewModel : AndroidViewModel, Observable`

Base ViewModel which persists state across device rotation and handles observables.
Also provides a simplified function to retrieve application context.

### Parameters

`app` - : Application reference which is passed to parent class

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ObservableViewModel(app: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`)`<br>Base ViewModel which persists state across device rotation and handles observables. Also provides a simplified function to retrieve application context. |

### Functions

| Name | Summary |
|---|---|
| [addOnPropertyChangedCallback](add-on-property-changed-callback.md) | `open fun addOnPropertyChangedCallback(callback: OnPropertyChangedCallback?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [app](app.md) | `fun app(): `[`Application`](https://developer.android.com/reference/android/app/Application.html)<br>Helper function for simplifying application context lookup |
| [notifyChange](notify-change.md) | `fun notifyChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Notify all properties of changes |
| [removeOnPropertyChangedCallback](remove-on-property-changed-callback.md) | `open fun removeOnPropertyChangedCallback(callback: OnPropertyChangedCallback?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [CalculatorViewModel](../-calculator-view-model/index.md) | `open class CalculatorViewModel : `[`ObservableViewModel`](./index.md) |
