package com.example.oop_3.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oop_3.*
import com.example.oop_3.ui.players.PlayersAdapter
import kotlinx.android.synthetic.main.fragment_players.*
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
        val myAdapter = TeamsAdapter(teams, object : TeamsAdapter.Callback {
            override fun onItemClicked(item: Team) {
                Toast.makeText(context, "${item.id}", Toast.LENGTH_SHORT).show()
            }
        })
        rv_teams.adapter = myAdapter
        rv_teams.layoutManager = LinearLayoutManager(this.requireContext())
    }
}