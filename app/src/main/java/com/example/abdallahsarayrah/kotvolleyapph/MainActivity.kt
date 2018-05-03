package com.example.abdallahsarayrah.kotvolleyapph

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("يرجى الانتظار...")
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)

        button.setOnClickListener {
            progressDialog.show()

            val requestQueue = Volley.newRequestQueue(this)
            val stringRequest = StringRequest(Request.Method.GET, "http://192.168.0.29/kotvolleyapph/", Response.Listener { response ->
                progressDialog.hide()
                textView.text = response
            }, Response.ErrorListener { error ->
                progressDialog.hide()
                textView.text = error.message
            })
            requestQueue.add(stringRequest)
        }
    }
}
