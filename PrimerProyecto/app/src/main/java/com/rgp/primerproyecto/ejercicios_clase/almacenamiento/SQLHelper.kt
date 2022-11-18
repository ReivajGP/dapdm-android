package com.rgp.primerproyecto.ejercicios_clase.almacenamiento

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import java.lang.Exception

class SQLHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "user.db"
        private const val TABLE_USER = "table_user"
        private const val ID = "id"
        private const val NAME = "name"
        private const val DESCRIPTION = "description"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreate = "CREATE TABLE $TABLE_USER ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NAME TEXT, $DESCRIPTION TEXT)"
        db?.execSQL(sqlCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sqlUpgrade = "DROP TABLE IF EXISTS $TABLE_USER"
        db?.execSQL(sqlUpgrade)
        // TODO: Obtener info
        onCreate(db)
    }

    fun insert(user: UserSQLModel) : Long {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(NAME, user.name)
            put(DESCRIPTION, user.description)
        }
        db.close()
        return db.insert(TABLE_USER, null, contentValues)
    }

    fun getAllUsers() : ArrayList<UserSQLModel> {
        val userList = arrayListOf<UserSQLModel>()
        val query = "SELECT * FROM $TABLE_USER"
        val db = readableDatabase

        val cursor : Cursor?

        try {
            cursor = db.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            return userList
        }

        var id: Int
        var name: String
        var description: String

        with(cursor) {
            while (moveToNext()) {
                id = getInt(cursor.getColumnIndexOrThrow(ID))
                name = getString(cursor.getColumnIndexOrThrow(NAME))
                description = getString(getColumnIndexOrThrow(DESCRIPTION))

                val user: UserSQLModel = UserSQLModel(id, name, description)
                userList.add(user)
            }
        }
        cursor.close()
        return userList
    }

    fun getDBUsers() : ArrayList<DBUser> {
        val usersInDB: ArrayList<UserSQLModel> = getAllUsers()
        var dbUsers: ArrayList<DBUser> = arrayListOf()
        if (usersInDB.isNotEmpty()) {
            for (i in 0..(usersInDB.size - 1)) {
                dbUsers.add(DBUser("", ""))
                dbUsers[i].name = usersInDB[i].name
                dbUsers[i].description = usersInDB[i].description
            }
        }
        return dbUsers
    }

    fun updateUser(user: UserSQLModel) : Int {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(ID, user.id)
            put(NAME, user.name)
            put(DESCRIPTION, user.description)
        }
        val result = db.update(TABLE_USER, contentValues, "id=?", arrayOf("${user.id}"))
        db.close()
        return result
    }

    fun deleteUser(userId: Int) : Int {
        val db = writableDatabase
        val result = db.delete(TABLE_USER, "id=?", arrayOf("$userId"))
        db.close()
        return result
    }
}