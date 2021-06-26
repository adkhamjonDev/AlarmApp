package com.example.alarmapp.fragments
import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alarmapp.databinding.FragmentPickerBinding


class PickerFragment : Fragment() {
    lateinit var binding: FragmentPickerBinding
    private var number=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentPickerBinding.inflate(inflater, container, false)



        binding.cardView2.setOnClickListener {
            number=0
            binding.count.text="0"
        }
        binding.press.setOnClickListener {
            if(number==33){
                val v = activity?.getSystemService(Context.VIBRATOR_SERVICE)as Vibrator
                v.vibrate(400)
                number=0
                binding.count.text=number.toString()
            }
            val v = activity?.getSystemService(Context.VIBRATOR_SERVICE)as Vibrator
            v.vibrate(100)
            number++
            binding.count.text=number.toString()
        }
        return binding.root
    }
}