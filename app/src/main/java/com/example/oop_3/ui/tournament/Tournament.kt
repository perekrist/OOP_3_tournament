package com.example.oop_3.ui.tournament

import com.example.oop_3.ui.match.Event
import com.example.oop_3.ui.teams.Team

class Tournament (var id: Int) {
    var teamsT: ArrayList<Team>? = null
    var matches: ArrayList<Event> = arrayListOf()
}
