package com.example.calendarnotes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calendarnotes.databinding.LayoutNoteCardBinding
import com.example.calendarnotes.model.CalendarNote

class MyNoteAdapter(private val context: Context,private val note:List<CalendarNote>,private val click:MyNoteClick):RecyclerView.Adapter<MyNoteAdapter.MyViewHolder>() {
    inner class MyViewHolder(private val binding: LayoutNoteCardBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data: CalendarNote, click: MyNoteClick) {
            binding.apply {
              txtTitle.text = data.description
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
       return note.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(note[position],click)
    }
}