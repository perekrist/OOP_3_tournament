package com.example.oop_3.ui.teams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop_3.Player
import com.example.oop_3.R
import com.example.oop_3.players
import com.example.oop_3.teams
import com.example.oop_3.ui.players.PlayersAdapter
import kotlinx.android.synthetic.main.activity_team_description.*

class TeamDescription : AppCompatActivity() {
    var id = 1
    var team = teams[id]


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_description)
        val teamId: String = intent.getStringExtra("team_id")!!
        id = teamId.toInt()
        val teamPlayers = initPlayers()
        team_name_d.text = team.name
        team_wins_d.text = "Wins: ${team.countOfWins}"
        team_players_d.text = "Players: ${team.teamPlayers.size} / 5"

        val myAdapter = PlayersAdapter(teamPlayers, object : PlayersAdapter.Callback {
            override fun onItemClicked(item: Player) {
                Toast.makeText(this@TeamDescription, item.name, Toast.LENGTH_SHORT).show()
            }

        })
        rv_team_players.adapter = myAdapter
        rv_team_players.layoutManager = LinearLayoutManager(this)
        println()
    }

    private fun initPlayers(): ArrayList<Player> {
        team.teamPlayers.clear()
        for (i in players) {
            println(i.teamId)
            if (i.teamId == id) {
                team.addPlayer(i)
            }
        }
        return team.teamPlayers
    }
}
