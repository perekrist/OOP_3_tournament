package com.example.oop_3.ui.match

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oop_3.R
import kotlinx.android.synthetic.main.match_event_item.view.*

class MatchAdapter(var items: ArrayList<Event>, val callback: Callback) : RecyclerView.Adapter<MatchAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.match_event_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Event) {
            itemView.event_name.text = "${item.name} $adapterPosition"
            itemView.event_time.text = item.time.toString()
            itemView.event_player.text = item.player
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }
    }

    interface Callback {
        fun onItemClicked(item: Event)
    }

}