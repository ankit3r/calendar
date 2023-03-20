package com.example.calendarnotes.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import com.example.calendarnotes.R
import com.example.calendarnotes.application.MyApp
import com.example.calendarnotes.databinding.ActivityEditBinding
import com.example.calendarnotes.model.CalendarNote
import com.example.calendarnotes.viewModel.DBviewMode
import com.example.calendarnotes.viewModel.DbFactroy
import com.example.calendarnotes.viewModel.EditTextViewModel
import java.util.*

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    private lateinit var eViewModel: EditTextViewModel
    private lateinit var backPressCallback: OnBackPressedCallback
    private lateinit var dbModel: DBviewMode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val myRepo = (application as MyApp).myRepo
        dbModel = ViewModelProvider(this, DbFactroy(myRepo))[DBviewMode::class.java]
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

        backPressCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val note = binding.editTxt.text.toString()
                if (note.isEmpty()){
                    finish()
                }else{
                    addNote(note){succ,error ->
                        if (succ){
                            Toast.makeText(this@EditActivity, "added", Toast.LENGTH_SHORT).show()
                            finish()
                        }else
                            Toast.makeText(this@EditActivity, error, Toast.LENGTH_SHORT).show()

                    }
                }            }
        }
        onBackPressedDispatcher.addCallback(this, backPressCallback)

        binding.btnSave.setOnClickListener {
            val note = binding.editTxt.text.toString()
            if (note.isEmpty()){
              finish()
            }else{
                addNote(note){succ,error ->
                    if (succ){
                        Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
                        finish()
                    }else
                        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()

                }
            }
        }



    }

    override fun onDestroy() {
        super.onDestroy()
        backPressCallback.remove()
    }

    private fun addNote(note: String,responce: (Boolean, String) -> Unit) {
        val id = "${eViewModel.day}${eViewModel.month}${eViewModel.year}"

        dbModel.addNote(
            CalendarNote(
                id,
                getDateInMillis(eViewModel.day, eViewModel.month, eViewModel.year),
                note,
                getColor(R.color.deep_purple_300)
            ),responce
        )

    }

    private fun getDateInMillis(day: Int, month: Int, year: Int): Long {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        return calendar.timeInMillis
    }
}