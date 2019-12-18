package com.example.oop_3.classes

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