package com.nstudio.krutringtoplayer.ui.main

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.nstudio.krutringtoplayer.R
import com.nstudio.krutringtoplayer.databinding.TemplateRingtonBinding
import com.nstudio.krutringtoplayer.domain.models.Rington
import java.util.Timer
import java.util.TimerTask

class RingtonAdapter: RecyclerView.Adapter<RingtonAdapter.ViewHolder>() {
    private val arrayList = ArrayList<Rington>()

    class ViewHolder(
        val item: TemplateRingtonBinding
    ): RecyclerView.ViewHolder(item.root) {

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(rington: Rington) {
            item.apply {
                currentPosition.text = rington.current.toString()
                duration.text = rington.duration.toString()
                title.text = rington.title

                seekbarAudio.apply {
                    max = rington.duration
                    min = 0
                    progress = rington.current
                }

                play.setOnClickListener {
                    if (!rington.mediaPlayer.isPlaying) {
                        rington.play()
                    } else {
                        rington.pause()
                    }
                }

                menu.setOnClickListener {
                    Thread {
                        while (rington.mediaPlayer.isPlaying) {
                            seekbarAudio.progress = rington.current
                            //currentPosition.text = rington.current.toString()
                            Thread.sleep(1000)
                        }
                    }.start()
                    /*val popupMenu = PopupMenu(itemView.context, it)
                    popupMenu.inflate(R.menu.menu_rington_item)
                    popupMenu.show()*/
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            item = TemplateRingtonBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun getItemCount(): Int = arrayList.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arrayList[position])

    }

    @SuppressLint("NotifyDataSetChanged")
    fun addRington(rington: Rington) {
        arrayList.remove(rington)
        arrayList.add(rington)
        notifyDataSetChanged()
    }
}

