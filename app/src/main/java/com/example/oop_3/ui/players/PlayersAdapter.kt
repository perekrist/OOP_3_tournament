package com.example.oop_3.ui.players

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.oop_3.Player
import com.example.oop_3.R
import kotlinx.android.synthetic.main.player_item.view.*

class PlayersAdapter(var items: ArrayList<Player>, val callback: Callback) : RecyclerView.Adapter<PlayersAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.player_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Player) {
            itemView.player_name.text = item.name
            itemView.player_number.text = item.num.toString()
            itemView.player_goals.text = item.countOfGames.toString()
            itemView.player_games.text = item.countOfGoals.toString()
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }
    }

    interface Callback {
        fun onItemClicked(item: Player)
    }

}