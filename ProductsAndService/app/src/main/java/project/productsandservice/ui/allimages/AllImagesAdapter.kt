package project.productsandservice.ui.allimages

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import project.productsandservice.databinding.ItemImageBinding
import project.productsandservice.domain.models.ImageModel

class AllImagesAdapter: RecyclerView.Adapter<AllImagesAdapter.ViewHolder>() {
    private val array = ArrayList<ImageModel>()

    class ViewHolder(
        private val item: ItemImageBinding
    ): RecyclerView.ViewHolder(item.root) {
        fun bind(uri: ImageModel) {
            Glide.with(itemView.context).load(uri.uri).into(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemImageBinding.inflate(
            LayoutInflater.from(parent.context)
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(array[position])
    }

    override fun getItemCount(): Int = array.size

    @SuppressLint("NotifyDataSetChanged")
    fun addImage(uri: ImageModel) {
        array.apply {
            remove(uri)
            add(uri)
        }
        notifyDataSetChanged()
    }
}