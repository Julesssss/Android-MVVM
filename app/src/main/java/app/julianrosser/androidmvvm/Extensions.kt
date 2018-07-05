package app.julianrosser.androidmvvm

import android.support.annotation.Px
import android.view.View

/**
 * Sets the view's padding. This version of the method sets all axes to the provided size.
 */
inline fun View.setPadding(@Px size: Int) {
    setPadding(size, size, size, size)
}