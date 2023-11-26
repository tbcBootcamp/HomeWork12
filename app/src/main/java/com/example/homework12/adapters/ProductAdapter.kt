package com.example.homework12.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework12.data.ItemModel
import com.example.homework12.databinding.RvImagesItemBinding

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ImageViewHolder>() {

    private var listOfImages: List<ItemModel> = emptyList()
    var onItemClick: (ItemModel) -> Unit = {}

    inner class ImageViewHolder(private var binding: RvImagesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ItemModel) {
            binding.apply {
                tvName.text = model.name
                tvPrice.text = model.price
                tvRate.text = model.rate.toString()
                ivPhoto.setImageResource(model.image)
                ivPhoto.setOnClickListener {
                    onItemClick(model)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            RvImagesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listOfImages.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(listOfImages[position])
    }

    fun submitList(newList: List<ItemModel>) {
        val diffResult = DiffUtil.calculateDiff(ProductsDiffUtil(listOfImages, newList))
        this.listOfImages = newList
        diffResult.dispatchUpdatesTo(this)
    }
}