[app](../../index.md) / [app.julianrosser.androidmvvm.viewmodel](../index.md) / [CalculatorViewModel](./index.md)

# CalculatorViewModel

`open class CalculatorViewModel : `[`ObservableViewModel`](../-observable-view-model/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CalculatorViewModel(app: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`, calculator: `[`Calculator`](../../app.julianrosser.androidmvvm.model/-calculator/index.md)` = Calculator())` |

### Properties

| Name | Summary |
|---|---|
| [inputCurrentWage](input-current-wage.md) | `var inputCurrentWage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [inputNewWage](input-new-wage.md) | `var inputNewWage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [outputChangeAmount](output-change-amount.md) | `var outputChangeAmount: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [outputChangePercent](output-change-percent.md) | `var outputChangePercent: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [calculateWageChange](calculate-wage-change.md) | `fun calculateWageChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>calculates wage change and percentage, updates variables and notifies view of change |

### Inherited Functions

| Name | Summary |
|---|---|
| [addOnPropertyChangedCallback](../-observable-view-model/add-on-property-changed-callback.md) | `open fun addOnPropertyChangedCallback(callback: OnPropertyChangedCallback?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [app](../-observable-view-model/app.md) | `fun app(): `[`Application`](https://developer.android.com/reference/android/app/Application.html)<br>Helper function for simplifying application context lookup |
| [notifyChange](../-observable-view-model/notify-change.md) | `fun notifyChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Notify all properties of changes |
| [removeOnPropertyChangedCallback](../-observable-view-model/remove-on-property-changed-callback.md) | `open fun removeOnPropertyChangedCallback(callback: OnPropertyChangedCallback?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
