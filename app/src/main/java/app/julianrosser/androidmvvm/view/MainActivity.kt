package app.julianrosser.androidmvvm.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import app.julianrosser.androidmvvm.R
import app.julianrosser.androidmvvm.databinding.ActivityMainBinding
import app.julianrosser.androidmvvm.viewmodel.CalculatorViewModel

/**
 * The main application activity. Allows users to calculate wage changes with the use of CalculatorViewModel
 */
class MainActivity : AppCompatActivity(), SaveDialogFragment.Callback {

    /**
     * Callback from SaveDialog
     *
     * @param description: The id used to save / retrieve calculation.
     */
    override fun onSave(description: String) {
        Snackbar.make(binding.root, "Saved $description", Snackbar.LENGTH_SHORT).show()
    }

    // Activity binding used to link views to persistent ViewModel and allows 2 way binding link
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // sets layout and returns binding associated with it
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // link CalculatorViewModel to activity binding
        binding.vm = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {
                showSaveDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showSaveDialog() {
        SaveDialogFragment().show(supportFragmentManager, "SaveDialog")
    }
}
