package com.luizFelippeNathan.prova01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class TelaInserirCinema : AppCompatActivity() {

    lateinit var tv_nome : TextView
    lateinit var tv_cnpj : TextView
    lateinit var tnd_caixa : TextView
    lateinit var tn_assentos : TextView
    lateinit var bt_inserir : Button
    lateinit var tv_cinema : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inserir_cinema)

        tv_cinema = findViewById(R.id.tv_cinema)
        tv_nome = findViewById(R.id.tv_nome3)
        tv_cnpj = findViewById(R.id.tv_cnpj3)
        tnd_caixa = findViewById(R.id.tnd_caixa3)
        tn_assentos = findViewById(R.id.tn_assentos)
        bt_inserir = findViewById(R.id.bt_inserir_cinema)

        val intent = intent
        if(intent.hasExtra("cinema")) {
            val cnpj = intent.getStringExtra("cinema")
            val cinema = ListasEstabelecimentos.obterCinemaPorCnpj(cnpj)

            tv_cinema.setText("Altere a informação desejada")
            bt_inserir.setText("Alterar")

            tv_nome.setText(cinema?.estabelecimento?.nome)
            tv_cnpj.isEnabled = false
            //tv_cnpj.setText(cinema?.estabelecimento?.cnpj)
            tnd_caixa.setText(cinema?.estabelecimento?.caixa.toString())
            tn_assentos.setText(cinema?.quantidadeAssentos.toString())

            ListasEstabelecimentos.listaCinema.remove(cinema)
            intent.removeExtra("cinema")
        }

        bt_inserir.setOnClickListener {
            if(!ListasEstabelecimentos.verificarCNPJ(tv_cnpj.text.toString())) {
                val cinema = Cinema(Estabelecimento(tv_nome.text.toString(), tv_cnpj.text.toString(), tnd_caixa.text.toString().toDouble()), tn_assentos.text.toString().toInt())

                ListasEstabelecimentos.setCinema(cinema)

                val intent = Intent(this, MainActivity::class.java)
                this.startActivity(intent)

                if(bt_inserir.text.toString().equals("Alterar"))
                    Toast.makeText(applicationContext, "Estabelecimento alterado!", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(applicationContext, "Estabelecimento adicionado!", Toast.LENGTH_SHORT).show()

                this.finish()
            } else {
                Toast.makeText(applicationContext, "CNPJ já cadastrado!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}