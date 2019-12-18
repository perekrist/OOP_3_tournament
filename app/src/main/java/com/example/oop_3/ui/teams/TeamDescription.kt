package com.example.oop_3.ui.teams

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop_3.*
import com.example.oop_3.classes.Player
import com.example.oop_3.ui.players.PlayerDescription
import com.example.oop_3.ui.players.PlayersAdapter
import kotlinx.android.synthetic.main.activity_team_description.*

class TeamDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_description)
        val teamId: String = intent.getStringExtra("team_id")!!
        val id = teamId.toInt()
        val team = teams[id]
        team_name_d.text = team.name
        team_wins_d.text = "Wins: ${team.countOfWins}"
        team_players_d.text = "Players: ${team.teamPlayers.size} / 5"

        val myAdapter = PlayersAdapter(team.teamPlayers, object : PlayersAdapter.Callback {
            override fun onItemClicked(item: Player) {
                val intent = Intent(this@TeamDescription, PlayerDescription::class.java).apply {
                    putExtra("player_id", item.num.toString())
                }
                startActivity(intent)
            }

        })
        rv_team_players.adapter = myAdapter
        rv_team_players.layoutManager = LinearLayoutManager(this)
    }
}
