package com.example.oop_3.ui.players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    }
}