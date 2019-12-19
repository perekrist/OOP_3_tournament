package com.example.oop_3.ui.tournament

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oop_3.R
import com.example.oop_3.ui.teams.Team
import kotlinx.android.synthetic.main.match_item.view.*

class MatchesAdapter(var items: ArrayList<Pair<Team, Team>>, val callback: Callback) : RecyclerView.Adapter<MatchesAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.match_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Pair<Team, Team>) {
            itemView.match_id.text = "Event ${adapterPosition + 1}"
            itemView.match_team_first.text = item.first.name
            itemView.match_team_second.text = item.second.name
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }
    }

    interface Callback {
        fun onItemClicked(item: Pair<Team, Team>)
    }

}