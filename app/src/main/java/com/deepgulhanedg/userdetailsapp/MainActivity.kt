package com.deepgulhanedg.userdetailsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL ="https://reqres.in/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<Data>?> {
            override fun onResponse(call: Call<List<Data>?>, response: Response<List<Data>?>) {
                val responceBody = response.body()!!

                val myStringBuilder = StringBuilder()
                for(myData in responceBody) {
                    myStringBuilder.append(myData.id)
                    myStringBuilder.append("\n")

                }

                val txtId = findViewById<TextView>(R.id.txtId) as TextView

                txtId.setText(myStringBuilder)

            }

            override fun onFailure(call: Call<List<Data>?>, t: Throwable) {

                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}