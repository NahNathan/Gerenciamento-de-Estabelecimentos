package com.luizFelippeNathan.prova01

data class Cinema (
    val estabelecimento: Estabelecimento,
    var quantidadeAssentos: Int
) {
    override fun toString() : String {
        return "Nome: ${this.estabelecimento.nome}\n" +
                "CNPJ: ${this.estabelecimento.cnpj}\n" +
                "Caixa: R$${this.estabelecimento.caixa}\n" +
                "Quantidade de Assentos: ${this.quantidadeAssentos}"
    }
}
