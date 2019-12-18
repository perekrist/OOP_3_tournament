package com.example.oop_3.ui.players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop_3.Player
import com.example.oop_3.R
import com.example.oop_3.players
import kotlinx.android.synthetic.main.fragment_players.*
import kotlinx.android.synthetic.main.fragment_players.view.*

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
        val myAdapter = PlayersAdapter(players, object : PlayersAdapter.Callback {
            override fun onItemClicked(item: Player) {
                Toast.makeText(context, "${item.name}", Toast.LENGTH_SHORT).show()
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
                    players.add(Player(players.size, "Player ${players.size + 1}"))
                } else
                    players.add(Player(players.size, editText.text.toString()))
                rv_players.adapter = myAdapter
            }
            builder.show()
            rv_players.adapter = myAdapter
        }
    }
}