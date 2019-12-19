package com.example.oop_3.ui.match

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop_3.R
import com.example.oop_3.players
import com.example.oop_3.tournaments
import com.example.oop_3.ui.players.Player
import com.example.oop_3.ui.players.PlayerDescription
import com.example.oop_3.ui.players.PlayersAdapter
import kotlinx.android.synthetic.main.activity_match_editing.*
import kotlinx.android.synthetic.main.activity_tournament_description.*
import kotlinx.android.synthetic.main.fragment_players.*

class MatchEditing : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_editing)
        val tournamentId: String = intent.getStringExtra("tourn_id")!!
        val matchId: String = intent.getStringExtra("match_id")!!
        val tId = tournamentId.toInt()
        val mId = matchId.toInt()
        var events = tournaments[tId].matches[mId].events
        val myAdapter = MatchAdapter(events, object : MatchAdapter.Callback {
            override fun onItemClicked(item: Event) {
//                val intent = Intent(this@MatchEditing, PlayerDescription::class.java).apply {
//                    putExtra("player_id", item.num.toString())
//                }
//                startActivity(intent)
            }
        })
        rv_current_match.adapter = myAdapter
        rv_current_match.layoutManager = LinearLayoutManager(this)
        add_event.setOnClickListener {
            events.add(Event())
            rv_current_match.adapter = myAdapter
        }
        rv_current_match.adapter = myAdapter
    }
}
