package com.example.oop_3.ui.teams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oop_3.Player
import com.example.oop_3.R
import com.example.oop_3.Team
import kotlinx.android.synthetic.main.player_item.view.*
import kotlinx.android.synthetic.main.team_item.view.*

class TeamsAdapter(var items: ArrayList<Team>, val callback: Callback) : RecyclerView.Adapter<TeamsAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.team_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Team) {
            itemView.team_name.text = "Team ${item.id}"
            itemView.team_wins.text = item.countOfWins.toString()
            itemView.team_players.text = "${item.countOfPlayers} / 5"
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }
    }

    interface Callback {
        fun onItemClicked(item: Team)
    }

}