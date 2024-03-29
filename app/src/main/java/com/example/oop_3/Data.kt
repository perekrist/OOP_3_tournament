package com.example.oop_3

import com.example.oop_3.ui.players.Player
import com.example.oop_3.ui.teams.Team
import com.example.oop_3.ui.tournament.Tournament

var players: ArrayList<Player> = arrayListOf(
    Player(0, "John"),
    Player(1, "Noah"),
    Player(2, "Dan"),
    Player(3, "Ray"),
    Player(4, "Ken"),
    Player(5, "Egor"),
    Player(6, "Ilya"),
    Player(7, "Mark"),
    Player(8, "Vadim"),
    Player(9, "Alex")
)

var teams: ArrayList<Team> = arrayListOf(
    Team(0),
    Team(1),
    Team(2),
    Team(3)
)

var tournaments: ArrayList<Tournament> = arrayListOf(
    Tournament(0)
)

var types: ArrayList<String> = arrayListOf("goal", "yellow", "red")

