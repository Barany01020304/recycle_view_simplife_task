package com.example.recycle_view_simplife_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import com.example.recycle_view_simplife_task.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity(), NumberAdapter.OnNumberClickListener {
    lateinit var binding: ActivityViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var position = intent.getIntExtra(MainActivity.positionKey, 0)
        binding.viewNumberImage.setImageResource(intent.getIntExtra(MainActivity.imageKey, 0))
        binding.viewDescText.text = intent.getStringExtra(MainActivity.descKey)
        binding.viewTitleText.text = intent.getStringExtra(MainActivity.titleKey)
        binding.nextImage.setOnClickListener {
            if (position == MainActivity.allItem().size - 1) {
                position = 0
            } else {
                position++
            }

            binding.viewNumberImage.setImageResource(MainActivity.allItem()[position].image)
            binding.viewDescText.text = MainActivity.allItem()[position].description
            binding.viewTitleText.text = MainActivity.allItem()[position].title
        }
        binding.backImage.setOnClickListener {
            if (position == 0) {
                position = MainActivity.allItem().size - 1
            } else {
                position--
            }

            binding.viewNumberImage.setImageResource(MainActivity.allItem()[position].image)
            binding.viewDescText.text = MainActivity.allItem()[position].description
            binding.viewTitleText.text = MainActivity.allItem()[position].title
        }
    }

    override fun onTitListener(position: Int) {

    }
}