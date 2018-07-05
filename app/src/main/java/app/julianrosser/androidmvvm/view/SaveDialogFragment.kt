package app.julianrosser.androidmvvm.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.EditText
import app.julianrosser.androidmvvm.R
import app.julianrosser.androidmvvm.setPadding

/**
 * DialogFragment for giving the current calculation a value before saving it to the repo.
 */
class SaveDialogFragment : DialogFragment() {

    /**
     * Callback for returning description to the calling Activity
     */
    interface Callback {
        fun onSave(description: String)
    }

    private var saveCallback: Callback? = null

    /**
     * Set the callback when attaching DialogFragment to Activity
     */
    override fun onAttach(context: Context?) {
        super.onAttach(context)

        saveCallback = context as? Callback
    }

    /**
     * Detach the callback when Activity is closing
     */
    override fun onDetach() {
        super.onDetach()

        saveCallback = null
    }

    /**
     * Build basic dialog containing EditText for entering description
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)

        val dialog = context?.let {

            val editText = EditText(it)
            editText.id = viewId
            editText.hint = getString(R.string.save_dialog_hint)
            editText.setPadding(resources.getDimension(R.dimen.default_margin).toInt())

            AlertDialog.Builder(it)
                    .setView(editText)
                    .setNegativeButton(getString(R.string.save_dialog_button_cancel), null)
                    .setPositiveButton(getString(R.string.save_dialog_button_positive), { _,_ -> onSave(editText.text.toString())  })
                    .create()
        }

        return dialog!!
    }

    private fun onSave(description: String) {
        if (description.isNotEmpty()) {
            saveCallback?.onSave(description)
        }
    }

    companion object {
        val viewId = View.generateViewId()
    }

}