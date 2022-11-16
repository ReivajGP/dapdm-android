package com.rgp.primerproyecto.ejercicios_clase.almacenamiento

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.rgp.primerproyecto.R

class FilesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_files)

        val etInfo: EditText = findViewById(R.id.etInfo)
        val btSaveFile: Button = findViewById(R.id.btSaveFile)
        val ivPerson: ImageView = findViewById((R.id.ivPerson))

        val fileName: String = "texto.txt"
        val body: String = "Cuerpo del archivo"

        // TODO: ADD GLIDE HERE

        btSaveFile.setOnClickListener{
            // Guardamos
            openFileOutput(fileName, Context.MODE_PRIVATE).use { output ->
                output.write(etInfo.text.toString().toByteArray())
            }

            // Visualizamos
            openFileInput(fileName).use { stream ->
                val text: String = stream.bufferedReader().use {
                    it.readText()
                }

                Toast.makeText(this, "Guardado: $text",Toast.LENGTH_SHORT).show()
            }
        }

        // Utilizando Raw
        resources.openRawResource(R.raw.ejemplo_raw).use { stream ->
            val texto: String = stream.bufferedReader().use {
                it.readText()
            }
            Toast.makeText(this, "Guardado: $texto",Toast.LENGTH_SHORT).show()
        }
    }
}