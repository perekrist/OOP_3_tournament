package com.example.oop_3.ui.teams

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop_3.*
import kotlinx.android.synthetic.main.fragment_teams.*

class TeamsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_teams, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        update()
        val myAdapter = TeamsAdapter(teams, object : TeamsAdapter.Callback {
            override fun onItemClicked(item: Team) {
                val intent = Intent(context, TeamDescription::class.java).apply {
                    putExtra("team_id", item.id.toString())
                }
                startActivity(intent)
            }
        })
        rv_teams.adapter = myAdapter
        rv_teams.layoutManager = LinearLayoutManager(this.requireContext())
        rv_teams.adapter = myAdapter
        add_team.setOnClickListener {
            val builder = AlertDialog.Builder(context!!)
            val inflater = layoutInflater
            builder.setTitle("Input team NAME")
            val dialogLayout = inflater.inflate(R.layout.alert_edittext, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.editText)
            builder.setView(dialogLayout)
            builder.setPositiveButton("OK") { _, _ ->
                teams.add(Team(teams.size))
                if (editText.text.isEmpty()) {
                    teams[teams.size - 1].name = "Team ${teams[teams.size - 1].id}"
                } else
                    teams[teams.size - 1].name = editText.text.toString()
                rv_teams.adapter = myAdapter
//                update()
            }
            builder.show()
            rv_teams.adapter = myAdapter
//            update()
        }

        teams_refresh.setOnClickListener{
            rv_teams.adapter = myAdapter
        }
    }
//
//    fun update() {
//        val availableTeams = arrayListOf<Team>()
//        for (i in teams) {
//            if (i.countOfPlayers!! < i.maxPlayers) {
//                availableTeams.add(i)
//            }
//        }
//        for (i in players) {
//            if (i.teamId == -1) {
//                val r = (0 until availableTeams.size).random()
//                i.setTeam(availableTeams[r].id)
//            }
//        }
//        for (i in teams) {
//            if (i.countOfPlayers == i.maxPlayers) {
//                continue
//            } else {
//                i.teamPlayers.clear()
//                for (j in players) {
//                    if (j.teamId == i.id) {
//                        i.teamPlayers.add(j)
//                    }
//                }
//            }
//        }
//    }
}