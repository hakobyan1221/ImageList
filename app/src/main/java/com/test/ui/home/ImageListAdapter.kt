package com.test.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.imagelistapp.R
import com.test.imagelistapp.databinding.ItemImageBinding
import com.test.imagelistapp.domain.ImageViewData

class ImageListAdapter(private val imageItemClickListener: (imageItem: ImageViewData) -> Unit) :
    PagingDataAdapter<ImageViewData, ImageListAdapter.ViewHolder>(DiffUtilCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemImageBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_image,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {


        init {
            binding.root.setOnClickListener {
                val imageItem = getItem(absoluteAdapterPosition)
                imageItem?.let { imageItemClickListener(it) }
            }
        }

        fun bind(item: ImageViewData) {
            with(binding) {
                image = item
            }
        }
    }

    object DiffUtilCallBack : DiffUtil.ItemCallback<ImageViewData>() {
        override fun areItemsTheSame(oldItem: ImageViewData, newItem: ImageViewData): Boolean {
            return oldItem.previewURL == newItem.previewURL
        }

        override fun areContentsTheSame(oldItem: ImageViewData, newItem: ImageViewData): Boolean {
            return oldItem == newItem
        }
    }
}
