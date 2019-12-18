package com.example.oop_3

class Team(var id: Int) {
    var name = ""
    var teamPlayers: ArrayList<Player> = arrayListOf()

    var countOfPlayers: Int? = null
    var countOfWins : Int? = null

    init {
        name = "Team $id"
        countOfPlayers = players.size
        countOfWins = 0
    }

    fun addPlayer(player: Player) {
        teamPlayers.add(player)
    }
}