package com.example.calendarnotes.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calendarnotes.model.CalendarNote
import com.example.calendarnotes.repository.MyRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DBviewMode(private val myRepo: MyRepo) : ViewModel() {

    private val mList = MutableLiveData<List<CalendarNote>>()
    val notes: LiveData<List<CalendarNote>>
        get() = mList


    fun getNote(){
      viewModelScope.launch(Dispatchers.IO) {
        mList.postValue(myRepo.getNotes())
      }
    }
    fun addNote(note: CalendarNote){
      viewModelScope.launch(Dispatchers.IO) {
        myRepo.addNote(note)
      }
    }
    fun deleteNote(note: CalendarNote){
      viewModelScope.launch(Dispatchers.IO) {
        myRepo.deleteNote(note)
      }
    }
    fun updateNote(note: CalendarNote){
      viewModelScope.launch(Dispatchers.IO) {
        myRepo.updateNote(note)
      }
    }

}