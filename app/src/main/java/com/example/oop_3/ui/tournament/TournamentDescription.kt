package com.example.oop_3.ui.tournament

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop_3.R
import com.example.oop_3.ui.teams.Team
import com.example.oop_3.teams
import com.example.oop_3.ui.match.MatchEditing
import kotlinx.android.synthetic.main.activity_tournament_description.*

class TournamentDescription : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tournament_description)
        val tournamentId: String = intent.getStringExtra("match_id")!!
        val t: ArrayList<Pair<Team, Team>> = arrayListOf()
        for (i in teams.indices) {
            if (i % 2 == 0) {
                if (teams.size > i + 1) {
                    t.add(Pair(teams[i], teams[i + 1]))
                } else {
                    t.add(Pair(teams[i], teams[i]))
                }
            }
        }
        val myAdapter = MatchesAdapter(t, object : MatchesAdapter.Callback {
            override fun onItemClicked(item: Pair<Team, Team>) {
                val intent = Intent(this@TournamentDescription, MatchEditing::class.java).apply {
//                    putExtra("match_id", )
                }
                startActivity(intent)
            }
        })
        rv_matches.adapter = myAdapter
        rv_matches.layoutManager = LinearLayoutManager(this)

    }
}
