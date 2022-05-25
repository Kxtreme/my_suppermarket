package me.kxtre.mysuppermarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.kxtre.mysuppermarket.controllers.model.Grocery
import me.kxtre.mysuppermarket.controllers.model.GroceryAdapter
import me.kxtre.mysuppermarket.databinding.ActivityGroceriesBinding

class GroceriesActivity : AppCompatActivity() {
    lateinit var binding: ActivityGroceriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroceriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateData()
    }

    private fun populateData() {
        val adapter = GroceryAdapter(this, (0..20).map { Grocery.generate() })
        binding.recyclerViewGroceries.adapter = adapter
    }
}