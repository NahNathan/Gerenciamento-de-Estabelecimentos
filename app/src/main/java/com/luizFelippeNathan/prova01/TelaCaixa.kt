package com.luizFelippeNathan.prova01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TelaCaixa : AppCompatActivity() {

    lateinit var bt_voltar : Button
    lateinit var tv_caixa : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_caixa)

        bt_voltar = findViewById(R.id.bt_voltar)
        tv_caixa = findViewById(R.id.tv_total)

        tv_caixa.setText("R$" + ListasEstabelecimentos.obterCaixa())

        bt_voltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
            this.finish()
        }
    }
}