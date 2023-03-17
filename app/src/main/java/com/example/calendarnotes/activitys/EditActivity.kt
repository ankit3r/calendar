package com.example.calendarnotes.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.calendarnotes.R
import com.example.calendarnotes.databinding.ActivityEditBinding
import com.example.calendarnotes.viewModel.EditTextViewModel

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    private lateinit var eViewModel: EditTextViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        eViewModel = ViewModelProvider(this)[EditTextViewModel::class.java]
        eViewModel.day = intent.getIntExtra("day", 0)
        eViewModel.month = intent.getIntExtra("month", 0)
        eViewModel.year = intent.getIntExtra("year", 0)

        binding.tetDateTime.text = getString(
            R.string.dayTime,
            eViewModel.day.toString(),
            eViewModel.month.toString(),
            eViewModel.year.toString()
        )



    }
}