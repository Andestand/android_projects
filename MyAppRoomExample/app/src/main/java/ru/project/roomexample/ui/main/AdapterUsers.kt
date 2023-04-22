package ru.project.roomexample.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.project.roomexample.data.models.UserRoom
import ru.project.roomexample.databinding.ItemUserTemplateBinding

class AdapterUsers: RecyclerView.Adapter<AdapterUsers.ViewHolder>() {
    private val array = ArrayList<UserRoom>()

    class ViewHolder(
        var item: ItemUserTemplateBinding
    ): RecyclerView.ViewHolder(item.root) {
        fun bind(user: UserRoom) {
            item.username.text = user.username
            item.password.text = user.password
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemUserTemplateBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(array[position])
    }

    override fun getItemCount(): Int = array.size

    @SuppressLint("NotifyDataSetChanged")
    fun addUser(user: UserRoom) {
        array.remove(user)
        array.add(user)
        notifyDataSetChanged()
    }
}