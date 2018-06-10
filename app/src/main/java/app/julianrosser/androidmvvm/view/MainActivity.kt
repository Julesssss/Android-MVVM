package app.julianrosser.androidmvvm.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.julianrosser.androidmvvm.R
import app.julianrosser.androidmvvm.databinding.ActivityMainBinding
import app.julianrosser.androidmvvm.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = CalculatorViewModel(application)

    }
}
