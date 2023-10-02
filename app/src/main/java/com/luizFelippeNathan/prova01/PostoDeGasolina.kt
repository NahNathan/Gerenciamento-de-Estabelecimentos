package com.luizFelippeNathan.prova01

data class PostoDeGasolina(
    val estabelecimento: Estabelecimento,
    var capacidadeTanque : Double
) {
    override fun toString() : String {
        return "Nome: ${this.estabelecimento.nome}\n" +
                "CNPJ: ${this.estabelecimento.cnpj}\n" +
                "Caixa: R$${this.estabelecimento.caixa}\n" +
                "Capacidade do Tanque: ${this.capacidadeTanque} litros"
    }
}