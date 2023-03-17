package com.example.calendarnotes.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.calendarnotes.application.MyApp
import com.example.calendarnotes.databinding.ActivityMainBinding
import com.example.calendarnotes.viewModel.DBviewMode
import com.example.calendarnotes.viewModel.DbFactroy
import com.example.calendarnotes.viewModel.MainViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mModel: MainViewModel
    private lateinit var dbModel: DBviewMode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // view model initialize here
        val myRepo = (application as MyApp).myRepo
        mModel = ViewModelProvider(this)[MainViewModel::class.java]
        dbModel = ViewModelProvider(this,DbFactroy(myRepo))[DBviewMode::class.java]
        binding.calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            goEditPage(dayOfMonth,month,year)
        }
    }
    private fun goEditPage(dayOfMonth: Int, month: Int, year: Int) {
        val intent = Intent(this,EditActivity::class.java)
        intent.putExtra("day",dayOfMonth)
        intent.putExtra("month",month)
        intent.putExtra("year",year)
        startActivity(intent)
    }

}
