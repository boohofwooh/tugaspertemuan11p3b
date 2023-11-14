package com.example.pertemuan11p3b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.pertemuan11p3b.databinding.ActivityMainBinding
import com.example.pertemuan11p3b.model.Data
import com.example.pertemuan11p3b.model.Users
import com.example.pertemuan11p3b.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getAllUser()
        response.enqueue(object : Callback<Users>{
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                val pokemonNameList = ArrayList<String>()
                for (i in response.body()?.data ?: arrayListOf()){
                    val pokemonName = Data(i.name, i.hp)
                    pokemonNameList.add("""
                       Name : ${pokemonName.name}
                       HP : ${pokemonName.hp}
                    """.trimIndent()
                    )
                }
                val listAdapter = ArrayAdapter(this@MainActivity,
                    android.R.layout.simple_list_item_1,pokemonNameList)
                binding.lsView.adapter = listAdapter
            }


            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}