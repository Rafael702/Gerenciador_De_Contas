package br.com.zup.GerenciadordeContas.conta.exception;

public class ContaNaoEncontrada extends RuntimeException {

    public ContaNaoEncontrada(String mensagem) {
        super(mensagem);
    }
}
