package com.example.oop_3

class Player (Number: Int, Name: String) {
    var num: Int? = null
    var name: String? = null
    var countOfGoals = 0
    var countOfGames = 0
    var teamId: Int? = null

    init {
        num = Number
        name = Name
    }

    fun setTeam(id: Int) {
        teamId = id
    }
}
