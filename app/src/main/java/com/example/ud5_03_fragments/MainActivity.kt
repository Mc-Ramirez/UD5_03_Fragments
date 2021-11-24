package com.example.ud5_03_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ud5_03_fragments.model.ObjetoUsuario
import com.example.ud5_03_fragments.model.RecyclerFakeData
import com.example.ud5_03_fragments.model.Respuesta.RespuestaUsuarioIndividual
import com.example.ud5_03_fragments.model.Respuesta.RespuestaUsuarios
import com.example.ud5_03_fragments.model.aUsuario
//import com.example.ud5_03_fragments.model.aListaUsuario
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var adapUsu : AdaptadorUsuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val app = application as App
        val recLista = app.ListaUsuarioGeneral
        val arrayUsuarios = Gson().fromJson(RecyclerFakeData.usersJson, RespuestaUsuarios::class.java)

        Log.d("RespuestaGson", arrayUsuarios.toString())
        val nuevaLista : MutableList<ObjetoUsuario> = mutableListOf()
        arrayUsuarios.results.forEach{ nuevaLista.add(it.aUsuario())}
        recLista.addAll(nuevaLista)
       adapUsu = AdaptadorUsuario(recLista)
        val recycler: RecyclerView = findViewById(R.id.rv)
        val layaoutRv = GridLayoutManager(this, 2)
        recycler.layoutManager = layaoutRv
        recycler.adapter = adapUsu
    }
}
