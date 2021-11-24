package com.example.ud5_03_fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ud5_03_fragments.model.ObjetoUsuario
import com.example.ud5_03_fragments.model.Respuesta.RespuestaUsuarioIndividual
import com.squareup.picasso.Picasso

class AdaptadorUsuario (private val usuarios: MutableList<ObjetoUsuario>): RecyclerView.Adapter<AdaptadorUsuario.ViewHolder>(){

    inner class ViewHolder(vista_item: View): RecyclerView.ViewHolder(vista_item){
        val tvNombreUsuario:TextView = vista_item.findViewById(R.id.tv_nombre_usuario)
        val tvPaisUsuario:TextView = vista_item.findViewById(R.id.tv_pais)
        val ivAvatarRepo: ImageView = vista_item.findViewById(R.id.iv_avatar)
    }
    //que ocurre cuando se crea
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layaoutinflater = LayoutInflater.from(parent.context)
        val vista_item : View = layaoutinflater.inflate(R.layout.items_usuarios, parent, false)
        return ViewHolder(vista_item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuarioActual : ObjetoUsuario = usuarios[position]
        holder.tvNombreUsuario.text = usuarioActual.first
        holder.tvPaisUsuario.text = usuarioActual.country
        Picasso.get().load(usuarioActual.medium).placeholder(R.drawable.selection_band_overlay).into(holder.ivAvatarRepo)
    }

    //retornar cuantos repos hay a la funcion onBindViewHolder
    override fun getItemCount(): Int {
        return usuarios.size
    }
}