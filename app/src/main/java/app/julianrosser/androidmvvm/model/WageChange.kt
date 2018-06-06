package app.julianrosser.androidmvvm.model

data class WageChange(val currentWage: Int, val newWage: Int, val wageChange: Int = 0, val percentChange: Int = 0)