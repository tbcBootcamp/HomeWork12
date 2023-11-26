package com.example.homework12.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.homework12.data.ItemModel

class ProductsDiffUtil(
    private val oldList: List<ItemModel>,
    private val newList: List<ItemModel>
): DiffUtil.Callback(){

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}