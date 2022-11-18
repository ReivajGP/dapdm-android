package com.rgp.primerproyecto.ejercicio_tres

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.rgp.primerproyecto.ejercicios_clase.almacenamiento.DBUser
import com.rgp.primerproyecto.ejercicios_clase.almacenamiento.UserSQLModel
import java.lang.Exception

class AnimalsSQLHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "animals.db"
        private const val TABLE_ANIMALS = "table_animals"
        private const val ID = "id"
        private const val NAME = "name"
        private const val IMAGE = "image"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreate =
            "CREATE TABLE $TABLE_ANIMALS ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NAME TEXT, $IMAGE INTEGER)"
        db?.execSQL(sqlCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sqlUpgrade = "DROP TABLE IF EXISTS $TABLE_ANIMALS"
        db?.execSQL(sqlUpgrade)
        onCreate(db)
    }

    fun insert(animal: AnimalSQLModel): Long {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(NAME, animal.name)
            put(IMAGE, animal.image)
        }
        val result = db.insert(TABLE_ANIMALS, null, contentValues)
        db.close()
        return result
    }

    fun updateAnimal(animal: AnimalSQLModel): Int {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(ID, animal.id)
            put(NAME, animal.name)
            put(IMAGE, animal.image)
        }
        val result = db.update(TABLE_ANIMALS, contentValues, "id=?", arrayOf("${animal.id}"))
        db.close()
        return result
    }

    fun deleteUser(animalId: Int): Int {
        val db = writableDatabase
        val result = db.delete(TABLE_ANIMALS, "id=?", arrayOf("$animalId"))
        db.close()
        return result
    }

    fun getAllAnimals(): ArrayList<AnimalSQLModel> {
        val animalsList = arrayListOf<AnimalSQLModel>()
        val query = "SELECT * FROM $TABLE_ANIMALS"
        val db = readableDatabase
        val cursor: Cursor?

        try {

            cursor = db.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            return animalsList
        }

        var id: Int
        var name: String
        var image: String

        with(cursor) {
            while (moveToNext()) {
                id = getInt(getColumnIndexOrThrow(ID))
                name = getString(getColumnIndexOrThrow(NAME))
                image = getString(getColumnIndexOrThrow(IMAGE))

                val animal = AnimalSQLModel(id, name, image)
                animalsList.add(animal)
            }
        }
        cursor.close()
        Log.e("DB", animalsList.toString())
        return animalsList
    }
}