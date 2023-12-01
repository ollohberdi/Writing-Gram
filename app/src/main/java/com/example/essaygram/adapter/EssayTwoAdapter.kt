package com.example.essaygram.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.essaygram.databinding.QuestionItem2Binding
import com.example.essaygram.model.TaskTwo

class EssayTwoAdapter(var list: List<TaskTwo>, var onClickTwo: OnClickTwo) :
    RecyclerView.Adapter<EssayTwoAdapter.Vh>() {
    inner class Vh(var itemRv: QuestionItem2Binding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(taskTwoQs: TaskTwo, position: Int) {
            itemRv.question1txt.text = taskTwoQs.question

            itemRv.root.setOnClickListener {
                onClickTwo.click(taskTwoQs, position)
            }
            itemRv.readmore1.setOnClickListener {
                onClickTwo.click(taskTwoQs, position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(QuestionItem2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    interface OnClickTwo {
        fun click(taskTwo: TaskTwo, position: Int)
    }
}