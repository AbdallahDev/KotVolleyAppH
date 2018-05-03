package com.example.abdallahsarayrah.kotvolleyapph

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_json_object.*

class JSonObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_object)

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("يرجى الانتظار...")
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)

        button2.setOnClickListener {
            progressDialog.show()

            val requestQueue = Volley.newRequestQueue(this)
            val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, "http://192.168.0.29/companyH/emp_get.php?id=1002", null, Response.Listener { response ->
                progressDialog.hide()
                textView2.text = response.getString("name")
                textView3.text = response.getString("salary")
            }, Response.ErrorListener { error ->
                progressDialog.hide()
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            })
            requestQueue.add(jsonObjectRequest)
        }
    }
}
