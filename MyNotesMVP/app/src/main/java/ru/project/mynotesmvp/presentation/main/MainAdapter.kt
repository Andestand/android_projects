package ru.project.mynotesmvp.presentation.main

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.project.mynotesmvp.data.models.Note
import ru.project.mynotesmvp.databinding.ItemNoteBinding
import ru.project.mynotesmvp.presentation.page_viewing.NoteActivity

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private val array = ArrayList<Note>()

    class ViewHolder(
        var item: ItemNoteBinding
    ): RecyclerView.ViewHolder(item.root) {

        fun bind(note: Note) {
            item.title.text = note.title
            Glide.with(itemView.context).load(note.image_link).into(item.iv)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(array[position])

        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(
                Intent(
                    holder.itemView.context,
                    NoteActivity::class.java
                ).putExtra("note", array[position])
            )
        }
    }

    override fun getItemCount(): Int = array.size

    @SuppressLint("NotifyDataSetChanged")
    fun addNote(note: Note) {
        array.remove(note)
        array.add(note)
        notifyDataSetChanged()
    }
}