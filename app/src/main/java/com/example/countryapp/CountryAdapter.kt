package com.example.countryapp


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.countryapp.databinding.CountryItemBinding

class CountryAdapter(countryModal: List<CountryModal>?, clickItem: CountryClick) :
    Adapter<CountryAdapter.CountryHolder>() {

    lateinit var context: Context
    var clickitem = clickItem
    var countrylist = countryModal

    class CountryHolder(itemView: CountryItemBinding) : ViewHolder(itemView.root) {

        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        context = parent.context

        var binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryHolder(binding)
    }

    override fun getItemCount(): Int {
        return countrylist?.size!!
    }
    override fun onBindViewHolder(holder: CountryHolder, position: Int) {

        holder.binding.apply {

            countrylist?.get(position)?.apply {

                namecou.text = name.toString()
                descou.text = capital.toString()
                Glide.with(context).load(countrylist!!.get(position).flags?.png).into(ind)

                holder.itemView.setOnClickListener {
                    clickitem.onTap(position)
                }
            }
        }
    }
}