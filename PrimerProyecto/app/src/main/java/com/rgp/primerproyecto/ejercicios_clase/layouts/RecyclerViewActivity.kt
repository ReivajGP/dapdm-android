package com.rgp.primerproyecto.ejercicios_clase.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rgp.primerproyecto.R

class RecyclerViewActivity : AppCompatActivity(), RecyclerItemListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        var usersList: RecyclerView = findViewById(R.id.rvList)
        var usersAdapter: UserAdapter = UserAdapter(getData(), this)

        usersList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        usersList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        usersList.itemAnimator = DefaultItemAnimator()
        usersList.adapter = usersAdapter
    }

    private fun getData() :ArrayList<RecyclerViewUser> {
        val data = arrayListOf<RecyclerViewUser>()

        data.add(RecyclerViewUser("Rei", ""))
        data.add(RecyclerViewUser("José", ""))
        data.add(RecyclerViewUser("Javier", ""))
        data.add(RecyclerViewUser("Miguel", ""))
        data.add(RecyclerViewUser("Pablo", ""))
        data.add(RecyclerViewUser("Rick", ""))
        data.add(RecyclerViewUser("Ingrid", ""))

        return data
    }

    override fun onItemSelected(user: RecyclerViewUser) {
        Toast.makeText(this, "User: ${user.name}", Toast.LENGTH_SHORT).show()
    }
}