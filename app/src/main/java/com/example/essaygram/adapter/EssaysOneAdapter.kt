package com.example.essaygram.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.essaygram.databinding.QuestionsItemBinding
import com.example.essaygram.model.TaskOne

/*
class EssaysOneAdapter {
}*/

class EssaysOneAdapter(var list: List<TaskOne>, var onClickOne: OnClickOne) :
    RecyclerView.Adapter<EssaysOneAdapter.Vh>() {
    inner class Vh(var itemRv: QuestionsItemBinding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(taskOneQs: TaskOne, position: Int) {
            itemRv.question1txt.text = taskOneQs.question
            itemRv.root.setOnClickListener {
                onClickOne.click(taskOneQs, position)
            }
            itemRv.readmore1.setOnClickListener {
                onClickOne.click(taskOneQs, position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(QuestionsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    interface OnClickOne {
        fun click(taskOne: TaskOne, position: Int)
    }

}