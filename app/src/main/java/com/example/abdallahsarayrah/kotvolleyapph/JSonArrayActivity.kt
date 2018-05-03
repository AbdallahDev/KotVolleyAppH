package com.example.abdallahsarayrah.kotvolleyapph

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_json_array.*

class JSonArrayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_array)

        val arrayList = ArrayList<String>()

        val requestQueue = Volley.newRequestQueue(this)
        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, "http://192.168.0.29/companyH/all_emp.php", null, Response.Listener { response ->
            (0 until response.length()).mapTo(arrayList) { response.getJSONObject(it).getString("name") }
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
            listView.adapter = adapter
        }, Response.ErrorListener { error -> })
        requestQueue.add(jsonArrayRequest)
    }
}
