package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var first = FirstFragment()//첫번째 프레그먼트 객체 선언
    var second = SecondFragment()//두전째 프레그먼트 객체 선언

    var value1: String? = null
    var value2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment("first")

/*        button6.setOnClickListener {
            var tran = supportFragmentManager.beginTransaction()//FragmentManager를 이용하여 객체 선언.
            //tran.add(R.id.container, first)//container에 FristFragment를 add
            tran.replace(R.id.container, first)//container에 FristFragment를 replace
            tran.addToBackStack(null)
            tran.commit()//Fragment를 commit
        }
        button7.setOnClickListener {
            var tran = supportFragmentManager.beginTransaction()
            //tran.add(R.id.container, second)
            tran.replace(R.id.container, second)
            tran.addToBackStack(null)
            tran.commit()
        }*/
    }

    fun setFragment(name: String){
        var tran =supportFragmentManager.beginTransaction()
        when(name){
            "first" -> {
                tran.replace(R.id.container, first)
            }
            "second" -> {
                tran.replace(R.id.container, second)
                tran.addToBackStack(null)
            }
        }
        tran.commit()
    }
}
