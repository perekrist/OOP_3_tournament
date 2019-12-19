package com.example.oop_3.ui.teams

import com.example.oop_3.ui.players.Player

class Team(var id: Int) {
    var name = ""
    var teamPlayers: ArrayList<Player> = arrayListOf()

    var countOfPlayers: Int? = null
    var countOfWins : Int? = null

     val maxPlayers = 5

    init {
        name = "Team $id"
        countOfPlayers = teamPlayers.size
        countOfWins = 0
    }
}