package com.example.ud5_03_fragments

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.ud5_03_fragments.model.ObjetoUsuario
import com.example.ud5_03_fragments.model.Respuesta.RespuestaUsuarioIndividual

class App:Application (){
    val ListaUsuarioGeneral : MutableList<ObjetoUsuario> = mutableListOf()
}

val AppCompatActivity.app:App
    get() = this.application as App