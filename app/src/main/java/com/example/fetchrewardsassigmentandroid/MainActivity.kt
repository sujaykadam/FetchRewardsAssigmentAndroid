package com.example.fetchrewardsassigmentandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchrewardsassigmentandroid.adapters.GroupedItemAdapter
import com.example.fetchrewardsassigmentandroid.databinding.ActivityMainBinding
import com.example.fetchrewardsassigmentandroid.viewmodels.ItemViewModel
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.items.observe(this) {
            binding.mainRecyclerView.adapter = GroupedItemAdapter(it)
        }

        viewModel.fetchItems()
    }
}
