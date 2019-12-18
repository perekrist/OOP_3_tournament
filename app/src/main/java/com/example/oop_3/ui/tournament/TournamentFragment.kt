package com.example.oop_3.ui.tournament

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop_3.classes.Player
import com.example.oop_3.R
import com.example.oop_3.classes.Tournament
import com.example.oop_3.players
import com.example.oop_3.tournaments
import com.example.oop_3.ui.players.PlayerDescription
import com.example.oop_3.ui.players.PlayersAdapter
import kotlinx.android.synthetic.main.fragment_players.*
import kotlinx.android.synthetic.main.fragment_tournament.*

class TournamentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tournament, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myAdapter = TournametsAdapter(tournaments, object : TournametsAdapter.Callback {
            override fun onItemClicked(item: Tournament) {
//                val intent = Intent(context, PlayerDescription::class.java).apply {
//                    putExtra("player_id", item.id.toString())
//                }
//                startActivity(intent)
            }
        })
        rv_tournament.adapter = myAdapter
        rv_tournament.layoutManager = LinearLayoutManager(this.requireContext())
        add_tournament.setOnClickListener {
            tournaments.add(Tournament(tournaments.size))
            rv_tournament.adapter = myAdapter
        }

    }
}