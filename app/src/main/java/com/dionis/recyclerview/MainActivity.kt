package com.dionis.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dionis.recyclerview.adapter.AdapterProduct
import com.dionis.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerProducts = binding.recyclerProducts
        recyclerProducts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerProducts.setHasFixedSize(true)

        val productList: MutableList<product> = mutableListOf()
        val adapterProduct = AdapterProduct(this, productList)
        recyclerProducts.adapter = adapterProduct
        adapterProduct.setOnItemClickListener(object : AdapterProduct.onItemClickListener{
            override fun onItemClick(position: Int) {

            }

        })

        val product1 = product(R.drawable.gabinete)
        productList.add(product1)

        val product2 = product(R.drawable.ssd)
        productList.add(product2)
    }

}