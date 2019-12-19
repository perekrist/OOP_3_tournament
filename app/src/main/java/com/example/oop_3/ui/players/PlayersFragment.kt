package com.example.oop_3.ui.players

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
import com.example.oop_3.ui.teams.Team
import kotlinx.android.synthetic.main.fragment_players.*

class PlayersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_players, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        update()
        val myAdapter = PlayersAdapter(players, object : PlayersAdapter.Callback {
            override fun onItemClicked(item: Player) {
                val intent = Intent(context, PlayerDescription::class.java).apply {
                    putExtra("player_id", item.num.toString())
                }
                startActivity(intent)
            }
        })
        rv_players.adapter = myAdapter
        rv_players.layoutManager = LinearLayoutManager(this.requireContext())
        add_player.setOnClickListener {
            val builder = AlertDialog.Builder(context!!)
            val inflater = layoutInflater
            builder.setTitle("Input player NAME")
            val dialogLayout = inflater.inflate(R.layout.alert_edittext, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.editText)
            builder.setView(dialogLayout)
            builder.setPositiveButton("OK") { _, _ ->
                if (editText.text.isEmpty()) {
                    players.add(
                        Player(
                            players.size,
                            "Player ${players.size + 1}"
                        )
                    )
                } else
                    players.add(
                        Player(
                            players.size,
                            editText.text.toString()
                        )
                    )
                rv_players.adapter = myAdapter
//                update()
            }
            builder.show()
            rv_players.adapter = myAdapter
//            update()
        }
    }

//    fun update() {
//        var availableTeams = arrayListOf<Team>()
//        availableTeams.clear()
//        for (i in teams) {
//            if (i.countOfPlayers!! < i.maxPlayers) {
//                availableTeams.add(i)
//            }
//        }
//        for (i in players) {
//            if (i.teamId == -1) {
//                val r = (0 until availableTeams.size).random()
//                println(r)
//                println(availableTeams)
//                i.setTeam(availableTeams[r].id)
//            }
//        }
//        for (i in teams) {
//            if (i.countOfPlayers!! >= i.maxPlayers) {
//                println("error")
//            } else {
//                i.teamPlayers.clear()
//                for (j in players) {
//                    if (j.teamId == i.id) {
//                        i.teamPlayers.add(j)
//                    }
//                }
//            }
//        }
//        availableTeams.clear()
//    }
}