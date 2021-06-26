package com.example.alarmapp.fragments

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Toast
import com.example.alarmapp.R
import com.example.alarmapp.databinding.FragmentCompasBinding
import kotlin.math.roundToInt


class CompasFragment : Fragment(),SensorEventListener {
    lateinit var binding:FragmentCompasBinding
    lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor
    private var currentDegree=0f
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentCompasBinding.inflate(inflater, container, false)
        sensorManager=activity?.getSystemService(Context.SENSOR_SERVICE)as SensorManager
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION)
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_FASTEST)



        return binding.root
    }
    override fun onStart() {
        super.onStart()
        if (sensor != null) {
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_FASTEST)
        }
        else{
            Toast.makeText(context, "Not supported", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
    override fun onSensorChanged(event: SensorEvent?) {
        var degree= event!!.values[0].roundToInt()
        val animation=RotateAnimation(currentDegree,
            -degree.toFloat(),Animation.RELATIVE_TO_SELF,0.5f,
            Animation.RELATIVE_TO_SELF,0.5f)
        animation.duration=500
        animation.fillAfter=true
        binding.compass.animation=animation
        currentDegree=-degree.toFloat()
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}