package com.akexorcist.snaptimepicker

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.snaptimepicker.databinding.LayoutSnapTimePickerNumberItemBinding


class TimeNumberViewHolder(
    private val _binding: LayoutSnapTimePickerNumberItemBinding,
) : RecyclerView.ViewHolder(_binding.root) {
    val binding: LayoutSnapTimePickerNumberItemBinding = _binding

    fun setNumber(number: String?) {
        _binding.textViewNumber.text = number ?: "-"
    }
}
