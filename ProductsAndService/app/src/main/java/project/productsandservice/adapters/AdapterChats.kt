package project.productsandservice.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import project.productsandservice.databinding.TemplateItemMessageUserBinding
import project.productsandservice.models.MessageUser

class AdapterChats: RecyclerView.Adapter<AdapterChats.HolderView>() {
    private val array = ArrayList<MessageUser>()

    class HolderView(
        private var binding: TemplateItemMessageUserBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(mu: MessageUser) {
            Glide.with(binding.root.context).load(mu.avatar).into(binding.avatar)
            binding.message.text = mu.message
            binding.datetime.text = mu.datetime
            binding.username.text = mu.username
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderView {
        return HolderView(
            TemplateItemMessageUserBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        )
    }

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: HolderView, position: Int) {
        holder.bind(array[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addMU(mu: MessageUser) {
        array.add(mu)
        notifyDataSetChanged()
    }
}
