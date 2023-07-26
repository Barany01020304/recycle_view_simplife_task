package com.example.recycle_view_simplife_task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycle_view_simplife_task.databinding.ActivityMainBinding
import com.example.recycle_view_simplife_task.databinding.ActivityMainBinding.inflate
import java.text.FieldPosition

class MainActivity : AppCompatActivity(),NumberAdapter.OnNumberClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycleView.adapter=NumberAdapter(allItem(), this)
       // binding.recycleView.layoutManager=LinearLayoutManager(this)
    }
    companion object {
        fun allItem(): List<NumberData> {
            var list = arrayListOf<NumberData>(
                NumberData(R.drawable.one, "one", "this is  Saturday"),
                NumberData(R.drawable.two, "two", "this is ٍSunday "),
                NumberData(R.drawable.three, "three", "this is Monday"),
                NumberData(R.drawable.four, "four", "this is  Tuesday"),
                NumberData(R.drawable.five, "five", "this is  Wednesday"),
                NumberData(R.drawable.six, "six", "this is Thursday"),
                NumberData(R.drawable.seven, "seven", "this is Friday")

            )
            return list

        }
        val imageKey="imageKey"
        val titleKey="titleKey"
        val descKey="descKey"
        val positionKey="positionKey"

    }
    override fun onTitListener(position: Int) {
        var intent=Intent(this,ViewActivity::class.java)
        intent.putExtra(imageKey, allItem()[position].image)
        intent.putExtra(titleKey, allItem()[position].title)
        intent.putExtra(descKey, allItem()[position].description)
        intent.putExtra(positionKey,position)
        startActivity(intent)
    }
}