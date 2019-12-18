package com.example.oop_3

class Team (var id: Int) {
    var players: ArrayList<Player> = arrayListOf()

    public fun addPlayer(player: Player) {
        players.add(player)
    }
}