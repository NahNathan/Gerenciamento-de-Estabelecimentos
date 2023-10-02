package com.luizFelippeNathan.prova01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class TelaInserirPostoGasolina : AppCompatActivity() {

    lateinit var tv_posto : TextView
    lateinit var tv_nome : TextView
    lateinit var tv_cnpj : TextView
    lateinit var tnd_caixa : TextView
    lateinit var tnd_capacidade : TextView
    lateinit var bt_inserir : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inserir_posto_gasolina)

        tv_posto = findViewById(R.id.tv_posto)
        tv_nome = findViewById(R.id.tv_nome2)
        tv_cnpj = findViewById(R.id.tv_cnpj2)
        tnd_caixa = findViewById(R.id.tnd_caixa2)
        tnd_capacidade = findViewById(R.id.tnd_capacidade)
        bt_inserir = findViewById(R.id.bt_inserir_posto)

        val intent = intent
        if(intent.hasExtra("posto")) {
            val cnpj = intent.getStringExtra("posto")
            val posto = ListasEstabelecimentos.obterPostoPorCnpj(cnpj)

            tv_posto.setText("Altere a informação desejada")
            bt_inserir.setText("Alterar")

            tv_nome.setText(posto?.estabelecimento?.nome)
            tv_cnpj.setText(posto?.estabelecimento?.cnpj)
            tnd_caixa.setText(posto?.estabelecimento?.caixa.toString())
            tnd_capacidade.setText(posto?.capacidadeTanque.toString())

            ListasEstabelecimentos.listaPostoDeGasolina.remove(posto)
            intent.removeExtra("posto")
        }

        bt_inserir.setOnClickListener {
            if(!ListasEstabelecimentos.verificarCNPJ(tv_cnpj.text.toString())) {
                val postoGasolina = PostoDeGasolina(Estabelecimento(tv_nome.text.toString(), tv_cnpj.text.toString(), tnd_caixa.text.toString().toDouble()), tnd_capacidade.text.toString().toDouble())

                ListasEstabelecimentos.setPostoDeGasolina(postoGasolina)

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