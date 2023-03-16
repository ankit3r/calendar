package com.example.calendarnotes.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.calendarnotes.repository.MyRepo

class DbFactroy(private val myRepo: MyRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DBviewMode(myRepo) as T
    }
}