package com.luizFelippeNathan.prova01

data class Supermercado(
    val estabelecimento: Estabelecimento,
    var arCondicionado : Boolean
) {
    fun setArCondicionado() : String {
        if(this.arCondicionado)
            return "Sim"
        else
            return "Não"
    }

    override fun toString() : String {
        return "Nome: ${this.estabelecimento.nome}\n" +
                "CNPJ: ${this.estabelecimento.cnpj}\n" +
                "Caixa: R$${this.estabelecimento.caixa}\n" +
                "Ar Condicionado: ${this.setArCondicionado()}"
    }
}