package com.rgp.primerproyecto.ejercicios_clase.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rgp.primerproyecto.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        var usersList: RecyclerView = findViewById(R.id.rvList)
        var usersAdapter: UserAdapter = UserAdapter(getData())

        usersList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
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
}