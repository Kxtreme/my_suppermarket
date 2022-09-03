package me.kxtre.mysuppermarket.view

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import me.kxtre.mysuppermarket.R
import me.kxtre.mysuppermarket.databinding.FragmentGroceriesAddDialogBinding

class GroceriesAddDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentGroceriesAddDialogBinding


    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window?.setLayout(width, height)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGroceriesAddDialogBinding.inflate(layoutInflater, container, false)
        registerListeners()
        return binding.root
    }

    private fun registerListeners() {
        binding.topAppBar.setNavigationOnClickListener {
            dialog?.dismiss()
        }
    }
}