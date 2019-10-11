package com.example.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class FirstFragment : Fragment() {
    var Button: Button? = null
    var edit1: EditText? = null
    var edit2: EditText? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_first, container, false)
        Button = view.findViewById<Button>(R.id.First_Button)
        edit1 = view.findViewById<EditText>(R.id.editText)
        edit2 = view.findViewById<EditText>(R.id.editText2)
        Button?.setOnClickListener {
            var main_activity = activity as MainActivity
            main_activity.value1 = edit1?.text.toString()
            main_activity.value2 = edit2?.text.toString()
            main_activity.setFragment("second")
        }
        return view
    }
}
