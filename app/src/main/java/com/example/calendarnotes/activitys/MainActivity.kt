package com.example.calendarnotes.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.calendarnotes.R
import com.example.calendarnotes.databinding.ActivityMainBinding
import com.example.calendarnotes.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // view model initialize here
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
      binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
          Toast.makeText(this, "year$year view:$view", Toast.LENGTH_SHORT).show()
          
      }
    }
}
