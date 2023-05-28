package project.productsandservice.ui.createAdvert

import project.productsandservice.databinding.ItemImageBinding
import androidx.recyclerview.widget.RecyclerView
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.net.Uri
import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import project.productsandservice.domain.models.ImageModel

class AdapterImages: ListAdapter<ImageModel, AdapterImages.ViewHolder>(DiffCallback()) {
    private val array = ArrayList<ImageModel>()

    class ViewHolder(
        val item: ItemImageBinding
    ): RecyclerView.ViewHolder(item.root) {

        fun bind(uri: ImageModel) {
            //item.image.setImageURI(uri.uri)
        }
    }

    private class DiffCallback: DiffUtil.ItemCallback<ImageModel>() {
        override fun areItemsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
            return oldItem.uri == newItem.uri
        }

        override fun areContentsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemImageBinding.inflate(
            LayoutInflater.from(
                parent.context
            )
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
        holder.item.deleteImageButton.setOnClickListener {

        }
        holder.item.image.setOnClickListener {

        }
    }

    //override fun getItemCount(): Int = array.size

    fun deleteImage(uri: ImageModel) {
        Log.d("DeleteImageRV", "Удаление картирнки из списка")
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addImage(uri: ImageModel) {
        //val callback = DiffUtil.Callback
        submitList(listOf(uri))
        notifyDataSetChanged()
        Log.d("AddImageRV", "Добавление картирнки в список")
    }

}
