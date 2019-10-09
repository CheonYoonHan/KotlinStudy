package com.example.a201611113.map

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var map1 = mapOf<Key 의 자료형 선언 , Value의 자료형 선언 >(Pair(Key1, Value1), Pair(Key2, Value2), ...)
        var map1 = mapOf<Int, String>(Pair(1, "Cheon"), Pair(2, "Park"), Pair(3, "Lee")) // <>에 자료형을 선언하지 않아도 사용할 수 있다.
        map1.get(1)//="cheon"

        //val map2 = mutableMapOf<Key 의 자료형 선언 , Value의 자료형 선언>(Key1 to value1, Key2 t0 Value2, ...)
        val map2 = mutableMapOf<Int, String>(201611113 to "윤한", 201711113 to "명상")
        map2.put(201511113, "상명")//값을 추가

    }
}
