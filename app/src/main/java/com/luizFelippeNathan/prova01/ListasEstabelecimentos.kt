package com.luizFelippeNathan.prova01

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.ListView

class ListasEstabelecimentos {
    companion object{

        var listaPostoDeGasolina = ArrayList<PostoDeGasolina>()
        var listaCinema = ArrayList<Cinema>()
        var listaSupermercado = ArrayList<Supermercado>()
        var listaCNPJ = ArrayList<String>()

        @JvmStatic fun setPostoDeGasolina(postoDeGasolina: PostoDeGasolina) {
            this.listaPostoDeGasolina.add(postoDeGasolina)
        }

        @JvmStatic fun setCinema(cinema: Cinema) {
            this.listaCinema.add(cinema)
        }

        @JvmStatic fun setSupermercado(supermercado: Supermercado) {
            this.listaSupermercado.add(supermercado)
        }

        @JvmStatic fun pegarListaEstabelecimentos() : ArrayList<String> {
            var lista = ArrayList<String>()
            for (postoDeGasolina in listaPostoDeGasolina) {
                this.listaCNPJ.add(postoDeGasolina.estabelecimento.cnpj)
                lista.add(postoDeGasolina.toString())
            }

            for (supermercado in listaSupermercado) {
                this.listaCNPJ.add(supermercado.estabelecimento.cnpj)
                lista.add(supermercado.toString())
            }

            for (cinema in listaCinema) {
                this.listaCNPJ.add(cinema.estabelecimento.cnpj)
                lista.add(cinema.toString())
            }

            return lista
        }

        @JvmStatic fun mostrarLista(listView : ListView, context : Context) {
            val adapter = ArrayAdapter(
                context,
                R.layout.simple_list_item_1,
                pegarListaEstabelecimentos()
            )

            listView.adapter = adapter
        }

        @JvmStatic fun obterCinemaPorCnpj(cnpj: String?) : Cinema? {
            for(cinema in listaCinema) {
                if(cinema.estabelecimento.cnpj.equals(cnpj))
                    return cinema
            }

            return null
        }

        @JvmStatic fun obterSupermercadoPorCnpj(cnpj: String?) : Supermercado? {
            for(supermercado in listaSupermercado) {
                if(supermercado.estabelecimento.cnpj.equals(cnpj))
                    return supermercado
            }

            return null
        }

        @JvmStatic fun obterPostoPorCnpj(cnpj: String?) : PostoDeGasolina? {
            for(posto in listaPostoDeGasolina) {
                if(posto.estabelecimento.cnpj.equals(cnpj))
                    return posto
            }

            return null
        }

        @JvmStatic fun verificarTipoEstabelecimentoPeloCnpj(cnpj : String) : String?{
            for (postoDeGasolina in listaPostoDeGasolina) {
                if(postoDeGasolina.estabelecimento.cnpj.equals(cnpj)) {
                    return "posto"
                }
            }

            for (supermercado in listaSupermercado) {
                if(supermercado.estabelecimento.cnpj.equals(cnpj)) {
                    return "supermercado"
                }
            }

            for (cinema in listaCinema) {
                if(cinema.estabelecimento.cnpj.equals(cnpj)) {
                    return "cinema"
                }
            }

            return null
        }

        @JvmStatic fun obterCaixa() : String {
            var caixa : Double = 0.0

            for (postoDeGasolina in listaPostoDeGasolina) {
                caixa += postoDeGasolina.estabelecimento.caixa
            }

            for (supermercado in listaSupermercado) {
                caixa += supermercado.estabelecimento.caixa
            }

            for (cinema in listaCinema) {
                caixa += cinema.estabelecimento.caixa
            }

            return caixa.toString()
        }

        @JvmStatic fun obterRelatorio() : String {
            var relatorio = ""

            for(estabelecimentos in this.pegarListaEstabelecimentos())
                relatorio += estabelecimentos.toString() + "\n\n"

            relatorio += "Developed by\nLuiz Felippe 👽 & Nathan Rodrigues ☕"

            return relatorio
        }

        @JvmStatic fun verificarCNPJ(cnpj : String) : Boolean {
            for (postoDeGasolina in listaPostoDeGasolina) {
                if(postoDeGasolina.estabelecimento.cnpj.equals(cnpj)) {
                    return true
                }
            }

            for (supermercado in listaSupermercado) {
                if(supermercado.estabelecimento.cnpj.equals(cnpj)) {
                    return true
                }
            }

            for (cinema in listaCinema) {
                if(cinema.estabelecimento.cnpj.equals(cnpj)) {
                    return true
                }
            }

            return false
        }
    }
}