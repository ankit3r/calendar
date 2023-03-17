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


    private fun getNote(){
      viewModelScope.launch(Dispatchers.IO) {
        mList.postValue(myRepo.getNotes())
      }
    }
    fun addNote(note: CalendarNote,responce: (Boolean, String) -> Unit){
      viewModelScope.launch(Dispatchers.IO) {
        myRepo.addNote(note,responce)
      }
    }
    fun deleteNote(note: CalendarNote,responce: (Boolean, String) -> Unit){
      viewModelScope.launch(Dispatchers.IO) {
        myRepo.deleteNote(note,responce)
      }
    }
    fun updateNote(note: CalendarNote,responce: (Boolean, String) -> Unit){
      viewModelScope.launch(Dispatchers.IO) {
        myRepo.updateNote(note,responce)
      }
    }
    init {
        getNote()
    }

}