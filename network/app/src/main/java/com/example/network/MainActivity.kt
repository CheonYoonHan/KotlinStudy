package com.example.network

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_login.setOnClickListener {
            var id = edit_id.text.toString()
            var pw = edit_pw.text.toString()

            asynctask().execute("http://15.165.54.1:8080/lookie/login",id, pw)
        }
        button_signup.setOnClickListener {
            var intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    inner class asynctask : AsyncTask<String, Void, String>() {
        var id: String? = null

        override fun doInBackground(vararg params: String?): String? {
            val client = OkHttpClient()

            val url = params[0]
            id = params[1]
            val pw = params[2]

            var response: String?


            try{
                var okhttp = OkhttpApiCall()
                response = okhttp.POST(client, url, okhttp.jsonbody(id, pw))
            }catch (e:IOException){
                return e.toString()
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            if(result== "success"){
                Toast.makeText(applicationContext, "로그인 완료",Toast.LENGTH_SHORT).show()
                var intent = Intent(applicationContext, BaseActivity::class.java)
                    intent.putExtra("id", id)
                startActivity(intent)
                finish()
                Log.d("HI", result)
            }
            else {
                if (result == "fail") {
                    Toast.makeText(applicationContext, "아이디와 비밀번호 확인해주세요.", Toast.LENGTH_LONG).show()
                } else
                    Toast.makeText(applicationContext, "아이디가 존재하지 않습니다", Toast.LENGTH_LONG).show()
            }
        }
    }
}