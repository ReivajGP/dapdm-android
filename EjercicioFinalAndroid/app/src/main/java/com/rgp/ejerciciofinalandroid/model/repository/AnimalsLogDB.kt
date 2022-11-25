package com.rgp.ejerciciofinalandroid.model.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.rgp.ejerciciofinalandroid.model.entities.AnimalDBLogEntry
import java.lang.Exception

class AnimalsLogDB(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VER) {
    companion object {
        private const val DB_NAME = "animalsLog.db"
        private const val DB_VER = 1
        private const val TBL_LOGS = "table_animals_logs"
        private const val ID = "id"
        private const val ANIMAL_ID = "animal_id"
        private const val LOG = "log"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreate = "CREATE TABLE $TBL_LOGS ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $ANIMAL_ID INTEGER, $LOG TEXT)"
        db?.execSQL(sqlCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val sqlUpgrade = "DROP TABLE IF EXISTS $TBL_LOGS"
        db?.execSQL(sqlUpgrade)
        onCreate(db)
    }

    fun insert(log: String, animalId: Int): Long {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(ANIMAL_ID, animalId)
            put(LOG, log)
        }
        val result = db.insert(TBL_LOGS, null, contentValues)
        db.close()
        return result
    }

    fun getAllLogEntries(forId: Int) : ArrayList<AnimalDBLogEntry> {
        val logEntries: ArrayList<AnimalDBLogEntry> = arrayListOf()
        val query = "SELECT * FROM $TBL_LOGS WHERE $ANIMAL_ID = $forId"
        val db = readableDatabase
        val cursor: Cursor?

        try {
            cursor = db.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            return logEntries
        }

        var animalId: Int
        var log: String

        with(cursor) {
            while(moveToNext()) {
                animalId = getInt(getColumnIndexOrThrow(ANIMAL_ID))
                log = getString(getColumnIndexOrThrow(LOG))

                val logEntry = AnimalDBLogEntry(animalId, log)
                logEntries.add(logEntry)
            }
        }
        cursor.close()
        return logEntries
    }
}