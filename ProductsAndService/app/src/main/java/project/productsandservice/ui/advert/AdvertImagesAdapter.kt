package project.productsandservice.ui.advert

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import project.productsandservice.databinding.ItemImageBinding

class AdvertImagesAdapter: RecyclerView.Adapter<AdvertImagesAdapter.ViewHolder>() {
    private val array = ArrayList<String>()

    class ViewHolder(
        private val item: ItemImageBinding
    ): RecyclerView.ViewHolder(item.root) {

        fun bind(link: String) {
            Glide.with(itemView.context).load(link).into(item.image)
            item.deleteImageButton.visibility = View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(array[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addImage(link: String) {
        array.remove(link)
        array.add(link)
        notifyDataSetChanged()
    }
}
