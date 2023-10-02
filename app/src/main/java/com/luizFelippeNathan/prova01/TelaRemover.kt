package com.luizFelippeNathan.prova01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class TelaRemover : AppCompatActivity() {

    lateinit var et_cnpj : TextView
    lateinit var bt_remover : Button
    lateinit var bt_voltar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_remover)

        et_cnpj = findViewById(R.id.et_cnpj)
        bt_remover = findViewById(R.id.bt_remover)
        bt_voltar = findViewById(R.id.bt_voltar5)

        val listView: ListView = findViewById(R.id.lv_estabelecimentos2)

        ListasEstabelecimentos.mostrarLista(listView, this)

        bt_remover.setOnClickListener {
            var cnpj = et_cnpj.text.toString()
            if(cnpj != null) {
                for(estabelecimentos in ListasEstabelecimentos.listaPostoDeGasolina) {
                    if(cnpj.equals(estabelecimentos.estabelecimento.cnpj)) {
                        ListasEstabelecimentos.listaPostoDeGasolina.remove(estabelecimentos)
                    }
                }
                for(estabelecimentos in ListasEstabelecimentos.listaCinema) {
                    if(cnpj.equals(estabelecimentos.estabelecimento.cnpj)) {
                        ListasEstabelecimentos.listaCinema.remove(estabelecimentos)
                    }
                }
                for(estabelecimentos in ListasEstabelecimentos.listaSupermercado) {
                    if(cnpj.equals(estabelecimentos.estabelecimento.cnpj)) {
                        ListasEstabelecimentos.listaSupermercado.remove(estabelecimentos)
                    }
                }

                ListasEstabelecimentos.mostrarLista(listView, this)
            }
        }

        bt_voltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
            this.finish()
        }
    }
}