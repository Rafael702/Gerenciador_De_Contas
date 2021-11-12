package br.com.zup.GerenciadordeContas.conta.dtos;

import br.com.zup.GerenciadordeContas.conta.enuns.Status;
import br.com.zup.GerenciadordeContas.conta.enuns.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContaSaidaDTO {
    private int id;
    private String nome;
    private double valor;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;
    private Tipo tipo;
    private Status status;
}
