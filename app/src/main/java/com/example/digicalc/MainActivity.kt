package com.example.digicalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var buttonSum: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivide: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pausa la ejecución durante unos segundos para simular la pantalla de carga
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        buttonSum = findViewById(R.id.buttonSum)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDivide = findViewById(R.id.buttonDivide)

        buttonSum.setOnClickListener {
            sumar()
        }

        buttonSubtract.setOnClickListener {
            restar()
        }

        buttonMultiply.setOnClickListener {
            multiplicar()
        }

        buttonDivide.setOnClickListener {
            dividir()
        }

        // Limpiar campo
        val shouldClearFields = intent.getBooleanExtra("clearFields", false)
        if (shouldClearFields) {
            editTextNumber1.text.clear()
            editTextNumber2.text.clear()
        }
    }

    // Operaciones
    private fun sumar() {
        val num1 = editTextNumber1.text.toString().trim()
        val num2 = editTextNumber2.text.toString().trim()

        if (num1.isNotEmpty() && num2.isNotEmpty()) {
            val resultado = num1.toInt() + num2.toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("resultado", resultado)
            intent.putExtra("operation", "suma")
            startActivity(intent)
        } else {
            Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show()
        }
    }

    private fun restar() {
        val num1 = editTextNumber1.text.toString().trim()
        val num2 = editTextNumber2.text.toString().trim()

        if (num1.isNotEmpty() && num2.isNotEmpty()) {
            val resultado = num1.toInt() - num2.toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("resultado", resultado)
            intent.putExtra("operation", "resta")
            startActivity(intent)
        } else {
            Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show()
        }
    }

    private fun multiplicar() {
        val num1 = editTextNumber1.text.toString().trim()
        val num2 = editTextNumber2.text.toString().trim()

        if (num1.isNotEmpty() && num2.isNotEmpty()) {
            val resultado = num1.toInt() * num2.toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("resultado", resultado)
            intent.putExtra("operation", "multiplicacion")
            startActivity(intent)
        } else {
            Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show()
        }
    }

    private fun dividir() {
        val num1 = editTextNumber1.text.toString().trim()
        val num2 = editTextNumber2.text.toString().trim()

        if (num1.isNotEmpty() && num2.isNotEmpty()) {
            val num2Value = num2.toInt()

            if (num2Value != 0) {
                val resultado = num1.toInt() / num2Value

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("resultado", resultado)
                intent.putExtra("operation", "division")
                startActivity(intent)
            } else {
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show()
        }
    }
}
