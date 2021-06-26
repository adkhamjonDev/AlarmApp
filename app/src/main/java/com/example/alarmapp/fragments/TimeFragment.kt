package com.example.alarmapp.fragments
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.alarmapp.databinding.FragmentTimeBinding
import java.text.SimpleDateFormat
import java.util.*
class TimeFragment : Fragment() {
    lateinit var binding: FragmentTimeBinding
    lateinit var calendar: Calendar
    lateinit var dateFormat: SimpleDateFormat
    lateinit var date:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentTimeBinding.inflate(inflater, container, false)
        calendar = Calendar.getInstance()
        setTime(binding.ucTime)
        binding.tong.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                alarm(19,11)
                Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Denied", Toast.LENGTH_SHORT).show()
            }
        }
        binding.asr.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                alarm(17,28)
            }
        }
        binding.quyosh.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                alarm(4,59)
                Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Denied", Toast.LENGTH_SHORT).show()
            }
        }
        binding.shom.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                alarm(19,44)
                Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Denied", Toast.LENGTH_SHORT).show()
            }
        }
        binding.peshin.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                alarm(12,21)
                Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Denied", Toast.LENGTH_SHORT).show()
            }
        }
        binding.xufton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                alarm(21,16)
                Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Denied", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
    fun setTime(textView: TextView){
        dateFormat = SimpleDateFormat("HH:mm")
        date = dateFormat.format(calendar.time)
        textView.text = date
    }
    fun alarm(hour:Int,minute:Int){
        val alarmManager=activity?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val date =Date()
        val calAlarm=Calendar.getInstance()
        val calNow=Calendar.getInstance()
        calNow.time=date
        calAlarm.time=date

        calAlarm.set(Calendar.HOUR_OF_DAY,hour)
        calAlarm.set(Calendar.MINUTE,minute)
        calAlarm.set(Calendar.SECOND,0)
        if(calAlarm.before(calNow)){
            calAlarm.add(Calendar.DATE,1)
        }
        val i=Intent(requireContext(),MyBroadCastReceiver::class.java)
        val pendingIntent=PendingIntent.getBroadcast(context,2444,i,0)
        alarmManager.set(AlarmManager.RTC_WAKEUP,calAlarm.timeInMillis,pendingIntent)
    }
}