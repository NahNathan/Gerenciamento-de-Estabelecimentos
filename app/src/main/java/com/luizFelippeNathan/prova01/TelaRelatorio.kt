package com.luizFelippeNathan.prova01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileOutputStream


class TelaRelatorio : AppCompatActivity() {

    private val caminhoDoArquivo = "MeuArquivo"
    private var arquivoExterno: File? = null

    lateinit var tv_relatorio : TextView
    lateinit var bt_exportar : Button
    lateinit var bt_voltar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_relatorio)

        tv_relatorio = findViewById(R.id.tv_relatorio)
        bt_exportar = findViewById(R.id.bt_exportar)
        bt_voltar = findViewById(R.id.bt_voltar3)

        mostrarRelatorio()

        bt_exportar.setOnClickListener {
            montarPDF()
            Toast.makeText(applicationContext, "PDF salvo com sucesso!", Toast.LENGTH_SHORT).show()
        }

        bt_voltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
            this.finish()
        }
    }

    fun mostrarRelatorio() {
        arquivoExterno = File(getExternalFilesDir(caminhoDoArquivo), "relatorio")

        if("relatorio".trim() != "") {
            val fileInputStream = FileInputStream(arquivoExterno)
            val inputStreamReader : InputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader : BufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()

            var text : String? = null

            while((bufferedReader.readLine().also {text = it }) != null)
                stringBuilder.append((text) + "\n")

            fileInputStream.close()

            tv_relatorio.setText(stringBuilder.toString())
        }
    }

    fun montarPDF() {
        val documento = Document()

        try {
            val diretorio = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS)
            val arquivo = java.io.File(diretorio, "relatorio.pdf")
            val writer = PdfWriter.getInstance(documento, FileOutputStream(arquivo))
            documento.open()
            documento.add(Paragraph(ListasEstabelecimentos.obterRelatorio()))
            documento.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}