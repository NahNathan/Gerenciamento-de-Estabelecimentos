package com.luizFelippeNathan.prova01

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class TelaMostrar : AppCompatActivity() {

    lateinit var bt_voltar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_mostrar)

        val listView: ListView = findViewById(R.id.lv_estabelecimentos)
        bt_voltar = findViewById(R.id.bt_voltar4)

        ListasEstabelecimentos.mostrarLista(listView, this)

        bt_voltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
            this.finish()
        }
    }
}
