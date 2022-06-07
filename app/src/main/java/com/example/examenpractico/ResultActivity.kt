package com.example.examenpractico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenpractico.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var b: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityResultBinding.inflate(layoutInflater)
        setContentView(b.root)

        val datos = intent.extras

        val str = """   DATOS
            Nombre: ${datos?.get("NOMBRE")}
            Año de nacimiento: ${datos?.get("YEAR")}
            Rama de estudio: ${datos?.get("RAMA")}
            Optativas: ${datos?.get("OPTATIVAS")}
        """.trimIndent()
        msj(this,str,false)
        b.tvDatos.text = str
        b.bVolver.setOnClickListener { onBackPressed() }
    }
}

