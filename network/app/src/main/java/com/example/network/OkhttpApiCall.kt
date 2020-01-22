package com.example.network

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class OkhttpApiCall {

    fun GET(clinet : OkHttpClient, url : HttpUrl) : String? {
        var request = Request.Builder()
            .url(url).build()
        var response : Response = clinet.newCall(request).execute()
        return response.body()!!.string()
    }

    fun POST(clinet: OkHttpClient, url:String?, jsonbody : String?): String? {
        var response : Response

        try {
            var request = Request.Builder()
                .url(url)
                .post(RequestBody.create(MediaType.parse("application/json"), jsonbody))
                .build()
            response = clinet.newCall(request).execute()
            Log.d("Response", response.toString())

            return response.body()?.string()!!
        } catch (e : IOException){
            return e.toString()
        }
    }

    fun jsonbody(id: String?, pw: String?): String?{
        var jsonObject = JSONObject()
            jsonObject.put("id",id)
            jsonObject.put("passwd",pw)

        return jsonObject.toString()
    }
}