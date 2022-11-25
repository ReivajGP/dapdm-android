package com.rgp.ejerciciofinalandroid.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rgp.ejerciciofinalandroid.model.entities.AnimalDBLogEntry
import com.rgp.ejerciciofinalandroid.model.repository.AnimalsLogDB
import com.rgp.ejerciciofinalandroid.viewmodel.helpers.LogFormatHelper

class DetailViewModel : ViewModel() {

    val logs = MutableLiveData<ArrayList<AnimalDBLogEntry>>()

    fun getAnimalsLogs(context: Context, animalId: Int) {
        val logEntries = AnimalsLogDB(context).getAllLogEntries(animalId)
        logs.postValue(logEntries)
    }

    fun formatDescription(logs: ArrayList<String>) : String {
        return LogFormatHelper().formatDescription(logs)
    }
}