package com.example.oop_3.ui.match

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop_3.*
import kotlinx.android.synthetic.main.activity_match_editing.*

class MatchEditing : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_editing)
        val tournamentId: String = intent.getStringExtra("tourn_id")!!
        val matchId: String = intent.getStringExtra("match_id")!!
        val tId = tournamentId.toInt()
        val mId = matchId.toInt()
        if (tournaments[tId].matches[mId].isFinished) {
            add_event.isVisible = false
            finish_match.isVisible = false
        }
        var events = tournaments[tId].matches[mId].events
        val myAdapter = MatchAdapter(events, object : MatchAdapter.Callback {
            override fun onItemClicked(item: Event) {
//                val intent = Intent(this@MatchEditing, PlayerDescription::class.java).apply {
//                    putExtra("player_id", item.num.toString())
//                }
//                startActivity(intent)
            }
        })
        rv_current_match.adapter = myAdapter
        rv_current_match.layoutManager = LinearLayoutManager(this)

        val typesSpinner = findViewById<Spinner>(R.id.event_types)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, types)
        val players1 = findViewById<Spinner>(R.id.event_player1)
        val players2 = findViewById<Spinner>(R.id.event_player2)
        val playerss = arrayListOf<String>()
        val playerss2 = arrayListOf<String>()
        playerss.add("-")
        for (i in tournaments[tId].matches[mId].matchPlayers) {
            playerss.add(i.num.toString())
            playerss2.add(i.num.toString())
        }
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, playerss2)
        val adapter3 = ArrayAdapter(this, android.R.layout.simple_list_item_1, playerss)
        typesSpinner.adapter = adapter
        players1.adapter = adapter2
        players2.adapter = adapter3
        add_event.setOnClickListener {
            if (event_types.selectedItem.toString() == types[0]) {
                players[event_player1.selectedItem.toString().toInt()].countOfGoals += 1
                for (j in teams) {
                    if (j.id == players[event_player1.selectedItem.toString().toInt()].teamId) {
                        if (j.id == tournaments[tId].matches[mId].match.first!!.id) {
                            tournaments[tId].matches[mId].score1 += 1
                        } else
                            tournaments[tId].matches[mId].score2 += 1
                    }
                }
            }
            events.add(
                Event(
                    event_time_d.text.toString().toInt(),
                    event_types.selectedItem.toString(),
                    event_player1.selectedItem.toString(),
                    event_player2.selectedItem.toString()
                )
            )
            rv_current_match.adapter = myAdapter
            rv_current_match.adapter = myAdapter
        }
        rv_current_match.adapter = myAdapter
        finish_match.setOnClickListener {
            add_event.isVisible = false
            finish_match.isVisible = false
            tournaments[tId].matches[mId].isFinished = true
            if (tournaments[tId].matches[mId].score1 > tournaments[tId].matches[mId].score2) {
                tournaments[tId].matches[mId].matchWinner = tournaments[tId].matches[mId].match.first
            } else
                tournaments[tId].matches[mId].matchWinner = tournaments[tId].matches[mId].match.second
        }
    }
}
