package com.example.recycle_view_simplife_task

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recycle_view_simplife_task.databinding.NumberEachItemBinding

class NumberAdapter(var numberList: List<NumberData>,var onContactClickListener: OnNumberClickListener) :
    RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        var view = NumberEachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NumberViewHolder(view,onContactClickListener)
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        var adapterList = numberList[position]
        holder.binding.itemImage.setImageResource(adapterList.image)
        holder.binding.titleText.text = adapterList.title
        holder.binding.descText.text = adapterList.description

        playToast(position,holder.itemView.context,holder.binding)
    }

    class NumberViewHolder(var binding: NumberEachItemBinding,onContactClickListener: OnNumberClickListener) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                 onContactClickListener.onTitListener(adapterPosition)
            }
        }
    }


    fun playToast(position: Int, context: Context, binding: NumberEachItemBinding) {
        binding.itemImage.setOnClickListener {
            Toast.makeText(context, "$position ", Toast.LENGTH_SHORT).show()
        }

    }
    interface OnNumberClickListener{
            fun onTitListener(position: Int)
    }


}