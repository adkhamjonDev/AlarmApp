package com.example.alarmapp.fragments
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Vibrator
class MyBroadCastReceiver:BroadcastReceiver() {
    lateinit var mediaPlayer: MediaPlayer
    private var url="http://www.cooperfulleon.com/sites/cooperfulleon.com/files/sounder_tones/standard/cooper_fulleon_sounder_tone_26.wav"
    override fun onReceive(context: Context?, intent: Intent?) {
        val vibrator=context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(10000)
    }
}