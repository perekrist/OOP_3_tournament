package com.example.oop_3

class Player (Number: Int, Name: String) {
    var num: Int? = null
    var name: String? = null
    var countOfGoals = 0
    var countOfGames = 0

    init {
        num = Number
        name = Name
    }
}
