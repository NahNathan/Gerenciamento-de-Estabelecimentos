package com.luizFelippeNathan.prova01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class TelaAlterar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_alterar)

        val listView: ListView = findViewById(R.id.lv_estabelecimentos3)

        ListasEstabelecimentos.mostrarLista(listView, this)

        listView.setOnItemClickListener { _, _, position, _ ->
            val cnpj = ListasEstabelecimentos.listaCNPJ.get(position)

            val tipoEstabelecimento = ListasEstabelecimentos.verificarTipoEstabelecimentoPeloCnpj(cnpj)

            ListasEstabelecimentos.listaCNPJ.removeAt(position)

            if(tipoEstabelecimento.equals("posto")) {
                val intent = Intent(this,TelaInserirPostoGasolina::class.java)
                intent.putExtra("posto", cnpj)
                this.startActivity(intent)
                this.finish()
            }

            if(tipoEstabelecimento.equals("supermercado")) {
                val intent = Intent(this,TelaInserirSupermercado::class.java)
                intent.putExtra("supermercado", cnpj)
                this.startActivity(intent)
                this.finish()
            }

            if(tipoEstabelecimento.equals("cinema")) {
                val intent = Intent(this,TelaInserirCinema::class.java)
                intent.putExtra("cinema", cnpj)
                this.startActivity(intent)
                this.finish()
            }
        }
    }
}