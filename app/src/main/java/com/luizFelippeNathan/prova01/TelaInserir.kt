package com.luizFelippeNathan.prova01

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class TelaInserir : AppCompatActivity() {

    lateinit var bt_inserir_supermercado : Button
    lateinit var bt_inserir_cinema : Button
    lateinit var bt_inserir_posto : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inserir)

        bt_inserir_supermercado = findViewById(R.id.bt_inserir_sp)
        bt_inserir_cinema = findViewById(R.id.bt_inserir_ci)
        bt_inserir_posto = findViewById(R.id.bt_inserir_pg)

        bt_inserir_posto.setOnClickListener {
            val intent = Intent(this,TelaInserirPostoGasolina::class.java)
            this.startActivity(intent)
            this.finish()
        }

        bt_inserir_cinema.setOnClickListener {
            val intent = Intent(this,TelaInserirCinema::class.java)
            this.startActivity(intent)
            this.finish()
        }

        bt_inserir_supermercado.setOnClickListener {
            val intent = Intent(this,TelaInserirSupermercado::class.java)
            this.startActivity(intent)
            this.finish()
        }
    }
}