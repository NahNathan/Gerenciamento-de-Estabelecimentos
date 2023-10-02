package com.luizFelippeNathan.prova01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var bt_inserir : Button
    lateinit var bt_remover : Button
    lateinit var bt_mostrar : Button
    lateinit var bt_alterar : Button
    lateinit var bt_caixa : Button
    lateinit var bt_salvar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_inserir = findViewById(R.id.bt_inserir)
        bt_remover = findViewById(R.id.bt_remover)
        bt_mostrar = findViewById(R.id.bt_mostrar)
        bt_alterar = findViewById(R.id.bt_alterar)
        bt_caixa = findViewById(R.id.bt_caixa)
        bt_salvar = findViewById(R.id.bt_salvar)

        bt_inserir.setOnClickListener {
            val intent = Intent(this, TelaInserir::class.java)
            this.startActivity(intent)
        }

        bt_remover.setOnClickListener {
            val intent = Intent(this, TelaRemover::class.java)
            this.startActivity(intent)
        }

        bt_mostrar.setOnClickListener {
            val intent = Intent(this, TelaMostrar::class.java)
            this.startActivity(intent)
        }

        bt_alterar.setOnClickListener {
            val intent = Intent(this, TelaAlterar::class.java)
            this.startActivity(intent)
        }

        bt_caixa.setOnClickListener {
            val intent = Intent(this, TelaCaixa::class.java)
            this.startActivity(intent)
        }

        bt_salvar.setOnClickListener{
            val intent = Intent(this, TelaSalvar::class.java)
            this.startActivity(intent)
        }
    }
}