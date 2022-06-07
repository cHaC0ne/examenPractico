package com.example.examenpractico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import com.example.examenpractico.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private var year = arrayOf("")
    private var rama = ""
    private var optativas = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.rbBiologia.setOnClickListener { rama = "Biologia" }
        b.rbMatematicas.setOnClickListener { rama = "Matematicas" }
        b.rbMedicina.setOnClickListener{ rama = "Ciencias de la Salud"}

        getSpinner(this,b.spYear, year , R.array.Year)

        b.bEnviar.setOnClickListener { getAndSend() }
    }

    fun getAndSend(){
        val intentResult = Intent(this, ResultActivity::class.java)

        intentResult.putExtra("NOMBRE", b.etNombre.text.toString())
        intentResult.putExtra("YEAR", year[0])
        intentResult.putExtra("RAMA", rama)
        intentResult.putExtra("OPTATIVAS", optativas.toString())
        startActivity(intentResult)
    }

    fun onCheckBoxClicked(view: View) {
        if (view is CheckBox) {
            val ckName = view.text.toString()
            if (view.isChecked) {
                if (!optativas.contains(ckName)) {
                    optativas.add(ckName)
                }
            } else {
                if (optativas.contains(ckName)) {
                    optativas.remove(ckName)
                }
            }
            msj(this, ckName)
        }
    }

    fun onRadioClicked (view : View){
        if(view is RadioButton){
            rama = view.text.toString()
        }

    }

}
