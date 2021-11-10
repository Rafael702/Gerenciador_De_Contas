package br.com.zup.GerenciadordeContas.conta;

import br.com.zup.GerenciadordeContas.conta.enuns.Status;
import br.com.zup.GerenciadordeContas.conta.enuns.Tipo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Conta {
    private String nome;
    private double valor;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;
    private Tipo tipo;
    private Status status;

    public Conta() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public LocalDateTime getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(LocalDateTime dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
