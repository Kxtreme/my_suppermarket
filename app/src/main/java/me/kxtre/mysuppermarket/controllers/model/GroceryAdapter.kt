package me.kxtre.mysuppermarket.controllers.model

import android.animation.LayoutTransition
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.kxtre.mysuppermarket.R
import me.kxtre.mysuppermarket.databinding.ListItemGroceryBinding

class GroceryAdapter(
private val context: Context,
private val objects: List<Grocery>
) : RecyclerView.Adapter<GroceryAdapter.ViewHolder>() {
    class ViewHolder constructor(val binding: ListItemGroceryBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemGroceryBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_grocery,
            parent, false
        )
        parent.layoutTransition?.enableTransitionType(LayoutTransition.CHANGING)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        val item = objects.getOrNull(position)?: return
        binding.title.text = item.name
        binding.department.text = item.department
        binding.price.text = context.getString(R.string.price, item.price)
        Glide.with(context)
            .load(item.imageUrl)
            .into(binding.image)
    }

    override fun getItemCount(): Int {
        return objects.size
    }
}