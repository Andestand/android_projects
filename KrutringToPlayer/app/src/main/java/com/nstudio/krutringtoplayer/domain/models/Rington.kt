package com.nstudio.krutringtoplayer.domain.models

import android.content.Context
import android.media.MediaPlayer

data class Rington(
    val context: Context,
    val title: String,
    val raw: Int
) {
    val mediaPlayer = MediaPlayer.create(context, raw)!!

    val current = mediaPlayer.currentPosition / 1000
    val duration = mediaPlayer.duration / 1000

    fun play() {
        mediaPlayer.start()
    }

    fun pause() {
        mediaPlayer.pause()
    }

    fun stop() {
        mediaPlayer.stop()
    }
}
