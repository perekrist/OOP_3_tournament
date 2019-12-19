package com.example.oop_3.ui.tournament

import com.example.oop_3.ui.match.Event
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
}
