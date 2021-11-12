package br.com.zup.GerenciadordeContas.conta.dtos;

import br.com.zup.GerenciadordeContas.conta.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Getter
public class ContaAtualizadaDTO {
    private Status status;
}
