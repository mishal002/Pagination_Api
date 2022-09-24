package com.example.demoapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapi.API.DataAdapter
import com.example.demoapi.API.DataApiModelItem
import com.example.demoapi.API.DataClient
import com.example.demoapi.API.DateInterface
import com.example.demoapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//https://jsonplaceholder.typicode.com/comments?postId=2
class MainActivity : AppCompatActivity() {

    var list= arrayListOf <DataApiModelItem>()
    private var adapter: DataAdapter? = null
    lateinit var binding: ActivityMainBinding
    var i = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.rvview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = binding.rvview.layoutManager as LinearLayoutManager
                val pos = layoutManager.findLastVisibleItemPosition()
                val num: Int = binding.rvview.adapter!!.itemCount

                if (pos == num - 1) {
                    i++
                    GetApi("$i")
                }
            }
        })
        GetApi("$i")
        Adapter(list)
    }

    fun GetApi(s: String) {
        var apiinterface = DataClient.getRetrofit().create(DateInterface::class.java)
        apiinterface.getData(s).enqueue(object : Callback<List<DataApiModelItem>> {
            override fun onResponse(
                call: Call<List<DataApiModelItem>>, response: Response<List<DataApiModelItem>>,
            ) {
                list.addAll(response.body()as ArrayList<DataApiModelItem>)
                Log.e("TAG", "OnSuccess: ${list}")
                adapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataApiModelItem>>, t: Throwable) {
                Log.e("TAG", "onFailure:*************** ${t.message}")
            }
        })
    }

    fun Adapter(list: List<DataApiModelItem>?) {
        adapter = DataAdapter(this, list)
        var lm = LinearLayoutManager(this)
        binding.rvview.adapter = adapter
        binding.rvview.layoutManager = lm
    }
}

