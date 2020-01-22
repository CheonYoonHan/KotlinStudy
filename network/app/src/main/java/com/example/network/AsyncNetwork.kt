package com.example.network

import android.content.Context
import android.os.AsyncTask

class AsyncNetwork(function : String, url : String, context: Context){

    inner class AsyncTast : AsyncTask<String, Void, String>(){
        override fun doInBackground(vararg params: String?): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}