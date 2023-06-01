package com.example.okesampah.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.okesampah.R
import com.example.okesampah.model.Pelanggan

class AdapterPelanggan(var data: ArrayList<Pelanggan>):RecyclerView.Adapter<AdapterPelanggan.Holder>() {
    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val tvNik = view.findViewById<TextView>(R.id.tv_nik)
        val tvStatus = view.findViewById<TextView>(R.id.tv_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view:View =  LayoutInflater.from(parent.context).inflate(R.layout.item_pelanggan, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvNama.text = data[position].nama
        holder.tvNik.text = data[position].nik
        holder.tvStatus.text = data[position].status
        if (data[position].status == "Belum Approve"){
            holder.tvStatus.setBackgroundColor(holder.tvStatus.getResources().getColor(R.color.red));
        }else if(data[position].status == "Sudah Approve"){
            holder.tvStatus.setBackgroundColor(holder.tvStatus.getResources().getColor(R.color.green));
        }else{
            holder.tvStatus.setBackgroundColor(holder.tvStatus.getResources().getColor(R.color.grey));
        }
    }
}