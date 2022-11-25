package com.rgp.ejerciciofinalandroid.viewmodel
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rgp.ejerciciofinalandroid.model.entities.AnimalDBLogEntry
import com.rgp.ejerciciofinalandroid.model.repository.AnimalsLogDB
import com.rgp.ejerciciofinalandroid.viewmodel.helpers.LogFormatHelper
import com.rgp.ejerciciofinalandroid.viewmodel.helpers.ToastHelper

class EntryViewModel : ViewModel() {
    val logs = MutableLiveData<ArrayList<AnimalDBLogEntry>>()

    // Public methods
    fun getAnimalsLogs(context: Context, animalId: Int) {
        val logEntries = AnimalsLogDB(context).getAllLogEntries(animalId)
        logs.postValue(logEntries)
    }

    fun logEntryButtonPressed(context: Context, hour: String, min: String, message: String, animalId: Int) : Boolean {
        if (areTextFieldsNotEmpty(hour, min, message)) {
            if (isTimeRight(hour, min)) {
                val logEntry = createLogMessage(hour, min, message)
                val result = AnimalsLogDB(context).insert(logEntry, animalId)
                if (result > -1) {
                    ToastHelper().displayToast(context, "Entrada añadida exitosamente.")
                    return true
                }
            } else ToastHelper().displayToast(context, "Asegúrate de ingresar correctamente la hora a la bitácora.")
        } else ToastHelper().displayToast(context,"Los campos de hora, minuto y mensaje deben estar llenos.")
        return false
    }

    fun formatDescription(logs: ArrayList<String>) : String {
        return LogFormatHelper().formatDescription(logs)
    }

    // Private methods
    private fun createLogMessage(hour: String, min: String, message: String) : String {
        return "${hour}:${min} hrs - ${message}"
    }

    private fun areTextFieldsNotEmpty(hour: String, min: String, message: String) : Boolean {
        return (hour.isNotEmpty() && min.isNotEmpty() && message.isNotEmpty())
    }

    private fun isTimeRight(hour: String, min: String) : Boolean {
        val intHour: Int? = hour.toIntOrNull()
        val intMin: Int? = min.toIntOrNull()
        if (intHour == null || intMin == null) {
            return false
        }
        if (intHour < 0 || intHour > 23) {
            return false
        }
        if (intMin < 0 || intMin > 59) {
            return false
        }
        return true
    }
}