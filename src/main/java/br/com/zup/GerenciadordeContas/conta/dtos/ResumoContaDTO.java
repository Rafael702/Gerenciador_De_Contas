package br.com.zup.GerenciadordeContas.conta.dtos;

import br.com.zup.GerenciadordeContas.conta.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResumoContaDTO {
    private int id;
    private String nome;
    private double valor;
    private Status status;
}
