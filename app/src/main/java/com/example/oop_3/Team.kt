package com.example.oop_3

class Team (var name: String) {
    var players: ArrayList<Player> = arrayListOf()

    var countOfPlayers = players.size
    var countOfWins = 0

    public fun addPlayer(player: Player) {
        players.add(player)
    }
}