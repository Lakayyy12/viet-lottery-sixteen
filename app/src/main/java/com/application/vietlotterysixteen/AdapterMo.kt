package com.application.vietlotterysixteen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterMo (
    val onItemClicked: OnContentClickListener
        ): RecyclerView.Adapter<AdapterMo.ViewHolder>(){

            private var titles = arrayOf("Niên kim", "Trò chơi hàng ngày", "Jackpot", "Keno",
            "Trò chơi trực tuyến", "Trò chơi thụ động", "Quyền lực chơi", "Punch Board",
            "Đặt cược thẳng", "Thiết bị đầu cuối")

    private var contents = arrayOf(R.string.glo1, R.string.glo2, R.string.glo3
        , R.string.glo4, R.string.glo5, R.string.glo6
        , R.string.glo7, R.string.glo8, R.string.glo9, R.string.glo10)

    private var images = intArrayOf(R.drawable.ic_casino, R.drawable.ic_casino, R.drawable.ic_casino
        , R.drawable.ic_casino, R.drawable.ic_casino, R.drawable.ic_casino, R.drawable.ic_casino
        , R.drawable.ic_casino, R.drawable.ic_casino, R.drawable.ic_casino)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout_guides, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: AdapterMo.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemImage.setImageResource(images[position])

        holder.itemView.setOnClickListener {
            onItemClicked.OnContentItemClicked(images[position], contents[position])
        }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.arrowR)
        var itemTitle: TextView = itemView.findViewById(R.id.header)
    }
}