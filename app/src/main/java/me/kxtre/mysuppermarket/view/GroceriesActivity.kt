package me.kxtre.mysuppermarket.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.kxtre.mysuppermarket.model.Grocery
import me.kxtre.mysuppermarket.adapter.GroceryAdapter
import me.kxtre.mysuppermarket.databinding.ActivityGroceriesBinding

class GroceriesActivity : AppCompatActivity() {
    lateinit var binding: ActivityGroceriesBinding
    private val addGroceryDialog = GroceriesAddDialogFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroceriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateData()
        registerListeners()
    }

    private fun populateData() {
        val adapter = GroceryAdapter(this, (0..20).map { Grocery.generate() })
        binding.recyclerViewGroceries.adapter = adapter
    }

    private fun registerListeners() {
        binding.addButton.setOnClickListener { openAddDialog() }
    }

    private fun openAddDialog() {
        if(addGroceryDialog.isAdded) return
        addGroceryDialog.show(supportFragmentManager, "fragment_add_grocery")
    }
}