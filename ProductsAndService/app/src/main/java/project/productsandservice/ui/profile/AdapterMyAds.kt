package project.productsandservice.ui.profile

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Parcelable
import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import project.productsandservice.R
import project.productsandservice.data.arrays.UsersArray
import project.productsandservice.databinding.TemplateItemAdBinding
import project.productsandservice.domain.models.Advert
import project.productsandservice.ui.advert.AdvertActivity


class AdapterMyAds: RecyclerView.Adapter<AdapterMyAds.ViewHolder>() {
    private val array = ArrayList<Advert>()

    //lateinit var tracker: SelectionTracker<Ad>

    class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = TemplateItemAdBinding.bind(item)

        fun bind(ad: Advert) = with(binding) {
            titleAd.text = ad.title
            Glide.with(itemView.context).load(ad.media_file[0]).into(imageAd)
            PriceTextView.text = ad.price
            DataTimeTextView.text = ad.date_added
        }

        fun onActivated(isActivated: Boolean) {
            itemView.isActivated = isActivated
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = TemplateItemAdBinding.inflate(
            LayoutInflater.from(parent.context)
        )
        return ViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = Unit

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: List<Any>) {
        //holder.onActivated(tracker.isSelected(array[position]))
        //if (SelectionTracker.SELECTION_CHANGED_MARKER !in payloads) {
            holder.bind(array[position])
        //}

        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(
                Intent(
                    holder.itemView.context, AdvertActivity::class.java
                ).apply {
                putExtra("ad",
                    Advert(
                        title = array[position].title,
                        description = array[position].description,
                        price = array[position].price,
                        media_file = array[position].media_file,
                        date_added = array[position].date_added,
                        author_advert = array[position].author_advert
                    ) as Parcelable
                )
            }
            )
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun add(ad: Advert) {
        array.remove(ad)
        array.add(ad)
        notifyDataSetChanged()
    }
}
