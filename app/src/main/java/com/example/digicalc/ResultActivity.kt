package com.example.digicalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultado = intent.getIntExtra("resultado", 0)
        val operation = intent.getStringExtra("operation")

        val cardView = findViewById<CardView>(R.id.result_cardview)
        val textViewResult = findViewById<TextView>(R.id.result_textview)

        val buttonBack = findViewById<Button>(R.id.buttonBack)
        buttonBack.setOnClickListener {
            finish() // Finaliza la actividad actual y regresa a la actividad anterior (MainActivity)
        }

        buttonBack.setOnClickListener {
            // Limpiar los campos de texto en la actividad MainActivity
            val mainActivityIntent = Intent(this@ResultActivity, MainActivity::class.java)
            mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            mainActivityIntent.putExtra("clearFields", true)
            startActivity(mainActivityIntent)
            finish()
        }

        //Pintar campo de colores y validar operaciones
        when (operation) {
            "suma" -> {
                textViewResult.text = "El resultado de la Suma es: $resultado"
                cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.default_color))
            }
            "resta" -> {
                textViewResult.text = "El resultado de la Resta es: $resultado"
                cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.default_color))
            }
            "multiplicacion" -> {
                textViewResult.text = "El resultado de la Multiplicación es: $resultado"
                cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.default_color))
            }
            "division" -> {
                textViewResult.text = "El resultado de la División es: $resultado"
                cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.default_color))
            }
            else -> {
                textViewResult.text = "El resultado es: $resultado"
                cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.default_color))
            }
        }
    }
}
