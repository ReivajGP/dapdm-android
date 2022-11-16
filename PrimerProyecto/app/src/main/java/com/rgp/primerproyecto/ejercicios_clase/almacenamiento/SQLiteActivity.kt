package com.rgp.primerproyecto.ejercicios_clase.almacenamiento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rgp.primerproyecto.R
import com.rgp.primerproyecto.ejercicios_clase.layouts.UserAdapter

class SQLiteActivity : AppCompatActivity() {

    private lateinit var sqlHelper: SQLHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        sqlHelper = SQLHelper(this)
        val etName: EditText = findViewById(R.id.etName)
        val etDescription: EditText = findViewById(R.id.etDescription)
        val btAdd: Button = findViewById(R.id.btAdd)
        val btView: Button = findViewById(R.id.btView)
        val btUpdate: Button = findViewById(R.id.btUpdate)
        val btDelete: Button = findViewById(R.id.btDelete)
        var usersList: RecyclerView = findViewById(R.id.rvUsers)
        var usersAdapter: DBUserAdapter = DBUserAdapter(SQLHelper(this).getDBUsers())

        usersList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        usersList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        usersList.itemAnimator = DefaultItemAnimator()
        usersList.adapter = usersAdapter

        btAdd.setOnClickListener{
            // Guardamos info
            if (etName.text.toString().isEmpty() || etDescription.text.toString().isEmpty()) {
                Toast.makeText(this, "Ingrese información",Toast.LENGTH_SHORT).show()
            } else {
                val user: UserSQLModel = UserSQLModel(name = etName.text.toString(), description = etDescription.text.toString())
                val result = sqlHelper.insert(user)
                if (result > -1) {
                    Toast.makeText(this, "Información guardada correctamente :D!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Información NO guardada x_x", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btView.setOnClickListener{
            // Visualizamos info
            val list = sqlHelper.getAllUsers()
            Log.e("lista", list.toString())
        }

        btUpdate.setOnClickListener{
            val updatedUser = UserSQLModel(id = 2, "José Estrada", description = "Descripción de José Estrada")
            var result = sqlHelper.updateUser(updatedUser)

            if (result > -1) {
                Toast.makeText(this, "Información actualizada correctamente :D!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Información NO actualizada x_x", Toast.LENGTH_SHORT).show()
            }
        }

        btDelete.setOnClickListener{
            var result = sqlHelper.deleteUser(2)

            if (result > -1) {
                Toast.makeText(this, "Información eliminada correctamente :D!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Información NO eliminada x_x", Toast.LENGTH_SHORT).show()
            }
        }
    }
}