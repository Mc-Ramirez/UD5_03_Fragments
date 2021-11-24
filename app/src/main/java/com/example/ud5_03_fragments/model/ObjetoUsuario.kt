package com.example.ud5_03_fragments.model

import com.example.ud5_03_fragments.model.Respuesta.*


data class ObjetoUsuario(
    val first : String,
    val last : String,
    val country : String,
    val medium : String,
    val age : Int,
    val date : String

    ){
        constructor(rUsuario: RespuestaUsuarioIndividual) : this(
        rUsuario.name.first,
            rUsuario.name.last,
            rUsuario.nat,
            rUsuario.picture.medium,
            rUsuario.dob.age,
            rUsuario.dob.date
        )
    }

    fun RespuestaUsuarioIndividual.aUsuario(): ObjetoUsuario{
        return ObjetoUsuario(
            this.name.first,
            this.name.last,
            this.nat,
            this.picture.medium,
        this.dob.age,
            this.dob.date
        )
    }




