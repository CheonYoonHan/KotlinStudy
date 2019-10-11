package com.example.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class SecondFragment : Fragment() {
    var Button2: Button? = null
    var text1: TextView? = null
    var text2: TextView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_second, container, false)
        Button2 = view.findViewById<Button>(R.id.Second_Button)
        text1 = view.findViewById<TextView>(R.id.textView)
        text2 = view.findViewById<TextView>(R.id.textView2)
        var main_activity = activity as MainActivity

        text1?.text = main_activity.value1
        text2?.text = main_activity.value2

        Button2?.setOnClickListener {
            main_activity.supportFragmentManager.popBackStack()
        }
        return view
    }


}
