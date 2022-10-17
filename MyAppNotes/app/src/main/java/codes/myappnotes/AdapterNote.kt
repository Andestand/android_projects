package codes.myappnotes

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import codes.myappnotes.databinding.TemplateItemNoteBinding

class AdapterNote: RecyclerView.Adapter<AdapterNote.HolderView>() {
    var array = ArrayList<Note>()

    class HolderView(item: View): RecyclerView.ViewHolder(item) {
        private val binding = TemplateItemNoteBinding.bind(item)

        fun bind(note: Note) = with(binding) {
            headerNote.text = note.header
            textNote.text = note.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderView {
        /** Данный метод создаёт экземпляр класса HolderView **/
        val view = LayoutInflater.from(parent.context).inflate(R.layout.template_item_note, parent, false)
        return HolderView(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: HolderView, position: Int){
        /** Данный метод заполняет экземпляр класса HolderView данными **/
        holder.bind(array[position])

        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(
                Intent(holder.itemView.context, PageNotesActivity::class.java).apply {
                    putExtra("Note", array[position])
                }
            )
        }
    }

    override fun getItemCount(): Int {
        /** Общее количество данных которое нужно вывести в RecyclerView **/
        return array.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addNote(note: Note) {
        /** Данный метод добавляет данные в массив и обновляет RecyclerView **/
        array.remove(note)
        array.add(note)
        notifyDataSetChanged()
    }
}
