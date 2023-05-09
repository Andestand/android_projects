package ru.project.roomexample.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import ru.project.roomexample.R
import ru.project.roomexample.data.models.UserRoom
import ru.project.roomexample.data.room.MyRoomManager
import ru.project.roomexample.databinding.ItemUserTemplateBinding
import ru.project.roomexample.ui.registerUser.AddUserBottomSheetFragment


class AdapterUsers: ListAdapter<UserRoom, AdapterUsers.ViewHolder>(DiffCallback()) {

    class ViewHolder(
        private val item: ItemUserTemplateBinding
    ): RecyclerView.ViewHolder(item.root) {

        fun bind(user: UserRoom) {
            itemView.setOnLongClickListener {
                popupMenu(user)
                true
            }

            item.username.text = user.username
            item.password.text = user.password
        }

        private fun popupMenu(
            user: UserRoom
        ) {
            val db = Room.databaseBuilder(
                itemView.context,
                MyRoomManager::class.java,
                "database"
            ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

            val popup = PopupMenu(itemView.context, item.root)

            popup.inflate(R.menu.menu_item_user)

            popup.setOnMenuItemClickListener {
                when(it.itemId) {
                    R.id.delete -> {
                        db.userDAO().delete(user)
                        Toast.makeText(itemView.context, "Удаленно, обновите список свайпом вниз",
                            Toast.LENGTH_SHORT).show()
                    }
                    /*R.id.change -> {
                        Intent(itemView.context, MainActivity::class.java).apply {
                            //putExtra("userData", user)
                            putExtra("isRequest", 50)
                        }

                    }*/
                }
                true
            }
            popup.show()
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<UserRoom>() {
        override fun areItemsTheSame(oldItem: UserRoom, newItem: UserRoom): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserRoom, newItem: UserRoom): Boolean {
            return oldItem == newItem
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
        holder.bind(currentList[position])
    }
}
