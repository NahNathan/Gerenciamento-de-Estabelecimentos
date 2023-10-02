package com.luizFelippeNathan.prova01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.TextView
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class TelaSalvar : AppCompatActivity() {

    private val caminhoDoArquivo = "MeuArquivo"
    private var arquivoExterno: File? = null

    private val armazenamentoExternoSomenteLeitura: Boolean get() {
        var armzSomLeitRet = false
        val armazenamentoExterno = Environment.getExternalStorageState()

        if (Environment.MEDIA_MOUNTED_READ_ONLY == armazenamentoExterno)
            armzSomLeitRet = true

        return armzSomLeitRet
    }

    private val armazenamentoExternoDisponivel: Boolean get() {
        var armzExtDispRet = false
        val extStorageState = Environment.getExternalStorageState()

        if (Environment.MEDIA_MOUNTED == extStorageState)
            armzExtDispRet = true

        return armzExtDispRet
    }

    lateinit var tv_dados : TextView
    lateinit var bt_mostrar_dados : Button
    lateinit var bt_voltar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_salvar)

        tv_dados = findViewById(R.id.tv_dados)
        bt_mostrar_dados = findViewById(R.id.bt_mostrar_dados)
        bt_voltar = findViewById(R.id.bt_voltar2)

        if(armazenamentoExternoDisponivel && !armazenamentoExternoSomenteLeitura)
            salvarDados()

        bt_voltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
            this.finish()
        }

        bt_mostrar_dados.setOnClickListener {
            val intent = Intent(this, TelaRelatorio::class.java)
            this.startActivity(intent)
            this.finish()
        }
    }

    fun salvarDados() {
        arquivoExterno = File(getExternalFilesDir(caminhoDoArquivo), "relatorio")
        try {
            val fileOutputStream = FileOutputStream(arquivoExterno)
            fileOutputStream.write(ListasEstabelecimentos.obterRelatorio().toByteArray())
            fileOutputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        tv_dados.setText("Relatório salvo com sucesso!")
    }
}