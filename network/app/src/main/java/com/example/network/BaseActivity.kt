package com.example.network

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_base.*

class BaseActivity : AppCompatActivity() {
    var storylist = arrayListOf<Story>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        var id = intent.getStringExtra("id")
        text_id.text = id
    }
}