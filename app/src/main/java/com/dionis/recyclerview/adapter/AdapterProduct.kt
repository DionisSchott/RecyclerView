package com.dionis.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dionis.recyclerview.R
import com.dionis.recyclerview.databinding.FragmentProductsBinding
import com.dionis.recyclerview.product

class AdapterProduct(private val context: Context, private val product: MutableList<product>) : RecyclerView.Adapter<AdapterProduct.ProductViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun  onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        return ProductViewHolder(FragmentProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false), mListener)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.image.setImageResource(product[position].image)
//        holder.name.text = product[position].name
//        holder.description.text = product[position].details
//        holder.price.text = product[position].price
    }

    override fun getItemCount(): Int = product.size

    inner class ProductViewHolder(private val binding: FragmentProductsBinding, listener: onItemClickListener) : RecyclerView.ViewHolder(binding.root) {

        val image = binding.productImage
//        val name = binding.productName
//        val description = binding.productDescription
//        val price = binding.productPrice

        init {


            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }
}
