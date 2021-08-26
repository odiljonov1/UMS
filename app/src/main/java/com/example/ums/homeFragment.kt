package com.example.ums

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.ums.R
import com.example.ums.Utils.MyData
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    lateinit var root: View

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        root = inflater.inflate(R.layout.fragment_home, container, false)

        val bundle = bundleOf("something" to "something")

        val navOption = NavOptions.Builder()

        navOption.setEnterAnim(R.anim.anim_enter)

        root.tariffs.setOnClickListener {
            MyData.number = "1"
            root.findNavController().navigate(R.id.listFragment, bundle, navOption.build())
        }

        root.minutes.setOnClickListener {
            MyData.number = "2"
            root.findNavController().navigate(R.id.listFragment, bundle, navOption.build())
        }

        root.internet.setOnClickListener {
            MyData.number = "3"
            root.findNavController().navigate(R.id.listFragment, bundle, navOption.build())
        }

        root.services.setOnClickListener {
            MyData.number = "4"
            root.findNavController().navigate(R.id.listFragment, bundle, navOption.build())
        }

        root.sms.setOnClickListener {
            MyData.number = "5"
            root.findNavController().navigate(R.id.listFragment, bundle, navOption.build())
        }

        root.news.setOnClickListener {
            root.findNavController().navigate(R.id.listFragment, bundle, navOption.build())
            MyData.number = "6"
        }

        return root
    }
}