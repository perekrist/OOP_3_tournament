package com.example.oop_3.ui.tournament

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop_3.R
import com.example.oop_3.ui.teams.Team
import com.example.oop_3.teams
import com.example.oop_3.tournaments
import com.example.oop_3.ui.match.MatchEditing
import kotlinx.android.synthetic.main.activity_tournament_description.*

class TournamentDescription : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tournament_description)
        val tournamentId: String = intent.getStringExtra("match_id")!!
        val id = tournamentId.toInt()
        val tournament = tournaments[id]
        if (tournament.teamsT.isEmpty()) {
            for (i in teams) {
                val r = (0..1).random()
                if (r == 1) {
                    tournament.teamsT.add(i)
                }
            }
        }
        var matchId = 0
        tournament.matches.clear()
        for (i in tournament.teamsT.indices) {
            if (i % 2 == 0) {
                if (tournament.teamsT.size > i + 1) {
                    tournament.matches.add(Match(Pair(tournament.teamsT[i], tournament.teamsT[i + 1])))
                } else
                    tournament.matches.add(Match(Pair(tournament.teamsT[i], tournament.teamsT[i])))
                tournament.matches[matchId].id = matchId
                matchId += 1
            }
        }
        val myAdapter = MatchesAdapter(
            tournament.matches,
            object : MatchesAdapter.Callback {
                override fun onItemClicked(item: Match) {
                    val intent =
                        Intent(this@TournamentDescription, MatchEditing::class.java).apply {
                            putExtra("match_id", item.id.toString())
                            putExtra("tourn_id", id.toString())
                        }
                    startActivity(intent)
                }
            })
        rv_matches.adapter = myAdapter
        rv_matches.layoutManager = LinearLayoutManager(this)

    }
}
