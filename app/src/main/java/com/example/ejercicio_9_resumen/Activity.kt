package com.example.ejercicio_9_resumen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio_9_resumen.databinding.ActivityBinding
import com.example.ejercicio_9_resumen.databinding.ActivityMainBinding

class Activity : AppCompatActivity() {

    private lateinit var binding: ActivityBinding

    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        bindingMain= ActivityMainBinding.inflate(layoutInflater)

        val bundle = intent.extras
        val clase = bundle?.getString("Clase")
        val raza = bundle?.getString("Raza")

        cambioFoto(clase.toString())
        cambioFoto2(raza.toString())

        atributosAleatorios()

        binding.Volver.setOnClickListener{cambioPaginaVolver()}
        binding.Comenzar.setOnClickListener{cambioPaginaComenzar()}
    }

    private fun atributosAleatorios() {

        binding.Fuerza.setText("Fuerza: "+randon(10,15))

        binding.Defensa.setText("Defensa: "+randon(1,5))

        binding.Vida.setText("Vida: "+randon(200,200))

        binding.TamaOMochila.setText("Tamaño Mochila: "+randon(200,200))

        binding.Monedero.setText("Monedero: "+randon(0,0))

    }

    fun randon(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return (start..end).random()
    }
    private fun cambioFoto(text: String) {

        val imagen = binding.clase

        if (text.equals("Guerrero"))
            imagen.setImageResource(R.drawable.guerrero)

        if (text.equals("Mago"))
            imagen.setImageResource(R.drawable.mago)

        if (text.equals("Berserker"))
            imagen.setImageResource(R.drawable.berserker)

        if (text.equals("Ladron"))
            imagen.setImageResource(R.drawable.ladron)

    }
    private fun cambioFoto2(text: String) {

        val imagen = binding.raza

        if (text.equals("Humano"))
            imagen.setImageResource(R.drawable.humano)

        if (text.equals("Goblin"))
            imagen.setImageResource(R.drawable.goblin)

        if (text.equals("Elfo"))
            imagen.setImageResource(R.drawable.elfo)

        if (text.equals("Enano"))
            imagen.setImageResource(R.drawable.enano)
    }

    private fun cambioPaginaVolver() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun cambioPaginaComenzar() {
        val intent = Intent(this, CuartaPag::class.java)
        startActivity(intent)
    }



}