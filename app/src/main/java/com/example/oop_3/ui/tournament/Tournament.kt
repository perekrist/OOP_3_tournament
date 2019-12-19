package com.example.oop_3.ui.tournament

import com.example.oop_3.ui.match.Event
import com.example.oop_3.ui.players.Player
import com.example.oop_3.ui.teams.Team

class Tournament (var id: Int) {
    var teamsT: ArrayList<Team> = arrayListOf()
    var matches: ArrayList<Match> = arrayListOf()
    var tournamentWinner: Team? = null
}

class Match(var match: Pair<Team?, Team?>) {
    var id: Int? = null
    var events: ArrayList<Event> = arrayListOf()
    var matchWinner: Team? = null
    var isFinished = false
    var matchPlayers: ArrayList<Player> = arrayListOf()
    var score1 = 0
    var score2 = 0

    init {
        if (match.first != null) {
            for (i in match.first?.teamPlayers!!) {
                matchPlayers.add(i)
            }
        }
        if (match.second != null) {
            for (i in match.second?.teamPlayers!!) {
                matchPlayers.add(i)
            }
        }
    }
}
