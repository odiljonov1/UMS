package com.example.ums

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ums.R
import com.example.ums.Utils.MyData
import kotlinx.android.synthetic.main.fragment_info.view.*

class MinutesShowFragment : Fragment() {

    lateinit var root:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        root = inflater.inflate(R.layout.fragment_info, container, false)

        if (MyData.number == "2") {
            val minutes = arguments?.getString("minutesMinutes")
            val code = arguments?.getString("minutesCode")
            val desc = arguments?.getString("minutesDesc")

            root.minutes_minutes_show.text = minutes.toString()
            root.minutes_code_show.text = code.toString()
            root.minutes_desc_show.text = desc.toString()
        }else if (MyData.number == "1"){

            val name = arguments?.getString("keyName")
            val desc = arguments?.getString("keyDesc")
            val code = arguments?.getString("keyCode")

            root.minutes_minutes_show.text = name.toString()
            root.minutes_code_show.text = code.toString()
            root.minutes_desc_show.text = desc.toString()

        }
        return root
    }
}