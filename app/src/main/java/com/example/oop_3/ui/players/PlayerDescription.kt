package com.example.oop_3.ui.players

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.oop_3.R
import com.example.oop_3.players
import com.example.oop_3.teams
import kotlinx.android.synthetic.main.activity_player_description.*

class PlayerDescription : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_description)
        val playerId: String = intent.getStringExtra("player_id")!!
        val id = playerId.toInt()
        val player = players[id]
        player_name_d.text = player.name
        player_wins_d.text = "Wins: ${player.countOfGames}"
        player_goals_d.text = "Goals: ${player.countOfGoals}"
        player_number_d.text = "Number: ${player.num}"
        if (player.teamId == -1) {
            player_team_d.text = "Team: null"
        } else
            player_team_d.text = "Team: ${teams[player.teamId].name}"
    }
}
