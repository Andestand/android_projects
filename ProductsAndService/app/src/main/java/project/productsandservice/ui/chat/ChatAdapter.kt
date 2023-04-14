package project.productsandservice.ui.chat

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import project.productsandservice.databinding.ItemMessageBinding
import project.productsandservice.domain.models.Message

class ChatAdapter: RecyclerView.Adapter<ViewHolder>() {
    private val array = ArrayList<Message>()

    companion object {
        const val item_left = 0
        const val item_right = 1
    }

    class ViewHolderLeft(
        private var item: ItemMessageBinding
    ): ViewHolder(item.root) {
        @SuppressLint("RtlHardcoded")
        fun bind(message: Message) {
            item.message.text = message.message
            item.datetime.text = message.datetime
            message.type = item_left
            item.root.gravity = Gravity.LEFT
        }
    }
    
    class ViewHolderRight(
        private var item: ItemMessageBinding
    ): ViewHolder(item.root) {
        @SuppressLint("RtlHardcoded")
        fun bind(message: Message) {
            item.message.text = message.message
            item.datetime.text = message.datetime
            message.type = item_right
            item.root.gravity = Gravity.RIGHT
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(array[position].type) {
            0 -> {
                item_left
            }
            1 -> {
                item_right
            }
            else -> {
                TODO()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        return when(viewType) {
            item_left -> {
                ViewHolderLeft(
                    ItemMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            item_right -> {
                ViewHolderRight(
                    ItemMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                TODO()
            }
        }
    }

    @SuppressLint("RtlHardcoded")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder) {
            is ViewHolderLeft -> {
                holder.bind(array[position])
            }

            is ViewHolderRight -> {
                holder.bind(array[position])
            }
        }
    }

    override fun getItemCount(): Int = array.size

    @SuppressLint("NotifyDataSetChanged")
    fun addMessage(message: Message) {
        array.remove(message)
        array.add(message)
        notifyDataSetChanged()
    }
}
