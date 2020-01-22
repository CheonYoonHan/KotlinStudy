package com.example.network

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.*
import okhttp3.*
import java.io.IOException

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        Button_signup.setOnClickListener{
            var id = Edit_signup_id.text.toString()
            var pw = Edit_signup_pw.text.toString()

            //서버로 id, pw 전송
            Asyncsignup().execute(getString(R.string.signup_url),id, pw)

            //Toast.makeText(applicationContext,"${getString(R.string.url)}json", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    inner class Asyncsignup : AsyncTask<String?, Void, String?>() {
        var id : String?=null
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): String? {
            var client = OkHttpClient()
            var url = params[0]
            id = params[1]
            var pw = params[2]

            var response : String?

            try{
                var okhttpApiCall = OkhttpApiCall()
                response = okhttpApiCall.POST(client,url,okhttpApiCall.jsonbody(id, pw))
            } catch (e: IOException){
                return e.toString()
            }

            return response
        }

        override fun onPostExecute(result: String?) {
            if(result!!.get(0) != '{'){
                Toast.makeText(applicationContext, "Signup Success",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext, "Signup fail",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
