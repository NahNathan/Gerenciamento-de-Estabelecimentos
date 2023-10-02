package com.luizFelippeNathan.prova01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class TelaInserirSupermercado : AppCompatActivity() {

    lateinit var tv_supermercado : TextView
    lateinit var tv_nome : TextView
    lateinit var tv_cnpj : TextView
    lateinit var tnd_caixa : TextView
    lateinit var cb_ar : CheckBox
    lateinit var bt_inserir : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inserir_supermercado)

        tv_supermercado = findViewById(R.id.tv_supermercado)
        tv_nome = findViewById(R.id.tv_nome)
        tv_cnpj = findViewById(R.id.tv_cnpj)
        tnd_caixa = findViewById(R.id.tnd_caixa)
        cb_ar = findViewById(R.id.cb_ar)
        bt_inserir = findViewById(R.id.bt_inserir_sup)

        val intent = intent
        if(intent.hasExtra("supermercado")) {
            val cnpj = intent.getStringExtra("supermercado")
            val supermercado = ListasEstabelecimentos.obterSupermercadoPorCnpj(cnpj)

            tv_supermercado.setText("Altere a informação desejada")
            bt_inserir.setText("Alterar")

            tv_nome.setText(supermercado?.estabelecimento?.nome)
            tv_cnpj.setText(supermercado?.estabelecimento?.cnpj)
            tnd_caixa.setText(supermercado?.estabelecimento?.caixa.toString())

            if(supermercado?.arCondicionado == true) {
                cb_ar.isChecked = true
            }

            ListasEstabelecimentos.listaSupermercado.remove(supermercado)
            intent.removeExtra("supermercado")
        }

        var ar = false

        cb_ar.setOnCheckedChangeListener { _, isChecked ->
            ar = isChecked
        }

        bt_inserir.setOnClickListener {
            if(!ListasEstabelecimentos.verificarCNPJ(tv_cnpj.text.toString())) {
                val supermercado = Supermercado(Estabelecimento(tv_nome.text.toString(), tv_cnpj.text.toString(), tnd_caixa.text.toString().toDouble()), ar)

                ListasEstabelecimentos.setSupermercado(supermercado)

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