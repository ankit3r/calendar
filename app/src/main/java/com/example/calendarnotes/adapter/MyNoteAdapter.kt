package com.example.calendarnotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.calendarnotes.databinding.LayoutNoteCardBinding
import com.example.calendarnotes.model.CalendarNote

class LiveDataRecyclerAdapter(
    liveData: LiveData<List<CalendarNote>>
) : RecyclerView.Adapter<LiveDataRecyclerAdapter.MyViewHolder>() ,Observer<List<CalendarNote>> {

    private var data: List<CalendarNote> = listOf()

    init {
        liveData.observeForever(this)
    }

    inner class MyViewHolder(private val binding: LayoutNoteCardBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data: CalendarNote) {
            binding.apply {
                txtTitle.text = "${data.date} ${data.description}"
                txtDisc.text = data.description

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutNoteCardBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun onChanged(value: List<CalendarNote>) {
        data = value
        notifyDataSetChanged()
    }
}